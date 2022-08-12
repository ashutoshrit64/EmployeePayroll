package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.DepartmentDTO;
import com.bridgelabz.employeepayroll.model.EmployeeDepartment;

public interface IDepartmentService {
    EmployeeDepartment addDepartment(DepartmentDTO departmentDTO);
}
