package com.example.EmployeeMgmt.controller;

import com.example.EmployeeMgmt.model.Company;
import com.example.EmployeeMgmt.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanyController  {
    @Autowired
    private CompanyServiceImpl companyServiceimpl;


    @GetMapping("/")
    public String viewHomePage(Model model , @Param("keyword") String keyword) {
        model.addAttribute("keyword", keyword);
        model.addAttribute("companies", companyServiceimpl.getAllCompanies(keyword));
        return "company_index";
    }

    @GetMapping("/showNewCompanyForm")
    public String showNewCompanyForm(Model model) {

        Company company = new Company();
        model.addAttribute("company", company);
        model.addAttribute("countries", companyServiceimpl.getAllCountries());
        return "new_company";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company) {
        try{ companyServiceimpl.saveCompany(company);
            return "redirect:/";
        }catch (Exception e){
            return "company_alert";
        }
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        System.out.println("/showFormForUpdate/{id}" + id);
        Company company = companyServiceimpl.getCompanyById(id);
        System.out.println(company.toString());
        model.addAttribute("company", company);
        model.addAttribute("countries", companyServiceimpl.getAllCountries());
        return "update_company";
    }

    @GetMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable(value = "id") Long id) {

        companyServiceimpl.deleteCompanyById(id);
        return "redirect:/";
    }
}
