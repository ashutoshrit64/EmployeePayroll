package com.bridgelabz.employeepayroll.model;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

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
    @OneToMany
    @CollectionTable(name = "emp_dept_mapping", joinColumns = @JoinColumn(name = "deptId"))
    private List<EmployeeDepartment> employeeDepartment;
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
    }
    public EmployeeModel() {

    }
}
