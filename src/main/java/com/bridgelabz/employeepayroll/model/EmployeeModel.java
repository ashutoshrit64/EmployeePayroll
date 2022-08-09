package com.bridgelabz.employeepayroll.model;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Employee")
@Data
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String companyName;
    private long salary;
    private String department;
    private LocalDateTime registeredDate;
    private LocalDateTime updatedDate;


    public EmployeeModel(EmployeeDTO employeeDTO){
        this.firstName=employeeDTO.getFirstName();
        this.lastName= employeeDTO.getLastName();
        this.companyName=employeeDTO.getCompanyName();
        this.salary= employeeDTO.getSalary();
        this.department=employeeDTO.getDepartment();
    }


    public EmployeeModel() {

    }
}
