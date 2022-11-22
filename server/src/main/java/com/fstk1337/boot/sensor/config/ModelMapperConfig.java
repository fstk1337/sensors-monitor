package com.fstk1337.boot.sensor.config;

import com.fstk1337.boot.sensor.dto.SensorDto;
import com.fstk1337.boot.sensor.model.sensor.Sensor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        PropertyMap<Sensor, SensorDto> sensorToSensorDtoMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                map().setType(source.getSensorType().getName());
                map().setUnit(source.getSensorType().getUnit());
            }
        };

        modelMapper.addMappings(sensorToSensorDtoMap);
        return modelMapper;
    }
}
