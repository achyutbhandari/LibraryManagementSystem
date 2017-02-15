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
                    <h1 class="page-header">Add System User</h1>
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
                                    <form role="form" method="post" action="addsystemuser">
                                        <div class="form-group">
                                            <label>ID </label>
                                            <input class=" right col-sm-10 ">
                                           
                                        </div>
                                         <div class="form-group">
                                            <label>User Name </label>
                                            <input class=" right col-sm-10 " name="username">
                                           
                                        </div>
                                         <div class="form-group">
                                            <label>Password </label>
                                            <input class=" right col-sm-10 " name="password">
                                           
                                        </div>
                                         <div class="form-group">
                                            <label>Role </label>
                                            <input class=" right col-sm-10 " name="role">
                                           
                                        </div>
                                         <div class="form-group">
                                            <label>First Name </label>
                                            <input class=" right col-sm-10 " name="firstname">
                                           
                                        </div>
                                         <div class="form-group">
                                            <label>Last Name</label>
                                            <input class=" right col-sm-10 " name="lastname">
                                         </div>
                                         
                                         <div class="form-group">
                                            <label>Phone No</label>
                                            <input class=" right col-sm-10 " name="phone">
                                         </div>  
                                        
                                       
                                         <div class="form-group">
                                            <label>Email </label>
                                            <input class=" right col-sm-10 " name="email">
                                         </div>  
                                        
                                
                                       <button type="submit" class="btn btn-default">Submit</button>
                                       <button type="reset" class="btn btn-default">Reset</button>
                                     </form>
                    </div>
                </div>
     </div>
    
    
    <%@include file="../footer.jsp" %>