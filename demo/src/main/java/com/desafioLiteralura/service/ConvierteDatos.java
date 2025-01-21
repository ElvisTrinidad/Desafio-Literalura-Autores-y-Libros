package com.desafioLiteralura.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T obtenerAutor(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            System.out.println("Error al convertir JSON: " + e.getMessage());
            return null;
        }
    }
}
