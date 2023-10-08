package com.example.tennischairumpireappui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EditMatchScoreDialogController {
    @FXML
    ImageView player1Country, player2Country;
    @FXML
    Label player1Surname, player2Surname, fifthSetLabel, fourthSetLabel;
    @FXML
    Button okButton, cancelButton;
    @FXML
    ChoiceBox<String> player1PointChoiceBox, player2PointChoiceBox, player1FirstSetChoiceBox, player2FirstSetChoiceBox,
    player1SecondSetChoiceBox, player2SecondSetChoiceBox, player1ThirdSetChoiceBox, player2ThirdSetChoiceBox,
    player1FourthSetChoiceBox, player2FourthSetChoiceBox, player1FifthSetChoiceBox, player2FifthSetChoiceBox;

    @FXML
    private void initialize(){
        DataSingleton data = DataSingleton.getInstance();
        player1Surname.setText(data.getMatch().getCopiedPlayer1().getSurname());
        player2Surname.setText(data.getMatch().getCopiedPlayer2().getSurname());

        player1Country.setImage(new Image(MainWindowController.getCountryPath(data.getMatch().getCopiedPlayer1().getCountry())));
        player2Country.setImage(new Image(MainWindowController.getCountryPath(data.getMatch().getCopiedPlayer2().getCountry())));

        okButton.setDisable(true);

        if(!data.getMatch().isGrandSlam()){
            player1FourthSetChoiceBox.setDisable(true);
            player2FourthSetChoiceBox.setDisable(true);
            player1FifthSetChoiceBox.setDisable(true);
            player2FifthSetChoiceBox.setDisable(true);

            fifthSetLabel.setDisable(true);
            fourthSetLabel.setDisable(true);
        }
    }

    @FXML
    private void handlePossibility(){
        DataSingleton data = DataSingleton.getInstance();

        // do poprawy, tylko zalazek pomyslu
        if((player1PointChoiceBox.getValue().equals("AD") && player2PointChoiceBox.getValue().equals("40"))
        || (player2PointChoiceBox.getValue().equals("AD") && player1PointChoiceBox.getValue().equals("40"))){
            okButton.setDisable(false);
        }
        else{
            okButton.setDisable(true);
        }

    }

}
