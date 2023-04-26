package com.kursach.demo.service;

import com.kursach.demo.dto.CommitteeDTO;
import com.kursach.demo.dto.CompanyDTO;
import com.kursach.demo.entity.Committee;
import com.kursach.demo.entity.Company;
import com.kursach.demo.entity.Person;
import com.kursach.demo.repository.CommitteeRepository;
import com.kursach.demo.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CommitteeRepository committeeRepository;


    private List<CompanyDTO> companyTODTOList(List<Company> companyList) {
        List<CompanyDTO> companyDTOList = new ArrayList<>();
        for (Company company : companyList) {
            companyDTOList.add(CompanyDTO.fromEntity(company));
        }
        return companyDTOList;
    }

    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        Company company = CompanyDTO.fromDTO(companyDTO);
        Company newCompany = companyRepository.save(company);
        return CompanyDTO.fromEntity(newCompany);
    }

    public List<CompanyDTO> showAllCCompanies() {
        return companyTODTOList(companyRepository.findAll());
    }

    public CompanyDTO showCompanyByName(String name) {
        return CompanyDTO.fromEntity(companyRepository.findCompanyByName(name));
    }

    public int deleteCompanyByName(String name) {
        return companyRepository.deleteCompanyByName(name);
    }

    public CompanyDTO editCompany(String name, CompanyDTO companyDTO) {
        Company company = CompanyDTO.fromDTO(companyDTO);
        if  (companyRepository.findCompanyByName(name).getCommittees() != null) {
            List<Committee> committeeList = new ArrayList<>();
            for (Committee committee : companyRepository.findCompanyByName(name).getCommittees()){
                committeeList.add(committee);
                committee.setCompany(company);
            }
            company.setCommittees(committeeList);
        }
        Company newCompany = companyRepository.save(company);
        companyRepository.deleteCompanyByName(name);
        return CompanyDTO.fromEntity(newCompany);
    }



}
