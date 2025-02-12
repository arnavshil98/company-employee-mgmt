package com.example.EmployeeMgmt.repository;

import com.example.EmployeeMgmt.metadata.MetadataQuery;
import com.example.EmployeeMgmt.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(value = MetadataQuery.GET_DATA_BY_NAME, nativeQuery = true)
    List<Company> getCompanyByName(String keyword);
}
