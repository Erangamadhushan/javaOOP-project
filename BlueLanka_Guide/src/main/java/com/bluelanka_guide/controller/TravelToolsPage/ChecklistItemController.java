package com.bluelanka_guide.controller.TravelToolsPage;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ChecklistItemController implements Initializable {
    public Button btnDelete;
    public Label lblDescription;
    public Label lblDate;
    public CheckBox chkChecked;

    private Runnable onDeleteCallback;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnDelete.setOnAction(event -> onDelete());
    }

    private void onDelete() {
        System.out.println("fef");
    }

}
