

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../Header.jsp" %>
<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"> Edit Books</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
     <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Basic Form Elements
                        </div>
                         <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                     <form action="updatebooks " method="post" role="form">
                                        <!--div class="form-group">
                                        <a href="../../../../../../../../D:/startbootstrap-sb-admin-2-1.0.0/forms.html"></a>
                                            <label>Id :</label>
                                            <input class=" right col-sm-10 ">
                                           
                                        </div-->
                                         <div class="form-group">
                                            <label>Title :</label>
                                            <input class=" right col-sm-10 " name="title" value="${book.getTitle()}">
                                            <input type ="hidden" name="id" value="${book.getId()}" class="right col-sm-10">
                                        </div>
                                         <div class="form-group">
                                            <label>Author :</label>
                                            <input class=" right col-sm-10 " name="author" value="${book.getAuthor()}">
                                         </div>
                                         <div class="form-group">
                                            <label>Edition :</label>
                                            <input class=" right col-sm-10 " name="edition" value="${book.getEdition()}">
                                         </div>
                                         <div class="form-group">
                                            <label>ISBN :</label>
                                            <input class=" right col-sm-10 " name="isbn" value="${book.getIsbn()}">
                                         </div>
                                        <div class="form-group">
                                             <label>Category  </label>
                            <select name="category" class="chosen half size" >
                               
                                    <option value ="${book.getCategory().getId()}">${book.getCategory().getName()}</option>  
                                     <c:forEach var="category" items="${categories}" >
                                       <option value ="${category.getId()}">${category.getName()}</option>     
                                </c:forEach>
                            </select>
                                         </div> 
                                         <button type="submit" class="btn btn-default">Submit</button>
                                       <button type="reset" class="btn btn-default">Reset</button>
                                         
                                         
                                     </form>
                    </div>
                </div>
     </div>
    
    
    <%@include file="../footer.jsp" %>

