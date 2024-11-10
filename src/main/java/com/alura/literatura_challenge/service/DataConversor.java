package com.alura.literatura_challenge.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public  class DataConversor implements ObtainDataI {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public <T> T obtainingData(String json, Class<T> dataClass) {
        try {
            return objectMapper.readValue(json,dataClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
