package com.fstk1337.boot.sensor.model;

public enum SensorType {
    PRESSURE("pressure"),
    VOLTAGE("voltage"),
    TEMPERATURE("temperature"),
    HUMIDITY("humidity");

    SensorType(String indicator) {
    }
}
