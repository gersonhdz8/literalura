package com.gersonhdz.literalura.services;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ConvertirDatos implements iConvertirDatos {

    private static final Logger logger = LoggerFactory.getLogger(ConvertirDatos.class);
    private ObjectMapper objectMapper = new ObjectMapper();    

    @Override
    public <T> T jsonToClass(JsonNode json, Class<T> clase) {
        try {
            return objectMapper.readValue(json.toString(), clase);
        } catch (JsonProcessingException e) {            
            e.printStackTrace();
        } 
        return null;
    }
    @Override
    public String classToJson(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            logger.error("Error converting object to JSON", e);
            return null;
        }
    }

    @Override
    public String listToJson(List<?> list) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(list);
        } catch (Exception e) {
            logger.error("Error converting list to JSON", e);
            return null;
        }
    }
}
