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
    public Button startGameButton;
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

        startGameButton.setDisable(true);

    }

    public void handleGameBeginning(ActionEvent actionEvent) {
        if(playersComboBox1.getValue() != null && playersComboBox2.getValue() != null
                && bestOfComboBox.getValue() != null && playersComboBox1.getValue() != playersComboBox2.getValue()
                && surfaceComboBox.getValue() != null){
            startGameButton.setDisable(false);
        }
        else{
            startGameButton.setDisable(true);
        }
    }

    public void onStartButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-window-dialog.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 880, 530);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Tennis Chair Umpire App");
        stage.setScene(scene);
        stage.show();

//        List<Object> choices = new ArrayList<>();
//        choices.add(playersComboBox1.getValue());
//        choices.add(playersComboBox2.getValue());
//
//        ChoiceDialog<Object> dialog = new ChoiceDialog<>(playersComboBox1.getValue(), choices);
//        dialog.setTitle("Pre-Game Settings");
//        dialog.setHeaderText("Who starts the match?");
//        dialog.setContentText("Choose your letter:");
//
//        Optional<Object> result = dialog.showAndWait();
//        result.ifPresent(letter -> System.out.println("Your choice: " + letter));
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
}