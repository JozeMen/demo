package com.kursach.demo.repository;

import com.kursach.demo.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findAll();

    Company findCompanyByName(String comName);

    int deleteCompanyByName(String name);

}
