/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ittn.librarymanagement.servlet;

import edu.ittn.librarymanagement.dao.SystemUserManager;
import edu.ittn.librarymanagement.module.SystemUserModel;
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
public class SystemUserServlet extends HttpServlet {

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
       SystemUserManager sysmanager = new SystemUserManager(con) ;
       String redirectPage = "/Admin/dashboard.jsp" ;
        switch(ServletPath) {
            case "/addsystemuserform" :
                redirectPage ="/Admin/addsystemuserform.jsp" ;
                break ;
            case "/addsystemuser" :
                String username= request.getParameter("username");
                String password= request.getParameter("password");
                String role= request.getParameter("role");
                String email= request.getParameter("email");
                String phonenum= request.getParameter("phone");
                String fname= request.getParameter("firstname");
                String lname= request.getParameter("lastname");
                
                SystemUserModel usermodel = new SystemUserModel() ;
                usermodel.setUsername(username);
                usermodel.setPassword(password);
                usermodel.setEmail(email);
                usermodel.setFirstname(fname);
                usermodel.setLastname(lname);
                usermodel.setPhone(phonenum);
                usermodel.setRole(role);
                sysmanager = new SystemUserManager(con) ;
                boolean sucess = sysmanager.insertSystemUser(usermodel) ;
                redirectPage ="/listusers" ;
                break ;
            case "/listusers" :
                List<SystemUserModel> sysuser = sysmanager.getAllSystemUsers();
                request.setAttribute("systemusers", sysuser);
                redirectPage= "/Admin/ListSystemUser.jsp";
                break ;
            case "/editsystemuser" :
                int userid = Integer.parseInt(request.getParameter("id")) ;
                SystemUserModel sysmodel  = sysmanager.getUserById(userid) ;
                request.setAttribute("sysuser",sysmodel);
                redirectPage= "/Admin/editsystemuser.jsp" ;
                
                break ;
            case "/updatesystemuser" :
                int uid = Integer.parseInt(request.getParameter("sysuserid")) ;
                String user = request.getParameter("username");
                String upassword = request.getParameter("password");
                String urole = request.getParameter("role");
                String uemail = request.getParameter("email");
                String uphone = request.getParameter("phone");
                String ufname = request.getParameter("fname");
                String ulname = request.getParameter("lname");
                
                SystemUserModel symodel = new SystemUserModel();
                symodel.setId(uid);
                symodel.setUsername(user);
                symodel.setPassword(upassword);
                symodel.setRole(urole);
                symodel.setEmail(uemail);
                symodel.setPhone(uphone);
                symodel.setFirstname(ufname);
                symodel.setLastname(ulname);
                
                boolean updated = sysmanager.UpdateUser(symodel) ;
                redirectPage = "/listusers" ;
                
                break;
            case "/deletesystemuser" :
                 int useid = Integer.parseInt(request.getParameter("id")) ;
                 boolean deleted = sysmanager.deleteUser(useid);
                redirectPage = "/listusers" ;
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
