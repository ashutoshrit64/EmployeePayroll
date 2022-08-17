package com.bridgelabz.employeepayroll.dto;

import com.bridgelabz.employeepayroll.model.EmployeeDepartment;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class EmployeeDTO {

    @NotNull
    private String firstName;
    private String lastName;
    private String companyName;
    @Min(value = 11)
    private long salary;
    private String emailId;
    private String password;


}
