package com.example.tennischairumpireappui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainWindowController {

    @FXML
    public AnchorPane mainWindow;
    @FXML
    public Button startMatchButton;
    public Label nameLeft, nameRight, surnameLeft, surnameRight;
    public ImageView servingBallGraphicLeft, servingBallGraphicRight;
    public ImageView countryGraphicLeft, countryGraphicRight;
    public Label rankingRight, rankingLeft;
    @FXML
    private ImageView leftAD, leftDE, rightAD, rightDE;

    @FXML
    public void initialize() throws IOException {

        leftAD.setVisible(false);
        rightAD.setVisible(false);


    }

    public void handleOnFaultClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("first-window-dialog.fxml"));
        Parent root = loader.load();
        FirstWindowDialogController firstWindowDialogController = loader.getController();

        DataSingleton data = DataSingleton.getInstance();
        System.out.println(data.getServer());
        System.out.println(data.getSide());

    }

    public void handleStartMatchButton(ActionEvent actionEvent) {
        startMatchButton.setDisable(true);

        DataSingleton data = DataSingleton.getInstance();

        if(data.getServer().equals(data.getPlayer1())){
            System.out.println("Serwujacy to player1");
        }
        else{
            System.out.println("serwujacy to player2");
        }
        if(data.getPlayer1().equals("Kyrgios")) System.out.println("Tak to kyrgios porownało stringi!!!!!! :))))");
        if(data.getPlayer2().equals("Kyrgios")) System.out.println("Tak to kyrgios porownało stringi!!!!! :)))");

    }
}
