package com.example.cocomo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DataSceneB {
    private DataSceneB(){}

    public static HashMap<String, HashMap<String, Double>> fillData(){
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        map.put(TYPES.RELY.type, new HashMap<>() {{
            this.put("Very Low", 0.75);
            this.put("Low", 0.88);
            this.put("Nominal", 1.0);
            this.put("High", 1.15);
            this.put("Extra High", 1.4);
        }});

        map.put(TYPES.DATA.type, new HashMap<>() {{
            this.put("Low", 0.94);
            this.put("Nominal", 1.0);
            this.put("High", 1.08);
            this.put("Extra High", 1.16);
        }});

        map.put(TYPES.CPLX.type, new HashMap<>() {{
            this.put("Very Low", 0.7);
            this.put("Low", 0.85);
            this.put("Nominal", 1.0);
            this.put("High", 1.15);
            this.put("Very high", 1.3);
            this.put("Extra High", 1.65);

        }});

        map.put(TYPES.TIME.type, new HashMap<>() {{
            this.put("Nominal", 1.0);
            this.put("High", 1.11);
            this.put("Very high", 1.3);
            this.put("Extra High", 1.66);
        }});

        map.put(TYPES.STOR.type, new HashMap<>() {{
            this.put("Nominal", 1.0);
            this.put("High", 1.06);
            this.put("Very high", 1.21);
            this.put("Extra High", 1.56);
        }});

        map.put(TYPES.VIRT.type, new HashMap<>() {{
            this.put("Low", 0.87);
            this.put("Nominal", 1.0);
            this.put("High", 1.15);
            this.put("Very high", 1.3);
        }});

        map.put(TYPES.TURN.type, new HashMap<>() {{
            this.put("Low", 0.87);
            this.put("Nominal", 1.0);
            this.put("High", 1.07);
            this.put("Very high", 1.15);
        }});

        map.put(TYPES.ACAP.type, new HashMap<>() {{
            this.put("Very Low", 1.46);
            this.put("Low", 1.19);
            this.put("Nominal", 1.0);
            this.put("High", 0.86);
            this.put("Very high", 0.71);
        }});

        map.put(TYPES.AEXP.type, new HashMap<>() {{
            this.put("Very Low", 1.29);
            this.put("Low", 1.13);
            this.put("Nominal", 1.0);
            this.put("High", 0.91);
            this.put("Very high", 0.82);
        }});

        map.put(TYPES.PCAP.type, new HashMap<>() {{
            this.put("Very Low", 1.42);
            this.put("Low", 1.17);
            this.put("Nominal", 1.0);
            this.put("High", 0.86);
            this.put("Very high", 0.7);
        }});

        map.put(TYPES.VEXP.type, new HashMap<>() {{
            this.put("Very Low", 1.21);
            this.put("Low", 1.10);
            this.put("Nominal", 1.0);
            this.put("High", 0.9);
        }});

        map.put(TYPES.LEXP.type, new HashMap<>() {{
            this.put("Very Low", 1.14);
            this.put("Low", 1.07);
            this.put("Nominal", 1.0);
            this.put("High", 0.95);
        }});

        map.put(TYPES.MODP.type, new HashMap<>() {{
            this.put("Very Low", 1.24);
            this.put("Low", 1.10);
            this.put("Nominal", 1.0);
            this.put("High", 0.91);
            this.put("Very high", 0.82);
        }});

        map.put(TYPES.TOOL.type, new HashMap<>() {{
            this.put("Very Low", 1.24);
            this.put("Low", 1.10);
            this.put("Nominal", 1.0);
            this.put("High", 0.91);
            this.put("Very high", 0.83);
        }});

        map.put(TYPES.SCED.type, new HashMap<>() {{
            this.put("Very Low", 1.23);
            this.put("Low", 1.08);
            this.put("Nominal", 1.0);
            this.put("High", 1.04);
            this.put("Very high", 1.10);
        }});

        return map;
    }


    public static ObservableList<Item> generateItems(String type, List<String> strings) {
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item("Very Low", type),
                new Item("Low", type),
                new Item("Nominal", type),
                new Item("High", type),
                new Item("Very High", type),
                new Item("Extra High", type)
        ));

        final List<Item> filteredList = items.stream()
                .filter(item -> !strings.contains(item.getChoice()))
                .collect(Collectors.toList());

        return FXCollections.observableArrayList(filteredList);
    }

    public static Item generateMediumItem(String type) {
        return new Item("Nominal", type);
    }
}
