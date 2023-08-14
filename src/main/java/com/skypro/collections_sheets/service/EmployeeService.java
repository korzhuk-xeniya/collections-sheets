package com.skypro.collections_sheets.service;

import com.skypro.collections_sheets.dto.Employee;

public interface EmployeeService {
    void addEmployee(Employee employee);

    void removeEmployee(Employee employee);

    void findEmployee(Employee employee);

    String outputEmployee();
}
