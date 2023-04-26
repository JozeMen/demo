package com.kursach.demo.dto;


import com.kursach.demo.entity.Committee;
import com.kursach.demo.entity.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CommitteeDTO {
    private Long committeeId;
    private String name;
    private List<PersonDTO> personDTOList;
    public static CommitteeDTO fromEntity(Committee committee) {
        CommitteeDTO committeeDTO = new CommitteeDTO();
        committeeDTO.committeeId = committee.getCommitteeId();
        committeeDTO.name = committee.getName();
        List<PersonDTO> personDTOList = new ArrayList<>();
        committeeDTO.setPersonDTOList(personDTOList);
        if (committee.getPeople() != null) {
            for (Person person : committee.getPeople()) {
                personDTOList.add(PersonDTO.fromEntity(person));
            }
        }
        return committeeDTO;
    }
    public static Committee fromDTO(CommitteeDTO committeeDTO) {
        Committee committee = new Committee();
        committee.setName(committeeDTO.getName());
        committee.setCommitteeId(committeeDTO.committeeId);
        List<Person> people = new ArrayList<>();
        committee.setPeople(people);
        if (committeeDTO.getPersonDTOList() != null) {
            for (PersonDTO personDTO : committeeDTO.getPersonDTOList()) {
                people.add(PersonDTO.fromDTO(personDTO));
            }
        }
        return committee;
    }

}
