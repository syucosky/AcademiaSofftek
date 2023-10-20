package org.example.ActividadM2;

public class TodoListMain {
    public static void main(String[] args) {

    Task task = new Task("Sebas","0");
    Task task2 = new Task("Sebas2","2");
    Task task3 = new Task("Sebas3","3");
    Task task4 = new Task("Sebas4","4");

    TodoList tList = new TodoList();
    tList.addTask(task);
    tList.addTask(task2);
    tList.addTask(task3);
    tList.addTask(task4);

//        tList.getTodoList().stream().map(l -> l.getName()).forEach(System.out::print);
//        tList.removeTask("Sebas4");
//        System.out.println(" ");
//        tList.getTodoList().stream().map(l -> l.getName()).forEach(System.out::print);
//        tList.editTaskName("Sebas","Sebas1");
//        System.out.println(" ");
//        tList.getTodoList().stream().map(l -> l.getName()).forEach(System.out::print);
        tList.getTodoList().stream().map(l -> l.getDescription()).forEach(System.out::print);
        tList.editTaskDescription("Sebas","1");
        System.out.println(" ");
        tList.getTodoList().stream().map(l -> l.getDescription()).forEach(System.out::print);


    }
}
