module com.bluelanka_guide {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.bluelanka_guide to javafx.fxml;
    opens com.bluelanka_guide.controller.TravelToolsPage to javafx.fxml;
    exports com.bluelanka_guide;
}