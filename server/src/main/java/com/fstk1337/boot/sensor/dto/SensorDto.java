package com.fstk1337.boot.sensor.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SensorDto {
    private String name;
    private ModelDto model;
    private String location;
    private String description;
}
