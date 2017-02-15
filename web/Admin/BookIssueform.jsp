<%-- 
    Document   : addbookform
    Created on : Mar 24, 2015, 8:31:33 AM
    Author     : Bhandari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../Header.jsp" %>
<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Issue Book</h1>
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
                                    <form role="form" method="post" action="addbookissue">
                                        
                                         <div class="form-group">
                                            <label>Member </label>
                                            <select name="member" class="chosen" >
                                            <c:forEach var="member" items="${members}" >
                                            <option value ="${member.getId()}">${member.getFirstname()}&nbsp;${member.getLastname()} </option>   
                                              
                                           </c:forEach>
                                          </select>
                                           
                                         </div>
                                         <div class="form-group">
                                            <label>Book </label>
                                            <select name="book" class="chosen" >
                                            <c:forEach var="book" items="${books}" >
                                            <option value ="${book.getId()}">${book.getTitle()}</option>   
                                              
                                           </c:forEach>
                                          </select>
                                           
                                         </div> 
                                        
                                        <button type="submit" class="btn btn-default">Submit</button>
                                       <button type="reset" class="btn btn-default">Reset</button>
                                       
                                      
                                        
                                
                                       
                                     </form>
                    </div>
                </div>
     </div>
     <script>

                $(document).ready(function () {
                    $(".chosen").chosen();
                
           
                       
                   });

                </script> 

    
    <%@include file="../footer.jsp" %>