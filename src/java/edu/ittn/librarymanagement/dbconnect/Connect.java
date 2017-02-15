/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ittn.librarymanagement.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bhandari
 */
public class Connect {
    Connection con = null  ;

    
    String driver ;
    String connectionString ;
    String user ;
    String password ;
    
    public Connect(String driver, String connectionString, String user, String password) {
        this.driver = driver;
        this.connectionString = connectionString;
        this.user = user;
        this.password = password;
    }
    public Connection dbconnect() {
        try {
            if(con == null) {
                Class.forName(driver);
                System.out.println("Driver loaded successfully");
            }
           
        } catch (ClassNotFoundException ex) {
            System.out.println("driver not loaded");
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection(connectionString,user,password);
            System.out.println("Connect to database sucessfully !!!");
        } catch (SQLException ex) {
            System.out.println("database not connected");
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
       return con ;
    } 
    
}
