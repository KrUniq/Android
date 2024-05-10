package ru.mirea.kharitonovakm.employeedb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Employee {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public int salary;

    public Employee(long id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public long getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}