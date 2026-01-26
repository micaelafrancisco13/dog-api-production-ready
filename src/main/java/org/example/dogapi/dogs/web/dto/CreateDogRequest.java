package org.example.dogapi.dogs.web.dto;

public record CreateDogRequest(String name, String breed, int age) {
}
