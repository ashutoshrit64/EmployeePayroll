package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.model.EmployeeModel;
import com.bridgelabz.employeepayroll.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    //CRUD operations->Create read update delete
    @PostMapping("addemployee")
    public EmployeeModel addemployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.addemployee(employeeDTO);
    }

    @PutMapping("updateemployee/{id}")
    public EmployeeModel updateemployee(@RequestBody EmployeeDTO employeeDTO,@PathVariable long id){
        return employeeService.updateemployee(id,employeeDTO);
    }

    @GetMapping("getEmployeedata")
    public List<EmployeeModel> getallemployee(){
        return employeeService.getEmpData();
    }

    @DeleteMapping("deleteemployee/{id}")
    public EmployeeModel deleteemployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

}
