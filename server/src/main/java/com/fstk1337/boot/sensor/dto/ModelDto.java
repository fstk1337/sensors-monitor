package com.fstk1337.boot.sensor.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ModelDto {
    private String name;
    private String type;
    private String unit;
    private int minValue;
    private int maxValue;
}
