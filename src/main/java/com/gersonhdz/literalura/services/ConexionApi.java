package com.gersonhdz.literalura.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConexionApi {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public JsonNode obtenerDatos(String url){
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String stringResponse = response.body();

         // Convertir la cadena JSON a un objeto JsonNode
        try {
            JsonNode jsonResponse = objectMapper.readTree(stringResponse);
            return jsonResponse ;
        } catch (IOException e) {
            throw new RuntimeException("Error al convertir la respuesta JSON a JsonNode", e);
        }
        
    }
}
