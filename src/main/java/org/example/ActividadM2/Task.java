package org.example.ActividadM2;

public class Task {
    private String name;
    private String description;


    public Task(String name, String description){
        this.name = name;
        this.description = description;
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
}
