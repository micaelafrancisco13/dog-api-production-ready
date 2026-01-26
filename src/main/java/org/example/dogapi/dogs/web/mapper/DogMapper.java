package org.example.dogapi.dogs.web.mapper;

import org.example.dogapi.dogs.persistence.Dog;
import org.example.dogapi.dogs.web.dto.DogResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DogMapper {
    DogResponse toResponse(Dog dog);
}
