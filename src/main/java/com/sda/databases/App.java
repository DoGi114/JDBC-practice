package com.sda.databases;

import java.sql.*;

/**
 * Hello world!
 */
public class App {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_company?serverTimezone=Europe/Warsaw";
    private static final String USER = "jdbc_company";
    private static final String PASSWORD = "dq9rh1bfg6olp1";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
        while (resultSet.next()) {
            Employee employee = new Employee(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getDate(5).toLocalDate(),
                    resultSet.getString(6));
            
            System.out.println(String.format("%s %s, hired at %s as %s with salary equals to %s",
                    employee.getFirst_name(),
                    employee.getLast_name(),
                    employee.getHired_at(),
                    employee.getPosition(),
                    employee.getSalary()
            ));
        }
        statement.close();
        connection.close();
    }
}
