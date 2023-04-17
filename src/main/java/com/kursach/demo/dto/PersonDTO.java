package com.kursach.demo.dto;
import com.kursach.demo.entity.Person;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class PersonDTO {
    private long id;
    private String name;
    private Date birthdate;
    private String homeAddress;
    private String scienceGrade;

//    private String groupName = null;

    public static PersonDTO fromEntity(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.id = person.getId();
        personDTO.name = person.getName();
        personDTO.birthdate = person.getBirthdate();
        personDTO.homeAddress = person.getHomeAddress();
        personDTO.scienceGrade = person.getScienceGrade();
//        personDTO.groupName = person.getCommittee() != null ?  person.getCommittee().getName() : "Отсутсвует";
        return personDTO;
    }

    public static Person fromDTO(PersonDTO personDTO) {
        Person person = new Person();
        person.setId(personDTO.id);
        person.setName(personDTO.name);
        person.setBirthdate(personDTO.birthdate);
        person.setHomeAddress(personDTO.getHomeAddress());
        person.setScienceGrade(personDTO.getScienceGrade());
//        if (person.getCommittee() != null) {
//            person.getCommittee().setName(personDTO.groupName);
//        }
        return person;
    }
}