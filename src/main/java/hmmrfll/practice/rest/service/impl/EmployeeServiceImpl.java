package hmmrfll.practice.rest.service.impl;

import hmmrfll.practice.rest.dto.EmployeeDto;
import hmmrfll.practice.rest.entity.Employee;
import hmmrfll.practice.rest.exception.ResourceNotFoundException;
import hmmrfll.practice.rest.mapper.EmployeeMapper;
import hmmrfll.practice.rest.repository.EmployeeRepository;
import hmmrfll.practice.rest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.MapToEMployee(employeeDto);
        Employee savedEmployee = repository.save(employee);
        return EmployeeMapper.MapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId) {
        Employee employee = repository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
        return EmployeeMapper.MapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = repository.findAll();
        return employees.stream().map(EmployeeMapper::MapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee = repository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
        if(updateEmployee.getFirstName() != null){
            employee.setFirstName(updateEmployee.getFirstName());
        }
        if(updateEmployee.getLastName() != null){
            employee.setLastName(updateEmployee.getLastName());
        }
        if(updateEmployee.getEmail() != null){
            employee.setEmail(updateEmployee.getEmail());
        }
        if(updateEmployee.getAge() != 0){
            employee.setAge(updateEmployee.getAge());
        }
        if(updateEmployee.getVacancy() != null){
            employee.setVacancy(updateEmployee.getVacancy());
        }
        Employee saveEmployee = repository.save(employee);
        return EmployeeMapper.MapToEmployeeDto(saveEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = repository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
        repository.delete(employee);
    }
}
