package com.example.EmployeeMgmt.service.impl;

import com.example.EmployeeMgmt.model.Company;
import com.example.EmployeeMgmt.model.Employee;
import com.example.EmployeeMgmt.model.EmployeeDto;
import com.example.EmployeeMgmt.model.EmployeeResponse;
import com.example.EmployeeMgmt.repository.CompanyRepository;
import com.example.EmployeeMgmt.repository.EmployeeRepository;
import com.example.EmployeeMgmt.service.CompanyService;
import com.example.EmployeeMgmt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDto> getAllEmployees(String keyword) {

        List<EmployeeDto> employees = new ArrayList<>();

        List<EmployeeResponse> employeeResponses =
                employeeRepository.getEmployeeByName(keyword);

        employeeResponses.forEach(e->{
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(e.getID());
            employeeDto.setAddress(e.getADDRESS());
            employeeDto.setCity(e.getCITY());
            employeeDto.setCId(e.getCOMPANY_ID());
            employeeDto.setEmail(e.getEMAIL());
            employeeDto.setName(e.getNAME());
            employeeDto.setPhoneNumber(e.getPHONE_NUMBER());
            employeeDto.setPin(e.getPINCODE());
            employeeDto.setCName(e.getCOMPANY_NAME());

            employees.add(employeeDto);
        });
        return  employees;
    }

    @Override
    public void saveEmployee(Employee employee) {

        this.employeeRepository.save(employee);

    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;

    }

    @Override
    public void deleteEmployeeById(Long id) {
        this.employeeRepository.deleteById(id);

    }

}