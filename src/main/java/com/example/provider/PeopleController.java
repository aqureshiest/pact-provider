package com.example.provider;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class PeopleController {

    private final List<Person> people = new ArrayList<>();

    @RequestMapping("/people")
    public List<PersonView> people() {
        return people.stream().map(PersonView::new).collect(Collectors.toList());
    }

    @RequestMapping("/people/{id}")
    public PersonView person(@PathVariable("id") int id) {
        return people.stream()
                .filter(p -> p.getId() == id)
                .map(PersonView::new)
                .findFirst().get();
    }

    public PeopleController() {
        Stream.of(
                new Person(1, "Tom", "Sam", 18, new String[]{"movies", "hiking"}),
                new Person(2, "Yom", "Jam", 22, new String[]{"reading"}),
                new Person(3, "Nom", "Ham", 36, new String[]{"sleeping", "walking"})
        ).forEach(people::add);
    }

    public List<Person> getPeople() {
        return people;
    }
}
