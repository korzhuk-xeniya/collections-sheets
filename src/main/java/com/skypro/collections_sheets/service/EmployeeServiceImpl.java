package com.skypro.collections_sheets.service;

import com.skypro.collections_sheets.Employee;
import com.skypro.collections_sheets.exceptions.EmployeeAlreadyAddedException;
import com.skypro.collections_sheets.exceptions.EmployeeNotFoundException;
import com.skypro.collections_sheets.exceptions.EmployeeStoragelsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    int maxNumberOfEmployee = 11;
    List<Employee> employeeList = new ArrayList<>(List.of(
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
    public void addEmployee(Employee employee) {
        if (maxNumberOfEmployee == employeeList.size()) {
            throw new EmployeeStoragelsFullException("ArrayIsFull Нельзя добавить сотрудника, достигнуто максимальное количество сотрудников");
        }
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded Такой сотрудник уже есть");
        }
        employeeList.add(employee);
    }

    @Override
    public void removeEmployee(Employee employee) {
        if (!employeeList.contains(employee)) {
            throw new EmployeeNotFoundException("EmployeeNotFound Такой сотрудник не найден");
        }
        employeeList.remove((Employee) employee);
    }

    @Override
    public void findEmployee(Employee employee) {
        if (!employeeList.contains(employee)) {
            throw new EmployeeNotFoundException("EmployeeNotFound Такой сотрудник не найден");
        }
        employeeList.contains(employee);
    }
    @Override
    public String outputEmployee() {
        return employeeList.toString();
    }
}
