package org.example.dogapi.dogs.web.dto;

public record UpdateDogRequest(String name, String breed, short age) {
}
