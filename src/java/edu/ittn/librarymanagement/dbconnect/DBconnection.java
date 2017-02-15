/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ittn.librarymanagement.dbconnect;



import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBconnection implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String driver = sc.getInitParameter("driver");
        String connectionString = sc.getInitParameter("connectionString");
        String user = sc.getInitParameter("username");
        String password= sc.getInitParameter("password");
        
        Connect con = new Connect(driver,connectionString,user,password);
        
        sc.setAttribute("con",con.dbconnect()) ;
               
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
      
//To change body of generated methods, choose Tools | Templates.
    }
    
}
