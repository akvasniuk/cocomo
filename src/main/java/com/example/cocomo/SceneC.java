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

public class SceneC {
    private final Stage mainStage;
    private final HashMap<String, HashMap<String, Double>> attributes;
    private final List<ChoiceBox<Item>> choiceBoxListEarlyDesign = new ArrayList<>();
    private final List<ChoiceBox<Item>> choiceBoxListPostArch = new ArrayList<>();
    private final List<ChoiceBox<Item>> choiceBoxListScale = new ArrayList<>();

    public SceneC(Stage mainStage) {
        this.mainStage = mainStage;
        this.attributes = DataSceneC.fillData();
    }

    public Scene createScene() {
        return new Scene(createElementsSceneC(), 1100, 790);
    }

    public BorderPane createElementsSceneC() {
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox();

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton rb1 = new RadioButton(MODES.EARLY_DESIGN);
        RadioButton rb2 = new RadioButton(MODES.POST_ARCHITECTURE);

        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(rb1, rb2);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(20);

        rb1.setToggleGroup(toggleGroup);
        rb1.setSelected(true);
        rb2.setToggleGroup(toggleGroup);

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

        vBox.setSpacing(16);
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
        Label label = new Label("Scale Factors");
        HBox hBox2 = new HBox();
        Label label1 = new Label(TYPES.PREC.type);
        ChoiceBox<Item> choiceBox = new ChoiceBox<>(DataSceneC.generateItems(TYPES.PREC.type,
                new ArrayList<>(List.of("Extra Low"))));
        choiceBox.setValue(DataSceneC.generateMediumItem(TYPES.PREC.type));
        Label label2 = new Label(TYPES.FLEX.type);
        ChoiceBox<Item> choiceBox1 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.FLEX.type,
                new ArrayList<>(List.of("Extra Low"))));
        choiceBox1.setValue(DataSceneC.generateMediumItem(TYPES.FLEX.type));
        Label label3 = new Label(TYPES.RESL.type);
        ChoiceBox<Item> choiceBox2 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.RESL.type,
                new ArrayList<>(List.of("Extra Low"))));
        choiceBox2.setValue(DataSceneC.generateMediumItem(TYPES.RESL.type));
        Label label4 = new Label(TYPES.TEAM.type);
        ChoiceBox<Item> choiceBox3 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.TEAM.type,
                new ArrayList<>(List.of("Extra Low"))));
        choiceBox3.setValue(DataSceneC.generateMediumItem(TYPES.TEAM.type));
        Label label5 = new Label(TYPES.PMAT.type);
        ChoiceBox<Item> choiceBox4 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.PMAT.type,
                new ArrayList<>(List.of("Extra Low"))));
        choiceBox4.setValue(DataSceneC.generateMediumItem(TYPES.PMAT.type));

        choiceBoxListScale.add(choiceBox);
        choiceBoxListScale.add(choiceBox1);
        choiceBoxListScale.add(choiceBox2);
        choiceBoxListScale.add(choiceBox3);
        choiceBoxListScale.add(choiceBox4);

        hBox2.getChildren().addAll(label1, choiceBox, label2, choiceBox1, label3, choiceBox2,
                label4, choiceBox3, label5, choiceBox4);
        hBox2.setSpacing(15);
        hBox2.setAlignment(Pos.CENTER);
        vBox2.getChildren().addAll(label, hBox2);
        vBox2.setSpacing(20);
        vBox2.setAlignment(Pos.CENTER);

        toggleGroup.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            RadioButton radioButton1 = (RadioButton) t1.getToggleGroup().getSelectedToggle();

            switch (radioButton1.getText()) {
                case MODES.EARLY_DESIGN:
                    vBox.getChildren().clear();
                    vBox.getChildren().addAll(vBox1, textField, hBox, vBox2, generateElementsEarlyDesign(), menu);
                    break;
                case MODES.POST_ARCHITECTURE:
                    vBox.getChildren().clear();
                    vBox.getChildren().addAll(vBox1, textField, hBox, vBox2, generateElementsPostArchitecture(), menu);
                    break;
                default:
                    System.out.println("ERROR");
            }
        });

        vBox.getChildren().addAll(vBox1, textField, hBox, vBox2, generateElementsEarlyDesign(), menu);
        BorderPane.setAlignment(hBox1, Pos.TOP_RIGHT);
        borderPane.setRight(hBox1);
        borderPane.setMinWidth(1000);
        hBox1.setAlignment(Pos.TOP_LEFT);

        calculateComoco.setOnAction(actionEvent -> {
            RadioButton radioButton = (RadioButton) toggleGroup.getSelectedToggle()
                    .getToggleGroup().getSelectedToggle();

            hBox1.getChildren().clear();

            try {
                double variableA_EARLY = 2.94;
                double variableA_POST = 2.45;
                double variableB = 0.91;
                double variableC = 3.67;
                double variableD = 0.28;
                int size = Integer.parseInt(textField.getText());
                double effort = 0;
                double time = 0;
                double staff;
                double productivity;

                AtomicReference<Double> effortAdjustmentFactor = new AtomicReference<>((double) 1);
                AtomicReference<Double> sumOfScale = new AtomicReference<>((double) 0);

                choiceBoxListScale.forEach(value -> sumOfScale.updateAndGet(v -> (v + attributes
                        .get(value.getValue().getType())
                        .get(value.getValue().getChoice()))));

                double variableE = variableB + 0.01 * sumOfScale.get();

                switch (radioButton.getText()) {
                    case MODES.EARLY_DESIGN:
                        choiceBoxListEarlyDesign.forEach(value -> effortAdjustmentFactor.updateAndGet(v ->
                                v * attributes.get(value.getValue().getType())
                                        .get(value.getValue().getChoice())));

                        effort = effortAdjustmentFactor.get() * variableA_EARLY * Math.pow(size, variableE);

                        time = getSCED(choiceBoxListEarlyDesign, TYPES.SCED_EARLY.type) * variableC
                                * Math.pow(getEffortWithoutSced(choiceBoxListEarlyDesign, variableA_EARLY,
                                size, variableE, TYPES.SCED_EARLY.type), variableD + 0.2 * (variableE - variableB));
                        break;
                    case MODES.POST_ARCHITECTURE:
                        choiceBoxListPostArch.forEach(value -> effortAdjustmentFactor.updateAndGet(v ->
                                v * attributes.get(value.getValue().getType())
                                        .get(value.getValue().getChoice())));

                        effort = effortAdjustmentFactor.get() * variableA_POST * Math.pow(size, variableE);

                        time = getSCED(choiceBoxListPostArch, TYPES.SCED_POST.type) * variableC
                                * Math.pow(getEffortWithoutSced(choiceBoxListPostArch, variableA_POST,
                                size, variableE, TYPES.SCED_EARLY.type), variableD + 0.2 * (variableE - variableB));
                        break;
                    default:
                        System.out.println("ERROR");
                }

                staff = effort / time;
                productivity = size / effort;

                double finalEffort = effort;
                double finalTime = time;
                LinkedHashMap<String, String> items = new LinkedHashMap<>() {
                    {
                        this.put("MODE", radioButton.getText());
                        this.put("KLOC", String.valueOf(size));
                        this.put("EFFORT(in person/months)", String.valueOf(finalEffort));
                        this.put("DURATION", String.valueOf(finalTime));
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

    private VBox generateElementsEarlyDesign() {
        VBox vBox = new VBox();

        VBox vBox1 = new VBox();
        Label label = new Label("Effort Adjustment Factor");

        HBox hBox = new HBox();
        Label label1 = new Label("Personnel Factors");
        Label label2 = new Label(TYPES.PERS.type);
        ChoiceBox<Item> choiceBox = new ChoiceBox<>(DataSceneC.generateItems(TYPES.PERS.type,
                new ArrayList<>(List.of())));
        choiceBox.setValue(DataSceneC.generateMediumItem(TYPES.PERS.type));
        Label label3 = new Label(TYPES.PREX.type);
        ChoiceBox<Item> choiceBox1 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.PREX.type,
                new ArrayList<>(List.of())));
        choiceBox1.setValue(DataSceneC.generateMediumItem(TYPES.PREX.type));

        hBox.getChildren().addAll(label2, choiceBox, label3, choiceBox1);
        hBox.setSpacing(15);
        hBox.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(label1, hBox);
        vBox1.setSpacing(20);
        vBox1.setAlignment(Pos.CENTER);

        VBox vBox2 = new VBox();
        HBox hBox1 = new HBox();
        Label label4 = new Label("Product Factors");
        Label label5 = new Label(TYPES.RCPX.type);
        ChoiceBox<Item> choiceBox2 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.RCPX.type,
                new ArrayList<>(List.of())));
        choiceBox2.setValue(DataSceneC.generateMediumItem(TYPES.RCPX.type));
        Label label6 = new Label(TYPES.RUSY.type);
        ChoiceBox<Item> choiceBox3 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.RUSE_EARLY.type,
                new ArrayList<>(List.of("Extra Low", "Very Low"))));
        choiceBox3.setValue(DataSceneC.generateMediumItem(TYPES.RUSE_EARLY.type));

        hBox1.getChildren().addAll(label5, choiceBox2, label6, choiceBox3);
        hBox1.setSpacing(15);
        hBox1.setAlignment(Pos.CENTER);
        vBox2.getChildren().addAll(label4, hBox1);
        vBox2.setSpacing(20);
        vBox2.setAlignment(Pos.CENTER);

        VBox vBox3 = new VBox();
        HBox hBox2 = new HBox();
        Label label7 = new Label("Platform Factors");
        Label label8 = new Label(TYPES.PDIF.type);
        ChoiceBox<Item> choiceBox4 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.PDIF.type,
                new ArrayList<>(List.of("Extra Low", "Very Low"))));
        choiceBox4.setValue(DataSceneC.generateMediumItem(TYPES.PDIF.type));

        hBox2.getChildren().addAll(label8, choiceBox4);
        hBox2.setSpacing(15);
        hBox2.setAlignment(Pos.CENTER);
        vBox3.getChildren().addAll(label7, hBox2);
        vBox3.setSpacing(20);
        vBox3.setAlignment(Pos.CENTER);

        VBox vBox4 = new VBox();
        HBox hBox3 = new HBox();
        Label label9 = new Label("Project Factors");
        Label label10 = new Label(TYPES.FCIL.type);
        ChoiceBox<Item> choiceBox5 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.FCIL.type,
                new ArrayList<>(List.of())));
        choiceBox5.setValue(DataSceneC.generateMediumItem(TYPES.FCIL.type));
        Label label11 = new Label(TYPES.SCED.type);
        ChoiceBox<Item> choiceBox6 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.SCED_EARLY.type,
                new ArrayList<>(List.of("Extra Low", "Very High", "Extra High"))));
        choiceBox6.setValue(DataSceneC.generateMediumItem(TYPES.SCED_EARLY.type));

        choiceBoxListEarlyDesign.add(choiceBox);
        choiceBoxListEarlyDesign.add(choiceBox1);
        choiceBoxListEarlyDesign.add(choiceBox2);
        choiceBoxListEarlyDesign.add(choiceBox3);
        choiceBoxListEarlyDesign.add(choiceBox4);
        choiceBoxListEarlyDesign.add(choiceBox5);
        choiceBoxListEarlyDesign.add(choiceBox6);

        hBox3.getChildren().addAll(label10, choiceBox5, label11, choiceBox6);
        hBox3.setSpacing(15);
        hBox3.setAlignment(Pos.CENTER);
        vBox4.getChildren().addAll(label9, hBox3);
        vBox4.setSpacing(20);
        vBox4.setAlignment(Pos.CENTER);


        vBox.getChildren().addAll(label, vBox1, vBox2, vBox3, vBox4);
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);

        return vBox;
    }

    private VBox generateElementsPostArchitecture() {
        VBox vBox = new VBox();

        VBox vBox1 = new VBox();
        Label label = new Label("Effort Adjustment Factor");

        HBox hBox = new HBox();
        Label label1 = new Label("Personnel Factors");
        Label label2 = new Label(TYPES.ACAP.type);
        ChoiceBox<Item> choiceBox = new ChoiceBox<>(DataSceneC.generateItems(TYPES.ACAP.type,
                new ArrayList<>(List.of("Extra High", "Extra Low"))));
        choiceBox.setValue(DataSceneC.generateMediumItem(TYPES.ACAP.type));
        Label label3 = new Label(TYPES.AEXP.type);
        ChoiceBox<Item> choiceBox1 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.AEXP.type,
                new ArrayList<>(List.of("Extra High", "Extra Low"))));
        choiceBox1.setValue(DataSceneC.generateMediumItem(TYPES.AEXP.type));
        Label label4 = new Label(TYPES.PCAP.type);
        ChoiceBox<Item> choiceBox2 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.PCAP.type,
                new ArrayList<>(List.of("Extra High", "Extra Low"))));
        choiceBox2.setValue(DataSceneC.generateMediumItem(TYPES.PCAP.type));
        Label label5 = new Label(TYPES.PCON.type);
        ChoiceBox<Item> choiceBox3 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.PCON.type,
                new ArrayList<>(List.of("Extra Low", "Extra High"))));
        choiceBox3.setValue(DataSceneC.generateMediumItem(TYPES.PCON.type));
        Label label6 = new Label(TYPES.PEXP.type);
        ChoiceBox<Item> choiceBox4 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.PEXP.type,
                new ArrayList<>(List.of("Extra Low", "Extra High"))));
        choiceBox4.setValue(DataSceneC.generateMediumItem(TYPES.PEXP.type));
        Label label7 = new Label(TYPES.LTEX.type);
        ChoiceBox<Item> choiceBox5 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.LTEX.type,
                new ArrayList<>(List.of("Extra Low", "Extra High"))));
        choiceBox5.setValue(DataSceneC.generateMediumItem(TYPES.LTEX.type));

        hBox.getChildren().addAll(label2, choiceBox, label3, choiceBox1, label4, choiceBox2,
                label5, choiceBox3, label6, choiceBox4, label7, choiceBox5);
        hBox.setSpacing(15);
        hBox.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(label1, hBox);
        vBox1.setSpacing(20);
        vBox1.setAlignment(Pos.CENTER);

        VBox vBox2 = new VBox();
        HBox hBox1 = new HBox();
        Label label8 = new Label("Product Factors");
        Label label9 = new Label(TYPES.RELY.type);
        ChoiceBox<Item> choiceBox6 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.RELY.type,
                new ArrayList<>(List.of("Extra Low", "Extra High"))));
        choiceBox6.setValue(DataSceneC.generateMediumItem(TYPES.RELY.type));
        Label label10 = new Label(TYPES.DATA.type);
        ChoiceBox<Item> choiceBox7 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.DATA.type,
                new ArrayList<>(List.of("Very Low", "Extra High", "Extra Low"))));
        choiceBox7.setValue(DataSceneC.generateMediumItem(TYPES.DATA.type));
        Label label11 = new Label(TYPES.CPLX.type);
        ChoiceBox<Item> choiceBox8 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.CPLX.type,
                new ArrayList<>(List.of("Extra Low"))));
        choiceBox8.setValue(DataSceneC.generateMediumItem(TYPES.CPLX.type));
        Label label12 = new Label(TYPES.RUSY.type);
        ChoiceBox<Item> choiceBox9 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.RUSE_POST.type,
                new ArrayList<>(List.of("Very Low", "Extra Low"))));
        choiceBox9.setValue(DataSceneC.generateMediumItem(TYPES.RUSE_POST.type));
        Label label13 = new Label(TYPES.DOCU.type);
        ChoiceBox<Item> choiceBox10 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.DOCU.type,
                new ArrayList<>(List.of("Extra High", "Extra Low"))));
        choiceBox10.setValue(DataSceneC.generateMediumItem(TYPES.DOCU.type));

        hBox1.getChildren().addAll(label9, choiceBox6, label10, choiceBox7, label11, choiceBox8,
                label12, choiceBox9, label13, choiceBox10);
        hBox1.setSpacing(15);
        hBox1.setAlignment(Pos.CENTER);
        vBox2.getChildren().addAll(label8, hBox1);
        vBox2.setSpacing(20);
        vBox2.setAlignment(Pos.CENTER);

        VBox vBox3 = new VBox();
        HBox hBox2 = new HBox();
        Label label14 = new Label("Platform Factors");
        Label label15 = new Label(TYPES.TIME.type);
        ChoiceBox<Item> choiceBox11 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.TIME.type,
                new ArrayList<>(List.of("Extra Low", "Very Low", "Low"))));
        choiceBox11.setValue(DataSceneC.generateMediumItem(TYPES.TIME.type));
        Label label16 = new Label(TYPES.STOR.type);
        ChoiceBox<Item> choiceBox12 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.STOR.type,
                new ArrayList<>(List.of("Extra Low", "Very Low", "Low"))));
        choiceBox12.setValue(DataSceneC.generateMediumItem(TYPES.STOR.type));
        Label label17 = new Label(TYPES.PVOL.type);
        ChoiceBox<Item> choiceBox13 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.PVOL.type,
                new ArrayList<>(List.of("Very Low", "Extra Low"))));
        choiceBox13.setValue(DataSceneC.generateMediumItem(TYPES.PVOL.type));

        hBox2.getChildren().addAll(label15, choiceBox11, label16, choiceBox12, label17, choiceBox13);
        hBox2.setSpacing(15);
        hBox2.setAlignment(Pos.CENTER);
        vBox3.getChildren().addAll(label14, hBox2);
        vBox3.setSpacing(20);
        vBox3.setAlignment(Pos.CENTER);

        VBox vBox4 = new VBox();
        HBox hBox3 = new HBox();
        Label label18 = new Label("Project Factors");
        Label label19 = new Label(TYPES.TOOL.type);
        ChoiceBox<Item> choiceBox14 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.TOOL.type,
                new ArrayList<>(List.of("Extra High", "Extra Low"))));
        choiceBox14.setValue(DataSceneC.generateMediumItem(TYPES.TOOL.type));
        Label label20 = new Label(TYPES.SITE.type);
        ChoiceBox<Item> choiceBox15 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.SITE.type,
                new ArrayList<>(List.of("Extra Low"))));
        choiceBox15.setValue(DataSceneC.generateMediumItem(TYPES.SITE.type));
        Label label21 = new Label(TYPES.SCED.type);
        ChoiceBox<Item> choiceBox16 = new ChoiceBox<>(DataSceneC.generateItems(TYPES.SCED_POST.type,
                new ArrayList<>(List.of("Extra High", "Extra Low"))));
        choiceBox16.setValue(DataSceneC.generateMediumItem(TYPES.SCED_POST.type));

        hBox3.getChildren().addAll(label19, choiceBox14, label20, choiceBox15, label21, choiceBox16);
        hBox3.setSpacing(15);
        hBox3.setAlignment(Pos.CENTER);
        vBox4.getChildren().addAll(label18, hBox3);
        vBox4.setSpacing(20);
        vBox4.setAlignment(Pos.CENTER);

        choiceBoxListPostArch.add(choiceBox);
        choiceBoxListPostArch.add(choiceBox1);
        choiceBoxListPostArch.add(choiceBox2);
        choiceBoxListPostArch.add(choiceBox3);
        choiceBoxListPostArch.add(choiceBox4);
        choiceBoxListPostArch.add(choiceBox5);
        choiceBoxListPostArch.add(choiceBox6);
        choiceBoxListPostArch.add(choiceBox7);
        choiceBoxListPostArch.add(choiceBox8);
        choiceBoxListPostArch.add(choiceBox9);
        choiceBoxListPostArch.add(choiceBox10);
        choiceBoxListPostArch.add(choiceBox11);
        choiceBoxListPostArch.add(choiceBox12);
        choiceBoxListPostArch.add(choiceBox13);
        choiceBoxListPostArch.add(choiceBox14);
        choiceBoxListPostArch.add(choiceBox15);
        choiceBoxListPostArch.add(choiceBox16);

        vBox.getChildren().addAll(label, vBox1, vBox2, vBox3, vBox4);
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);

        return vBox;
    }

    private double getSCED(List<ChoiceBox<Item>> choiceBoxes, String Sced) {
        AtomicReference<Double> sced = new AtomicReference<>((double) 0);

        choiceBoxes.forEach(value -> {
            if (value.getValue().getType().equals(Sced)) {
                sced.set(attributes.get(Sced).get(value.getValue().getChoice()));
            }
        });

        return sced.get();
    }

    private double getEffortWithoutSced(List<ChoiceBox<Item>> choiceBoxes, double variableA,
                                        double size, double variableE, String Sced) {
        AtomicReference<Double> effortAdjustmentFactor = new AtomicReference<>((double) 1);

        choiceBoxes.forEach(value -> {
            if (!value.getValue().getType().equals(Sced)) {
                effortAdjustmentFactor.updateAndGet(v ->
                        (v * attributes.get(value.getValue().getType())
                                .get(value.getValue().getChoice())));
            }
        });

        return effortAdjustmentFactor.get() * variableA * Math.pow(size, variableE);
    }
}