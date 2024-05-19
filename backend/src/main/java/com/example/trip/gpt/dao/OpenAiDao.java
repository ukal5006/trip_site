package com.example.trip.gpt.dao;

import java.io.IOException;
import java.text.ParseException;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.example.trip.gpt.dto.ChatGPTRequest;
import com.example.trip.gpt.dto.ChatGPTResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class OpenAiDao {

    private final CloseableHttpClient httpClient;
    private final String apiUrl;
    private final String apiKey;
    private final ObjectMapper objectMapper;

    public OpenAiDao(CloseableHttpClient httpClient, @Value("${openai.api.url}") String apiUrl, @Value("${openai.api.key}") String apiKey) {
        this.httpClient = httpClient;
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
        this.objectMapper = new ObjectMapper();
    }

    public ChatGPTResponse getChatCompletion(ChatGPTRequest chatRequest) throws IOException, ParseException, org.apache.hc.core5.http.ParseException {
        HttpPost request = new HttpPost(apiUrl);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Authorization", "Bearer " + apiKey);

        StringEntity entity = new StringEntity(objectMapper.writeValueAsString(chatRequest));
        request.setEntity(entity);

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            String responseBody = EntityUtils.toString(response.getEntity());
            return objectMapper.readValue(responseBody, ChatGPTResponse.class);
        }
    }
}
