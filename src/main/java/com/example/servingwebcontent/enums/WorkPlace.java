package com.example.servingwebcontent.enums;

public enum WorkPlace {
    HOME("自宅"),
    COMPANY("会社");

    public final String displayStr;

    private WorkPlace(String displayStr) {
        this.displayStr = displayStr;
    }
}
