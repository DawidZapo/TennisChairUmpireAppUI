package com.example.tennischairumpireappui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.controlsfx.control.SearchableComboBox;

import java.io.IOException;
import java.util.List;

public class firstWindowDialogController {

    @FXML
    public SearchableComboBox playersComboBox1;
    @FXML
    public SearchableComboBox playersComboBox2;
    @FXML
    public ComboBox bestOfComboBox;
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
                && bestOfComboBox.getValue() != null && playersComboBox1.getValue() != playersComboBox2.getValue()){
            startGameButton.setDisable(false);
        }
        else{
            startGameButton.setDisable(true);
        }
    }

    public void onStartButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main-window-dialog.fxml"));
        Scene scene = new Scene(root, 880, 530);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Tennis Chair Umpire App");
        stage.setScene(scene);
        stage.show();
    }
}