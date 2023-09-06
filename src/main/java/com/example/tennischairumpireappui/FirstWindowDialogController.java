package com.example.tennischairumpireappui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.controlsfx.control.SearchableComboBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FirstWindowDialogController {

    @FXML
    public SearchableComboBox playersComboBox1;
    @FXML
    public SearchableComboBox playersComboBox2;
    @FXML
    public ComboBox bestOfComboBox, surfaceComboBox;
    @FXML
    public Button startNewMatchButton;
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView leftAD, leftDE, rightAD, rightDE;

    @FXML
    public void initialize(){
        DataSource dataSource = new DataSource();
        if(!dataSource.open()){
            System.out.println("Problems with opening database");
            return;
        }

        List<Player> players = dataSource.queryPlayers();
        for(var player : players){
            playersComboBox1.getItems().add(player.getSurname());
            playersComboBox2.getItems().add(player.getSurname());
        }
        dataSource.close();

        startNewMatchButton.setDisable(true);

    }

    public void handleGameBeginning(ActionEvent actionEvent) {
        if(playersComboBox1.getValue() != null && playersComboBox2.getValue() != null
                && bestOfComboBox.getValue() != null && playersComboBox1.getValue() != playersComboBox2.getValue()
                && surfaceComboBox.getValue() != null){
            startNewMatchButton.setDisable(false);
        }
        else{
            startNewMatchButton.setDisable(true);
        }
    }

    @FXML
    private void onStartNewMatchClick(ActionEvent event) throws IOException {
        loadMainStage("main-window-dialog.fxml",event);

        DataSingleton data = DataSingleton.getInstance();
        data.setSurface((String)surfaceComboBox.getValue());

        List<Object> players = new ArrayList<>();
        players.add(playersComboBox1.getValue());
        players.add(playersComboBox2.getValue());
        ChoiceDialog<Object> playerDialog = new ChoiceDialog<>(playersComboBox1.getValue(), players);
        playerDialog.setTitle("Who starts the match?");
        playerDialog.setHeaderText(null);
        playerDialog.setContentText("Choose player who will serve first");

        List<String> sides = new ArrayList<>();
        sides.add("Left-Hand Side");
        sides.add("Right-Hand Side");
        ChoiceDialog<String> sideDialog = new ChoiceDialog<>("Left-Hand Side", sides);
        sideDialog.setTitle("Which side?");
        sideDialog.setHeaderText(null);
        sideDialog.setContentText("Which side will the server start?");

        Optional<Object> playerResult = playerDialog.showAndWait();
        if (playerResult.isPresent()) {

            Optional<String> sideResult = sideDialog.showAndWait();
            if (sideResult.isPresent()) {
                Object selectedPlayer = playerResult.get();
                String selectedSide = sideResult.get();

                data.setServer(selectedPlayer);
                data.setSide(selectedSide);
                data.setPlayer1(playersComboBox1.getValue());
                data.setPlayer2(playersComboBox2.getValue());
                data.setBestOf(bestOfComboBox.getValue());

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Summary");
                alert.setHeaderText(null);
                alert.setContentText("Server: " + selectedPlayer + "\n"
                        + "Will start on " + selectedSide);
                alert.showAndWait();
            }
            else{
                data.setServer(playerResult.get());
                data.setSide("Left-Hand Side");
                data.setPlayer1(playersComboBox1.getValue());
                data.setPlayer2(playersComboBox2.getValue());
                data.setBestOf(bestOfComboBox.getValue());
            }
        }
        else{
            data.setServer(playersComboBox1.getValue());
            data.setSide("Left-Hand Side");
            data.setPlayer1(playersComboBox1.getValue());
            data.setPlayer2(playersComboBox2.getValue());
            data.setBestOf(bestOfComboBox.getValue());
        }
    }

    @FXML
    private void onLoadMatchClick(ActionEvent event) throws IOException {
//        Raczej do zmiany to ponizej
        DataSingleton data = DataSingleton.getInstance();

        DataSource dataSource = new DataSource();
        if(!dataSource.open()){
            System.out.println("Problems with opening database");
            return;
        }

        List<Match> matches = dataSource.queryUnfinishedMatches();

        if(matches.size() != 0){
            List<String> matchUps = new ArrayList<>();
            for(var match : matches){
                matchUps.add("%d: %s - %s".formatted(match.getID(), match.getCopiedPlayer1().getSurname(), match.getCopiedPlayer2().getSurname()));
            }

            ChoiceDialog<String> matchDialog = new ChoiceDialog<>(matchUps.get(0), matchUps);
            matchDialog.setTitle("Match resume settings");
            matchDialog.setHeaderText(null);
            matchDialog.setContentText("Choose match to finish?");

            List<String> sides = new ArrayList<>();
            sides.add("Left-Hand Side");
            sides.add("Right-Hand Side");
            ChoiceDialog<String> sideDialog = new ChoiceDialog<>(sides.get(0), sides);
            sideDialog.setTitle("Match resume settings");
            sideDialog.setHeaderText(null);
            sideDialog.setContentText("Which side will the server start?");

            Optional<String> matchResult = matchDialog.showAndWait();
            if(matchResult.isPresent()){

                Optional<String> sideResult = sideDialog.showAndWait();
                if(sideResult.isPresent()){
                    int matchToFinishID = Integer.parseInt(trimToDigitsOnly(matchResult.get()));
                    data.setMatchToResumeID(matchToFinishID);
                    data.setSideToResumeMatch(sideResult.get());
                    loadMainStage("to-resume-main-window-dialog.fxml",event);
                }

            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Database information");
            alert.setHeaderText(null);
            alert.setContentText("No unfinished matches found");
            alert.showAndWait();
        }

        dataSource.close();
    }

    private void loadMainStage(String fxml, ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        Scene scene = new Scene(root, 880, 530);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Tennis Chair Umpire App");
        stage.setScene(scene);
        stage.show();
    }
    private String trimToDigitsOnly(String input){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c > 47 && c < 58){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}