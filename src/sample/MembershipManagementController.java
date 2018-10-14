package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MembershipManagementController implements Initializable {
    @FXML public AnchorPane anchorPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchorPane.setPrefWidth(Screen.getPrimary().getBounds().getWidth() -261);
        anchorPane.setPrefHeight(Screen.getPrimary().getBounds().getHeight() -66);
    }
}
