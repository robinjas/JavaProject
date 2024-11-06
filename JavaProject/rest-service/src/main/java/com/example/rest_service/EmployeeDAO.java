package com.example.rest_service;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDAO {

    private final List<Employee> employeeList = new ArrayList<>();

    // Retrieve all employees
    public Employees getAllEmployees() {
        return new Employees(employeeList);
    }

    // Add a new employee
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }
}
