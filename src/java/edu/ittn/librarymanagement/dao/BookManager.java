/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ittn.librarymanagement.dao;

import edu.ittn.librarymanagement.module.BookModel;
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
public class BookManager {
    Connection con ;
     CategoryManager catManager ;
    public BookManager(Connection conn) {
        this.con = conn ;
          catManager = new CategoryManager(con);
    }
    public boolean insertBook(BookModel bookmodel) {
        boolean flag = false ;
        String query = "INSERT INTO book(title,author,edition,isbn,category_id)VALUES(?,?,?,?,?)" ;
        try{
            PreparedStatement ps = con.prepareStatement(query) ;
            ps.setString(1,bookmodel.getTitle());
            ps.setString(2,bookmodel.getAuthor());
            ps.setString(3,bookmodel.getEdition());
            ps.setString(4,bookmodel.getIsbn());
            ps.setInt(5,bookmodel.getCategory().getId());
           
            int isInserted = ps.executeUpdate();
            if(isInserted>0) {
                flag = true ;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE,null,ex) ; 
            
      
    }
        return flag ;
    }
    public List<BookModel> getAllBooks() {
        List<BookModel> list = new ArrayList<>() ;
        try {
            String query = "SELECT * FROM book" ;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
              BookModel bookModel = new BookModel();
              bookModel.setId(rs.getInt("id"));
              bookModel.setTitle(rs.getString("title")) ;
              bookModel.setAuthor(rs.getString("author")) ;
              bookModel.setEdition(rs.getString("edition")) ;
              bookModel.setIsbn(rs.getString("isbn")) ;
              
              CategoryModel catmodel = catManager.getCategoryById(rs.getInt("category_id"));
              
              bookModel.setCategory(catmodel);
              list.add(bookModel) ;
                
              
            }
        }
        catch(SQLException ex) {
          Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE,null,ex) ;
       }
        return list ;
    }

    public BookModel geBooksById(int bookid) {
      BookModel bokmodel = new BookModel() ;
      String sql = "SELECT * from book where id = ?" ;
     try {
      PreparedStatement ps = con.prepareStatement(sql) ;
      ps.setInt(1, bookid);
      ResultSet rs = ps.executeQuery();
      while(rs.next()) {
          bokmodel.setId(rs.getInt("id"));
          bokmodel.setTitle(rs.getString("title")) ;
          bokmodel.setAuthor(rs.getString("author"));
          bokmodel.setEdition(rs.getString("edition"));
          bokmodel.setIsbn(rs.getString("isbn"));
          CategoryModel catmodel = catManager.getCategoryById(rs.getInt("category_id"));
          bokmodel.setCategory(catmodel);

          
      }
      
    }   catch (SQLException ex) {
            Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    return bokmodel ;
}

    public boolean updateBooks(BookModel bmodel) {
        boolean flag = false ;
        try {
        String query = "UPDATE book set title=?, author=?, edition=?, isbn=? , category_id=? where id=?" ;
        PreparedStatement ps = con.prepareStatement(query) ;
        ps.setString(1, bmodel.getTitle());
        ps.setString(2, bmodel.getAuthor());
        ps.setString(3, bmodel.getEdition());
        ps.setString(4, bmodel.getIsbn());
        ps.setInt(5, bmodel.getCategory().getId());
        ps.setInt(6,bmodel.getId());
       
        
        int isUpdated= ps.executeUpdate() ;
        if(isUpdated>0){
            flag = true ;
        }
        }catch(SQLException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE,null,ex) ;
        }
        return flag ; 
       
    }

    public boolean deleteBook(int bkid) {
      boolean flag = false ;
      String query = "DELETE from book where id =?" ;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, bkid);
            int isdeleted = ps.executeUpdate();
            if(isdeleted>0) {
                flag = true ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag ;
    }
}