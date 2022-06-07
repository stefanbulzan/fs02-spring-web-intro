package ro.fasttrackit.springintro.web;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final List<Person> persons = List.of(
            new Person(1, "Ana", 23),
            new Person(2, "Mihai", 43),
            new Person(3, "Georgica", 53),
            new Person(4, "Dorina", 27),
            new Person(5, "Maria", 13)
    );

    public List<Person> getAll(String name) {
        if (name == null) {
            return persons;
        } else {
            return persons.stream()
                    .filter(person -> name.equalsIgnoreCase(person.name()))
                    .collect(Collectors.toList());
        }
    }

    public Person getById(int id) {
        return persons.stream()
                .filter(person -> person.id() == id)
                .findFirst()
                .orElseThrow();
    }
}
