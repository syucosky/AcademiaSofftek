package org.example.ActividadM3;


import org.example.ActividadM2.*;
import javax.swing.*;
import java.util.List;

public class MainTodoList {
    public void todoListApp(ConnectionToBbDd conectionDb){
        while (true) {
            //Options to display in buttons of choice
            String[] options = {"Add Task", "Look List", "Edit Task","Delete Task", "Exit"};
            //Message with the options
            int choice = JOptionPane.showOptionDialog(null, "What you want to do?", "List of task",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            // IF to ADD new TASk
            if (choice == 0) {
                String taskName = JOptionPane.showInputDialog("Enter the name of the task:");
                String description = JOptionPane.showInputDialog("Enter the description of the task:");
                // If the name and description are not empty, it adds them to the list
                if(taskName != null & description != null){
                    Task task = new Task(taskName,description);
                      conectionDb.addTask(task);
                }
                //IF to Look all TASK
            } else if (choice == 1) {
                List<Task> taskList = conectionDb.getListOfTask();
                if (taskList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "The list of task is empty.");
                } else {
                    StringBuilder listText = new StringBuilder("List of task:\n");
                    // This iteration concat the name of the tasks that are in the lists
                    for (int i = 0; i < taskList.size(); i++) {
                        listText.append(i + 1).append(". ").append(taskList.get(i).getTaskName()).append("\n");
                        listText.append("    ..").append(". ").append(taskList.get(i).getDescription()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, listText.toString());
                }
                //IF to EDIT TASK
            }else if(choice == 2){
                boolean editOk = true;
                //GET list of task of date base
                List<Task> taskList = conectionDb.getListOfTask();
                while(editOk & !taskList.isEmpty()) {
                    StringBuilder listText = new StringBuilder("Choice number of task to edit:\n");
                    for (int i = 0; i < taskList.size(); i++) {
                        listText.append(i).append(". ").append(taskList.get(i).getTaskName()).append("\n");
                    }
                    String choiceEdit = JOptionPane.showInputDialog(listText.toString());
                    if (choiceEdit != null) {
                            try {
                                //Choice one of three options: Edit Name or Edit Description or Back
                                StringBuilder taskTest = new StringBuilder("Choice what you want edit:\n");             
                                taskTest.append(1).append(". ").append("Name: ").append(taskList.get(Integer.parseInt(choiceEdit)).getTaskName()).append("\n");
                                taskTest.append(2).append(". ").append("Description: ").append(taskList.get(Integer.parseInt(choiceEdit)).getDescription());
                                String[] optionsEdit = {"Name", "Description", "Back"};
                                int choiceNameOrDesc = JOptionPane.showOptionDialog(null, taskTest, "Edit task",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsEdit, optionsEdit[0]);
                                //If to Edit the NAME
                                if (choiceNameOrDesc == 0) {
                                    String nameEdit = JOptionPane.showInputDialog("Enter new name");
                                    if(!nameEdit.isEmpty()) {
                                        //Method to edit recibe id of elemnt and name to edit
                                        conectionDb.editTask(taskList.get(Integer.parseInt(choiceEdit)).getId(), nameEdit, "name");
                                        editOk = false;
                                    }else{
                                        JOptionPane.showMessageDialog(null, "The name cannot be empty");
                                    }
                                    //If to Edit the Description
                                } else if (choiceNameOrDesc == 1) {
                                    String descriptionEdit = JOptionPane.showInputDialog("Enter new description");
                                    if(!descriptionEdit.isEmpty()) {
                                        //Method to edit recibe id of elemnt and description to edit
                                        conectionDb.editTask(taskList.get(Integer.parseInt(choiceEdit)).getId(), descriptionEdit, "description");                
                                        editOk = false;
                                    }else{
                                        JOptionPane.showMessageDialog(null, "The description cannot be empty");
                                    }
                                    //If choice back the loop ends
                                }else if (choiceNameOrDesc == 2){
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Choice a valid number of option");
                            }
                    }else{
                        editOk = false;
                    }
                }
                // If the list is empty at moment of edit
                if(taskList.isEmpty()){
                    JOptionPane.showMessageDialog(null, "The list of task is empty.");
                }
            }else if(choice == 3){
                //GET list of task of date base
                List<Task> taskList = conectionDb.getListOfTask();
                if(!taskList.isEmpty()){
                    StringBuilder listText = new StringBuilder("Choice number of task to delete:\n");
                    for (int i = 0; i < taskList.size(); i++) {
                        listText.append(i).append(". ").append(taskList.get(i).getTaskName()).append("\n");
                    }
                    String choiceEdit = JOptionPane.showInputDialog(listText.toString());
                    if (choiceEdit != null) {
                            try {
                                conectionDb.deleteTask(taskList.get(Integer.parseInt(choiceEdit)).getId());
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null,"could not delete");
                            }  
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "The list of task is empty.");
                }    
            }else {
                break; // End of while
            }
        }
    }

    public static void main(String[] args) {
        ConnectionToBbDd conectionDb  = new ConnectionToBbDd();
        MainTodoList app = new MainTodoList();
        app.todoListApp(conectionDb);
    }
}