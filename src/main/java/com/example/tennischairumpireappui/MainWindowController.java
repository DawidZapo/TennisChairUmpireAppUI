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
    private ImageView leftAD, leftDE, rightAD, rightDE, scoringLeft, scoringRight,
            firstSetLeft, firstSetRight, secondSetLeft, secondSetRight, thirdSetLeft, thirdSetRight,
            fourthSetLeft, fourthSetRight, fifthSetLeft, fifthSetRight, tennisCourt,
            challengeLeft, codeViolationLeft, timeViolationLeft, timeOutLeft, hindranceLeft,
            challengeRight, codeViolationRight, timeViolationRight, timeOutRight, hindranceRight;

    @FXML
    public void initialize() throws IOException {


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
