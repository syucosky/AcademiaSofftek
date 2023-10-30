package org.example.ActividadM3;

import org.example.ActividadM2.*;

public class Task {
    private int id;
    private String taskName;
    private String description;

    public  Task (int id,String taskName, String description){
        this.id = id;
        this.taskName = taskName;
        this.description = description;
    }
    public  Task (String taskName, String description){
        this.taskName = taskName;
        this.description = description;
    }
    public int getId(){
        return this.id;
    }
    public String getTaskName(){
        return this.taskName;
    }
    public String getDescription(){
        return this.description;
    }
    public void setTaskName(String taskName){
        this.taskName = taskName;
    }
    public void setDescription(String description){
        this.description = description;
    }
}
