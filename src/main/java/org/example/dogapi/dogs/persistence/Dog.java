package org.example.dogapi.dogs.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import java.time.Instant;

@Entity
@Table(name = "dogs")
@NoArgsConstructor
@Getter
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "breed")
    private String breed;

    @Column(name = "age")
    private int age;

    /**
     * Source of truth: DB default (now()).
     * - insertable/updatable false: app never writes it
     * - @Generated(INSERT): Hibernate reads it after insert
     */
    @Generated()
    @Column(name = "created_at", insertable = false, updatable = false)
    private Instant createdAt;

    public Dog(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public void update(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }
}
