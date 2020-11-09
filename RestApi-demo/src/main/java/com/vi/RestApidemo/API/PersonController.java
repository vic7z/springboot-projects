package com.vi.RestApidemo.API;

import com.vi.RestApidemo.Service.PersonService;
import com.vi.RestApidemo.dao.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping("/Person")
    public List<Person> getAllPeople() {
        return personService.getPeople();
    }

    @RequestMapping("/Person/{id}")
    public Person getPerson(@PathVariable("id") UUID id) {
        return personService.getPerson(id);
    }

    @RequestMapping("/addPerson")
    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @RequestMapping("/person/{name}")
    @PutMapping
    public void update(@RequestBody Person person, @PathVariable("name") String name) {
        personService.update(name, person);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/person/{id}")
    public void delet(@PathVariable("id") UUID uuid) {
        System.out.println("delete called");
        personService.deletPerson(uuid);
    }


}
