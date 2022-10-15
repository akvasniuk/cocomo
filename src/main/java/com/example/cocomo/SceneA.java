package com.example.cocomo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.LinkedHashMap;

public class SceneA {
    private final Stage mainStage;
    private final double[][] table;

    public SceneA(Stage mainStage) {
        this.mainStage = mainStage;
        this.table = new double[][]{
                {2.4, 1.05, 2.5, 0.38},
                {3.0, 1.12, 2.5, 0.35},
                {3.6, 1.20, 2.5, 0.32}};
    }

    public Scene createScene() {
        return new Scene(createElementsSceneA(), 800, 600);
    }

    public BorderPane createElementsSceneA() {
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox();

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton rb1 = new RadioButton(MODES.ORGANIC_MODE);
        RadioButton rb2 = new RadioButton(MODES.SEMI_DETACHED_MODE);
        RadioButton rb3 = new RadioButton(MODES.EMBEDDED_MODE);

        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(rb1, rb2, rb3);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(20);

        rb1.setToggleGroup(toggleGroup);
        rb1.setSelected(true);
        rb2.setToggleGroup(toggleGroup);
        rb3.setToggleGroup(toggleGroup);

        TextField textField = new TextField();
        textField.setPromptText("KLOC");
        textField.setMaxWidth(300);

        Button calculateComoco = new Button("Calculate COCOMO");
        Button reset = new Button("Reset");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(calculateComoco, reset);
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(30);
        hBox.setAlignment(Pos.CENTER);

        vBox.setSpacing(30);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-font-size: 30px");

        BorderPane.setAlignment(vBox, Pos.CENTER);
        BorderPane.setMargin(vBox, new Insets(12, 12, 12, 12));
        borderPane.setCenter(vBox);

        Button menu = new Button("Return to menu");
        menu.setOnAction(actionEvent -> new MainView(mainStage));

        VBox hBox1 = new VBox();
        hBox1.setPadding(new Insets(10));
        hBox1.setSpacing(30);
        hBox1.setAlignment(Pos.CENTER);

        calculateComoco.setOnAction(actionEvent -> {
            hBox1.getChildren().clear();
            RadioButton radioButton = (RadioButton) toggleGroup.getSelectedToggle();
            int size;

            try {
                size = Integer.parseInt(textField.getText());

                int model;
                double effort;
                double time;
                double staff;
                double productivity;

                switch (radioButton.getText()) {
                    case MODES.ORGANIC_MODE:
                        model = 0;
                        break;
                    case MODES.SEMI_DETACHED_MODE:
                        model = 1;
                        break;
                    case MODES.EMBEDDED_MODE:
                        model = 2;
                        break;
                    default:
                        model = 3;
                }

                effort = table[model][0] * Math.pow(size, table[model][1]);
                time = table[model][2] * Math.pow(effort, table[model][3]);
                staff = effort / time;
                productivity = size / effort;

                int finalSize = size;
                LinkedHashMap<String, String> items = new LinkedHashMap<>() {
                    {
                        this.put("MODE", radioButton.getText());
                        this.put("A variable", String.valueOf(table[model][0]));
                        this.put("B variable", String.valueOf(table[model][1]));
                        this.put("C variable", String.valueOf(table[model][2]));
                        this.put("D variable", String.valueOf(table[model][3]));
                        this.put("KLOC", String.valueOf(finalSize));
                        this.put("EFFORT(in person/months)", String.valueOf(effort));
                        this.put("DURATION", String.valueOf(time));
                        this.put("STAFFING", String.valueOf(staff));
                        this.put("PRODUCTIVITY", String.valueOf(productivity));
                    }
                };

                items.forEach((k, v) -> {
                    Label label = new Label(String.format("%s - %s", k, v));
                    hBox1.getChildren().add(label);
                });

                vBox.setStyle("-fx-font-size: 15px;");
                hBox1.setStyle("-fx-background-color:#168878; -fx-font-size: 20px;");
                reset.setMinWidth(70);
                calculateComoco.setMinWidth(180);
                mainStage.setWidth(900);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        reset.setOnAction(actionEvent -> {
            hBox1.getChildren().clear();
            vBox.setStyle("-fx-font-size: 30px");
            textField.setText("");
            hBox1.setStyle(null);
        });

        vBox.getChildren().addAll(vBox1, textField, hBox, menu);
        BorderPane.setAlignment(hBox1, Pos.TOP_RIGHT);
        borderPane.setRight(hBox1);
        hBox1.setAlignment(Pos.TOP_LEFT);

        return borderPane;
    }
}
