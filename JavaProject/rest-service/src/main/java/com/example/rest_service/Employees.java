package com.example.rest_service;

import java.util.List;

public class Employees {

    private List<Employee> employeeList;

    public Employees(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
