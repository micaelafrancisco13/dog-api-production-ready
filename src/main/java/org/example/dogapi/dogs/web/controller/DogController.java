package org.example.dogapi.dogs.web.controller;

import org.example.dogapi.dogs.persistence.Dog;
import org.example.dogapi.dogs.service.DogService;
import org.example.dogapi.dogs.web.dto.CreateDogRequest;
import org.example.dogapi.dogs.web.dto.DogResponse;
import org.example.dogapi.dogs.web.dto.UpdateDogRequest;
import org.example.dogapi.dogs.web.mapper.DogMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/dogs")
public class DogController {
    private final DogService service;
    private final DogMapper mapper;

    public DogController(DogService service, DogMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<DogResponse> create(@RequestBody CreateDogRequest req) {
        Dog dog = service.create(req.name(), req.breed(), req.age());
        DogResponse resp = mapper.toResponse(dog);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()      // /api/v1/dogs
                .path("/{id}")
                .buildAndExpand(resp.id())
                .toUri();

        return ResponseEntity.created(location).body(resp);
    }

    @GetMapping("/{id}")
    public DogResponse get(@PathVariable long id) {
        return mapper.toResponse(service.get(id));
    }

    @GetMapping
    public Page<DogResponse> list(Pageable pageable) {
        return service.list(pageable).map(mapper::toResponse);
    }

    @PutMapping("/{id}")
    public DogResponse update(@PathVariable long id, @RequestBody UpdateDogRequest req) {
        return mapper.toResponse(service.update(id, req.name(), req.breed(), req.age()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
