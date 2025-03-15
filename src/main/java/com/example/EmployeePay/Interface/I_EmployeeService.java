package com.example.EmployeePay.Interface;

import com.example.EmployeePay.DTO.EmployeeDTO;
import com.example.EmployeePay.Entities.EmployeeEntity;
import org.springframework.stereotype.Service;

@Service
public interface I_EmployeeService {

    public EmployeeDTO get(Long id) throws Exception;

    public EmployeeDTO create(EmployeeDTO newEmp) throws Exception;

    public EmployeeDTO edit(EmployeeDTO emp, Long id) throws Exception;

    public String delete(Long id);


}
