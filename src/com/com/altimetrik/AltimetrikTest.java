package com.com.altimetrik;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AltimetrikTest {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Male", "HR", 2011, 25000.0f));
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2022, 25000.0f));
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Male", "HR", 2032, 25000.0f));
        /*employeeList.add(new Employe(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employe(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employe(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employe(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));*/
        employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())).forEach((k,v)
    -> System.out.println(k+v));
        employeeList.stream().collect(Collectors.toMap(Employee::getName,emp -> emp, (emp1,emp2)->emp2)).forEach((k,v)
                -> System.out.println(k+v.getGender()+v.getYear()));
    }
}
