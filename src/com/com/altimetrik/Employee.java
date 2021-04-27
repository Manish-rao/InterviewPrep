package com.com.altimetrik;

public class Employee {
    int num;
    private String name;
    private int age;
    private String gender;
    private String role;
    private int year;
    private float salary;

    public Employee() {

    }

    public Employee(int num, String name, int age, String gender, String role, int year, float salary) {
        this.num = num;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.role = role;
        this.year = year;
        this.salary = salary;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
