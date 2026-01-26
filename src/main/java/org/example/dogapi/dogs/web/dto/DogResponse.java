package org.example.dogapi.dogs.web.dto;

import java.time.Instant;

public record DogResponse(long id, String name, String breed, int age, Instant createdAt) {
}
