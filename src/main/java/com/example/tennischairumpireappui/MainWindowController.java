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
    public static Image game0 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbersBlured\\number-0.png");
    public static Image game1 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbersBlured\\number-1.png");
    public static Image game2 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbersBlured\\number-2.png");
    public static Image game3 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbersBlured\\number-3.png");
    public static Image game4 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbersBlured\\number-4.png");
    public static Image game5 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbersBlured\\number-5.png");
    public static Image game6 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbersBlured\\number-6.png");
    public static Image game7 = new Image("C:\\Users\\dawid\\IdeaProjects\\TennisChairUmpireAppUI\\src\\main\\resources\\graphics\\numbersBlured\\number-7.png");

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

    public static Image get15_30_40Image(int points1, int points2){
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

        nameLeft.setText(player1.getName());
        surnameLeft.setText(player1.getSurname());
        heightLeft.setText(Integer.toString(player1.getHeight()));
        countryGraphicLeft.setImage(new Image(getCountryPath(player1.getCountry())));
        player1Menu.setText(player1.getSurname());
        player1.setAvatar(new Image(getCountryAvatarPath(player1.getCountry(), false)));
        player1.setAvatarWithBall(new Image(getCountryAvatarPath(player1.getCountry(), true)));


        nameRight.setText(player2.getName());
        surnameRight.setText(player2.getSurname());
        heightRight.setText(Integer.toString(player2.getHeight()));
        countryGraphicRight.setImage(new Image(getCountryPath(player2.getCountry())));
        player2Menu.setText(player2.getSurname());
        player2.setAvatar(new Image(getCountryAvatarPath(player2.getCountry(), false)));
        player2.setAvatarWithBall(new Image(getCountryAvatarPath(player2.getCountry(), true)));


        boolean isGrandSlam;
        isGrandSlam = data.getBestOf().equals("5");
        data.setMatch(player1, player2, isGrandSlam);

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
                data.getMatch().getCopiedPlayer1().setCurrentAvatar(data.getMatch().getCopiedPlayer1().getAvatarWithBall());
                leftDE.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                leftAD.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                leftAD.setVisible(false);

                data.getMatch().getCopiedPlayer2().setCurrentAvatar(data.getMatch().getCopiedPlayer2().getAvatar());
                rightDE.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                rightAD.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                rightAD.setVisible(false);

            }
            else{
                data.getMatch().getCopiedPlayer2().setCurrentAvatar(data.getMatch().getCopiedPlayer2().getAvatarWithBall());
                leftDE.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                leftAD.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                leftAD.setVisible(false);

                data.getMatch().getCopiedPlayer1().setCurrentAvatar(data.getMatch().getCopiedPlayer1().getAvatar());
                rightDE.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                rightAD.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                rightAD.setVisible(false);
            }
        }
        else{
            if(data.getMatch().getCopiedPlayer1().isServing()){
                data.getMatch().getCopiedPlayer1().setCurrentAvatar(data.getMatch().getCopiedPlayer1().getAvatarWithBall());
                rightDE.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                rightAD.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                rightAD.setVisible(false);

                data.getMatch().getCopiedPlayer2().setCurrentAvatar(data.getMatch().getCopiedPlayer2().getAvatar());
                leftDE.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                leftAD.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                leftAD.setVisible(false);
            }
            else{
                data.getMatch().getCopiedPlayer2().setCurrentAvatar(data.getMatch().getCopiedPlayer2().getAvatarWithBall());
                rightDE.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                rightAD.setImage(data.getMatch().getCopiedPlayer2().getCurrentAvatar());
                rightAD.setVisible(false);

                data.getMatch().getCopiedPlayer1().setCurrentAvatar(data.getMatch().getCopiedPlayer1().getAvatar());
                leftDE.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
                leftAD.setImage(data.getMatch().getCopiedPlayer1().getCurrentAvatar());
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

        /// DO ZMIANY TO PONIZEJ !!!!!!!!!!!!!!!!!!
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

    public static Image getGameImage(int games){
        if(games == 0) return game0;
        else if(games == 1) return game1;
        else if(games == 2) return game2;
        else if(games == 3) return game3;
        else if(games == 4) return game4;
        else if(games == 5) return game5;
        else if(games == 6) return game6;
        else if(games == 7) return game7;
        else return null;
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
            data.getMatch().addPoint(data.getMatch().getCopiedPlayer1(), data.getMatch().getCopiedPlayer2(),scoringLeft,scoringRight, leftDE, leftAD, rightDE, rightAD, firstSetLeft, secondSetLeft, thirdSetLeft,
                    fourthSetLeft, fifthSetLeft, servingBallGraphicLeft, servingBallGraphicRight);

//            scoringLeft.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer1().getPoints(), data.getMatch().getCopiedPlayer2().getPoints()));
//            scoringRight.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer2().getPoints(), data.getMatch().getCopiedPlayer1().getPoints()));

        }
        else if(actionEvent.getSource().equals(player2AddPoint)){
            data.getMatch().addPoint(data.getMatch().getCopiedPlayer2(), data.getMatch().getCopiedPlayer1(), scoringRight, scoringLeft, leftDE, leftAD, rightDE, rightAD, firstSetRight, secondSetRight, thirdSetRight,
                   fourthSetRight, fifthSetRight, servingBallGraphicLeft, servingBallGraphicRight);

//            scoringRight.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer2().getPoints(), data.getMatch().getCopiedPlayer1().getPoints()));
//            scoringLeft.setImage(get15_30_40Image(data.getMatch().getCopiedPlayer1().getPoints(), data.getMatch().getCopiedPlayer2().getPoints()));

        }
        else{
            System.out.println("No button found");
        }
    }
}
