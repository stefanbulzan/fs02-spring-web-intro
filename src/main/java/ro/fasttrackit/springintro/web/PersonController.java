package ro.fasttrackit.springintro.web;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    List<Person> getAllPersons(@RequestParam(required = false) String name) {
        return service.getAll(name);
    }

    @GetMapping("{id}")
    Person getOnePerson(@PathVariable int id) {
        return service.getById(id);
    }
}

record Person(int id, String name, int age) {
}
