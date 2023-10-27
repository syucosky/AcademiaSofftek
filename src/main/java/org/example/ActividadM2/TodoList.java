package org.example.ActividadM2;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Task> listToDo;

    public TodoList(){

        listToDo = new ArrayList<>();
    }

    // Add new task to the list
    public void addTaskToList(Task task){
        this.listToDo.add(task);
    }
    // First search the task in the list and after edit the name
    public void editTask(String taskName){
         Task taskToEdit = findByName(taskName);
         try{
             taskToEdit.setTaskName(taskName);
         }catch(Exception e){
             System.out.println("The task does not exist");
         }
    }
    //First find the task in the list and then delete it
    public void deleteTask(String taskName){
        try {
            listToDo.remove(findByName(taskName));
        }catch (Exception e){
            System.out.println("The task does not exist");
        }
    }
    // Method to search task by name
    public Task findByName(String taskName){
        return listToDo.stream()
                .filter( task -> task.getTaskName().equals(taskName))
                .findFirst().orElse(null);
    }
    // This method return the list of tasks
    public List<Task> getListToDo(){
        return this.listToDo;
    }
}
