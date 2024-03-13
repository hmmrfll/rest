package hmmrfll.practice.rest.service;

import hmmrfll.practice.rest.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(Long employeeId);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee);
    void deleteEmployee(Long employeeId);
}
