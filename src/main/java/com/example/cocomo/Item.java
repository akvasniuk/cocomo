package com.example.cocomo;

class Item {
    String choice;
    String type;

    public Item(String choice, String type) {
        this.choice = choice;
        this.type = type;
    }

    @Override
    public String toString() {
        return this.choice;
    }

    public String getChoice() {
        return choice;
    }

    public String getType() {
        return type;
    }
}
