package com.skypro.collections_sheets.service;

import com.skypro.collections_sheets.Employee;

import java.util.List;

public class EmployeeService {
    int maxNumberOfEmployee = 10;
    List<Employee> employees = List.of(
            new Employee("Иванов", "Иван"),
            new Employee("Перова", "Наталья"),
            new Employee("Носова", "Анна"),
            new Employee("Семенова", "Ольга"),
            new Employee("Лазарев", "Иван "),
            new Employee("Лубков", "Павел"),
            new Employee("Смирнова", "Ирина"),
            new Employee("Тарасов", "Дмитрий"),
            new Employee("Миронова", "Татьяна")
    );

    public void addEmployee() {
        if (maxNumberOfEmployee == employees.size()) {
            System.out.println("Нельзя добавить сотрудника, достигнуто максимальное количество сотрудников");
        }
        for (int employee = 0; employee < maxNumberOfEmployee; employee++) {
            if (employees[employee] == null) {
                Employee newEmployee = new Employee(fio, department, salary);
                employees[size++] = newEmployee;
            }
        }
    }
    public void deleteEmployee (FIO fio) {
        for (int lineOfBook = 0; lineOfBook < size; lineOfBook++) {
            if (employees[lineOfBook].getFio().equals(fio)) {
                System.out.println(employees[lineOfBook].getFio() + " удален ");
                employees[lineOfBook] = null;
                size--;
            }
        }
    }
}
