package com.example.cloud.controller;

import com.example.cloud.client.RandomUserClient;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OpenFeignController {
    private final RandomUserClient client;

    @GetMapping("/apitest")
    public ResponseEntity<String> apiTest(@RequestParam String nat) {
        return ResponseEntity.ok(client.getRandomUser(nat));
    }
}
