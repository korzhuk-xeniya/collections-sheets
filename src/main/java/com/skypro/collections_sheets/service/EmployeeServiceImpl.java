package com.skypro.collections_sheets.service;

import com.skypro.collections_sheets.dto.Employee;
import com.skypro.collections_sheets.exceptions.EmployeeAlreadyAddedException;
import com.skypro.collections_sheets.exceptions.EmployeeNotFoundException;
import com.skypro.collections_sheets.exceptions.EmployeeStoragelsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<Employee> employeeMap;
    private static final int MAX_NUMBER_OF_EMPLOYEE = 11;

    public EmployeeServiceImpl(Map<Employee> employeeMap, Employee employee) {
        this.employeeMap = new HashMap<> (Map.of(
            new Employee("Иванов", "Иван"),
            new Employee("Перова", "Наталья"),
            new Employee("Носова", "Анна"),
            new Employee("Семенова", "Ольга"),
            new Employee("Лазарев", "Иван "),
            new Employee("Лубков", "Павел"),
            new Employee("Смирнова", "Ирина"),
            new Employee("Тарасов", "Дмитрий"),
            new Employee("Миронова", "Татьяна")
    ));

    @Override
    public void addEmployee( Employee  employee) {
        if (MAX_NUMBER_OF_EMPLOYEE == employeeMap.size()) {
            throw new EmployeeStoragelsFullException();
        }
        String key = firstName + lastName;
        if (employeeMap.containsK  (employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.add(employee);
    }

    @Override
    public void removeEmployee(Employee employee) {
        if (!employeeMap.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employeeMap.remove((Employee) employee);
    }

    @Override
    public void findEmployee(Employee employee) {
        if (!employeeMap.contains(employee)) {
            throw new EmployeeNotFoundException("EmployeeNotFound Такой сотрудник не найден");
        }
        employeeMap.contains(employee);
    }
    @Override
    public String outputEmployee() {
        return employeeMap.toString();
    }
}
