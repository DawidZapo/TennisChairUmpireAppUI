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
    ChoiceBox<String> player1PointChoiceBox, player2PointChoiceBox;
    @FXML
    ChoiceBox<Integer> player1FirstSetChoiceBox, player2FirstSetChoiceBox, player1SecondSetChoiceBox, player2SecondSetChoiceBox, player1ThirdSetChoiceBox, player2ThirdSetChoiceBox,
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

        // tylko do pierwszego seta, zalazek pomyslu
        if((player1FirstSetChoiceBox.getValue() == 7 && player2FirstSetChoiceBox.getValue() == 6)
        || (player1FirstSetChoiceBox.getValue() == 6 && player2FirstSetChoiceBox.getValue() == 7)){

            if(!data.isScoringChanged()){
                player1PointChoiceBox.getItems().clear();
                player1PointChoiceBox.getItems().addAll("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
                player1PointChoiceBox.setValue("0");

                player2PointChoiceBox.getItems().clear();
                player2PointChoiceBox.getItems().addAll("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
                player2PointChoiceBox.setValue("0");

                data.setScoringChanged(true);
            }


        }
        else{

            if(data.isScoringChanged()){
                player1PointChoiceBox.getItems().clear();
                player1PointChoiceBox.getItems().addAll("0", "15", "30", "40", "AD");
                player1PointChoiceBox.setValue("0");

                player2PointChoiceBox.getItems().clear();
                player2PointChoiceBox.getItems().addAll("0", "15", "30", "40", "AD");
                player2PointChoiceBox.setValue("0");

                data.setScoringChanged(false);
            }

        }


    }

}
