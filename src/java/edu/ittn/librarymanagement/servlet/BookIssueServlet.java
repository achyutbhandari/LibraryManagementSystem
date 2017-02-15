/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ittn.librarymanagement.servlet;

import edu.ittn.librarymanagement.dao.BookIssueManager;
import edu.ittn.librarymanagement.dao.BookManager;
import edu.ittn.librarymanagement.dao.LoginManager;
import edu.ittn.librarymanagement.dao.MemberManager;
import edu.ittn.librarymanagement.module.BookIssueModel;
import edu.ittn.librarymanagement.module.BookModel;
import edu.ittn.librarymanagement.module.LoginModel;
import edu.ittn.librarymanagement.module.MemberModel;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
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
public class BookIssueServlet extends HttpServlet {

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
        RequestDispatcher rd = null;
        Connection con = (Connection) request.getServletContext().getAttribute("con");
        MemberManager membermanager = new MemberManager(con);
        BookManager bookmanager = new BookManager(con);
        LoginManager systemmanager = new LoginManager(con);
        BookIssueManager bookissuemanager = new BookIssueManager(con);

        String redirectPage = "/Admin/dashboard.jsp";
        switch (ServletPath) {
            
            case "/addbookissueform":
                List<MemberModel> member = membermanager.getAllMembers();
                request.setAttribute("members", member);
                List<BookModel> book = bookmanager.getAllBooks();
                request.setAttribute("books", book);
                
                
             

                redirectPage = "/Admin/BookIssueform.jsp";
                break;
            
             case "/addbookissue":
                
                 Integer memid = Integer.parseInt(request.getParameter("member"));
                 Integer bookid = Integer.parseInt(request.getParameter("book"));
                
                 LoginModel systemUserObj = (LoginModel)request.getSession(false).getAttribute("user");
                 BookModel bookobj = bookmanager.geBooksById(bookid);
                 MemberModel memobj = membermanager.getMemberById(memid) ;
               
                  BookIssueModel bookissuemodel = new BookIssueModel();
                 bookissuemodel.setMemberid(memobj);
                 bookissuemodel.setBookid(bookobj);
                 bookissuemodel.setBookissue(new Date());
                 bookissuemodel.setSystemuserid(systemUserObj);
                 boolean sucess = bookissuemanager.InsertBookIssue(bookissuemodel);

                 redirectPage = "/listbookissue";
                  break;
                 
             case "/listbookissue" :
                 List<BookIssueModel> bookissue = bookissuemanager.getAllBookIssue();
                 request.setAttribute("booksissue", bookissue);
                 redirectPage ="/Admin/ListBookIssue.jsp";
                 break;
                 
              case "/returnissue" :
                int returnid = Integer.parseInt(request.getParameter("id"));
                BookIssueModel issuemodel = new BookIssueModel();
             //   issuemodel = bookissuemanager.getBookIssueById(returnid);
                issuemodel.setBookreturn(new Date());
                issuemodel.setId(returnid);
                
                boolean updatebook = bookissuemanager.BookreturnIssue(issuemodel );
                
                redirectPage = "/listbookissue";
                break;
                
              case "/deleteissue" :
                  int bid = Integer.parseInt(request.getParameter("id")) ;
                  boolean isdeleted = bookissuemanager.deleteIssue(bid);
                  redirectPage = "/listbookissue" ;
                  break ;
               default:
                 redirectPage = "/Admin/dashboard.jsp";
                }
        rd = request.getRequestDispatcher(redirectPage);
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
                  
                
                 
                
                 
                 
               
                
                
                
       
                
        
