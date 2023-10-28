package com.example.tennischairumpireappui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class EditMatchScoreDialogController {
    @FXML
    ImageView player1Country, player2Country;
    @FXML
    Label player1Surname, player2Surname, fifthSetLabel, fourthSetLabel;
    @FXML
    Button okButton, cancelButton;
    @FXML
    ChoiceBox<String> player1PointChoiceBox, player2PointChoiceBox, player1FirstSetChoiceBox, player2FirstSetChoiceBox, player1SecondSetChoiceBox, player2SecondSetChoiceBox, player1ThirdSetChoiceBox, player2ThirdSetChoiceBox,
    player1FourthSetChoiceBox, player2FourthSetChoiceBox, player1FifthSetChoiceBox, player2FifthSetChoiceBox;
//    @FXML
//    ChoiceBox<Integer> player1FirstSetChoiceBox, player2FirstSetChoiceBox, player1SecondSetChoiceBox, player2SecondSetChoiceBox, player1ThirdSetChoiceBox, player2ThirdSetChoiceBox,
//    player1FourthSetChoiceBox, player2FourthSetChoiceBox, player1FifthSetChoiceBox, player2FifthSetChoiceBox;

    @FXML
    private void initialize(){
        DataSingleton data = DataSingleton.getInstance();
        player1Surname.setText(data.getMatch().getCopiedPlayer1().getSurname());
        player2Surname.setText(data.getMatch().getCopiedPlayer2().getSurname());

        player1Country.setImage(new Image(MainWindowController.getCountryPath(data.getMatch().getCopiedPlayer1().getCountry())));
        player2Country.setImage(new Image(MainWindowController.getCountryPath(data.getMatch().getCopiedPlayer2().getCountry())));

        okButton.setDisable(true);

        player1SecondSetChoiceBox.setDisable(true);
        player2SecondSetChoiceBox.setDisable(true);
        player1ThirdSetChoiceBox.setDisable(true);
        player2ThirdSetChoiceBox.setDisable(true);


        if(!data.getMatch().isGrandSlam()){
            player1FourthSetChoiceBox.setDisable(true);
            player2FourthSetChoiceBox.setDisable(true);
            player1FifthSetChoiceBox.setDisable(true);
            player2FifthSetChoiceBox.setDisable(true);

            fifthSetLabel.setDisable(true);
            fourthSetLabel.setDisable(true);
        }
    }

    // under construction:) pomysl taki aby program pozwalal ci edytowac tylko jeden set w danym czasie i po wprowdzeniu
    // poprawnego wyniku np seta pierwszego, pozwolilo ci edytowac wynik drugiego
    @FXML
    private void handleScoreEditing(){
        DataSingleton data = DataSingleton.getInstance();

        // winner.getPoints()-looser.getPoints() >= 2 && winner.getPoints() >= 4
        if(((Integer.parseInt(player1FirstSetChoiceBox.getValue()) - Integer.parseInt(player2FifthSetChoiceBox.getValue()) >= 2) &&
                (Integer.parseInt(player1FirstSetChoiceBox.getValue()) >= 4)) ||

                ((Integer.parseInt(player2FirstSetChoiceBox.getValue()) - Integer.parseInt(player1FifthSetChoiceBox.getValue()) >= 2) &&
                        (Integer.parseInt(player2FirstSetChoiceBox.getValue()) >= 4))){

        }

    }

    @FXML
    private void handlePossibility(){
        DataSingleton data = DataSingleton.getInstance();

        List<ChoiceBox<String>> listOfCurrentSets = getLastSetChoiceBoxString(player1FirstSetChoiceBox,player2FirstSetChoiceBox,
                player1SecondSetChoiceBox, player2SecondSetChoiceBox,
                player1ThirdSetChoiceBox, player2ThirdSetChoiceBox,
                player1FourthSetChoiceBox, player2FourthSetChoiceBox,
                player1FifthSetChoiceBox, player2FifthSetChoiceBox);
        ChoiceBox<String> player1CurrentSet;
        ChoiceBox<String> player2CurrentSet;

        if(listOfCurrentSets != null){
            player1CurrentSet = listOfCurrentSets.get(0);
            player2CurrentSet = listOfCurrentSets.get(1);
        }
        else return;

        if((player1CurrentSet.getValue().equals("6") && player2CurrentSet.getValue().equals("6"))
        || (player1CurrentSet.getValue().equals("6") && player2CurrentSet.getValue().equals("6"))){

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

    private List<ChoiceBox<String>> getLastSetChoiceBoxString(ChoiceBox<String> player1FirstSetChoiceBox, ChoiceBox<String> player2FirstSetChoiceBox,
                                                         ChoiceBox<String> player1SecondSetChoiceBox, ChoiceBox<String> player2SecondSetChoiceBox,
                                                         ChoiceBox<String> player1ThirdSetChoiceBox, ChoiceBox<String> player2ThirdSetChoiceBox,
                                                         ChoiceBox<String> player1FourthSetChoiceBox, ChoiceBox<String> player2FourthSetChoiceBox,
                                                         ChoiceBox<String> player1FifthSetChoiceBox, ChoiceBox<String> player2FifthSetChoiceBox) {
        List<ChoiceBox<String>> list = new ArrayList<>(List.of(player1FirstSetChoiceBox, player2FirstSetChoiceBox,
                player1SecondSetChoiceBox, player2SecondSetChoiceBox,
                player1ThirdSetChoiceBox, player2ThirdSetChoiceBox,
                player1FourthSetChoiceBox, player2FourthSetChoiceBox,
                player1FifthSetChoiceBox, player2FifthSetChoiceBox));
        try {
            if (!player1FirstSetChoiceBox.getValue().equals("0") && !player2FirstSetChoiceBox.getValue().equals("0") &&
                    player1SecondSetChoiceBox.getValue().equals("0") && player2SecondSetChoiceBox.getValue().equals("0") &&
                    player1ThirdSetChoiceBox.getValue().equals("0") && player2ThirdSetChoiceBox.getValue().equals("0") &&
                    player1FourthSetChoiceBox.getValue().equals("0") && player2FourthSetChoiceBox.getValue().equals("0") &&
                    player1FifthSetChoiceBox.getValue().equals("0") && player2FifthSetChoiceBox.getValue().equals("0")) {

                return new ArrayList<>(List.of(player1FirstSetChoiceBox, player2FirstSetChoiceBox));

            } else if (!player1FirstSetChoiceBox.getValue().equals("0") && !player2FirstSetChoiceBox.getValue().equals("0") &&
                    !player1SecondSetChoiceBox.getValue().equals("0") && !player2SecondSetChoiceBox.getValue().equals("0") &&
                    player1ThirdSetChoiceBox.getValue().equals("0") && player2ThirdSetChoiceBox.getValue().equals("0") &&
                    player1FourthSetChoiceBox.getValue().equals("0") && player2FourthSetChoiceBox.getValue().equals("0") &&
                    player1FifthSetChoiceBox.getValue().equals("0") && player2FifthSetChoiceBox.getValue().equals("0")) {

                return new ArrayList<>(List.of(player1SecondSetChoiceBox, player2SecondSetChoiceBox));

            } else if (!player1FirstSetChoiceBox.getValue().equals("0") && !player2FirstSetChoiceBox.getValue().equals("0") &&
                    !player1SecondSetChoiceBox.getValue().equals("0") && !player2SecondSetChoiceBox.getValue().equals("0") &&
                    !player1ThirdSetChoiceBox.getValue().equals("0") && !player2ThirdSetChoiceBox.getValue().equals("0") &&
                    player1FourthSetChoiceBox.getValue().equals("0") && player2FourthSetChoiceBox.getValue().equals("0") &&
                    player1FifthSetChoiceBox.getValue().equals("0") && player2FifthSetChoiceBox.getValue().equals("0")) {

                return new ArrayList<>(List.of(player1ThirdSetChoiceBox, player2ThirdSetChoiceBox));

            } else if (!player1FirstSetChoiceBox.getValue().equals("0") && !player2FirstSetChoiceBox.getValue().equals("0") &&
                    !player1SecondSetChoiceBox.getValue().equals("0") && !player2SecondSetChoiceBox.getValue().equals("0") &&
                    !player1ThirdSetChoiceBox.getValue().equals("0") && !player2ThirdSetChoiceBox.getValue().equals("0") &&
                    !player1FourthSetChoiceBox.getValue().equals("0") && !player2FourthSetChoiceBox.getValue().equals("0") &&
                    player1FifthSetChoiceBox.getValue().equals("0") && player2FifthSetChoiceBox.getValue().equals("0")) {

                return new ArrayList<>(List.of(player1FourthSetChoiceBox, player2FourthSetChoiceBox));

            } else if (!player1FirstSetChoiceBox.getValue().equals("0") && !player2FirstSetChoiceBox.getValue().equals("0") &&
                    !player1SecondSetChoiceBox.getValue().equals("0") && !player2SecondSetChoiceBox.getValue().equals("0") &&
                    !player1ThirdSetChoiceBox.getValue().equals("0") && !player2ThirdSetChoiceBox.getValue().equals("0") &&
                    !player1FourthSetChoiceBox.getValue().equals("0") && !player2FourthSetChoiceBox.getValue().equals("0") &&
                    !player1FifthSetChoiceBox.getValue().equals("0") && !player2FifthSetChoiceBox.getValue().equals("0")) {

                return new ArrayList<>(List.of(player1FifthSetChoiceBox, player2FifthSetChoiceBox));

            } else return null;
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
            for (var a : list) {
                System.out.println(a.getValue());
            }
            return null;
        }
    }
    private List<ChoiceBox<Integer>> getLastSetChoiceBox(ChoiceBox<Integer> player1FirstSetChoiceBox, ChoiceBox<Integer> player2FirstSetChoiceBox,
                                                         ChoiceBox<Integer> player1SecondSetChoiceBox, ChoiceBox<Integer> player2SecondSetChoiceBox,
                                                         ChoiceBox<Integer> player1ThirdSetChoiceBox, ChoiceBox<Integer> player2ThirdSetChoiceBox,
                                                         ChoiceBox<Integer> player1FourthSetChoiceBox, ChoiceBox<Integer> player2FourthSetChoiceBox,
                                                         ChoiceBox<Integer> player1FifthSetChoiceBox, ChoiceBox<Integer> player2FifthSetChoiceBox) {
        List<ChoiceBox<Integer>> list = new ArrayList<>(List.of(player1FirstSetChoiceBox, player2FirstSetChoiceBox,
                player1SecondSetChoiceBox, player2SecondSetChoiceBox,
                player1ThirdSetChoiceBox, player2ThirdSetChoiceBox,
                player1FourthSetChoiceBox, player2FourthSetChoiceBox,
                player1FifthSetChoiceBox, player2FifthSetChoiceBox));

        if (!player1FirstSetChoiceBox.getValue().equals(0) && !player2FirstSetChoiceBox.getValue().equals(0) &&
                player1SecondSetChoiceBox.getValue().equals(0) && player2SecondSetChoiceBox.getValue().equals(0) &&
                player1ThirdSetChoiceBox.getValue().equals(0) && player2ThirdSetChoiceBox.getValue().equals(0) &&
                player1FourthSetChoiceBox.getValue().equals(0) && player2FourthSetChoiceBox.getValue().equals(0) &&
                player1FifthSetChoiceBox.getValue().equals(0) && player2FifthSetChoiceBox.getValue().equals(0)) {
             return new ArrayList<>(List.of(player1FirstSetChoiceBox, player2FirstSetChoiceBox));
        } else if (player1FirstSetChoiceBox.getValue() != 0 && player2FirstSetChoiceBox.getValue() != 0 &&
                player1SecondSetChoiceBox.getValue() != 0 && player2SecondSetChoiceBox.getValue() != 0 &&
                player1ThirdSetChoiceBox.getValue() == 0 && player2ThirdSetChoiceBox.getValue() == 0 &&
                player1FourthSetChoiceBox.getValue() == 0 && player2FourthSetChoiceBox.getValue() == 0 &&
                player1FifthSetChoiceBox.getValue() == 0 && player2FifthSetChoiceBox.getValue() == 0) {

            return new ArrayList<>(List.of(player1SecondSetChoiceBox, player2SecondSetChoiceBox));
        } else if (player1FirstSetChoiceBox.getValue() != 0 && player2FirstSetChoiceBox.getValue() != 0 &&
                player1SecondSetChoiceBox.getValue() != 0 && player2SecondSetChoiceBox.getValue() != 0 &&
                player1ThirdSetChoiceBox.getValue() != 0 && player2ThirdSetChoiceBox.getValue() != 0 &&
                player1FourthSetChoiceBox.getValue() == 0 && player2FourthSetChoiceBox.getValue() == 0 &&
                player1FifthSetChoiceBox.getValue() == 0 && player2FifthSetChoiceBox.getValue() == 0) {
            return new ArrayList<>(List.of(player1ThirdSetChoiceBox, player2ThirdSetChoiceBox));
        } else if (player1FirstSetChoiceBox.getValue() != 0 && player2FirstSetChoiceBox.getValue() != 0 &&
                player1SecondSetChoiceBox.getValue() != 0 && player2SecondSetChoiceBox.getValue() != 0 &&
                player1ThirdSetChoiceBox.getValue() != 0 && player2ThirdSetChoiceBox.getValue() != 0 &&
                player1FourthSetChoiceBox.getValue() != 0 && player2FourthSetChoiceBox.getValue() != 0 &&
                player1FifthSetChoiceBox.getValue() == 0 && player2FifthSetChoiceBox.getValue() == 0) {
            return new ArrayList<>(List.of(player1FourthSetChoiceBox, player2FourthSetChoiceBox));
        } else if (player1FirstSetChoiceBox.getValue() != 0 && player2FirstSetChoiceBox.getValue() == 0 &&
                player1SecondSetChoiceBox.getValue() != 0 && player2SecondSetChoiceBox.getValue() == 0 &&
                player1ThirdSetChoiceBox.getValue() != 0 && player2ThirdSetChoiceBox.getValue() == 0 &&
                player1FourthSetChoiceBox.getValue() != 0 && player2FourthSetChoiceBox.getValue() != 0 &&
                player1FifthSetChoiceBox.getValue() != 0 && player2FifthSetChoiceBox.getValue() != 0) {
            return new ArrayList<>(List.of(player1FifthSetChoiceBox, player2FifthSetChoiceBox));
        } else return null;

    }

    @FXML
    private void onOkButtonClick(ActionEvent actionEvent) {

    }


    @FXML
    private void onCancelButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
