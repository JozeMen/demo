package com.kursach.demo.service;

import com.kursach.demo.dto.PersonDTO;
import com.kursach.demo.entity.Payment;
import com.kursach.demo.entity.Person;
import com.kursach.demo.repository.CommitteeRepository;
import com.kursach.demo.repository.PaymentRepository;
import com.kursach.demo.repository.PersonRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CommitteeRepository committeeRepository;
    @Autowired
    private PaymentRepository paymentRepository;


    private List<PersonDTO> personTODTOList(List<Person> personList) {
        List<PersonDTO> personTODTOList = new ArrayList<>();
        for (Person person : personList) {
            personTODTOList.add(PersonDTO.fromEntity(person));
        }
        return personTODTOList;
    }

    public PersonDTO createPerson(String comName, PersonDTO personDTO) {
        Person person = PersonDTO.fromDTO(personDTO);
        person.setCommittee(committeeRepository.findCommitteeByName(comName));
        Person newPerson = personRepository.save(person);
        return PersonDTO.fromEntity(newPerson);
    }

    public List<PersonDTO> findAAllByName(String name) {
        return personTODTOList(personRepository.findAllByName(name));
    }

    public List<PersonDTO> findAllPeople() {
        return personTODTOList(personRepository.findAll());
    }
    public void deletePersonById(Long id) {

        personRepository.deletePersonById(id);
    }

    public PersonDTO editPerson(Long id, PersonDTO personDTO) {
        Person person = PersonDTO.fromDTO(personDTO);
        Person oldPerson = personRepository.findPersonById(id);
        if (oldPerson.getCommittee() != null) {
            person.setCommittee(oldPerson.getCommittee());
        }
        if (paymentRepository.findPaymentsByPaymentId(oldPerson.getId()) != null) {
            for (Payment temp: paymentRepository.findPaymentsByPaymentId(oldPerson.getId())) {
                temp.setPerson(person);
            }
        }
        personRepository.deletePersonById(id);
        return PersonDTO.fromEntity(personRepository.save(person));
    }
}
