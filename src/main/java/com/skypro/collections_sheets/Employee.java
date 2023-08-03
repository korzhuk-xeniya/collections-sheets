package com.skypro.collections_sheets;

import java.util.Objects;

public class Employee {
    private String name;

    private String lastName;

    public Employee(String lastName, String name) {
        this.lastName = lastName;
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString () {
        return "Фамилия Имя " + lastName + " " + name + " " ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName);
    }

    }



