
package org.example.ActividadM4.Setting;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConnectionToDb {
     private Connection connect = null;
    private String user = "root";
    private String pwrd = "root";
    //String with the name of database
    private String ddbb = "daoactividam4";
    //String with the url of data base
    private String url = "jdbc:mysql://localhost:3306"+"/"+ddbb;

    //Method to establish the connection of the app with the data base
    public Connection connect(){
        try {
            connect = DriverManager.getConnection(url, user, pwrd);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"could not connect");
        }
        return connect;
    }
}
