package com.example.cocomo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {
    private final Stage primaryStage;
    private final SceneA stageA;
    private final SceneB stageB;
    private final SceneC stageC;

    public MainView(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.stageA = new SceneA(primaryStage);
        this.stageB = new SceneB(primaryStage);
        this.stageC = new SceneC(primaryStage);

        menuStage();
    }


    public void show() {
        this.primaryStage.show();
    }

    public BorderPane menu() {
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox();

        Button sceneA = createButton(MenuType.BASIC_COCOMO.type);
        Button sceneB = createButton(MenuType.INTERMEDIATE_COCOMO.type);
        Button sceneC = createButton(MenuType.COCOMO_2.type);

        sceneA.setOnAction(actionEvent -> {
            primaryStage.setTitle(MenuType.BASIC_COCOMO.type);
            primaryStage.setScene(stageA.createScene());
        });

        sceneB.setOnAction(actionEvent -> {
            primaryStage.setTitle(MenuType.INTERMEDIATE_COCOMO.type);
            primaryStage.setScene(stageB.createScene());
        });

        sceneC.setOnAction(actionEvent -> {
            primaryStage.setTitle(MenuType.COCOMO_2.type);
            primaryStage.setScene(stageC.createScene());
        });

        vBox.setPadding(new Insets(10));
        vBox.setSpacing(30);
        vBox.getChildren().addAll(sceneA, sceneB, sceneC);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-font-size: 30px");

        BorderPane.setAlignment(vBox, Pos.CENTER);
        BorderPane.setMargin(vBox, new Insets(12, 12, 12, 12));
        borderPane.setCenter(vBox);
        borderPane.setStyle("-fx-background-color:#336699;");

        return borderPane;
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setStyle("-fx-background-color: " +
                "#ecebe9,\n" +
                "        rgba(0,0,0,0.05),\n" +
                "        linear-gradient(#dcca8a, #c7a740),\n" +
                "        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n" +
                "        linear-gradient(#f6ebbe, #e6c34d);" +
                "-fx-font-size: 30px");

        return button;
    }

    private void menuStage() {
        BorderPane borderMenu = menu();

        primaryStage.setTitle("Calculator menu");
        primaryStage.setScene(new Scene(borderMenu));
    }
}