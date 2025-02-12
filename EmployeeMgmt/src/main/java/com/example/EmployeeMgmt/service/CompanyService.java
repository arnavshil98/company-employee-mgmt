package com.example.EmployeeMgmt.service;

import com.example.EmployeeMgmt.model.Company;
import java.util.List;

public interface CompanyService {

    Object getAllCompanies(String keyword);

    void saveCompany(Company company);

    Company getCompanyById(long id);

    void deleteCompanyById(Long id);

    List<Company> getAll();
}
