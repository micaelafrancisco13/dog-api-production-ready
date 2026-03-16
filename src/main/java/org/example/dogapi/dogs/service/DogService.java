package org.example.dogapi.dogs.service;

import org.example.dogapi.dogs.persistence.Dog;
import org.example.dogapi.dogs.persistence.DogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class DogService {
    private final DogRepository repo;

    public DogService(DogRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Dog create(String name, String breed, short age) {
        return repo.save(new Dog(name, breed, age));
    }

    @Transactional(readOnly = true)
    public Dog get(long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Dog not found: " + id));
    }

    @Transactional(readOnly = true)
    public Page<Dog> list(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Transactional
    public Dog update(long id, String name, String breed, short age) {
        Dog dog = get(id);
        dog.update(name, breed, age);
        return dog;
    }

    @Transactional
    public void delete(long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(NOT_FOUND, "Dog not found: " + id);
        }
        repo.deleteById(id);
    }
}
