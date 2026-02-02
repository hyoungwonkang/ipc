package com.example.boot.dto;

import java.util.List;

import lombok.Data;

@Data
public class RestTemplateDto {
    private List<UserResult> results;
    private Info info;
    
    @Data
    public static class UserResult {
        private String gender;
        private Name name;
        private Location location;
        private String email;
        private Login login;
        private Dob dob;
        private String phone;
        private String cell;
        private Picture picture;
        private String nat;
    }
    
    @Data
    public static class Name {
        private String title;
        private String first;
        private String last;
    }
    
    @Data
    public static class Location {
        private Street street;
        private String city;
        private String state;
        private String country;
        private String postcode;
    }
    
    @Data
    public static class Street {
        private int number;
        private String name;
    }
    
    @Data
    public static class Login {
        private String uuid;
        private String username;
        private String password;
        private String salt;
        private String md5;
        private String sha1;
        private String sha256;
    }
    
    @Data
    public static class Dob {
        private String date;
        private int age;
    }
    
    @Data
    public static class Picture {
        private String large;
        private String medium;
        private String thumbnail;
    }
    
    @Data
    public static class Info {
        private String seed;
        private int results;
        private int page;
        private String version;
    }
}