package com.example.tennischairumpireappui;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class EditMatchScoreDialogController {
    @FXML
    ImageView player1Country, player2Country;
    @FXML
    Label player1Surname, player2Surname;
    @FXML
    ChoiceBox<String> player1PointChoiceBox, player2PointChoiceBox, player1FirstSetChoiceBox, player2FirstSetChoiceBox,
    player1SecondSetChoiceBox, player2SecondSetChoiceBox, player1ThirdSetChoiceBox, player2ThirdSetChoiceBox,
    player1FourthSetChoiceBox, player2FourthSetChoiceBox, player1FifthSetChoiceBox, player2FifthSetChoiceBox;

    @FXML
    private void initialize(){
        DataSingleton data = DataSingleton.getInstance();
        player1Surname.setText(data.getMatch().getCopiedPlayer1().getSurname());
        player2Surname.setText(data.getMatch().getCopiedPlayer2().getSurname());
    }

}
