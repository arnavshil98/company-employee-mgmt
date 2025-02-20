package com.example.EmployeeMgmt.service.impl;

import com.example.EmployeeMgmt.model.Company;
import com.example.EmployeeMgmt.model.Country;
import com.example.EmployeeMgmt.repository.CompanyRepository;
import com.example.EmployeeMgmt.repository.CountryRepo;
import com.example.EmployeeMgmt.service.CompanyService;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    CountryRepo countryRepo;

    public List<Company> getAllCompanies(String keyword) {
        return companyRepository.getCompanyByName(keyword);
    }

    @Override
    public void saveCompany(Company company) {
        this.companyRepository.save(company);

    }

    @Override
    public Company getCompanyById(long id) {
        Optional<Company> optional = companyRepository.findById(id);
        Company company = null;
        if (optional.isPresent()) {
            company = optional.get();
        } else {
            throw new RuntimeException(" Company not found for id :: " + id);
        }
        return company;

    }

    @Override
    public void deleteCompanyById(Long id) {
        this.companyRepository.deleteById(id);

    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }



    @PostConstruct
    public void insertCountry(){
        System.out.println("country init");
        List<Country> country = new ArrayList<>();
        country.add(Country.builder().name("India").build());
        country.add(Country.builder().name("USA").build());
        country.add(Country.builder().name("UK").build());
        country.add(Country.builder().name("Russia").build());
        country.add(Country.builder().name("Dubai").build());
        countryRepo.saveAll(country);
    }


    public List<Country> getAllCountries(){
        return countryRepo.findAll();
    }

}