package com.example.cocomo;

public enum MenuType {
     BASIC_COCOMO("Basic COCOMO"),
     INTERMEDIATE_COCOMO("Intermediate COCOMO"),
     COCOMO_2("COCOMO II"),
    FUNCTIONAL_POINT("Function Point");

     final String type;

    MenuType(String type) {
        this.type = type;
    }
}
