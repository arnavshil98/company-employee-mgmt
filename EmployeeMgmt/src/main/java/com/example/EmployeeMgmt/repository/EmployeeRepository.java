package com.example.EmployeeMgmt.repository;

import com.example.EmployeeMgmt.metadata.MetadataQuery;
import com.example.EmployeeMgmt.model.Employee;
import com.example.EmployeeMgmt.model.EmployeeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = MetadataQuery.GET_EMPLOYEE_BY_NAME, nativeQuery = true)
    List<EmployeeResponse> getEmployeeByName(String keyword);
}
