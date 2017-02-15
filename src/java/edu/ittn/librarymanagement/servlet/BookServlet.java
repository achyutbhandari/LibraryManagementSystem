/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ittn.librarymanagement.servlet;

import edu.ittn.librarymanagement.dao.BookManager;
import edu.ittn.librarymanagement.dao.CategoryManager;
import edu.ittn.librarymanagement.module.BookModel;
import edu.ittn.librarymanagement.module.CategoryModel;
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

public class BookServlet extends HttpServlet {

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
       Connection con = (Connection)request.getServletContext().getAttribute("con");
       
                BookManager bookmanager = new BookManager(con);
       String redirectPage = "/Admin/dashboard.jsp" ;
        
               CategoryManager catManager = new CategoryManager(con) ;
        switch(ServletPath) {
            case "/addbookform" :
                List<CategoryModel> categories = catManager.getAllCategories();
                request.setAttribute("categories", categories);
                redirectPage ="/Admin/addbookform.jsp" ;
                break ;
            case "/addbooks" :
                String title = request.getParameter("title");
                String author = request.getParameter("author") ;
                String edition = request.getParameter("edition");
                String isbn = request.getParameter("isbn");
                Integer catId =  Integer.parseInt(request.getParameter("category"));
                CategoryModel cat = catManager.getCategoryById(catId);
              
                BookModel bookmodel = new BookModel();
                bookmodel.setTitle(title);
                bookmodel.setAuthor(author);
                bookmodel.setEdition(edition);
                bookmodel.setIsbn(isbn);
                bookmodel.setCategory(cat) ;
               
                
                boolean sucess = bookmanager.insertBook(bookmodel) ;
                
                redirectPage = "/listbooks" ;
                break ;
                case "/listbooks" :
                List<BookModel> books = bookmanager.getAllBooks();
                request.setAttribute("books", books);
                 
                redirectPage ="/Admin/ListBooks.jsp" ;
                
                
                break ;
                case "/editbooks" :
                    int bookid = Integer.parseInt(request.getParameter("id")) ;
                    BookModel bokmodel = bookmanager.geBooksById(bookid);
                    request.setAttribute("book",  bokmodel);
                    List<CategoryModel> allcategory = catManager.getAllCategories();
                    for(CategoryModel category: allcategory){
                        if(category.getId()== bokmodel.getCategory().getId()){
                            allcategory.remove(category);
                            break;
                        }
                    }
                    request.setAttribute("categories",  allcategory);
                
                    redirectPage= "/Admin/editbook.jsp" ;
                    break ;
                case "/updatebooks" :
                    int bid = Integer.parseInt(request.getParameter("id"));
                    String btitle = request.getParameter("title");
                    String bauthor =request.getParameter("author");
                    String bedition = request.getParameter("edition") ;
                    String bisbn = request.getParameter("isbn");
                    
                    CategoryModel bcategory = catManager.getCategoryById(Integer.parseInt(request.getParameter("category")));
                    BookModel bmodel = new BookModel();
                    bmodel.setId(bid);
                    bmodel.setTitle(btitle);
                    bmodel.setAuthor(bauthor);
                    bmodel.setEdition(bedition);
                    bmodel.setCategory(bcategory);
                    bmodel.setIsbn(bisbn);
                    
                     boolean updated = bookmanager.updateBooks(bmodel);
                    redirectPage="/listbooks" ;
                    break ;
                case "/deletebooks" :
                    int bkid = Integer.parseInt(request.getParameter("id")) ;
                    boolean deleted = bookmanager.deleteBook(bkid);
                     redirectPage="/listbooks" ;
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
