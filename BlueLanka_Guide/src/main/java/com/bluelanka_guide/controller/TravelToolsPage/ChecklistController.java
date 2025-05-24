package com.bluelanka_guide.controller.TravelToolsPage;

import com.bluelanka_guide.models.CheckItem;
import com.bluelanka_guide.models.Model;
import com.bluelanka_guide.views.ViewFactoryTravelTools;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;

public class ChecklistController implements Initializable {

    public Button btnBack;
    public Button btnAddNew;
    public Button btnRemoveAll;
    public ListView<HBox> listViewItems;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //back button function
        btnBack.setOnAction(event -> onBackBtnClicked());

        //add new button function
        btnAddNew.setOnAction(event -> onAddNew());

        //remove all button
        btnRemoveAll.setOnAction(event -> onRemoveAll());
    }

    private void onRemoveAll() {
        listViewItems.getItems().clear();
    }

    private void onBackBtnClicked() {
        Model.getInstance().getViewFactoryTravelTools().getToolSelectedMenuItem().set("back");
    }

    private void onAddNew() {
        listViewItems.getItems().add(Model.getInstance().getViewFactoryTravelTools().getListItem());
    }
}
