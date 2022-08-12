package com.bridgelabz.employeepayroll.dto;

import com.bridgelabz.employeepayroll.model.EmployeeDepartment;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
public class EmployeeDTO {

    @NotNull
    private String firstName;
    private String lastName;
    private String companyName;
    private long salary;
    private DepartmentDTO department;
    private String emailId;
    private String password;


}
