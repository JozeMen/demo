package com.kursach.demo.controller;

import com.kursach.demo.dto.CompanyDTO;
import com.kursach.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @GetMapping
    public List<CompanyDTO> showAllCompanies() {
        return companyService.showAllCCompanies();
    }

    @GetMapping("/{name}")
    public CompanyDTO showCompanyByName(@PathVariable String name) {
        return companyService.showCompanyByName(name);
    }
    @PostMapping
    public CompanyDTO createCompany(@RequestBody CompanyDTO companyDTO){
        return companyService.createCompany(companyDTO);
    }
    @DeleteMapping("/{name}")
    public int deleteCompany(@PathVariable String name) {
        return companyService.deleteCompanyByName(name);
    }
    @PutMapping("/{name}")
    public CompanyDTO editCompany(@PathVariable String name, @RequestBody CompanyDTO companyDTO) {
        return companyService.editCompany(name, companyDTO);
    }
}
