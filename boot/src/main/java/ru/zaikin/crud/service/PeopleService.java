package ru.zaikin.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zaikin.crud.dao.PersonDaoImpl;
import ru.zaikin.crud.model.Person;

import java.util.List;

@Service
public class PeopleService {
    private PersonDaoImpl personDao;

    @Autowired
    public PeopleService(PersonDaoImpl personDao) {
        this.personDao = personDao;
    }

    public List<Person> getAll() {
        return personDao.getAll();
    }

    public void save(Person person) {
        personDao.save(person);
    }

    public Person getById(int id) {
        return personDao.getById(id);
    }

    public void update(Person person) {
        personDao.update(person);
    }

    public void delete(int id) {
        personDao.delete(id);
    }
}
