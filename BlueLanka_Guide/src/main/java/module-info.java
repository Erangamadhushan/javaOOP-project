module com.bluelanka_guide {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.j;
    requires org.xerial.sqlitejdbc;
    requires javafx.web;
    requires annotations;
    requires jdk.jsobject;
    requires com.fasterxml.jackson.databind;
    requires de.jensd.fx.glyphs.fontawesome;

    opens com.bluelanka_guide to javafx.fxml;
    opens com.bluelanka_guide.controller.DestinationsPage to javafx.fxml;
    opens com.bluelanka_guide.controller.TravelToolsPage to javafx.fxml;
    opens com.bluelanka_guide.controller.TripPlanner to javafx.fxml;
    opens com.bluelanka_guide.controller to javafx.fxml;
    exports com.bluelanka_guide.controller;
    exports com.bluelanka_guide.controller.DestinationsPage;
    exports com.bluelanka_guide.controller.TravelToolsPage;
    exports com.bluelanka_guide.controller.TripPlanner;
    exports com.bluelanka_guide;
    exports com.bluelanka_guide.util;
    opens com.bluelanka_guide.util to javafx.fxml;
    exports com.bluelanka_guide.controller.DashboardPage;
    opens com.bluelanka_guide.controller.DashboardPage to javafx.fxml;
}