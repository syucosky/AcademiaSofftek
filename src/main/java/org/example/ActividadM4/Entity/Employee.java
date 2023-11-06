
package org.example.ActividadM4.Entity;


public class Employee {
    private int id;
    private String name;
    
    public Employee(){
        
    }
    public Employee(String name){
        this.name = name;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    
    
}
