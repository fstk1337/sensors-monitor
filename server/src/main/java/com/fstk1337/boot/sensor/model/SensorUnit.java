package com.fstk1337.boot.sensor.model;

public enum SensorUnit {
    BAR("pressure"),
    VOLT("voltage"),
    CELSIUS("temperature"),
    PERCENT("humidity");

    SensorUnit(String indicator) {
    }
}
