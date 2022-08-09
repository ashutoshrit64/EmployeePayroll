package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.Exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.model.EmployeeModel;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeModel addemployee(EmployeeDTO employeeDTO) {
        EmployeeModel employeeModel=new EmployeeModel(employeeDTO);
        employeeModel.setRegisteredDate(LocalDateTime.now());
        employeeRepository.save(employeeModel);
        return employeeModel;
    }

    @Override
    public EmployeeModel updateemployee(long id, EmployeeDTO employeeDTO) {

        Optional<EmployeeModel> isEmployeePresent=employeeRepository.findById(id);
        if(isEmployeePresent.isPresent()){
            isEmployeePresent.get().setFirstName(employeeDTO.getFirstName());
            isEmployeePresent.get().setLastName(employeeDTO.getLastName());
            isEmployeePresent.get().setCompanyName(employeeDTO.getCompanyName());
            isEmployeePresent.get().setDepartment(employeeDTO.getDepartment());
            isEmployeePresent.get().setSalary(employeeDTO.getSalary());
            isEmployeePresent.get().setUpdatedDate(LocalDateTime.now());
            employeeRepository.save(isEmployeePresent.get());
            return isEmployeePresent.get();
        }
        throw new EmployeeNotFoundException(400,"Employee Not Present!!");
    }

    @Override
    public List<EmployeeModel> getEmpData() {
        List<EmployeeModel> getallemployee=employeeRepository.findAll();
        if(getallemployee.size()>0)
            return getallemployee;
        else
            throw new EmployeeNotFoundException(400,"No DATA Present");
    }

    @Override
    public EmployeeModel deleteEmployee(Long id) {
        Optional<EmployeeModel> isEmployeePresent=employeeRepository.findById(id);
        if(isEmployeePresent.isPresent()){
            employeeRepository.delete(isEmployeePresent.get());
            return isEmployeePresent.get();
        }
        throw new EmployeeNotFoundException(400,"Employee Not Present");
    }
    //JWt
    //JMS
    //Swagger
    //Relationship between classes
}
