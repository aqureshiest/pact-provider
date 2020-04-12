package com.example.provider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.of;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonView {
    String name;
    int age;
    String likes;

    public PersonView(Person p) {
        this.name = p.getFirst() + " " + p.getLast();
        this.age = p.getAge();
        this.likes = p.getLikes() != null ? of(p.getLikes()).collect(joining()) : "";
    }
}
