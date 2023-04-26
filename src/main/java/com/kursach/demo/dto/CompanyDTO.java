package com.kursach.demo.dto;

import com.kursach.demo.entity.Committee;
import com.kursach.demo.entity.Company;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CompanyDTO
{
    private Long id;

    private String name;
    private List<CommitteeDTO> committeeDTOList;

    public static CompanyDTO fromEntity(Company company) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(company.getId());
        companyDTO.setName(company.getName());
        List<CommitteeDTO> committeeDTOArrayList = new ArrayList<>();
        companyDTO.setCommitteeDTOList(committeeDTOArrayList);
        if (company.getCommittees() != null) {
            for (Committee committee : company.getCommittees()) {
                committeeDTOArrayList.add(CommitteeDTO.fromEntity(committee));
            }
        }
        return companyDTO;
    }
    public static Company fromDTO(CompanyDTO companyDTO) {
        Company company = new Company();
        company.setId(companyDTO.getId());
        company.setName(companyDTO.getName());
        List<Committee> committeeArrayList = new ArrayList<>();
        company.setCommittees(committeeArrayList);
        if (companyDTO.getCommitteeDTOList() != null) {
            for (CommitteeDTO committeeDTO : companyDTO.getCommitteeDTOList()) {
                committeeArrayList.add(CommitteeDTO.fromDTO(committeeDTO));
            }
        }
        return company;
    }

}
