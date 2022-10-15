package com.example.cocomo;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class SceneD {
    private final Stage mainStage;
    private final int[][] table;

    public SceneD(Stage mainStage) {
        this.mainStage = mainStage;
        this.table = new int[][]{
                {3, 4, 6},
                {4, 5, 7},
                {3, 4, 6},
                {7, 10, 15},
                {5, 7, 10}
        };
    }


    public Scene createScene() {
        return new Scene(createElementsSceneC(), 1130, 730);
    }

    public BorderPane createElementsSceneC() {
        BorderPane borderPane = new BorderPane();
        VBox vBox = new VBox();
        ScrollPane scrollPane = new ScrollPane(vBox);

        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Simple");
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("Average");
        RadioButton rb3 = new RadioButton("High");

        ToggleGroup toggleGroup1 = new ToggleGroup();
        RadioButton rb4 = new RadioButton("Simple");
        rb4.setSelected(true);
        RadioButton rb5 = new RadioButton("Average");
        RadioButton rb6 = new RadioButton("High");

        ToggleGroup toggleGroup2 = new ToggleGroup();
        RadioButton rb7 = new RadioButton("Simple");
        rb7.setSelected(true);
        RadioButton rb8 = new RadioButton("Average");
        RadioButton rb9 = new RadioButton("High");

        ToggleGroup toggleGroup3 = new ToggleGroup();
        RadioButton rb10 = new RadioButton("Simple");
        rb10.setSelected(true);
        RadioButton rb11 = new RadioButton("Average");
        RadioButton rb12 = new RadioButton("High");

        ToggleGroup toggleGroup4 = new ToggleGroup();
        RadioButton rb13 = new RadioButton("Simple");
        rb13.setSelected(true);
        RadioButton rb14 = new RadioButton("Average");
        RadioButton rb15 = new RadioButton("High");

        VBox hBox1 = new VBox();
        hBox1.setAlignment(Pos.TOP_RIGHT);
        hBox1.setSpacing(20);

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(new Label("Domain Characteristic Table"));
        hBox2.setAlignment(Pos.CENTER);

        HBox vBox3 = new HBox();
        vBox3.getChildren().addAll(rb1, rb2, rb3);
        vBox3.setAlignment(Pos.CENTER);
        vBox3.setSpacing(50);

        HBox hBox4 = new HBox();
        TextField textField = new TextField("0");
        hBox4.getChildren().addAll(new Label("Number of User Input"), textField, vBox3);
        hBox4.setAlignment(Pos.CENTER);
        hBox4.setSpacing(20);

        rb1.setToggleGroup(toggleGroup);
        rb2.setToggleGroup(toggleGroup);
        rb3.setToggleGroup(toggleGroup);

        rb4.setToggleGroup(toggleGroup1);
        rb5.setToggleGroup(toggleGroup1);
        rb6.setToggleGroup(toggleGroup1);

        HBox hBox5 = new HBox();
        hBox5.getChildren().addAll(rb4, rb5, rb6);
        hBox5.setAlignment(Pos.CENTER);
        hBox5.setSpacing(50);
        HBox hBox6 = new HBox();
        TextField textField1 = new TextField("0");
        hBox6.getChildren().addAll(new Label("Number of User Outputs"), textField1, hBox5);
        hBox6.setAlignment(Pos.CENTER);
        hBox6.setSpacing(20);

        rb7.setToggleGroup(toggleGroup2);
        rb8.setToggleGroup(toggleGroup2);
        rb9.setToggleGroup(toggleGroup2);
        HBox hBox7 = new HBox();
        hBox7.getChildren().addAll(rb7, rb8, rb9);
        hBox7.setAlignment(Pos.CENTER);
        hBox7.setSpacing(50);
        HBox hBox8 = new HBox();
        TextField textField2 = new TextField("0");
        hBox8.getChildren().addAll(new Label("Number of User Inquiries"), textField2, hBox7);
        hBox8.setAlignment(Pos.CENTER);
        hBox8.setSpacing(20);

        rb10.setToggleGroup(toggleGroup3);
        rb11.setToggleGroup(toggleGroup3);
        rb12.setToggleGroup(toggleGroup3);
        HBox hBox9 = new HBox();
        hBox9.getChildren().addAll(rb10, rb11, rb12);
        hBox9.setAlignment(Pos.CENTER);
        hBox9.setSpacing(50);
        HBox hBox10 = new HBox();
        TextField textField3 = new TextField("0");
        hBox10.getChildren().addAll(new Label("Number of Files"), textField3, hBox9);
        hBox10.setAlignment(Pos.CENTER);
        hBox10.setSpacing(20);

        rb13.setToggleGroup(toggleGroup4);
        rb14.setToggleGroup(toggleGroup4);
        rb15.setToggleGroup(toggleGroup4);
        HBox hBox11 = new HBox();
        hBox11.getChildren().addAll(rb13, rb14, rb15);
        hBox11.setAlignment(Pos.CENTER);
        hBox11.setSpacing(50);
        HBox hBox12 = new HBox();
        TextField textField4 = new TextField("0");
        hBox12.getChildren().addAll(new Label("Number of External Interfaces"), textField4, hBox11);
        hBox12.setAlignment(Pos.CENTER);
        hBox12.setSpacing(20);

        HBox hBox13 = new HBox();
        hBox13.getChildren().addAll(new Label("Complexity Adjustment Table"));
        hBox13.setAlignment(Pos.CENTER);

        HBox hBox14 = new HBox();
        ToggleGroup toggleGroup5 = new ToggleGroup();
        RadioButton r = new RadioButton("0");
        RadioButton r1 = new RadioButton("1");
        RadioButton r2 = new RadioButton("2");
        RadioButton r3 = new RadioButton("3");
        RadioButton r4 = new RadioButton("4");
        RadioButton r5 = new RadioButton("5");
        r.setSelected(true);
        r.setToggleGroup(toggleGroup5);
        r1.setToggleGroup(toggleGroup5);
        r2.setToggleGroup(toggleGroup5);
        r3.setToggleGroup(toggleGroup5);
        r4.setToggleGroup(toggleGroup5);
        r5.setToggleGroup(toggleGroup5);
        HBox hBox15 = new HBox();
        hBox15.getChildren().addAll(r, r1, r2, r3, r4, r5);
        hBox15.setAlignment(Pos.CENTER);
        hBox15.setSpacing(50);
        Label label = new Label("1. Does the system require backup and recovery?");
        label.setMinWidth(50);
        hBox14.getChildren().addAll(label, hBox15);
        hBox14.setAlignment(Pos.CENTER);
        hBox14.setSpacing(20);

        HBox hBox16 = new HBox();
        ToggleGroup toggleGroup6 = new ToggleGroup();
        RadioButton r6 = new RadioButton("0");
        r6.setSelected(true);
        RadioButton r7 = new RadioButton("1");
        RadioButton r8 = new RadioButton("2");
        RadioButton r9 = new RadioButton("3");
        RadioButton r10 = new RadioButton("4");
        RadioButton r11 = new RadioButton("5");
        r6.setToggleGroup(toggleGroup6);
        r7.setToggleGroup(toggleGroup6);
        r8.setToggleGroup(toggleGroup6);
        r9.setToggleGroup(toggleGroup6);
        r10.setToggleGroup(toggleGroup6);
        r11.setToggleGroup(toggleGroup6);
        HBox hBox17 = new HBox();
        hBox16.getChildren().addAll(r6, r7, r8, r9, r10, r11);
        hBox16.setAlignment(Pos.CENTER);
        hBox16.setSpacing(50);
        Label label1 = new Label("2. Are data communications required?");
        hBox17.getChildren().addAll(label1, hBox16);
        hBox17.setAlignment(Pos.CENTER);
        hBox17.setSpacing(20);

        HBox hBox18 = new HBox();
        ToggleGroup toggleGroup7 = new ToggleGroup();
        RadioButton r12 = new RadioButton("0");
        r12.setSelected(true);
        RadioButton r13 = new RadioButton("1");
        RadioButton r14 = new RadioButton("2");
        RadioButton r15 = new RadioButton("3");
        RadioButton r16 = new RadioButton("4");
        RadioButton r17 = new RadioButton("5");
        r12.setToggleGroup(toggleGroup7);
        r13.setToggleGroup(toggleGroup7);
        r14.setToggleGroup(toggleGroup7);
        r15.setToggleGroup(toggleGroup7);
        r16.setToggleGroup(toggleGroup7);
        r17.setToggleGroup(toggleGroup7);
        HBox hBox19 = new HBox();
        hBox18.getChildren().addAll(r12, r13, r14, r15, r16, r17);
        hBox18.setAlignment(Pos.CENTER);
        hBox18.setSpacing(50);
        hBox19.getChildren().addAll(new Label("3. Are there distribute processing functions?"), hBox18);
        hBox19.setAlignment(Pos.CENTER);
        hBox19.setSpacing(20);

        HBox hBox20 = new HBox();
        ToggleGroup toggleGroup8 = new ToggleGroup();
        RadioButton r18 = new RadioButton("0");
        r18.setSelected(true);
        RadioButton r19 = new RadioButton("1");
        RadioButton r20 = new RadioButton("2");
        RadioButton r21 = new RadioButton("3");
        RadioButton r22 = new RadioButton("4");
        RadioButton r23 = new RadioButton("5");
        r18.setToggleGroup(toggleGroup8);
        r19.setToggleGroup(toggleGroup8);
        r20.setToggleGroup(toggleGroup8);
        r21.setToggleGroup(toggleGroup8);
        r22.setToggleGroup(toggleGroup8);
        r23.setToggleGroup(toggleGroup8);
        HBox hBox21 = new HBox();
        hBox20.getChildren().addAll(r18, r19, r20, r21, r22, r23);
        hBox20.setAlignment(Pos.CENTER);
        hBox20.setSpacing(50);
        hBox21.getChildren().addAll(new Label("4. Is performance critical?"), hBox20);
        hBox21.setAlignment(Pos.CENTER);
        hBox21.setSpacing(20);

        HBox hBox22 = new HBox();
        ToggleGroup toggleGroup9 = new ToggleGroup();
        RadioButton r24 = new RadioButton("0");
        r24.setSelected(true);
        RadioButton r25 = new RadioButton("1");
        RadioButton r26 = new RadioButton("2");
        RadioButton r27 = new RadioButton("3");
        RadioButton r28 = new RadioButton("4");
        RadioButton r29 = new RadioButton("5");
        r24.setToggleGroup(toggleGroup9);
        r25.setToggleGroup(toggleGroup9);
        r26.setToggleGroup(toggleGroup9);
        r27.setToggleGroup(toggleGroup9);
        r28.setToggleGroup(toggleGroup9);
        r29.setToggleGroup(toggleGroup9);
        HBox hBox23 = new HBox();
        hBox22.getChildren().addAll(r24, r25, r26, r27, r28, r29);
        hBox22.setAlignment(Pos.CENTER);
        hBox22.setSpacing(50);
        hBox23.getChildren().addAll(new Label("5. Will the system run in an existing, heavily utilized operational environment?"), hBox22);
        hBox23.setAlignment(Pos.CENTER);
        hBox23.setSpacing(20);

        HBox hBox24 = new HBox();
        ToggleGroup toggleGroup10 = new ToggleGroup();
        RadioButton r30 = new RadioButton("0");
        r30.setSelected(true);
        RadioButton r31 = new RadioButton("1");
        RadioButton r32 = new RadioButton("2");
        RadioButton r33 = new RadioButton("3");
        RadioButton r34 = new RadioButton("4");
        RadioButton r35 = new RadioButton("5");
        r30.setToggleGroup(toggleGroup10);
        r31.setToggleGroup(toggleGroup10);
        r32.setToggleGroup(toggleGroup10);
        r33.setToggleGroup(toggleGroup10);
        r34.setToggleGroup(toggleGroup10);
        r35.setToggleGroup(toggleGroup10);
        HBox hBox25 = new HBox();
        hBox24.getChildren().addAll(r30, r31, r32, r33, r34, r35);
        hBox24.setAlignment(Pos.CENTER);
        hBox24.setSpacing(50);
        hBox25.getChildren().addAll(new Label("6. Does the system require on-line data entry?"), hBox24);
        hBox25.setAlignment(Pos.CENTER);
        hBox25.setSpacing(20);


        HBox hBox26 = new HBox();
        ToggleGroup toggleGroup11 = new ToggleGroup();
        RadioButton r36 = new RadioButton("0");
        r36.setSelected(true);
        RadioButton r37 = new RadioButton("1");
        RadioButton r38 = new RadioButton("2");
        RadioButton r39 = new RadioButton("3");
        RadioButton r40 = new RadioButton("4");
        RadioButton r41 = new RadioButton("5");
        r36.setToggleGroup(toggleGroup11);
        r37.setToggleGroup(toggleGroup11);
        r38.setToggleGroup(toggleGroup11);
        r39.setToggleGroup(toggleGroup11);
        r40.setToggleGroup(toggleGroup11);
        r41.setToggleGroup(toggleGroup11);
        HBox hBox27 = new HBox();
        hBox26.getChildren().addAll(r36, r37, r38, r39, r40, r41);
        hBox26.setAlignment(Pos.CENTER);
        hBox26.setSpacing(50);
        hBox27.getChildren().addAll(new Label("7. Does the on-line data entry require the input transaction to be built over multiple...?"), hBox26);
        hBox27.setAlignment(Pos.CENTER);
        hBox27.setSpacing(20);

        HBox hBox28 = new HBox();
        ToggleGroup toggleGroup12 = new ToggleGroup();
        RadioButton r42 = new RadioButton("0");
        r42.setSelected(true);
        RadioButton r43 = new RadioButton("1");
        RadioButton r44 = new RadioButton("2");
        RadioButton r45 = new RadioButton("3");
        RadioButton r46 = new RadioButton("4");
        RadioButton r47 = new RadioButton("5");
        r42.setToggleGroup(toggleGroup12);
        r43.setToggleGroup(toggleGroup12);
        r44.setToggleGroup(toggleGroup12);
        r45.setToggleGroup(toggleGroup12);
        r46.setToggleGroup(toggleGroup12);
        r47.setToggleGroup(toggleGroup12);
        HBox hBox29 = new HBox();
        hBox28.getChildren().addAll(r42, r43, r44, r45, r46, r47);
        hBox28.setAlignment(Pos.CENTER);
        hBox28.setSpacing(50);
        hBox29.getChildren().addAll(new Label("8. Are the master files update on-line?"), hBox28);
        hBox29.setAlignment(Pos.CENTER);
        hBox29.setSpacing(20);

        HBox hBox30 = new HBox();
        ToggleGroup toggleGroup13 = new ToggleGroup();
        RadioButton r48 = new RadioButton("0");
        r48.setSelected(true);
        RadioButton r49 = new RadioButton("1");
        RadioButton r50 = new RadioButton("2");
        RadioButton r51 = new RadioButton("3");
        RadioButton r52 = new RadioButton("4");
        RadioButton r53 = new RadioButton("5");
        r48.setToggleGroup(toggleGroup13);
        r49.setToggleGroup(toggleGroup13);
        r50.setToggleGroup(toggleGroup13);
        r51.setToggleGroup(toggleGroup13);
        r52.setToggleGroup(toggleGroup13);
        r53.setToggleGroup(toggleGroup13);
        HBox hBox31 = new HBox();
        hBox30.getChildren().addAll(r48, r49, r50, r51, r52, r53);
        hBox30.setAlignment(Pos.CENTER);
        hBox30.setSpacing(50);
        hBox31.getChildren().addAll(new Label("9. Are the inputs, outputs, files or inquiries complex?"), hBox30);
        hBox31.setAlignment(Pos.CENTER);
        hBox31.setSpacing(20);

        HBox hBox32 = new HBox();
        ToggleGroup toggleGroup14 = new ToggleGroup();
        RadioButton r54 = new RadioButton("0");
        r54.setSelected(true);
        RadioButton r55 = new RadioButton("1");
        RadioButton r56 = new RadioButton("2");
        RadioButton r57 = new RadioButton("3");
        RadioButton r58 = new RadioButton("4");
        RadioButton r59 = new RadioButton("5");
        r54.setToggleGroup(toggleGroup14);
        r55.setToggleGroup(toggleGroup14);
        r56.setToggleGroup(toggleGroup14);
        r57.setToggleGroup(toggleGroup14);
        r58.setToggleGroup(toggleGroup14);
        r59.setToggleGroup(toggleGroup14);
        HBox hBox33 = new HBox();
        hBox32.getChildren().addAll(r54, r55, r56, r57, r58, r59);
        hBox32.setAlignment(Pos.CENTER);
        hBox32.setSpacing(50);
        hBox33.getChildren().addAll(new Label("10. Is the internal processing complex?"), hBox32);
        hBox33.setAlignment(Pos.CENTER);
        hBox33.setSpacing(20);

        HBox hBox34 = new HBox();
        ToggleGroup toggleGroup15 = new ToggleGroup();
        RadioButton r60 = new RadioButton("0");
        r60.setSelected(true);
        RadioButton r61 = new RadioButton("1");
        RadioButton r62 = new RadioButton("2");
        RadioButton r63 = new RadioButton("3");
        RadioButton r64 = new RadioButton("4");
        RadioButton r65 = new RadioButton("5");
        r60.setToggleGroup(toggleGroup15);
        r61.setToggleGroup(toggleGroup15);
        r62.setToggleGroup(toggleGroup15);
        r63.setToggleGroup(toggleGroup15);
        r64.setToggleGroup(toggleGroup15);
        r65.setToggleGroup(toggleGroup15);
        HBox hBox35 = new HBox();
        hBox34.getChildren().addAll(r60, r61, r62, r63, r64, r65);
        hBox34.setAlignment(Pos.CENTER);
        hBox34.setSpacing(50);
        hBox35.getChildren().addAll(new Label("11. Is the code to be designed reusable?"), hBox34);
        hBox35.setAlignment(Pos.CENTER);
        hBox35.setSpacing(20);

        HBox hBox36 = new HBox();
        ToggleGroup toggleGroup16 = new ToggleGroup();
        RadioButton r66 = new RadioButton("0");
        r66.setSelected(true);
        RadioButton r67 = new RadioButton("1");
        RadioButton r68 = new RadioButton("2");
        RadioButton r69 = new RadioButton("3");
        RadioButton r70 = new RadioButton("4");
        RadioButton r71 = new RadioButton("5");
        r66.setToggleGroup(toggleGroup16);
        r67.setToggleGroup(toggleGroup16);
        r68.setToggleGroup(toggleGroup16);
        r69.setToggleGroup(toggleGroup16);
        r70.setToggleGroup(toggleGroup16);
        r71.setToggleGroup(toggleGroup16);
        HBox hBox37 = new HBox();
        hBox36.getChildren().addAll(r66, r67, r68, r69, r70, r71);
        hBox36.setAlignment(Pos.CENTER);
        hBox36.setSpacing(50);
        hBox37.getChildren().addAll(new Label("12. Are conversion and installation included in the design?"), hBox36);
        hBox37.setAlignment(Pos.CENTER);
        hBox37.setSpacing(20);

        HBox hBox38 = new HBox();
        ToggleGroup toggleGroup17 = new ToggleGroup();
        RadioButton r72 = new RadioButton("0");
        r72.setSelected(true);
        RadioButton r73 = new RadioButton("1");
        RadioButton r74 = new RadioButton("2");
        RadioButton r75 = new RadioButton("3");
        RadioButton r76 = new RadioButton("4");
        RadioButton r77 = new RadioButton("5");
        r72.setToggleGroup(toggleGroup17);
        r73.setToggleGroup(toggleGroup17);
        r74.setToggleGroup(toggleGroup17);
        r75.setToggleGroup(toggleGroup17);
        r76.setToggleGroup(toggleGroup17);
        r77.setToggleGroup(toggleGroup17);
        HBox hBox39 = new HBox();
        hBox38.getChildren().addAll(r72, r73, r74, r75, r76, r77);
        hBox38.setAlignment(Pos.CENTER);
        hBox38.setSpacing(50);
        hBox39.getChildren().addAll(new Label("13. Is the system designed for multiple installations in different org?"), hBox38);
        hBox39.setAlignment(Pos.CENTER);
        hBox39.setSpacing(20);

        HBox hBox40 = new HBox();
        ToggleGroup toggleGroup18 = new ToggleGroup();
        RadioButton r78 = new RadioButton("0");
        r78.setSelected(true);
        RadioButton r79 = new RadioButton("1");
        RadioButton r80 = new RadioButton("2");
        RadioButton r81 = new RadioButton("3");
        RadioButton r82 = new RadioButton("4");
        RadioButton r83 = new RadioButton("5");
        r78.setToggleGroup(toggleGroup18);
        r79.setToggleGroup(toggleGroup18);
        r80.setToggleGroup(toggleGroup18);
        r81.setToggleGroup(toggleGroup18);
        r82.setToggleGroup(toggleGroup18);
        r83.setToggleGroup(toggleGroup18);
        HBox hBox41 = new HBox();
        hBox40.getChildren().addAll(r78, r79, r80, r81, r82, r83);
        hBox40.setAlignment(Pos.CENTER);
        hBox40.setSpacing(50);
        hBox41.getChildren().addAll(new Label("14. Is the application designed to facilitate change and ease of use by the user?"), hBox40);
        hBox41.setAlignment(Pos.CENTER);
        hBox41.setSpacing(20);

        Button calculateComoco = new Button("Calculate");
        Button reset = new Button("Reset");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(calculateComoco, reset);
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(30);
        hBox.setAlignment(Pos.CENTER);

        vBox.setSpacing(16);
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-font-size: 14px");

        BorderPane.setAlignment(scrollPane, Pos.CENTER);
        borderPane.setCenter(scrollPane);

        Button menu = new Button("Return to menu");
        menu.setOnAction(actionEvent -> new MainView(mainStage));

        hBox1.setPadding(new Insets(10));
        hBox1.setSpacing(30);
        hBox1.setAlignment(Pos.TOP_RIGHT);

        reset.setOnAction(actionEvent -> {
            hBox1.getChildren().clear();
            vBox.setStyle("-fx-font-size: 14px");
            textField.setText("");
            hBox1.setStyle(null);
        });

        List<ItemP> itemPS = new ArrayList<>(List.of(
                new ItemP("DOS batch files", 128),
                new ItemP("Basic", 107),
                new ItemP("PL/1", 80),
                new ItemP("C#", 58),
                new ItemP("Advanced LISP", 56),
                new ItemP("Java", 55),
                new ItemP("JavaScript", 54),
                new ItemP("C++", 53),
                new ItemP("Visual Basic", 50),
                new ItemP("Database Languages", 40),
                new ItemP("Access", 38),
                new ItemP("Adoption support languages", 35),
                new ItemP("FoxPro 2.5", 34),
                new ItemP("DELPHI", 29),
                new ItemP("Standard object-oriented", 29),
                new ItemP("VB.Net", 28),
                new ItemP("Standard languages of the 4th generation", 20),
                new ItemP("HTML 3.0", 15),
                new ItemP("SQL", 13),
                new ItemP("SQL Forms", 11),
                new ItemP("Excel", 6)
        ));


        HBox hBo = new HBox();
        VBox vBo = new VBox();
        Label label2 = new Label("Select programming language");
        ChoiceBox<ItemP> itemPChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList(itemPS));
        itemPChoiceBox.setValue(itemPS.get(5));
        hBo.getChildren().addAll(label2, itemPChoiceBox);
        hBo.setSpacing(15);
        hBo.setAlignment(Pos.CENTER);
        vBo.getChildren().addAll(hBo);
        vBo.setSpacing(20);
        vBo.setAlignment(Pos.CENTER);

        vBox.getChildren().addAll(hBox2, hBox4, hBox6, hBox8, hBox10, hBox12, hBox13,
                hBox14, hBox17, hBox19, hBox21, hBox23, hBox25, hBox27, hBox29,
                hBox31, hBox33, hBox35, hBox37, hBox39, hBox1, hBox41, vBo, hBox, menu);
        BorderPane.setAlignment(hBox1, Pos.TOP_RIGHT);
        borderPane.setRight(hBox1);
        borderPane.setMinWidth(1000);
        hBox1.setAlignment(Pos.TOP_LEFT);

        calculateComoco.setOnAction(actionEvent -> {
            RadioButton radioButton = (RadioButton) toggleGroup.getSelectedToggle()
                    .getToggleGroup().getSelectedToggle();
            RadioButton radioButton1 = (RadioButton) toggleGroup1.getSelectedToggle()
                    .getToggleGroup().getSelectedToggle();
            RadioButton radioButton2 = (RadioButton) toggleGroup2.getSelectedToggle()
                    .getToggleGroup().getSelectedToggle();
            RadioButton radioButton3 = (RadioButton) toggleGroup3.getSelectedToggle()
                    .getToggleGroup().getSelectedToggle();
            RadioButton radioButton4 = (RadioButton) toggleGroup4.getSelectedToggle()
                    .getToggleGroup().getSelectedToggle();
            List<RadioButton> radioButtons = new ArrayList<>(Arrays.asList(radioButton, radioButton1, radioButton2,
                    radioButton3, radioButton4));
            List<TextField> textFields = new ArrayList<>(Arrays.asList(textField, textField1,
                    textField2, textField3, textField4));
            hBox1.getChildren().clear();

            List<RadioButton> radioButtons1 = new ArrayList<>(List.of(
                    (RadioButton) toggleGroup5.getSelectedToggle().getToggleGroup().getSelectedToggle(),
                    (RadioButton) toggleGroup6.getSelectedToggle().getToggleGroup().getSelectedToggle(),
                    (RadioButton) toggleGroup7.getSelectedToggle().getToggleGroup().getSelectedToggle(),
                    (RadioButton) toggleGroup8.getSelectedToggle().getToggleGroup().getSelectedToggle(),
                    (RadioButton) toggleGroup9.getSelectedToggle().getToggleGroup().getSelectedToggle(),
                    (RadioButton) toggleGroup10.getSelectedToggle().getToggleGroup().getSelectedToggle(),
                    (RadioButton) toggleGroup11.getSelectedToggle().getToggleGroup().getSelectedToggle(),
                    (RadioButton) toggleGroup12.getSelectedToggle().getToggleGroup().getSelectedToggle(),
                    (RadioButton) toggleGroup13.getSelectedToggle().getToggleGroup().getSelectedToggle(),
                    (RadioButton) toggleGroup14.getSelectedToggle().getToggleGroup().getSelectedToggle(),
                    (RadioButton) toggleGroup15.getSelectedToggle().getToggleGroup().getSelectedToggle(),
                    (RadioButton) toggleGroup16.getSelectedToggle().getToggleGroup().getSelectedToggle(),
                    (RadioButton) toggleGroup17.getSelectedToggle().getToggleGroup().getSelectedToggle(),
                    (RadioButton) toggleGroup18.getSelectedToggle().getToggleGroup().getSelectedToggle()
            ));

            try {
                int UFP = 0;
                int sumF = 0;
                for (int i = 0; i < radioButtons.size(); i++) {
                    switch (radioButtons.get(i).getText()) {
                        case "Simple":
                            UFP += Integer.parseInt(textFields.get(i).getText()) * table[i][0];
                            break;
                        case "Average":
                            UFP += Integer.parseInt(textFields.get(i).getText()) * table[i][1];
                            break;
                        case "High":
                            UFP += Integer.parseInt(textFields.get(i).getText()) * table[i][2];
                            break;
                    }
                }

                for (RadioButton button : radioButtons1) {
                    sumF += Integer.parseInt(button.getText());
                }

                double CAF = 0.65 + 0.01 * sumF;
                double FP = UFP * CAF;
                double LOC = FP * itemPChoiceBox.getValue().getValue();

                int finalUFP = UFP;
                LinkedHashMap<String, String> items = new LinkedHashMap<>() {
                    {
                        this.put("Unadjusted Function Points (UFP)", String.valueOf(finalUFP));
                        this.put("Complexity Adjustment Factor (CAF)", String.valueOf(CAF));
                        this.put("Function Points (FP)", String.valueOf(FP));
                        this.put("FP TO LOC", String.valueOf(LOC));
                    }
                };

                items.forEach((k, v) -> {
                    Label leb = new Label(String.format("%s - %s", k, v));
                    hBox1.getChildren().add(leb);
                });

                vBox.setStyle("-fx-font-size: 10px;");
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

    class ItemP {
        private final String name;
        private final int value;

        public ItemP(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
