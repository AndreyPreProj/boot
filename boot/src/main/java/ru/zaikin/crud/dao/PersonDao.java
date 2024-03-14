package ru.zaikin.crud.dao;

import ru.zaikin.crud.model.Person;

import java.util.List;

public interface PersonDao {
    List<Person> getAll();
    void save(Person person);
    Person getById(int id);

    void update(Person person);
    void delete(int id);
}
