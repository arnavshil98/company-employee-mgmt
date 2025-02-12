package com.example.EmployeeMgmt.controller;

import com.example.EmployeeMgmt.model.Company;
import com.example.EmployeeMgmt.model.Employee;
import com.example.EmployeeMgmt.service.impl.CompanyServiceImpl;
import com.example.EmployeeMgmt.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeServiceimpl;

    @Autowired
    CompanyServiceImpl companyService;

    @GetMapping("/getAllEmployees")
    public String viewHomePage(Model model , @Param("keyword") String keyword) {
        model.addAttribute("keyword", keyword);
        model.addAttribute("employees", employeeServiceimpl.getAllEmployees(keyword));
        return "employee_index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("companies",companyService.getAll());
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        try{
            employeeServiceimpl.saveEmployee(employee);
            return "redirect:/getAllEmployees";
        }catch (Exception e){
            return "alert";
        }
    }

    @GetMapping("/showEmployeeFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        System.out.println("/showEmployeeFormForUpdate/{id}" + id);
        Employee employee = employeeServiceimpl.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("companies",companyService.getAll());
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id) {

        employeeServiceimpl.deleteEmployeeById(id);
        return "redirect:/getAllEmployees";
    }
}
