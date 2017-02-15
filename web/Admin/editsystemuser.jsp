

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../Header.jsp" %>
<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"> Edit System User</h1>
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
                                     <form action="updatesystemuser " method="post" role="form">
                                        <!--div class="form-group">
                                        <a href="../../../../../../../../D:/startbootstrap-sb-admin-2-1.0.0/forms.html"></a>
                                            <label>Id :</label>
                                            <input class=" right col-sm-10 ">
                                           
                                        </div-->
                                         <div class="form-group">
                                            <label>User Name</label>
                                            <input class=" right col-sm-10 " name="username" value="${sysuser.getUsername()}">
                                            <input type ="hidden" name="sysuserid" value="${sysuser.getId()}" class="right col-sm-10">
                                        </div>
                                         <div class="form-group">
                                            <label>password </label>
                                            <input class=" right col-sm-10 " name="password" value="${sysuser.getPassword()}">
                                         </div>
                                         <div class="form-group">
                                            <label>Role </label>
                                            <input class=" right col-sm-10 " name="role" value="${sysuser.getRole()}">
                                         </div>
                                         <div class="form-group">
                                            <label>Email </label>
                                            <input class=" right col-sm-10 " name="email" value="${sysuser.getEmail()}">
                                         </div>
                                        
                                         <div class="form-group">
                                            <label>Phone</label>
                                            <input class=" right col-sm-10 " name="phone" value="${sysuser.getPhone()}">
                                         </div>
                                         <div class="form-group">
                                            <label>First Name</label>
                                            <input class=" right col-sm-10 " name="fname" value="${sysuser.getFirstname()}">
                                         </div>
                                         <div class="form-group">
                                            <label>Last Name</label>
                                            <input class=" right col-sm-10 " name="lname" value="${sysuser.getLastname()}">
                                         </div>
                                         <button type="submit" class="btn btn-default">Submit</button>
                                       <button type="reset" class="btn btn-default">Reset</button>
                                         
                                         
                                     </form>
                    </div>
                </div>
     </div>
    
    
    <%@include file="../footer.jsp" %>

