/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ittn.librarymanagement.dao;

import edu.ittn.librarymanagement.module.CategoryModel;
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
public class CategoryManager {
    Connection con ;
    public CategoryManager(Connection con) {
        this.con = con ;
    }
    public boolean insertCategory(CategoryModel category) {
      boolean flag = false ;
      String query ="INSERT INTO category(name,section)VALUES(?,?) " ; 
      try {
      PreparedStatement ps = con.prepareStatement(query) ;
      ps.setString(1,category.getName()) ;
       ps.setString(2,category.getSection());
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
    public List<CategoryModel> getAllCategories() {
        List<CategoryModel> list = new ArrayList<>() ;
        try {
            String query = "SELECT * FROM category" ;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
              CategoryModel catModel = new CategoryModel();
              catModel.setId(rs.getInt("id"));
              catModel.setName(rs.getString("name")) ;
              catModel.setSection(rs.getString("section")) ;
              list.add(catModel) ;
                
              
            }
        }
        catch(SQLException ex) {
          Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE,null,ex) ;
       }
        return list ;
    }
    public CategoryModel getCategoryById(int catId) {
        CategoryModel catmodel = new CategoryModel();
        try {
        String query = "Select * from category  where id = ? " ;
        PreparedStatement ps = con.prepareStatement(query) ;
        ps.setInt(1, catId);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            catmodel.setId(rs.getInt("id"));
            catmodel.setName(rs.getString("name"));
            catmodel.setSection(rs.getString("section"));
        
        }
        }catch(SQLException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE,null,ex) ;
        }
        return catmodel ;    
}

    public boolean updateCategory(CategoryModel categorymodel) {
        boolean flag = false ;
        try {
        String query = "UPDATE category set name=?, section=? where id=?" ;
        PreparedStatement ps = con.prepareStatement(query) ;
        ps.setString(1, categorymodel.getName());
        ps.setString(2, categorymodel.getSection());
        ps.setInt(3, categorymodel.getId());
        
        int isUpdated= ps.executeUpdate() ;
        if(isUpdated>0){
            flag = true ;
        }
        }catch(SQLException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE,null,ex) ;
        }
        return flag ; 
        
    }

    public boolean deleteCategory(int cateid) {
       boolean flag = false ;
       
        String query = "DELETE from  category where id=? " ;
        try {
        PreparedStatement ps = con.prepareStatement(query) ;
        ps.setInt(1,cateid);
       
        
           int isdeleted= ps.executeUpdate() ;
           
        if(isdeleted>0){
            flag = true ;
        }
        }catch(SQLException ex) {
           
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE,null,ex) ;
        }
        return flag ; 
    }
    

}