package com.gersonhdz.literalura.services;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public interface iConvertirDatos {
    <T> T jsonToClass(JsonNode json , Class <T> clase);
    String classToJson(Object obj);
    String listToJson(List<?> list);

}
