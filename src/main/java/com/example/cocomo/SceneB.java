package com.example.cocomo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class SceneB {
    private final Stage mainStage;
    private final double[][] table;
    private final HashMap<String, HashMap<String, Double>> attributes;

    public SceneB(Stage mainStage) {
        this.mainStage = mainStage;
        this.table = new double[][]{
                {3.2, 1.05, 2.5, 0.38},
                {3.0, 1.12, 2.5, 0.35},
                {2.8, 1.20, 2.5, 0.32}};
        this.attributes = DataSceneB.fillData();
    }

    public Scene createScene() {
        return new Scene(createElementsSceneB(), 1100, 650);
    }

    public BorderPane createElementsSceneB() {
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

        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-font-size: 14px");

        BorderPane.setAlignment(vBox, Pos.CENTER);
        BorderPane.setMargin(vBox, new Insets(12, 12, 12, 12));
        borderPane.setCenter(vBox);

        Button menu = new Button("Return to menu");
        menu.setOnAction(actionEvent -> new MainView(mainStage));

        VBox hBox1 = new VBox();
        hBox1.setPadding(new Insets(10));
        hBox1.setSpacing(30);
        hBox1.setAlignment(Pos.CENTER);

        reset.setOnAction(actionEvent -> {
            hBox1.getChildren().clear();
            vBox.setStyle("-fx-font-size: 14px");
            textField.setText("");
            hBox1.setStyle(null);
        });

        VBox vBox2 = new VBox();
        Label label = new Label("Product Attributes");
        HBox hBox2 = new HBox();
        Label label1 = new Label(TYPES.RELY.type);
        ChoiceBox<Item> choiceBox = new ChoiceBox<>(DataSceneB.generateItems(TYPES.RELY.type,
                new ArrayList<>(List.of("Extra High"))));
        choiceBox.setValue(DataSceneB.generateMediumItem(TYPES.RELY.type));
        Label label2 = new Label(TYPES.DATA.type);
        ChoiceBox<Item> choiceBox1 = new ChoiceBox<>(DataSceneB.generateItems(TYPES.DATA.type,
                new ArrayList<>(List.of("Extra High"))));
        choiceBox1.setValue(DataSceneB.generateMediumItem(TYPES.DATA.type));
        Label label3 = new Label(TYPES.CPLX.type);
        ChoiceBox<Item> choiceBox2 = new ChoiceBox<>(DataSceneB.generateItems(TYPES.CPLX.type, new ArrayList<>()));
        choiceBox2.setValue(DataSceneB.generateMediumItem(TYPES.CPLX.type));

        hBox2.getChildren().addAll(label1, choiceBox, label2, choiceBox1, label3, choiceBox2);
        hBox2.setSpacing(15);
        hBox2.setAlignment(Pos.CENTER);
        vBox2.getChildren().addAll(label, hBox2);
        vBox2.setSpacing(20);
        vBox2.setAlignment(Pos.CENTER);

        VBox vBox3 = new VBox();
        Label label4 = new Label("Hardware Аttributes");
        HBox hBox3 = new HBox();
        Label label5 = new Label(TYPES.TIME.type);
        ChoiceBox<Item> choiceBox3 = new ChoiceBox<>(DataSceneB.generateItems(TYPES.TIME.type,
                new ArrayList<>(List.of("Very Low", "Low"))));
        choiceBox3.setValue(DataSceneB.generateMediumItem(TYPES.TIME.type));
        Label label6 = new Label(TYPES.STOR.type);
        ChoiceBox<Item> choiceBox4 = new ChoiceBox<>(DataSceneB.generateItems(TYPES.STOR.type,
                new ArrayList<>(List.of("Very Low", "Low"))));
        choiceBox4.setValue(DataSceneB.generateMediumItem(TYPES.STOR.type));
        Label label7 = new Label(TYPES.VIRT.type);
        ChoiceBox<Item> choiceBox5 = new ChoiceBox<>(DataSceneB.generateItems(TYPES.VIRT.type,
                new ArrayList<>(List.of("Very Low", "Extra High"))));
        choiceBox5.setValue(DataSceneB.generateMediumItem(TYPES.VIRT.type));
        Label label8 = new Label(TYPES.TURN.type);
        ChoiceBox<Item> choiceBox6 = new ChoiceBox<>(DataSceneB.generateItems(TYPES.TURN.type,
                new ArrayList<>(List.of("Very Low", "Low"))));
        choiceBox6.setValue(DataSceneB.generateMediumItem(TYPES.TURN.type));


        hBox3.getChildren().addAll(label5, choiceBox3, label6, choiceBox4, label7, choiceBox5,
                label8, choiceBox6);
        hBox3.setSpacing(15);
        hBox3.setAlignment(Pos.CENTER);
        vBox3.getChildren().addAll(label4, hBox3);
        vBox3.setSpacing(20);
        vBox3.setAlignment(Pos.CENTER);

        VBox vBox4 = new VBox();
        Label label10 = new Label("Personnel Аttributes");
        HBox hBox4 = new HBox();
        Label label11 = new Label(TYPES.ACAP.type);
        ChoiceBox<Item> choiceBox7 = new ChoiceBox<>(DataSceneB.generateItems(TYPES.ACAP.type,
                new ArrayList<>(List.of("Extra High"))));
        choiceBox7.setValue(DataSceneB.generateMediumItem(TYPES.ACAP.type));
        Label label12 = new Label(TYPES.AEXP.type);
        ChoiceBox<Item> choiceBox8 = new ChoiceBox<>(DataSceneB.generateItems(TYPES.AEXP.type,
                new ArrayList<>(List.of("Extra High"))));
        choiceBox8.setValue(DataSceneB.generateMediumItem(TYPES.AEXP.type));
        Label label13 = new Label(TYPES.PCAP.type);
        ChoiceBox<Item> choiceBox9 = new ChoiceBox<>(DataSceneB.generateItems(TYPES.PCAP.type,
                new ArrayList<>(List.of("Extra High"))));
        choiceBox9.setValue(DataSceneB.generateMediumItem(TYPES.PCAP.type));
        Label label14 = new Label(TYPES.VEXP.type);
        ChoiceBox<Item> choiceBox10 = new ChoiceBox<>(DataSceneB.generateItems(TYPES.VEXP.type,
                new ArrayList<>(List.of("Extra High", "Very High"))));
        choiceBox10.setValue(DataSceneB.generateMediumItem(TYPES.VEXP.type));
        Label label15 = new Label(TYPES.LEXP.type);
        ChoiceBox<Item> choiceBox11 = new ChoiceBox<>(DataSceneB.generateItems(TYPES.LEXP.type,
                new ArrayList<>(List.of("Extra High", "Very High"))));
        choiceBox11.setValue(DataSceneB.generateMediumItem(TYPES.LEXP.type));

        hBox4.getChildren().addAll(label11, choiceBox7, label12, choiceBox8, label13, choiceBox9,
                label14, choiceBox10, label15, choiceBox11);
        hBox4.setSpacing(15);
        hBox4.setAlignment(Pos.CENTER);
        vBox4.getChildren().addAll(label10, hBox4);
        vBox4.setSpacing(20);
        vBox4.setAlignment(Pos.CENTER);

        VBox vBox5 = new VBox();
        Label label16 = new Label("Project Аttributes");
        HBox hBox5 = new HBox();
        Label label17 = new Label(TYPES.MODP.type);
        ChoiceBox<Item> choiceBox12 = new ChoiceBox<>(DataSceneB.generateItems(TYPES.MODP.type,
                new ArrayList<>(List.of("Extra High"))));
        choiceBox12.setValue(DataSceneB.generateMediumItem(TYPES.MODP.type));
        Label label18 = new Label(TYPES.TOOL.type);
        ChoiceBox<Item> choiceBox13 = new ChoiceBox<>(DataSceneB.generateItems(TYPES.TOOL.type,
                new ArrayList<>(List.of("Extra High"))));
        choiceBox13.setValue(DataSceneB.generateMediumItem(TYPES.TOOL.type));
        Label label19 = new Label(TYPES.SCED.type);
        ChoiceBox<Item> choiceBox14 = new ChoiceBox<>(DataSceneB.generateItems(TYPES.SCED.type,
                new ArrayList<>(List.of("Extra High"))));
        choiceBox14.setValue(DataSceneB.generateMediumItem(TYPES.SCED.type));

        hBox5.getChildren().addAll(label17, choiceBox12, label18, choiceBox13, label19, choiceBox14);
        hBox5.setSpacing(15);
        hBox5.setAlignment(Pos.CENTER);
        vBox5.getChildren().addAll(label16, hBox5);
        vBox5.setSpacing(20);
        vBox5.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(vBox1, textField, hBox, vBox2, vBox3, vBox4, vBox5, menu);
        BorderPane.setAlignment(hBox1, Pos.TOP_RIGHT);
        borderPane.setRight(hBox1);
        borderPane.setMinWidth(1000);
        hBox1.setAlignment(Pos.TOP_LEFT);

        List<ChoiceBox<Item>> choiceBoxList = new ArrayList<>(Arrays.asList(
                choiceBox, choiceBox1, choiceBox2, choiceBox3, choiceBox4, choiceBox5,
                choiceBox6, choiceBox7, choiceBox8, choiceBox9, choiceBox10, choiceBox11,
                choiceBox12, choiceBox13, choiceBox14
        ));

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
                AtomicReference<Double> effortAdjustmentFactor = new AtomicReference<>((double) 1);

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

                choiceBoxList.forEach(value -> effortAdjustmentFactor.updateAndGet(v ->
                        v * attributes.get(value.getValue().getType())
                                .get(value.getValue().getChoice())));

                effort = table[model][0] * effortAdjustmentFactor.get() * Math.pow(size, table[model][1]);
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
                    Label leb = new Label(String.format("%s - %s", k, v));
                    hBox1.getChildren().add(leb);
                });

                vBox.setStyle("-fx-font-size: 15px;");
                hBox1.setStyle("-fx-background-color:#168878; -fx-font-size: 20px;");
                reset.setMinWidth(70);
                calculateComoco.setMinWidth(180);
                mainStage.setWidth(1200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return borderPane;
    }
}