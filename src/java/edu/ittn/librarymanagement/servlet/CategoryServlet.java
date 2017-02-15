/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ittn.librarymanagement.servlet;

import edu.ittn.librarymanagement.dao.CategoryManager;
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
public class CategoryServlet extends HttpServlet {

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
       Connection con =(Connection)request.getServletContext().getAttribute("con") ;
                CategoryManager catManager = new CategoryManager(con) ;
       
       String redirectPage = "/Admin/dashboard.jsp" ;
        switch(ServletPath) {
            case "/addcategoryform" :
                redirectPage ="/Admin/addcategoryform.jsp" ;
                break ;
            case "/addcategory" :
                // form baata aako data lai request.getParameter le leko and variable ma rakhedako 
                String catname = request.getParameter("name");
                String section = request.getParameter("section") ;
                // category model banayera tyo data lai set gare ko 
                CategoryModel category = new CategoryModel() ;
                category.setName(catname);
                category.setSection(section) ;
                
                boolean sucess = catManager.insertCategory(category) ;
                redirectPage="/listcategories" ;
                
                break ;
            case "/listcategories" :
                List<CategoryModel> categories = catManager.getAllCategories();
                request.setAttribute("categories", categories);
                redirectPage ="/Admin/ListCategory.jsp" ;
                
                
                break ;
            case "/editcat" :
                int catid = Integer.parseInt(request.getParameter("id")) ;
                CategoryModel catmodel  = catManager.getCategoryById(catid) ;
                request.setAttribute("category",catmodel);
                redirectPage= "/Admin/editcategory.jsp" ;
                break ;
                case "/updatecategory" :
                int categoryid = Integer.parseInt(request.getParameter("catid")) ;
                String categoryname = request.getParameter("name") ;
                String catsection = request.getParameter("section") ;
                CategoryModel categorymodel = new CategoryModel();
                categorymodel.setId(categoryid);
                categorymodel.setName(categoryname);
                categorymodel.setSection(catsection);
                
                    boolean updated = catManager.updateCategory(categorymodel);
                    redirectPage="/listcategories" ;
                    break ;
                case "/deletecat" :
                    int cateid = Integer.parseInt(request.getParameter("id")) ;
                    boolean deleted = catManager.deleteCategory(cateid);
                     redirectPage="/listcategories" ;
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