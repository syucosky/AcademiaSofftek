package org.example.ActividadM3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConnectionToBbDd {
    private Connection connect = null;
    private String user = "root";
    private String pwrd = "root";
    //String with the name of database
    private String ddbb = "tolist";
    //String with the url of data base
    private String url = "jdbc:mysql://localhost:3306"+"/"+ddbb;

    //Method to establish the connection of the app with the data base
    public Connection connectToBd(){
        try {
            connect = DriverManager.getConnection(url, user, pwrd);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"could not connect");
        }
        return connect;
    }
    
    //Method to add the new task to the data base
    public void addTask(Task task){
        Connection connect = connectToBd();
        if(connect != null){
            try {
                String queryAdd = "INSERT INTO tasktodo(name,description) VALUES('"+task.getTaskName()+"','"+task.getDescription()+"')";
                Statement st = connect.createStatement();
                st.executeUpdate(queryAdd);
                JOptionPane.showMessageDialog(null,"task added successfully");
                connect.close();
                st.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"unadded task");
            }
        }   
    }
    //Method to get all elements of data base
    public List<Task> getListOfTask(){
        Connection connect = connectToBd();
        List<Task> listOfTask = new ArrayList<>();
        if(connect != null){
            try {
                String queryGetList = "SELECT * FROM tasktodo";
                Statement st = connect.createStatement();
                ResultSet rSet = st.executeQuery(queryGetList);
                //Iterator to list all elements of data base
                while(rSet.next()){
                    int id = rSet.getInt(1);
                    String name = rSet.getString(2);
                    String description = rSet.getString(3);
                    Task task = new Task(id,name,description);
                    listOfTask.add(task);
                }
                connect.close();
                st.close();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"could not return list");
            }
        }
        return listOfTask;
    }
    //Method to edit name or description of task
    public void editTask(int id,String nameOrDescription, String column){
        Connection connect = connectToBd();
        if(connect != null){
            try {
                String queryEdit;
                if(column.equals("description")){                
                    queryEdit = "UPDATE tasktodo SET description ='"+nameOrDescription+"' WHERE id = "+ id;
                }else{
                    queryEdit = "UPDATE tasktodo SET name ='"+nameOrDescription+"' WHERE id = "+ id; 
                }           
                Statement st = connect.createStatement();
                st.executeUpdate(queryEdit);
                connect.close();
                st.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"could not edit");

            }
        }
    }
    //Method to delete task of data base
    public void deleteTask(int id){
        Connection connect = connectToBd();
        if(connect != null){
            try {
                String queryDelete = "DELETE FROM tasktodo WHERE id =" +id;
                Statement st = connect.createStatement();
                st.executeUpdate(queryDelete);
                connect.close();
                st.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"could not delete");
            }
        }
    }
}
