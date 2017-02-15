/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ittn.librarymanagement.dao;

import edu.ittn.librarymanagement.module.BookIssueModel;
import edu.ittn.librarymanagement.module.BookModel;
import edu.ittn.librarymanagement.module.LoginModel;
import edu.ittn.librarymanagement.module.MemberModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bhandari
 */
public class BookIssueManager {
    Connection con ;
    BookManager bookmanager ;
    MemberManager membermanager ;
    LoginManager systemusermanager ;
    public BookIssueManager(Connection conn) {
        this.con = conn ;
        bookmanager = new BookManager(con);
        membermanager = new MemberManager(con);
        systemusermanager = new LoginManager(con);
        
    }

    public boolean InsertBookIssue(BookIssueModel bookissuemodel) {
        boolean flag = false ;
       
        String query = "INSERT INTO book_issue(member_id,book_id,book_issue,system_user_id)VALUES(?,?,?,?)" ;
         

       
        try{
            PreparedStatement ps = con.prepareStatement(query) ;
             ps.setInt(1,bookissuemodel.getMemberid().getId());
             ps.setInt(2,bookissuemodel.getBookid().getId());
             ps.setDate(3, new Date(bookissuemodel.getBookissue().getTime()));
              ps.setInt(4,bookissuemodel.getSystemuserid().getId());
              
              
                                                
            
            int isInserted = ps.executeUpdate();
           
            if(isInserted>0) {
                flag = true ;
            }
             

             
        }
        catch(SQLException ex){
            System.out.println(query);
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE,null,ex) ; 
            
      
    }
        return flag ;
         
    }

    public List<BookIssueModel> getAllBookIssue() {
        List<BookIssueModel> list = new ArrayList<>();
      //  String query = "SELECT * FROM book_issue where return_done is ?" ;
        String query = "SELECT * FROM book_issue " ;
        try {
            PreparedStatement ps = con.prepareStatement(query) ;
           // ps.setNull(1, java.sql.Types.NULL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                BookIssueModel bookissuemodel = new BookIssueModel();
                bookissuemodel.setId(rs.getInt("id"));
                BookModel bookmodel  = bookmanager.geBooksById(rs.getInt("book_id"));
                MemberModel membermodel = membermanager.getMemberById(rs.getInt("member_id")) ;
                LoginModel sysuser = systemusermanager.getUserById(rs.getInt("system_user_id"));
                bookissuemodel.setSystemuserid(sysuser);
                bookissuemodel.setBookid(bookmodel);
                bookissuemodel.setMemberid(membermodel);
                bookissuemodel.setBookissue(rs.getDate("book_issue"));
                bookissuemodel.setBookreturn(rs.getDate("return_done"));
                bookissuemodel.setFine(rs.getFloat("fine"));
                
                list.add(bookissuemodel);
               
               }
                   
                    } catch (SQLException ex) {
            Logger.getLogger(BookIssueManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list ;
    }

    public boolean BookreturnIssue(BookIssueModel bim) {
       boolean flag = false ;
       BookIssueModel bimu = null ;
       String query = "Select * from book_issue where id = ? " ;
        try {
            PreparedStatement ps = con.prepareStatement(query) ;
            ps.setInt(1, bim.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               bimu = new BookIssueModel() ; 
               bimu.setId(rs.getInt("id"));
               bimu.setFine(rs.getFloat("fine"));
               bimu.setBookissue(rs.getDate("book_issue"));
               Date date = rs.getDate("return_done") ;
                BookModel bookmodel  = bookmanager.geBooksById(rs.getInt("book_id"));
                MemberModel membermodel = membermanager.getMemberById(rs.getInt("member_id")) ;
                LoginModel sysuser = systemusermanager.getUserById(rs.getInt("system_user_id"));
                bimu.setSystemuserid(sysuser);
                bimu.setBookid(bookmodel);
                bimu.setMemberid(membermodel);
               if(date != null){
                bimu.setBookreturn(date);
               }
               
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookIssueManager.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       String query1 = "UPDATE book_issue Set fine = ?, return_done = ? where id =?" ;
     
       
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       Date did = new Date(bimu.getBookissue().getTime()) ;
       String issuedate = sdf.format(did) ;
       String returndate = sdf.format( new Date(bim.getBookreturn().getTime()));
       
        LocalDate isdate = LocalDate.parse(issuedate);
        LocalDate redate = LocalDate.parse(returndate);
        int day= (int)ChronoUnit.DAYS.between(isdate, redate);
       
        try {
            PreparedStatement ps2 = con.prepareStatement(query1) ;
            ps2.setFloat(1, day*5);
            ps2.setDate(2,  new Date(bim.getBookreturn().getTime()));
            ps2.setInt(3, bim.getId());
            ps2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookIssueManager.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return flag ;
        
            
         /*   boolean flag = true ;
            String query1 = "Select * from book_issue where id=?";
            String query = "UPDATE book_issue SET fine =? ,return_done=? WHERE Id = ?";
           
            Date d1 = new Date(bim.getBookreturn().getTime());
            
            
           try {
                PreparedStatement ps =con.prepareStatement(query1) ;
                ps.setInt(1,bim.getId());
                ResultSet rs= ps.executeQuery();
                while(rs.next()){
                    bim.setBookreturn(rs.getDate("return_done"));
                    bim.setBookissue(rs.getDate("book_issue"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(BookIssueManager.class.getName()).log(Level.SEVERE, null, ex);
            } 
           
           float fine = 0 ;
           long diff = d1.getTime() - bim.getBookissue().getTime();
           long diffInDays = TimeUnit.MICROSECONDS.toDays(diff);
           
           if (diffInDays>15) {
            fine = (float)((diffInDays-15)*5);  
           }
           
           else
               fine = 0 ;
               
          
          
          
            try {
            PreparedStatement ps = con.prepareStatement(query) ;
            ps.setFloat(1,fine);  
            ps.setInt(3,bim.getId());
            ps.setDate(2,d1) ;
            ps.executeUpdate();    
                    
                    
                   
        } catch (SQLException ex) {
            Logger.getLogger(BookIssueManager.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return flag ;  */
    }

    

 /*   public BookIssueModel getBookIssueById(int returnid) {
        BookIssueModel bookissuemodel = new BookIssueModel();
        String query = "SELECT * FROM book_issue WHERE Id=?" ;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, returnid);
            ResultSet rs = ps.executeQuery();
            bookissuemodel.setId(rs.getInt("Id"));
            MemberModel memmodel = membermanager.getMemberById(rs.getInt("member_id"));
            bookissuemodel.setMemberid(memmodel);
            BookModel bookmodel = bookmanager.geBooksById(rs.getInt("book_id"));
            bookissuemodel.setBookid(bookmodel);
            bookissuemodel.setBookissue(rs.getDate("book_issue"));
            bookissuemodel.setBookreturn(rs.getDate("return_done"));
            bookissuemodel.setFine(rs.getFloat("fine"));
            
        } catch (SQLException ex) {
            Logger.getLogger(BookIssueManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookissuemodel ;
    }
*/

    public boolean deleteIssue(int bid) {
        boolean flag = false ;
        String query = "delete from book_issue where id=?" ;
        try {
            
            PreparedStatement ps = con.prepareStatement(query) ;
            ps.setInt(1, bid);
             int isdeleted = ps.executeUpdate();
            if(isdeleted>0 ) 
                flag = true ;
            
        } catch (SQLException ex) {
            Logger.getLogger(BookIssueManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag ;
    }
    

   

   
    }

   
    
    


                
                
                
                
             
                
               
            