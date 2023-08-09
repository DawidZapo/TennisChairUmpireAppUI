package com.example.tennischairumpireappui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MainWindowController {
    @FXML
    public AnchorPane mainWindow;
    @FXML
    private ImageView leftAD, leftDE, rightAD, rightDE;

    @FXML
    public void initialize(){

        FXMLLoader loader = new FXMLLoader(getClass().getResource("first-window-dialog.fxml"));
        FirstWindowDialogController firstWindowDialogController = loader.getController();


        leftAD.setVisible(false);
        rightAD.setVisible(false);


    }
}
