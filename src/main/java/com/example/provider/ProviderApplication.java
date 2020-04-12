package com.example.provider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}

@RestController
class PeopleController {

    private final List<Person> people = new ArrayList<>();

    @RequestMapping("/people")
    public List<Person> people() {
        return people;
    }

    @RequestMapping("/people/{id}")
    public Person person(@PathVariable("id") int id) {
        return people.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    public PeopleController() {
        Stream.of(
                new Person(1, "Tom", "Sam", 18, new String[]{"movies", "hiking"}),
                new Person(2, "Yom", "Jam", 22, new String[]{"reading"}),
                new Person(3, "Nom", "Ham", 36, new String[]{"sleeping", "walking"})
        ).forEach(people::add);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
    int id;
    String first;
    String last;
    int age;
    String[] likes;
}
