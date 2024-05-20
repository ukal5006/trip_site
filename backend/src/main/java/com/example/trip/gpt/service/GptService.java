package com.example.trip.gpt.service;

//src/main/java/com/example/openai/service/OpenAiService.java


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.trip.gpt.dto.ChatGPTRequest;
import com.example.trip.gpt.dto.ChatGPTResponse;

@Service
public class GptService {

 @Value("${openai.model}")
 private String model;

 @Value("${openai.api.url}")
 private String apiURL;

 private final RestTemplate restTemplate;

 public GptService(RestTemplate restTemplate) {
     this.restTemplate = restTemplate;
 }

 public String getResponse(String prompt) {
     ChatGPTRequest request = new ChatGPTRequest(model, prompt);
     ChatGPTResponse response = restTemplate.postForObject(apiURL, request, ChatGPTResponse.class);
     return response.getChoices().get(0).getMessage().getContent();
 }
}
