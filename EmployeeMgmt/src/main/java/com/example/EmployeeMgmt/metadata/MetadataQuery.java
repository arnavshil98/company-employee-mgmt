package com.example.EmployeeMgmt.metadata;

public interface MetadataQuery {
    String GET_DATA_BY_NAME = "select * from COMPANY where COMPANY_NAME like %?1%";

    String GET_EMPLOYEE_BY_NAME = "SELECT emp.ID,emp.ADDRESS,emp.CITY,emp.COMPANY_ID,emp.EMAIL,emp.NAME,emp.PHONE_NUMBER,emp.PINCODE,\n" +
            " (SELECT com.COMPANY_NAME FROM COMPANY as com WHERE  com.ID = emp.COMPANY_ID ) as COMPANY_NAME\n" +
            "FROM EMPLOYEE as emp where NAME like %?1%";


}
