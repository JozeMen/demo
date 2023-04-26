package com.kursach.demo.service;

import com.kursach.demo.dto.CommitteeDTO;
import com.kursach.demo.entity.Committee;
import com.kursach.demo.entity.Person;
import com.kursach.demo.repository.CommitteeRepository;
import com.kursach.demo.repository.CompanyRepository;
import com.kursach.demo.repository.PersonRepository;
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
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private PersonRepository personRepository;

    private List<CommitteeDTO> committeeTODTOList(List<Committee> committeeList) {
        List<CommitteeDTO> committeeDTOList = new ArrayList<>();
        for (Committee committee : committeeList) {
            committeeDTOList.add(CommitteeDTO.fromEntity(committee));
        }
        return committeeDTOList;
    }


    public CommitteeDTO createCommittee(String comName, CommitteeDTO committeeDTO) {
        Committee committee = CommitteeDTO.fromDTO(committeeDTO);
        committee.setCompany(companyRepository.findCompanyByName(comName));
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
        Committee committee = committeeRepository.findCommitteeByName(name);
        personRepository.deletePersonByCommittee(committee);
        committee.setCompany(null);
        return committeeRepository.deleteCommitteeByName(name);
    }

    public CommitteeDTO editCommittee(String name, CommitteeDTO committeeDTO) {
        Committee committee = CommitteeDTO.fromDTO(committeeDTO);
        Committee oldCompany = committeeRepository.findCommitteeByName(name);
        if  (oldCompany.getPeople() != null) {
            List<Person> personList = new ArrayList<>();
            for (Person person : oldCompany.getPeople()){
                personList.add(person);
                person.setCommittee(committee);
            }
            committee.setPeople(personList);
        }
        committee.setCompany(companyRepository.findCompanyByName(oldCompany.getCompany().getName()));
        Committee newCommittee = committeeRepository.save(committee);
        committeeRepository.deleteCommitteeByName(name);
        return CommitteeDTO.fromEntity(newCommittee);
    }
}
