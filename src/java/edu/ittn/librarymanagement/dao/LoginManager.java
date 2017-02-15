/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ittn.librarymanagement.dao;



import edu.ittn.librarymanagement.module.LoginModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginManager {
    Connection con = null ;
    public LoginManager(Connection conn) {
        this.con = conn ;
    }
    public LoginModel authenticate(LoginModel loginModel) { 
        LoginModel model = null ;
        System.out.println(loginModel.getUserName());
       String query = " Select * from system_user where username =? and password =? " ;
       try { 
       PreparedStatement ps = con.prepareStatement(query) ;
       ps.setString(1,loginModel.getUserName()) ;
       ps.setString(2,loginModel.getPassword()) ;
       
       ResultSet rs = ps.executeQuery() ;
       
       while(rs.next())
       {
           model = new LoginModel();
           model.setId(rs.getInt("id"));
           model.setUserName(rs.getString("username"));
           model.setPassword(rs.getString("password"));
           model.setRoles(rs.getString("role"));
           model.setEmails(rs.getString("email"));
           model.setPhno(rs.getString("phn_number"));
           model.setFirstName(rs.getString("first_name"));
           model.setLastName(rs.getString("last_name"));
           
           
       }  
       }
       catch(SQLException ex) {
          Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE,null,ex) ;
       }
       
       return model ;
       
    }

    public LoginModel getUserById(int userid) {
        LoginModel sysmodel = new LoginModel();
        String query = "SELECT * from system_user where id =? " ;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
               sysmodel.setId(rs.getInt("userid"));
               sysmodel.setUserName(rs.getString("username"));
               sysmodel.setPassword(rs.getString("password"));
               sysmodel.setRoles(rs.getString("role"));
               sysmodel.setEmails(rs.getString("email"));
               sysmodel.setPhno(rs.getString("phn_no"));
               sysmodel.setFirstName(rs.getString("first_name"));
               sysmodel.setLastName(rs.getString("last_name"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SystemUserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sysmodel ;
    }
}
