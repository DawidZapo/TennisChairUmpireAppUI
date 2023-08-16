package com.example.tennischairumpireappui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainWindowController {
    @FXML
    public Menu player1Menu, player2Menu;

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
    public static Image scoring0 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\scoring\\0.png");
    public static Image scoring15 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\scoring\\15.png");
    public static Image scoring30 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\scoring\\30.png");
    public static Image scoring40 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\scoring\\40.png");
    public static Image scoringAD = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\scoring\\AD.png");
    public static Image scoringBlank = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\scoring\\blank.png");

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

    private Image get15_30_40Image(int points1, int points2){
        if(points1 == 0) return scoring0;
        else if(points1 == 1) return scoring15;
        else if(points1 == 2) return scoring30;
        else if(points1 == 3) return scoring40;
        else if(points1 > 3 && points1 == points2) return scoring40;
        else if(points1 > 3 && points1 - points2 == 1) return scoringAD;
        else if(points1 > 3 && points2 - points1 == 1) return scoring40;
        else return scoringBlank;

    }

    @FXML
    private void handleStartMatchButton(ActionEvent actionEvent) {
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
        player1Menu.setText(player1.getSurname());

        nameRight.setText(player2.getName());
        surnameRight.setText(player2.getSurname());
        heightRight.setText(Integer.toString(player2.getHeight()));
        countryGraphicRight.setImage(new Image(getCountryPath(player2.getCountry())));
        player2Menu.setText(player2.getSurname());

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

    @FXML
    private void onPlayClick(){
        aceButton.setDisable(true);
        faultButton.setDisable(true);
        letButton.setDisable(true);
        playButton.setDisable(true);
    }
    @FXML
    private void onAceClick(){
        DataSingleton data = DataSingleton.getInstance();

        if(data.getMatch().getCopiedPlayer1().isServing()){
            data.getMatch().addPoint(data.getMatch().getCopiedPlayer1(), data.getMatch().getCopiedPlayer2());
            System.out.println("CopiedPlayer1 is serving");

            if(servingBallGraphicLeft.isVisible()){
                System.out.println("Server on the left");
                scoringLeft.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer1().getPoints(), data.getMatch().getCopiedPlayer2().getPoints()));
                scoringRight.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer2().getPoints(), data.getMatch().getCopiedPlayer1().getPoints()));
            }
            else{
                System.out.println("Server on the right");
                scoringRight.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer1().getPoints(), data.getMatch().getCopiedPlayer2().getPoints()));
                scoringLeft.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer2().getPoints(), data.getMatch().getCopiedPlayer1().getPoints()));
            }
        }
        else{
            data.getMatch().addPoint(data.getMatch().getCopiedPlayer2(), data.getMatch().getCopiedPlayer1());
            System.out.println("CopiedPlayer2 is serving");

            if(servingBallGraphicLeft.isVisible()){
                System.out.println("Server on the left");
                scoringLeft.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer2().getPoints(), data.getMatch().getCopiedPlayer1().getPoints()));
                scoringRight.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer1().getPoints(), data.getMatch().getCopiedPlayer2().getPoints()));
            }
            else{
                System.out.println("Server on the right");
                scoringRight.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer2().getPoints(), data.getMatch().getCopiedPlayer1().getPoints()));
                scoringLeft.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer1().getPoints(), data.getMatch().getCopiedPlayer2().getPoints()));
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

    @FXML
    private void onAddPointClick(ActionEvent actionEvent) {
        DataSingleton data = DataSingleton.getInstance();

        if(actionEvent.getSource().equals(player1AddPoint)){
            data.getMatch().addPoint(data.getMatch().getCopiedPlayer1(), data.getMatch().getCopiedPlayer2());

            scoringLeft.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer1().getPoints(), data.getMatch().getCopiedPlayer2().getPoints()));
            scoringRight.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer2().getPoints(), data.getMatch().getCopiedPlayer1().getPoints()));

        }
        else if(actionEvent.getSource().equals(player2AddPoint)){
            data.getMatch().addPoint(data.getMatch().getCopiedPlayer2(), data.getMatch().getCopiedPlayer1());

            scoringRight.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer2().getPoints(), data.getMatch().getCopiedPlayer1().getPoints()));
            scoringLeft.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer1().getPoints(), data.getMatch().getCopiedPlayer2().getPoints()));

        }
        else{
            System.out.println("No button found");
        }
    }
}
