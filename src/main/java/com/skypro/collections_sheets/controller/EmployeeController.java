package com.skypro.collections_sheets.controller;

import com.skypro.collections_sheets.Employee;
import com.skypro.collections_sheets.exceptions.EmployeeAlreadyAddedException;
import com.skypro.collections_sheets.exceptions.EmployeeNotFoundException;
import com.skypro.collections_sheets.exceptions.EmployeeStoragelsFullException;
import com.skypro.collections_sheets.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public String outputEmployee() {
        return employeeService.outputEmployee();
    }


    @GetMapping("/add")
    public String addEmployee(@RequestParam ("firstName") String firstName,
                              @RequestParam ("lastName")  String lastName) {
        Employee employee = new Employee(lastName, firstName);
        try {
            employeeService.addEmployee(employee);
        } catch (EmployeeStoragelsFullException | EmployeeAlreadyAddedException ex) {
            return (ex.getMessage());
        }
    return " Employee " + employee + " added ";
    }
    @GetMapping("/remove")
    public String removeEmployee(@RequestParam ("firstName") String firstName,
                              @RequestParam ("lastName")  String lastName) {
        Employee employee = new Employee(lastName, firstName);
        try {
            employeeService.removeEmployee(employee);
        } catch (EmployeeNotFoundException ex) {
            return (ex.getMessage());
        }
        return " Employee" + employee + " removed ";
    }
    @GetMapping("/find")
    public String findEmployee(@RequestParam ("firstName") String firstName,
                                 @RequestParam ("lastName")  String lastName) {
        Employee employee = new Employee(lastName, firstName);
        try {
            employeeService.findEmployee(employee);
        } catch (EmployeeNotFoundException ex) {
            return (ex.getMessage());
        }
        return " Employee " + employee + "found ";
    }
}