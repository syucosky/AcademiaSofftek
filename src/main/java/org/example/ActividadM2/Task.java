package org.example.ActividadM2;

public class Task {
    private String taskName;
    private String description;


    public  Task (String taskName, String description){
        this.taskName = taskName;
        this.description = description;
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
