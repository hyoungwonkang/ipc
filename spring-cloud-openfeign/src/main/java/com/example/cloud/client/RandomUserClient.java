package com.example.cloud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// GET https://randomuser.me/api?nat=us

@FeignClient(name = "random-user", url = "https://randomuser.me")
public interface RandomUserClient {
    @GetMapping("/api")
    String getRandomUser(@RequestParam String nat);
}
