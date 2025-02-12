package com.example.EmployeeMgmt.repository;

import com.example.EmployeeMgmt.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo  extends JpaRepository<Country,Integer> {
}
