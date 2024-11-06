package com.example.rest_service;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// Importing other classes
import com.example.rest_service.Employees;
import com.example.rest_service.EmployeeDAO;
import com.example.rest_service.Employee;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    // GET endpoint to retrieve all employees
    @GetMapping(produces = "application/json")
    public Employees getEmployees() {
        return employeeDao.getAllEmployees();
    }

    // POST endpoint to add a new employee
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        // Generating a new employee ID based on the current list size
        Integer id = employeeDao.getAllEmployees().getEmployeeList().size() + 1;
        employee.setId(id);

        // Adding the new employee to the data store
        employeeDao.addEmployee(employee);

        // Building the URI for the newly created resource
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
