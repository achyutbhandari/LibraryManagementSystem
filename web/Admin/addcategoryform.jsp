

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../Header.jsp" %>
<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Category</h1>
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
                                     <form action="addcategory " method="post" role="form">
                                        <!--div class="form-group">
                                            <label>Id :</label>
                                            <input class=" right col-sm-10 ">
                                           
                                        </div-->
                                         <div class="form-group">
                                            <label>Name :</label>
                                            <input class=" right col-sm-10 " name="name">
                                           
                                        </div>
                                         <div class="form-group">
                                            <label>Section :</label>
                                            <input class=" right col-sm-10 " name="section">
                                         </div>
                                         <button type="submit" class="btn btn-default">Submit</button>
                                       <button type="reset" class="btn btn-default">Reset</button>
                                         
                                         
                                     </form>
                    </div>
                </div>
     </div>
    
    
    <%@include file="../footer.jsp" %>

