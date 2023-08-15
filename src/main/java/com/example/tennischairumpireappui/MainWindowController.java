package com.example.tennischairumpireappui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainWindowController {

    @FXML
    public AnchorPane mainWindow;
    @FXML
    public Button startMatchButton;
    @FXML
    public Label nameLeft, nameRight, surnameLeft, surnameRight;
    @FXML
    public ImageView servingBallGraphicLeft, servingBallGraphicRight;
    @FXML
    public ImageView countryGraphicLeft, countryGraphicRight;
    @FXML
    public Label heightLeft, heightRight;
    @FXML
    public Button player1AddPoint, player1SubtractPoint, player1Challenge, player1CodeViolation, player1TimeViolation, player1MedicalTimeOut, player1Hindrance,
            player2AddPoint, player2SubtractPoint, player2Challenge, player2CodeViolation, player2TimeViolation, player2MedicalTimeOut, player2Hindrance,
            aceButton, faultButton, letButton, playButton;
    @FXML
    private ImageView leftAD, leftDE, rightAD, rightDE, scoringLeft, scoringRight,
            firstSetLeft, firstSetRight, secondSetLeft, secondSetRight, thirdSetLeft, thirdSetRight,
            fourthSetLeft, fourthSetRight, fifthSetLeft, fifthSetRight, tennisCourt,
            challengeLeft, codeViolationLeft, timeViolationLeft, timeOutLeft, hindranceLeft,
            challengeRight, codeViolationRight, timeViolationRight, timeOutRight, hindranceRight;

    @FXML
    public void initialize() throws IOException {
        player1AddPoint.setDisable(true);
        player1SubtractPoint.setDisable(true);
        player1Challenge.setDisable(true);
        player1CodeViolation.setDisable(true);
        player1TimeViolation.setDisable(true);
        player1MedicalTimeOut.setDisable(true);
        player1MedicalTimeOut.setDisable(true);
        player1Hindrance.setDisable(true);

        player2AddPoint.setDisable(true);
        player2SubtractPoint.setDisable(true);
        player2Challenge.setDisable(true);
        player2CodeViolation.setDisable(true);
        player2TimeViolation.setDisable(true);
        player2MedicalTimeOut.setDisable(true);
        player2MedicalTimeOut.setDisable(true);
        player2Hindrance.setDisable(true);

        aceButton.setDisable(true);
        letButton.setDisable(true);
        faultButton.setDisable(true);
        playButton.setDisable(true);


    }

    public void handleOnFaultClick(ActionEvent actionEvent) throws IOException {

        DataSingleton data = DataSingleton.getInstance();
        System.out.println(data.getServer());
        System.out.println(data.getSide());


    }

    public void handleStartMatchButton(ActionEvent actionEvent) {
        startMatchButton.setDisable(true);

        DataSingleton data = DataSingleton.getInstance();

//        if(data.getServer().equals(data.getPlayer1())){
//            System.out.println("Serwujacy to player1");
//        }
//        else{
//            System.out.println("serwujacy to player2");
//        }
//        if(data.getPlayer1().equals("Kyrgios")) System.out.println("Tak to kyrgios porownało stringi!!!!!! :))))");
//        if(data.getPlayer2().equals("Kyrgios")) System.out.println("Tak to kyrgios porownało stringi!!!!! :)))");
//
        DataSource dataSource = new DataSource();
        if(!dataSource.open()){
            System.out.println("Problems with opening database");
            return;
        }

        Player player1 = dataSource.queryPlayer((String) data.getPlayer1());
        Player player2 = dataSource.queryPlayer((String) data.getPlayer2());
        boolean isGrandSlam;
        isGrandSlam = data.getBestOf().equals("5");
        data.setMatch(player1, player2, isGrandSlam);

        nameLeft.setText(player1.getName());
        surnameLeft.setText(player1.getSurname());
        heightLeft.setText(Integer.toString(player1.getHeight()));
        countryGraphicLeft.setImage(new Image(getCountryPath(player1.getCountry())));

        nameRight.setText(player2.getName());
        surnameRight.setText(player2.getSurname());
        heightRight.setText(Integer.toString(player2.getHeight()));
        countryGraphicRight.setImage(new Image(getCountryPath(player2.getCountry())));

        if(data.getServer().equals(data.getPlayer1())) {
            data.getMatch().getCopiedPlayer1().setServing(true);
            servingBallGraphicRight.setVisible(false);
        }
        else {
            data.getMatch().getCopiedPlayer2().setServing(true);
            servingBallGraphicLeft.setVisible(false);
        }


        if(data.getSide().equals("Left-Hand Side")){
            if(data.getMatch().getCopiedPlayer1().isServing()){
                leftDE.setImage(new Image(getCountryAvatarPath(data.getMatch().getCopiedPlayer1().getCountry(), true)));
                leftAD.setImage(new Image(getCountryAvatarPath(data.getMatch().getCopiedPlayer1().getCountry(), true)));
                leftAD.setVisible(false);

                rightDE.setImage(new Image(getCountryAvatarPath(data.getMatch().getCopiedPlayer2().getCountry(), false)));
                rightAD.setImage(new Image(getCountryAvatarPath(data.getMatch().getCopiedPlayer2().getCountry(), false)));
                rightAD.setVisible(false);

            }
            else{
                leftDE.setImage(new Image(getCountryAvatarPath(data.getMatch().getCopiedPlayer2().getCountry(), true)));
                leftAD.setImage(new Image(getCountryAvatarPath(data.getMatch().getCopiedPlayer2().getCountry(), true)));
                leftAD.setVisible(false);

                rightDE.setImage(new Image(getCountryAvatarPath(data.getMatch().getCopiedPlayer1().getCountry(), false)));
                rightAD.setImage(new Image(getCountryAvatarPath(data.getMatch().getCopiedPlayer1().getCountry(), false)));
                rightAD.setVisible(false);
            }
        }
        else{
            if(data.getMatch().getCopiedPlayer1().isServing()){
                rightDE.setImage(new Image(getCountryAvatarPath(data.getMatch().getCopiedPlayer1().getCountry(), true)));
                rightAD.setImage(new Image(getCountryAvatarPath(data.getMatch().getCopiedPlayer1().getCountry(), true)));
                rightAD.setVisible(false);

                leftDE.setImage(new Image(getCountryAvatarPath(data.getMatch().getCopiedPlayer2().getCountry(), false)));
                leftAD.setImage(new Image(getCountryAvatarPath(data.getMatch().getCopiedPlayer2().getCountry(), false)));
                leftAD.setVisible(false);
            }
            else{
                rightDE.setImage(new Image(getCountryAvatarPath(data.getMatch().getCopiedPlayer2().getCountry(), true)));
                rightAD.setImage(new Image(getCountryAvatarPath(data.getMatch().getCopiedPlayer2().getCountry(), true)));
                rightAD.setVisible(false);

                leftDE.setImage(new Image(getCountryAvatarPath(data.getMatch().getCopiedPlayer1().getCountry(), false)));
                leftAD.setImage(new Image(getCountryAvatarPath(data.getMatch().getCopiedPlayer1().getCountry(), false)));
                leftAD.setVisible(false);
            }
        }

        player1AddPoint.setDisable(false);
        player1SubtractPoint.setDisable(false);
        player1Challenge.setDisable(false);
        player1CodeViolation.setDisable(false);
        player1TimeViolation.setDisable(false);
        player1MedicalTimeOut.setDisable(false);
        player1MedicalTimeOut.setDisable(false);
        player1Hindrance.setDisable(false);

        player2AddPoint.setDisable(false);
        player2SubtractPoint.setDisable(false);
        player2Challenge.setDisable(false);
        player2CodeViolation.setDisable(false);
        player2TimeViolation.setDisable(false);
        player2MedicalTimeOut.setDisable(false);
        player2MedicalTimeOut.setDisable(false);
        player2Hindrance.setDisable(false);

        aceButton.setDisable(false);
        letButton.setDisable(false);
        faultButton.setDisable(false);
        playButton.setDisable(false);

    }

    private String getCountryPath(String country){
        return "C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\countries\\" + country + ".png";
    }
    private String getCountryAvatarPath(String country, boolean withBall){
        if(withBall){
            return "C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\countriesAvatarsWithBall\\" + country + ".png";
        }
        else{
            return "C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\countriesAvatars\\" + country + ".png";
        }
    }
}
