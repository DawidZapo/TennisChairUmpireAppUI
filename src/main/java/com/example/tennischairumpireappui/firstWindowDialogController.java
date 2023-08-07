package com.example.tennischairumpireappui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class firstWindowDialogController {
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView leftAD, leftDE, rightAD, rightDE;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void initialize(){
        leftDE.setVisible(false);
        rightDE.setVisible(false);
    }
}