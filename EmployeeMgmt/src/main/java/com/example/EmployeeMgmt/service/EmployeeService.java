package com.example.EmployeeMgmt.service;

import com.example.EmployeeMgmt.model.Company;
import com.example.EmployeeMgmt.model.Employee;

public interface EmployeeService {

    Object getAllEmployees(String keyword);

    void saveEmployee(Employee company);

    Employee getEmployeeById(long id);

    void deleteEmployeeById(Long id);
}
