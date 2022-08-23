package com.bridgelabz.employeepayroll.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "department")
@Data
public class EmployeeDepartment {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private long deptId;
    private String departmentName;
    private String departmentDescription;
    private LocalDateTime createdTimeStamp;
    private LocalDateTime updatedTimeStamp;


}
