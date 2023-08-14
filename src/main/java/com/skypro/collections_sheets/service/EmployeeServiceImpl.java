package com.skypro.collections_sheets.service;

import com.skypro.collections_sheets.dto.Employee;
import com.skypro.collections_sheets.exceptions.EmployeeAlreadyAddedException;
import com.skypro.collections_sheets.exceptions.EmployeeNotFoundException;
import com.skypro.collections_sheets.exceptions.EmployeeStoragelsFullException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    private static final int MAX_NUMBER_OF_EMPLOYEE = 11;

    public String EmployeeServiceImpl() {
        this.employees = new HashMap<>();

        @Override
        public void addEmployee (String lastName, String firstName ){
            Employee employee = new Employee(lastName, firstName);

            if (MAX_NUMBER_OF_EMPLOYEE == employees.size()) {
                throw new EmployeeStoragelsFullException();
            }

            if (employees.containsKey(employee.getFullName())) {
                throw new EmployeeAlreadyAddedException();
            }
            employees.put(employee.getFullName(), employee);
        }

        @Override
        public void removeEmployee (String lastName, String firstName){
            Employee employee = new Employee(lastName, firstName);
            if (!employees.containsKey(employee.getFullName())) {
                throw new EmployeeNotFoundException();
            }
            employees.remove(employee.getFullName());
        }

        @Override
        public void findEmployee (String lastName, String firstName){
            Employee employee = new Employee(lastName, firstName);

            if (!employees.containsKey(employee.getFullName())) {
                throw new EmployeeNotFoundException();
            }
            employees.get(employee.getFullName());
        }
        @Override
        public String outputEmployee () {
            return employees.toString();
        }
    }
}
}
