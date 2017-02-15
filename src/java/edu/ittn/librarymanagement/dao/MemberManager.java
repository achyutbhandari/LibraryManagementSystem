/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ittn.librarymanagement.dao;

import edu.ittn.librarymanagement.module.MemberModel;
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
public class MemberManager {
    Connection con = null ;
    public MemberManager(Connection conn) {
     this.con= conn  ;
}
    public boolean insertMember(MemberModel member) {
        boolean flag = false ;
        String query = "INSERT INTO member(first_name,last_name,address,join_date,expiry_date,phn_no,email_address)VALUES(?,?,?,?,?,?,?) " ;
        try {
            PreparedStatement ps = con.prepareStatement(query) ;
            ps.setString(1,member.getFirstname());
            ps.setString(2,member.getLastname());
            ps.setString(3,member.getAddress());
            ps.setString(4,member.getJoineddate());
            ps.setString(5,member.getExpirydate());
            ps.setString(6,member.getPhone());
            ps.setString(7,member.getEmail());
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

    public List<MemberModel> getAllMembers( ) {
        List<MemberModel> list = new ArrayList<>() ;
      String sql = "SELECT * FROM member " ;
     try {
      PreparedStatement ps = con.prepareStatement(sql) ;
      ResultSet rs = ps.executeQuery();
      while(rs.next()) {
          MemberModel memmodel = new MemberModel() ;
          memmodel.setId(rs.getInt("id"));
          memmodel.setFirstname(rs.getString("first_name"));
          memmodel.setLastname(rs.getString("last_name"));
          memmodel.setAddress(rs.getString("address"));
          memmodel.setJoineddate(rs.getString("join_date"));
          memmodel.setExpirydate(rs.getString("expiry_date"));
          memmodel.setPhone(rs.getString("phn_no"));
          memmodel.setEmail(rs.getString("email_address"));
          list.add(memmodel) ;
      }
      
    }   catch (SQLException ex) {
            Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    return list ;
 
    }

    public MemberModel getMemberById(int memid) {
        MemberModel memmodel = new MemberModel();
        String query = "SELECT * from member where id = ?";
        
            
            try {
                PreparedStatement ps =con.prepareStatement(query);
                ps.setInt(1, memid);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    memmodel.setId(rs.getInt("id"));
                    memmodel.setFirstname(rs.getString("first_name"));
                    memmodel.setLastname(rs.getString("last_name"));
                    memmodel.setAddress(rs.getString("address")) ;
                    memmodel.setJoineddate(rs.getString("join_date"));
                    memmodel.setExpirydate(rs.getString("expiry_date"));
                    memmodel.setPhone(rs.getString("phn_no"));
                    memmodel.setEmail(rs.getString("email_address")) ;
                    
                    
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(MemberManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            return memmodel ;
        }

    public boolean UpdateMember(MemberModel membermodel) {
       boolean flag = false ;
       String query = "UPDATE member set first_name=?, last_name=?, address=?, join_date=?, expiry_date=?, phn_no=?,email_address=? where id=? " ;
       
           try {
               PreparedStatement ps = con.prepareStatement(query);
              
               ps.setString(1, membermodel.getFirstname());
               ps.setString(2, membermodel.getLastname());
               ps.setString(3, membermodel.getAddress());
               ps.setString(4, membermodel.getJoineddate());
               ps.setString(5, membermodel.getExpirydate());
               ps.setString(6, membermodel.getPhone());
               ps.setString(7, membermodel.getEmail());
               ps.setInt(8, membermodel.getId());
               
               int isUpdated = ps.executeUpdate();
               if(isUpdated>0){
                   flag = true ;
               }
               
           } catch (SQLException ex) {
               Logger.getLogger(MemberManager.class.getName()).log(Level.SEVERE, null, ex);
           }
           return flag ;
       }

    public boolean deleteMember(int mid) {
        boolean flag = false ;
        String query = "DELETE from member where id=?" ;
        try {
            PreparedStatement ps = con.prepareStatement(query) ;
            ps.setInt(1, mid);
            int isdeleted = ps.executeUpdate();
            if(isdeleted>0){
                flag = true ;
            }
                    } catch (SQLException ex) {
            Logger.getLogger(MemberManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag ;
    }
}
    
    

    
