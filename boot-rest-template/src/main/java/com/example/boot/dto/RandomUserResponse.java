package com.example.boot.dto;

import java.util.List;

public record RandomUserResponse(List<Result> results) {
    public record Result(String gender, String email) {
        @Override
        public String toString() {
            return "results{" + gender + ", " + email + "}";
        }   
    }
}
