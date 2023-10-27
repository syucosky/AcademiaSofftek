package org.example.ActividadM2;


import javax.swing.*;
import java.util.List;

public class MainTodoList {
    public void todoListApp(TodoList listOfTask){
        while (true) {
            //Options to display in buttons of choice
            String[] options = {"Add Task", "Look List", "Edit Task", "Exit"};
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
                    listOfTask.addTaskToList(task);
                }
                //IF to Look all TASK
            } else if (choice == 1) {
                if (listOfTask.getListToDo().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "The list of task is empty.");
                } else {
                    StringBuilder listText = new StringBuilder("List of task:\n");
                    List<Task> tasks = listOfTask.getListToDo();
                    // This iteration concat the name of the tasks that are in the lists
                    for (int i = 0; i < listOfTask.getListToDo().size(); i++) {
                        listText.append(i + 1).append(". ").append(tasks.get(i).getTaskName()).append("\n");
                        listText.append("    ..").append(". ").append(tasks.get(i).getDescription()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, listText.toString());
                }
                //IF to EDIT TASK
            }else if(choice == 2){
                boolean editOk = true;
                while(editOk & !listOfTask.getListToDo().isEmpty()) {
                    StringBuilder listText = new StringBuilder("Choice number of task to edit:\n");
                    List<Task> tasks = listOfTask.getListToDo();
                    for (int i = 0; i < listOfTask.getListToDo().size(); i++) {
                        listText.append(i).append(". ").append(tasks.get(i).getTaskName()).append("\n");
                    }
                    String choiceEdit = JOptionPane.showInputDialog(listText.toString());
                    if (choiceEdit != null) {
                        boolean ok = true;
                        while (ok) {
                            try {
                                //Choice one of three options: Edit Name or Edit Description or Back
                                StringBuilder taskTest = new StringBuilder("Choice what you want edit:\n");
                                taskTest.append(1).append(". ").append("Name: ").append(listOfTask.getListToDo().get(Integer.parseInt(choiceEdit)).getTaskName()).append("\n");
                                taskTest.append(2).append(". ").append("Description: ").append(listOfTask.getListToDo().get(Integer.parseInt(choiceEdit)).getDescription());
                                String[] optionsEdit = {"Name", "Description", "Back"};
                                int choiceNameOrDesc = JOptionPane.showOptionDialog(null, taskTest, "Edit task",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionsEdit, optionsEdit[0]);
                                //If to Edit the NAME
                                if (choiceNameOrDesc == 0) {
                                    String nameEdit = JOptionPane.showInputDialog("Enter new name");
                                    if(!nameEdit.isEmpty()) {
                                        listOfTask.getListToDo().get(Integer.parseInt(choiceEdit)).setTaskName(nameEdit);
                                        editOk = false;
                                    }
                                    //If to Edit the Description
                                } else if (choiceNameOrDesc == 1) {
                                    String descriptionEdit = JOptionPane.showInputDialog("Enter new description");
                                    if(!descriptionEdit.isEmpty()) {
                                        listOfTask.getListToDo().get(Integer.parseInt(choiceEdit)).setDescription(descriptionEdit);
                                        editOk = false;
                                    }
                                    //If choice back the loop ends
                                }else if (choiceNameOrDesc == 2){
                                    ok = false;
                                }

                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Choice a valid number of option");
                                ok = false;
                            }
                        }
                    }else{
                        editOk = false;
                    }
                }
                // If the list is empty at moment of edit
                if(listOfTask.getListToDo().isEmpty()){
                    JOptionPane.showMessageDialog(null, "The list is empty.");
                }
            }else {
                break; // End of while
            }
        }
    }

    public static void main(String[] args) {
        TodoList listOfTask = new TodoList();
        MainTodoList app = new MainTodoList();
        app.todoListApp(listOfTask);
}
}