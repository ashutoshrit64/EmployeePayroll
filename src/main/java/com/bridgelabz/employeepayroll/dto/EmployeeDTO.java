package com.bridgelabz.employeepayroll.dto;

import com.bridgelabz.employeepayroll.model.EmployeeDepartment;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class EmployeeDTO {


    private String firstName;
    private String lastName;
    private String companyName;
    private long salary;
    private String emailId;
    private String password;


}
