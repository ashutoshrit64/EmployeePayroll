package com.bridgelabz.employeepayroll.model;

import com.bridgelabz.employeepayroll.dto.DepartmentDTO;
import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @OneToOne
    private EmployeeDepartment employeeDepartment;
    private LocalDateTime registeredDate;
    private LocalDateTime updatedDate;
    private String emailId;

    private String password;


    public EmployeeModel(EmployeeDTO employeeDTO){
        this.firstName=employeeDTO.getFirstName();
        this.lastName= employeeDTO.getLastName();
        this.companyName=employeeDTO.getCompanyName();
        this.salary= employeeDTO.getSalary();
        this.emailId=employeeDTO.getEmailId();
        this.password=employeeDTO.getPassword();
        EmployeeDepartment employeeDepartment1=mapDepartment(employeeDTO.getDepartment());
        this.employeeDepartment=employeeDepartment1;
    }

    public EmployeeDepartment mapDepartment(DepartmentDTO department) {
        EmployeeDepartment employeeDepartment=new EmployeeDepartment();
        employeeDepartment.setDepartmentName(department.getDepartmentName());
        employeeDepartment.setDepartmentDescription(department.getDepartmentDesc());
        return employeeDepartment;
    }
    public EmployeeModel() {

    }
}
