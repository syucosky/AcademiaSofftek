/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.ActividadM4.DAO;

import java.sql.Connection;
import org.example.ActividadM4.Entity.Employee;
import org.example.ActividadM4.Setting.ConnectionToDb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author syuco
 */
public class DAOCrudImp implements DAOCrudInterface{

    //Create the instance to connect to db
    ConnectionToDb connection = new ConnectionToDb();
    
    @Override
    public void create(Employee employee) {
        try {
            Connection connect = connection.connect();
            //Query to insert new employee
            String queryInsert = "INSERT INTO employee(name) VALUES(?)";
            PreparedStatement insert = connect.prepareStatement(queryInsert);
            insert.setString(1,employee.getName());
            insert.executeUpdate();
            connect.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    @Override
    public Employee read(String name) {
        Employee employee = new Employee();
        try {
            Connection connect = connection.connect();  
            String queryRead = "SELECT * FROM employee WHERE name = ?";
            PreparedStatement read = connect.prepareStatement(queryRead);
            read.setString(1, name);
            ResultSet rSet = read.executeQuery();
            while(rSet.next()){
                employee.setId(rSet.getInt("id"));
                employee.setName(rSet.getString("name"));
            }
            connect.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return employee;
    }

    @Override
    public void update(Employee  employee) {
        try {
            Connection connect = connection.connect();
            String queryUpdate = "UPDATE employee SET name = ? WHERE id = ?";
            PreparedStatement update = connect.prepareStatement(queryUpdate);
            update.setString(1,employee.getName());
            update.setInt(2, employee.getId());
            update.executeUpdate();
            connect.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }   

    @Override
    public void delete(Employee employee) {
        try {
            Connection connect = connection.connect();
            String queryDelete = "DELETE FROM employee WHERE id = ?";
            PreparedStatement delete = connect.prepareStatement(queryDelete);
            delete.setInt(1, employee.getId());
            delete.executeUpdate();
            delete.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     
}
