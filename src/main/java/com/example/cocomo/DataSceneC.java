package com.example.cocomo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DataSceneC {
    private DataSceneC() {
    }

    public static HashMap<String, HashMap<String, Double>> fillData() {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        map.put(TYPES.PREC.type, new HashMap<>() {{
            this.put("Very Low", 6.2);
            this.put("Low", 4.96);
            this.put("Nominal", 3.72);
            this.put("High", 2.48);
            this.put("Very High", 1.24);
            this.put("Extra High", 0.0);
        }});

        map.put(TYPES.FLEX.type, new HashMap<>() {{
            this.put("Very Low", 5.07);
            this.put("Low", 4.05);
            this.put("Nominal", 3.04);
            this.put("High", 2.03);
            this.put("Very High", 1.01);
            this.put("Extra High", 0.0);
        }});

        map.put(TYPES.RESL.type, new HashMap<>() {{
            this.put("Very Low", 7.07);
            this.put("Low", 5.65);
            this.put("Nominal", 4.24);
            this.put("High", 2.83);
            this.put("Very High", 1.41);
            this.put("Extra High", 0.0);
        }});

        map.put(TYPES.TEAM.type, new HashMap<>() {{
            this.put("Very Low", 5.48);
            this.put("Low", 4.38);
            this.put("Nominal", 3.29);
            this.put("High", 2.19);
            this.put("Very High", 1.10);
            this.put("Extra High", 0.0);
        }});

        map.put(TYPES.PMAT.type, new HashMap<>() {{
            this.put("Very Low", 7.8);
            this.put("Low", 6.24);
            this.put("Nominal", 4.68);
            this.put("High", 3.12);
            this.put("Very High", 1.56);
            this.put("Extra High", 0.0);
        }});

        map.put(TYPES.PERS.type, new HashMap<>() {{
            this.put("Extra Low", 2.12);
            this.put("Very Low", 1.62);
            this.put("Low", 1.26);
            this.put("Nominal", 1.0);
            this.put("High", 0.83);
            this.put("Very High", 0.63);
            this.put("Extra High", 0.5);
        }});

        map.put(TYPES.PREX.type, new HashMap<>() {{
            this.put("Extra Low", 1.59);
            this.put("Very Low", 1.33);
            this.put("Low", 1.22);
            this.put("Nominal", 1.0);
            this.put("High", 0.87);
            this.put("Very High", 0.74);
            this.put("Extra High", 0.62);
        }});

        map.put(TYPES.RCPX.type, new HashMap<>() {{
            this.put("Extra Low", 0.49);
            this.put("Very Low", 0.6);
            this.put("Low", 0.83);
            this.put("Nominal", 1.0);
            this.put("High", 1.33);
            this.put("Very High", 1.91);
            this.put("Extra High", 2.72);
        }});

        map.put(TYPES.RUSE_EARLY.type, new HashMap<>() {{
            this.put("Low", 0.95);
            this.put("Nominal", 1.0);
            this.put("High", 1.07);
            this.put("Very High", 1.15);
            this.put("Extra High", 1.24);
        }});

        map.put(TYPES.PDIF.type, new HashMap<>() {{
            this.put("Low", 0.87);
            this.put("Nominal", 1.0);
            this.put("High", 1.29);
            this.put("Very High", 1.81);
            this.put("Extra High", 2.61);
        }});

        map.put(TYPES.FCIL.type, new HashMap<>() {{
            this.put("Extra Low", 1.43);
            this.put("Very Low", 1.3);
            this.put("Low", 1.1);
            this.put("Nominal", 1.0);
            this.put("High", 0.87);
            this.put("Very High", 0.73);
            this.put("Extra High", 0.62);
        }});

        map.put(TYPES.SCED_EARLY.type, new HashMap<>() {{
            this.put("Very Low", 1.43);
            this.put("Low", 1.14);
            this.put("Nominal", 1.0);
            this.put("High", 1.0);
        }});

        map.put(TYPES.ACAP.type, new HashMap<>() {{
            this.put("Very Low", 1.42);
            this.put("Low", 1.29);
            this.put("Nominal", 1.0);
            this.put("High", 0.85);
            this.put("Very high", 0.71);
        }});

        map.put(TYPES.AEXP.type, new HashMap<>() {{
            this.put("Very Low", 1.22);
            this.put("Low", 1.1);
            this.put("Nominal", 1.0);
            this.put("High", 0.88);
            this.put("Very high", 0.81);
        }});

        map.put(TYPES.PCAP.type, new HashMap<>() {{
            this.put("Very Low", 1.34);
            this.put("Low", 1.15);
            this.put("Nominal", 1.0);
            this.put("High", 0.88);
            this.put("Very high", 0.76);
        }});

        map.put(TYPES.PCON.type, new HashMap<>() {{
            this.put("Very Low", 1.29);
            this.put("Low", 1.12);
            this.put("Nominal", 1.0);
            this.put("High", 0.9);
            this.put("Very high", 0.81);
        }});

        map.put(TYPES.PEXP.type, new HashMap<>() {{
            this.put("Very Low", 1.19);
            this.put("Low", 1.09);
            this.put("Nominal", 1.0);
            this.put("High", 0.91);
            this.put("Very high", 0.85);
        }});

        map.put(TYPES.LTEX.type, new HashMap<>() {{
            this.put("Very Low", 1.2);
            this.put("Low", 1.09);
            this.put("Nominal", 1.0);
            this.put("High", 0.91);
            this.put("Very high", 0.84);
        }});

        map.put(TYPES.RELY.type, new HashMap<>() {{
            this.put("Very Low", 0.84);
            this.put("Low", 0.92);
            this.put("Nominal", 1.0);
            this.put("High", 1.1);
            this.put("Very high", 1.26);
        }});

        map.put(TYPES.DATA.type, new HashMap<>() {{
            this.put("Low", 0.23);
            this.put("Nominal", 1.0);
            this.put("High", 1.14);
            this.put("Very high", 1.28);
        }});

        map.put(TYPES.CPLX.type, new HashMap<>() {{
            this.put("Very Low", 0.73);
            this.put("Low", 0.87);
            this.put("Nominal", 1.0);
            this.put("High", 1.17);
            this.put("Very high", 1.34);
            this.put("Extra High", 1.74);
        }});

        map.put(TYPES.RUSE_POST.type, new HashMap<>() {{
            this.put("Low", 0.95);
            this.put("Nominal", 1.0);
            this.put("High", 1.07);
            this.put("Very high", 1.15);
            this.put("Extra High", 1.24);
        }});

        map.put(TYPES.DOCU.type, new HashMap<>() {{
            this.put("Very Low", 0.81);
            this.put("Low", 0.91);
            this.put("Nominal", 1.0);
            this.put("High", 1.11);
            this.put("Very high", 1.23);
        }});

        map.put(TYPES.TIME.type, new HashMap<>() {{
            this.put("Nominal", 1.0);
            this.put("High", 1.11);
            this.put("Very high", 1.29);
            this.put("Extra High", 1.63);

        }});

        map.put(TYPES.STOR.type, new HashMap<>() {{
            this.put("Nominal", 1.0);
            this.put("High", 1.05);
            this.put("Very high", 1.17);
            this.put("Extra High", 1.46);
        }});

        map.put(TYPES.PVOL.type, new HashMap<>() {{
            this.put("Low", 0.87);
            this.put("Nominal", 1.0);
            this.put("High", 1.15);
            this.put("Very high", 1.3);
        }});

        map.put(TYPES.TOOL.type, new HashMap<>() {{
            this.put("Very Low", 1.17);
            this.put("Low", 1.09);
            this.put("Nominal", 1.0);
            this.put("High", 0.9);
            this.put("Very high", 0.78);
        }});

        map.put(TYPES.SITE.type, new HashMap<>() {{
            this.put("Very Low", 1.22);
            this.put("Low", 1.09);
            this.put("Nominal", 1.0);
            this.put("High", 0.93);
            this.put("Very high", 0.86);
            this.put("Extra High", 0.8);
        }});

        map.put(TYPES.SCED_POST.type, new HashMap<>() {{
            this.put("Very Low", 1.43);
            this.put("Low", 1.14);
            this.put("Nominal", 1.0);
            this.put("High", 1.0);
            this.put("Very high", 1.0);
        }});

        return map;
    }


    public static ObservableList<Item> generateItems(String type, List<String> strings) {
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item("Extra Low", type),
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
