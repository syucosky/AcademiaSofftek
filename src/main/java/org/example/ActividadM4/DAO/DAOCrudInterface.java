/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.ActividadM4.DAO;

import org.example.ActividadM4.Entity.Employee;

/**
 *
 * @author syuco
 */
public interface DAOCrudInterface {
    
    public void create(Employee employed);
    
    public Employee read(String name);
    
    public void update(Employee employed);
    
    public void delete(Employee employed);
}
