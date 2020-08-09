package com.sda.databases;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Employee {
    private int id;
    private String first_name;
    private String last_name;
    private double salary;
    private LocalDate hired_at;
    private String position;
}
