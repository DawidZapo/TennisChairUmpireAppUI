package com.example.tennischairumpireappui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class firstWindowDialogController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}