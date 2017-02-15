/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ittn.librarymanagement.dao;

import edu.ittn.librarymanagement.module.SystemUserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bhandari
 */
public class SystemUserManager {
    Connection con = null ;
    public SystemUserManager(Connection conn) {
        this.con = conn ;
        
    }

   
    public boolean insertSystemUser(SystemUserModel sysmodel) {
        boolean flag = false ;
        String query = "INSERT INTO system_user(username,password,role,email,phn_number,first_name,last_name)VALUES(?,?,?,?,?,?,?) " ;
        try {
            PreparedStatement ps = con.prepareStatement(query) ;
           ps.setString(1,sysmodel.getUsername());
           ps.setString(2,sysmodel.getPassword());
           ps.setString(3,sysmodel.getRole());
           ps.setString(4,sysmodel.getEmail());
           ps.setString(5,sysmodel.getPhone());
           ps.setString(6,sysmodel.getFirstname());
           ps.setString(7,sysmodel.getLastname());
            int isInserted = ps.executeUpdate();
            if(isInserted>0) {
           flag= true ;
       }
      }
       catch(SQLException ex){
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE,null,ex) ;   
      
    }
        
        return flag ;
    }

    public List<SystemUserModel> getAllSystemUsers() {
         List<SystemUserModel> list = new ArrayList<>() ;
        try {
             String query = "SELECT * FROM system_user" ;
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery();
             while(rs.next()) {
              SystemUserModel sysModel = new SystemUserModel();
              sysModel.setId(rs.getInt("userid"));
              sysModel.setUsername(rs.getString("username")) ;
              sysModel.setPassword(rs.getString("password")) ;
              sysModel.setPhone(rs.getString("phn_number"));
              sysModel.setRole(rs.getString("role"));
              sysModel.setFirstname(rs.getString("first_name"));
              sysModel.setLastname(rs.getString("last_name"));
              sysModel.setEmail(rs.getString("email"));
              list.add(sysModel) ;
                
              
            }
        }
        catch(SQLException ex) {
          Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE,null,ex) ;
       }
        return list ;
       
    }

    public SystemUserModel getUserById(int userid) {
        SystemUserModel sysmodel = new SystemUserModel();
        String query = "SELECT * from system_user where userid =? " ;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
               sysmodel.setId(rs.getInt("userid"));
               sysmodel.setUsername(rs.getString("username"));
               sysmodel.setPassword(rs.getString("password"));
               sysmodel.setRole(rs.getString("role"));
               sysmodel.setEmail(rs.getString("email"));
               sysmodel.setPhone(rs.getString("phn_number"));
               sysmodel.setFirstname(rs.getString("first_name"));
               sysmodel.setLastname(rs.getString("last_name"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SystemUserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sysmodel ;
    }

    public boolean UpdateUser(SystemUserModel symodel) {
        boolean flag = false ;
        String sql = "UPDATE system_user set username=?,password =?,role=?,email=?,phn_number=?,first_name=?,last_name=? where userid=? " ;
        try {
            PreparedStatement ps = con.prepareStatement(sql) ;
            ps.setString(1, symodel.getUsername());
            ps.setString(2, symodel.getPassword());
            ps.setString(3, symodel.getRole());
            ps.setString(4, symodel.getEmail());
            ps.setString(5, symodel.getPhone());
            ps.setString(6, symodel.getFirstname());
            ps.setString(7, symodel.getLastname());
            ps.setInt   (8, symodel.getId());
            
            int isupdated = ps.executeUpdate();
            if(isupdated>0) {
                flag = true ;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SystemUserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag ;
    }

    public boolean deleteUser(int useid) {
        boolean flag = false ;
        String query = "DELETE from system_user where userid =?" ;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,useid);
           int isdeleted =ps.executeUpdate() ;
           if(isdeleted>0) {
               flag = true ;
           }
           
        } catch (SQLException ex) {
            Logger.getLogger(SystemUserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag ;
       
    }

    
        
}

    
    

