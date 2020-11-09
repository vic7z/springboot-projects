package com.vi.RestApidemo.Service;

import com.vi.RestApidemo.dao.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
    private List<Person> people = new ArrayList<>(Arrays.asList(
            new Person("vic"),
            new Person("vin")
    ));

    public List<Person> getPeople() {
        return people;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public Person getPerson(UUID id) {
        return people.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void deletPerson(UUID id) {
        people.removeIf(t -> t.getId().equals(id));
    }

    public void update(String name, Person person) {
        for (int i = 0; i < people.size(); i++) {
            Person p = people.get(i);
            if (p.getName().equals(name)) {
                people.set(i, person);
                return;
            }
        }
    }

}
