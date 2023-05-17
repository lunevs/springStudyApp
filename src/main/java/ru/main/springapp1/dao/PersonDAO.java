package ru.main.springapp1.dao;


import org.springframework.stereotype.Component;
import ru.main.springapp1.models.Person;


import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNTER = 0;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNTER, "Bob", 12, "ya@ya.ru"));
        people.add(new Person(++PEOPLE_COUNTER, "Nick", 55, "com@com.com"));
        people.add(new Person(++PEOPLE_COUNTER, "Julia", 8, "org@org.org"));
        people.add(new Person(++PEOPLE_COUNTER, "Fred", 22, "you@me.org"));

    }

    public List<Person> getPeopleList() {
        return people;
    }

    public Person getPersonById(int id) {
        return people.stream().filter(el -> el.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNTER);
        this.people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person person = getPersonById(id);
        person.setName(updatedPerson.getName());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
