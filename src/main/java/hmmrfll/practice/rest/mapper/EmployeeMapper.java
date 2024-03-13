package hmmrfll.practice.rest.mapper;

import hmmrfll.practice.rest.dto.EmployeeDto;
import hmmrfll.practice.rest.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto MapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getAge(),
                employee.getVacancy()
        );
    }

    public static Employee MapToEMployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getAge(),
                employeeDto.getVacancy()
        );
    }
}
