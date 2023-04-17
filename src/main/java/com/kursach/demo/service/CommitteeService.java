package com.kursach.demo.service;

import com.kursach.demo.dto.CommitteeDTO;
import com.kursach.demo.entity.Committee;
import com.kursach.demo.entity.Person;
import com.kursach.demo.repository.CommitteeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommitteeService {
    @Autowired
    private CommitteeRepository committeeRepository;
    private List<CommitteeDTO> committeeTODTOList(List<Committee> committeeList) {
        List<CommitteeDTO> committeeDTOList = new ArrayList<>();
        for (Committee committee : committeeList) {
            committeeDTOList.add(CommitteeDTO.fromEntity(committee));
        }
        return committeeDTOList;
    }


    public CommitteeDTO createCommittee(CommitteeDTO committeeDTO) {
        Committee committee = CommitteeDTO.fromDTO(committeeDTO);
        Committee newCommittee = committeeRepository.save(committee);
        return CommitteeDTO.fromEntity(newCommittee);
    }

    public List<CommitteeDTO> showAllCCommittee() {
        return committeeTODTOList(committeeRepository.findAll());
    }

    public CommitteeDTO showCommitteeByName(String name) {
        return CommitteeDTO.fromEntity(committeeRepository.findCommitteeByName(name));
    }

    public int deleteCommitteeByName(String name) {
        return committeeRepository.deleteCommitteeByName(name);
    }

    public CommitteeDTO editCommittee(String name, CommitteeDTO committeeDTO) {
        Committee committee = CommitteeDTO.fromDTO(committeeDTO);
        if  (committeeRepository.findCommitteeByName(name).getPeople() != null) {
            List<Person> personList = new ArrayList<>();
            for (Person person : committeeRepository.findCommitteeByName(name).getPeople()){
                personList.add(person);
                person.setCommittee(committee);
            }
            committee.setPeople(personList);
        }
        Committee newCommittee = committeeRepository.save(committee);
        committeeRepository.deleteCommitteeByName(name);
        return CommitteeDTO.fromEntity(newCommittee);
    }
}
