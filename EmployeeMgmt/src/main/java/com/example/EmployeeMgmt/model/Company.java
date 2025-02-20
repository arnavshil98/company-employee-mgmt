package com.example.EmployeeMgmt.model;



import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "COMPANY")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "COMPANY_NAME",unique = true)
    private String companyName;

    @Column(name = "CONTACT_PERSON")
    private String contactPerson;

    @Column(name = "EMAIL")
    private String email ;

    @Column(name = "PHONE_NUMBER",length = 10)
    private String phoneNumber;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "COUNTRY")
    private String country;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "cName")
    private Set<Employee> employeeSet;

}

