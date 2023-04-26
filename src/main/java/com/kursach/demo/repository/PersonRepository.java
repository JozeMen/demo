package com.kursach.demo.repository;

import com.kursach.demo.entity.Committee;
import com.kursach.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAll();
    List<Person> findAllByName(String name);
    Person findPersonById(Long id);

    void deletePersonById(Long id);
    void deletePersonByCommittee(Committee committee);

}
