package com.bluelanka_guide.controller.DestinationsPage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DestinationsController extends Application {


    static class Destination {
        private final int id;
        private final String name;
        private final String country;
        private final String description;
        private final double rating;
        private final String imagePath;
        private final double latitude;
        private final double longitude;

        public Destination(int id, String name, String country, String description, double rating, String imagePath, double latitude, double longitude) {
        //public Destination(int id, String name, String country, String description, double rating, String imagePath) {
            this.id = id;
            this.name = name;
            this.country = country;
            this.description = description;
            this.rating = rating;
            this.imagePath = imagePath;
            this.latitude = latitude;
            this.longitude = longitude;
        }
        public int getId() { return id; }
        public String getName() { return name; }
        public String getCountry() { return country; }
        public String getDescription() { return description; }
        public double getRating() { return rating; }
        public String getImagePath() { return imagePath; }
        public double getLatitude() { return latitude; }
        public double getLongitude() { return longitude; }

    }
        private BorderPane root;
        private VBox sidebar;
        private StackPane mapContainer;
        private VBox destinationDetails;
        private TabPane destinationTabs;
        private TextField searchField;
        private Button toggleSidebarButton;
        private boolean sidebarVisible = true;
        private List<Destination> destinations;
        private Destination selectedDestination;

    @Override
        public void start(@NotNull Stage primaryStage) {
            initializeDestinations();
            root = new BorderPane();
            //applyStyles();
            createSidebar();
            createMapView();

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setTitle("Destination Explorer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

        private void initializeDestinations() {
            destinations = new ArrayList<>();
            destinations.add(new Destination(1, "Negambo", "Sri Lanka", "Browns Beach in Negombo is a popular coastal destination known for its golden sands, clear waters, and vibrant atmosphere, offering a perfect blend of relaxation and adventure.", 4.8, ".jpg", 48.8566, 2.3522));
            destinations.add(new Destination(2, "Hikkaduwa", "Sri Lanka", "A bustling metropolis blending ultramodern and traditional aspects of Japanese culture.", 4.7, "tokyo.jpg", 48.8566, 2.3522));
            destinations.add(new Destination(3, "Arugambe", "Sri Lanka", "The Big Apple known for its skyscrapers, Broadway shows, and cultural diversity.", 4.6, "newyork.jpg", 48.8566, 2.3522));
    }

    private void createSidebar() {
        sidebar = new VBox();
        sidebar.setPrefWidth(300);
        sidebar.setStyle("-fx-background-color: white; -fx-border-color: #e5e7eb; -fx-border-width: 0 1 0 0;");

        HBox header = new HBox();
        header.setStyle("-fx-padding: 15; -fx-border-color: #e5e7eb; -fx-border-width: 0 0 1 0;");
        header.setAlignment(Pos.CENTER_LEFT);

        Label titleLabel = new Label("Destination Explorer");
        titleLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: #111827;");
        header.getChildren().add(titleLabel);

        HBox searchBox = new HBox();
        searchBox.setStyle("-fx-padding: 15;");
        searchBox.setAlignment(Pos.CENTER);

        searchField = new TextField();
        searchField.setPromptText("Search destinations...");
        searchField.setStyle("-fx-background-color: #f3f4f6; -fx-background-radius: 4; -fx-padding: 8;");
        HBox.setHgrow(searchField, Priority.ALWAYS);
        searchBox.getChildren().add(searchField);

        destinationTabs = new TabPane();
        destinationTabs.setStyle("-fx-background-color: transparent;");
        destinationTabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        VBox.setVgrow(destinationTabs, Priority.ALWAYS);

        Tab popularTab = new Tab("Popular");
        popularTab.setContent(createDestinationList());

        Tab savedTab = new Tab("Saved");
        VBox savedContent = new VBox(new Label("No saved destinations yet"));
        savedContent.setAlignment(Pos.CENTER);
        savedContent.setPadding(new Insets(20));
        savedTab.setContent(savedContent);

        Tab recentTab = new Tab("Recent");
        VBox recentContent = new VBox(new Label("No recent searches"));
        recentContent.setAlignment(Pos.CENTER);
        recentContent.setPadding(new Insets(20));
        recentTab.setContent(recentContent);

        destinationTabs.getTabs().addAll(popularTab, savedTab, recentTab);
        sidebar.getChildren().addAll(header, searchBox, destinationTabs);

        root.setLeft(sidebar);

    }

    private ScrollPane createDestinationList() {
        VBox destinationList = new VBox(10);
        destinationList.setPadding(new Insets(10));

        for (Destination destination : destinations) {
            VBox card = createDestinationCard(destination);
            destinationList.getChildren().add(card);
        }

        ScrollPane scrollPane = new ScrollPane(destinationList);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-padding: 0;");
        return scrollPane;
    }

    private VBox createDestinationCard(Destination destination) {
        VBox card = new VBox();
        card.setStyle("-fx-background-color: white; -fx-background-radius: 8; -fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.1), 4, 0, 0, 1); -fx-cursor: hand;");

        StackPane imageContainer = new StackPane();
        imageContainer.setPrefHeight(120);
        Rectangle imagePlaceholder = new Rectangle(300, 120, Color.LIGHTGRAY);

        HBox ratingBadge = new HBox();
        ratingBadge.setStyle("-fx-background-color: rgba(255, 255, 255, 0.9); -fx-background-radius: 12; -fx-padding: 4 8;");
        ratingBadge.getChildren().add(new Label(String.format("%.1f", destination.getRating())));
        StackPane.setAlignment(ratingBadge, Pos.TOP_RIGHT);
        StackPane.setMargin(ratingBadge, new Insets(8));
        imageContainer.getChildren().addAll(imagePlaceholder, ratingBadge);

        VBox infoContainer = new VBox(5);
        infoContainer.setPadding(new Insets(10));
        Label nameLabel = new Label(destination.getName());
        nameLabel.setStyle("-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: #111827;");
        Label countryLabel = new Label(destination.getCountry());
        countryLabel.setStyle("-fx-font-size: 12; -fx-text-fill: #6b7280;");
        Label descriptionLabel = new Label(destination.getDescription());
        descriptionLabel.setWrapText(true);
        descriptionLabel.setStyle("-fx-font-size: 12; -fx-text-fill: #4b5563;");
        infoContainer.getChildren().addAll(nameLabel, countryLabel, descriptionLabel);

        card.getChildren().addAll(imageContainer, infoContainer);
        card.setOnMouseClicked(e -> selectDestination(destination));
        return card;
    }

    private void createMapView() {
        mapContainer = new StackPane();

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();

        StringBuilder markersJS = new StringBuilder();
        for (Destination dest : destinations) {
            markersJS.append(String.format(
                    "L.marker([%f, %f]).addTo(map).bindPopup('%s');\n",
                    dest.getLatitude(), dest.getLongitude(), dest.getName()));
        }
        String mapHTML = """
                <html>
                <head>
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css"/>
                    <style> html, body, #map { height: 100%%; margin: 0; padding: 0; } </style>
                </head>
                <body>
                    <div id="map"></div>
                    <script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>
                    <script>
                        var map = L.map('map').setView([20, 0], 2);
                        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                            maxZoom: 18
                        }).addTo(map);
                        %s
                    </script>
                </body>
                </html>
                """.formatted(markersJS.toString());

        webEngine.loadContent(mapHTML);

        mapContainer.getChildren().add(webView);
        root.setCenter(mapContainer);
    }

    private Pane createMapMarkers() {
        Pane markersPane = new Pane();
        markersPane.setPrefSize(800, 600);

        for (Destination destination : destinations) {
            double x = (destination.getLongitude() + 180) / 360 * 800;
            double y = (90 - destination.getLatitude()) / 180 * 600;

            StackPane marker = new StackPane();
            Circle pin = new Circle(10, Color.valueOf("#0d9488"));
            pin.setStroke(Color.WHITE);
            pin.setStrokeWidth(2);

            Label label = new Label(destination.getName());
            label.setVisible(false);
            label.setStyle("-fx-background-color: white; -fx-background-radius: 4; -fx-padding: 4 8; -fx-font-size: 10;");

            marker.getChildren().addAll(pin, label);
            marker.setLayoutX(x);
            marker.setLayoutY(y);

            marker.setOnMouseEntered(e -> {
                pin.setRadius(12);
                label.setVisible(true);
            });

            marker.setOnMouseExited(e -> {
                if (selectedDestination == null || selectedDestination.getId() != destination.getId()) {
                    pin.setRadius(10);
                    label.setVisible(false);
                }
            });

            marker.setOnMouseClicked(e -> selectDestination(destination));
            markersPane.getChildren().add(marker);
        }

        return markersPane;
    }

    private void selectDestination(Destination destination) {
        selectedDestination = destination;
        updateDestinationDetails();
        System.out.println("Selected destination: " + destination.getName());
    }

    private void updateDestinationDetails() {
        if (selectedDestination == null) {
            destinationDetails.setVisible(false);
            return;
        }

        destinationDetails.getChildren().clear();
        destinationDetails.setVisible(true);

        VBox detailsContent = new VBox(10);
        detailsContent.setPadding(new Insets(15));

        HBox header = new HBox(10);
        header.setAlignment(Pos.CENTER_LEFT);

        VBox titleBox = new VBox();
        titleBox.getChildren().addAll(
                new Label(selectedDestination.getName()),
                new Label(selectedDestination.getCountry())
        );

        Label ratingLabel = new Label(String.format("%.1f", selectedDestination.getRating()));
        HBox ratingBox = new HBox(ratingLabel);
        ratingBox.setStyle("-fx-background-color: #ccfbf1; -fx-background-radius: 4; -fx-padding: 4 8;");

        header.getChildren().addAll(titleBox, ratingBox);

        Label descriptionLabel = new Label(selectedDestination.getDescription());
        descriptionLabel.setWrapText(true);
        descriptionLabel.setStyle("-fx-font-size: 14; -fx-text-fill: #4b5563;");

        HBox buttons = new HBox(10);
        Button directionsButton = new Button("Directions");
        directionsButton.setStyle("-fx-background-color: #0d9488; -fx-text-fill: white;");
        Button infoButton = new Button("More Info");
        infoButton.setStyle("-fx-background-color: white; -fx-border-color: #d1d5db;");
        buttons.getChildren().addAll(directionsButton, infoButton);

        detailsContent.getChildren().addAll(header, descriptionLabel, buttons);
        destinationDetails.getChildren().add(detailsContent);
    }

    private void toggleSidebar() {
        sidebarVisible = !sidebarVisible;
        root.setLeft(sidebarVisible ? sidebar : null);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
