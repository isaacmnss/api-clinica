package com.alura.medapi.service;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BooleanToSmallIntConverter implements AttributeConverter <Boolean,Short>{

    @Override
    public Short convertToDatabaseColumn(Boolean value) {
        return (value != null && value) ? (short) 1 : (short) 0;
    }

    @Override
    public Boolean convertToEntityAttribute(Short dbData) {
        return dbData != null && dbData == 1;
    }

}
