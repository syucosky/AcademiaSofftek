package org.example.ActividadM2;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Task> todoList;

    public TodoList(){
        this.todoList = new ArrayList<Task>();
    }


    //Search the task in the list by task name and return it
    public Task getTask(String taskName){
        return this.todoList.stream()
                              .filter(tsk -> tsk.getName().equals(taskName))
                              .findFirst().orElse(null);
    }

    //Add the task received by parameter to the task list
    public void addTask(Task task){
        this.todoList.add(task);
    }

    // Received task name find the associate task and remove from the list
    public Boolean removeTask(String taskName){
            Task task = this.todoList.stream()
                    .filter(tsk -> tsk.getName().equals(taskName))
                    .findFirst().orElse(null);
            if(task != null){
                this.todoList.remove(task);
                return true;
            }else{
                return false;
            }
    }
    //Search the task by task name and edit the name
    public boolean editTaskName(String taskName, String newTaskName){
        if(getTask(taskName) != null){
            getTask(taskName).setName(newTaskName);
            return true;
        }else{
            return false;
        }
    }
    //Search the task by task name and edit the description
    public boolean editTaskDescription(String taskName, String newDescription){
        if(getTask(taskName) != null){
            getTask(taskName).setDescription(newDescription);
            return true;
        }else{
            return false;
        }
    }

    // Return list of task
    public List<Task> getTodoList(){
        return this.todoList;
    }
}
