package hmmrfll.practice.rest.controller;

import hmmrfll.practice.rest.dto.EmployeeDto;
import hmmrfll.practice.rest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService service;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(service.createEmployee(employeeDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable(name = "id") Long employeeId){
        return ResponseEntity.ok(service.getEmployee(employeeId));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        return ResponseEntity.ok(service.getAllEmployee());
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(name = "id") Long employeeId,
                                                      @RequestBody EmployeeDto updateEmployee){
        return ResponseEntity.ok(service.updateEmployee(employeeId, updateEmployee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") Long employeeId){
        service.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee delete successfully with id: " + employeeId);
    }
}
