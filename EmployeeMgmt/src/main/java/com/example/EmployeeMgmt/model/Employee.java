package com.example.EmployeeMgmt.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL",unique = true)
    private String email ;

    @Column(name = "PHONE_NUMBER",unique = true,length = 10)
    private String phoneNumber;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "PINCODE",length = 6)
    private String pin;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company cName;

}

