package com.fstk1337.boot.sensor.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SensorDto {
    private String name;
    private String model;
    private String type;
    private String unit;
    private int minValue;
    private int maxValue;
    private String location;
    private String description;
}
