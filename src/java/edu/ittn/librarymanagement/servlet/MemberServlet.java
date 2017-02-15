/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ittn.librarymanagement.servlet;

import edu.ittn.librarymanagement.dao.MemberManager;
import edu.ittn.librarymanagement.module.MemberModel;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bhandari
 */
public class MemberServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ServletPath = request.getServletPath();
       RequestDispatcher rd = null ;
       Connection con = (Connection)request.getServletContext().getAttribute("con") ;
                MemberManager memmanager = new MemberManager(con) ;
       String redirectPage = "/Admin/dashboard.jsp" ;
        switch(ServletPath) {
            case "/addmemberform" :
                
                redirectPage ="/Admin/addmemberform.jsp" ;
                break ;
            case "/addmembers" :
                String fname = request.getParameter("fname") ;
                String lname = request.getParameter("lname");
                String address = request.getParameter("address") ;
                String jdate = request.getParameter("jdate") ;
                String expdate = request.getParameter("expdate") ;
                String phno = request.getParameter("phno") ;
                String email = request.getParameter("email") ;
                
                MemberModel member = new MemberModel() ;
                member.setFirstname(fname);
                member.setLastname(lname);
                member.setAddress(address);
                member.setJoineddate(jdate);
                member.setExpirydate(expdate);
                member.setPhone(phno);
                member.setEmail(email);
                
                boolean sucess = memmanager.insertMember(member) ;
                redirectPage ="/listmembers" ;
                break ;
            case "/listmembers" :
                 List<MemberModel> dmembers = memmanager.getAllMembers();
                request.setAttribute("dmember", dmembers);
                redirectPage ="/Admin/ListMembers.jsp" ;
                
                break ;
            case "/editmember" :
                int memid = Integer.parseInt(request.getParameter("id")) ;
                MemberModel memmodel  = memmanager.getMemberById(memid) ;
                request.setAttribute("member",memmodel);
                redirectPage = "/Admin/editmember.jsp" ;
                break;
            case "/updatemember" :
                int memberid = Integer.parseInt(request.getParameter("memid")) ;
                String firstname =  request.getParameter("fname") ;
                String lastname  =  request.getParameter("lname") ;
                String maddress =   request.getParameter("address") ;
                String joineddate = request.getParameter("jdate") ;
                String expirydate = request.getParameter("edate") ;
                String phone      = request.getParameter("phone") ;
                String emailadd   = request.getParameter("email") ;
                MemberModel membermodel = new MemberModel() ;
                
                membermodel.setId(memberid);
                membermodel.setFirstname(firstname);
                membermodel.setLastname(lastname);
                membermodel.setAddress(maddress);
                membermodel.setJoineddate(joineddate);
                membermodel.setExpirydate(expirydate);
                membermodel.setPhone(phone);
                membermodel.setEmail(emailadd);
                
                boolean updated = memmanager.UpdateMember(membermodel);
                redirectPage = "/listmembers" ;
                break ;
            case "/deletemember" :
                 int mid = Integer.parseInt(request.getParameter("id")) ;
                    boolean deleted = memmanager.deleteMember(mid);
                   
                     redirectPage="/listmembers" ;
                    break ;
                
               
            default :
                redirectPage ="/Admin/dashboard.jsp" ;
        }
        rd = request.getRequestDispatcher(redirectPage) ;
        rd.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
