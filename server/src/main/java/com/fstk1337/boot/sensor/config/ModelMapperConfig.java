package com.fstk1337.boot.sensor.config;

import com.fstk1337.boot.sensor.dto.SensorDto;
import com.fstk1337.boot.sensor.model.sensor.Sensor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
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
        TypeMap<Sensor, SensorDto> propertyMapper = modelMapper.createTypeMap(Sensor.class, SensorDto.class);
        propertyMapper.addMappings(
            mapper -> mapper.map(source -> source.getSensorType().getType(), SensorDto::setType)
        );
        propertyMapper.addMappings(
            mapper -> mapper.map(source -> source.getSensorType().getUnit(), SensorDto::setUnit)
        );

        return modelMapper;
    }
}
