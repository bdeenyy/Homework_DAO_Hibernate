package com.example.homework_dao_hibernate.repository;

import com.example.homework_dao_hibernate.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        String jpql = "SELECT p FROM Person p WHERE LOWER(p.cityOfLiving) = LOWER(:city)";
        return entityManager.createQuery(jpql, Person.class)
                .setParameter("city", city.toLowerCase())
                .getResultList();
    }
}
