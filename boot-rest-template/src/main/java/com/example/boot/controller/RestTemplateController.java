package com.example.boot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.boot.dto.RandomUserResponse;
import com.example.boot.dto.RestTemplateDto;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
public class RestTemplateController {
    private final RestTemplate restTemplate;

    @GetMapping("/apitest")
    public ResponseEntity<RandomUserResponse> apiTest(@RequestParam(required = false, defaultValue = "us") String nat) {
        String url = "https://randomuser.me/api?nat=" + nat;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, RandomUserResponse.class);
    }
}
