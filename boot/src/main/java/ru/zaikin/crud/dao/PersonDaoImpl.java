package ru.zaikin.crud.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.zaikin.crud.model.Person;


import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {
    @PersistenceContext
    private EntityManager entityManager;
    private List<Person> people = new ArrayList<>();


    public List<Person> getAll() {
        String jpql = "SELECT p from Person p";
        Query<Person> query = (Query<Person>) entityManager.createQuery(jpql, Person.class);
        return query.getResultList();
    }

    public void save(Person person) {
        entityManager.persist(person);
    }

    public Person getById(int id) {
        String jpql = "SELECT p from Person p where p.id=:id";
        Query<Person> query= (Query<Person>) entityManager.createQuery(jpql, Person.class).setParameter("id", id);
        Person person = query.getSingleResult();
        System.out.println(person.getId());
        return person;
    }

    public void update(Person person) {
        entityManager.merge(person);
    }

    public void delete(int id) {
        entityManager.remove(getById(id));
    }

}
