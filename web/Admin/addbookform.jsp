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
            <h1 class="page-header">Add Book</h1>
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
                            <form role="form" method="post" action="addbooks">
                                <div class="form-group">
                                    <label>Title </label>
                                    <input class=" right col-sm-10 " name="title">

                                </div>
                                <div class="form-group">
                                    <label>Author </label>
                                    <input class=" right col-sm-10 " name="author">

                                </div>
                                <div class="form-group">
                                    <label>Edition </label>
                                    <input class=" right col-sm-10 " name="edition">

                                </div>
                                <div class="form-group">
                                    <label>ISBN </label>
                                    <input class=" right col-sm-10 "name="isbn">

                                </div
                        </div>
                        <div class="form-group">
                            <label>Category  </label>
                            <select name="category" class="chosen half-size" >
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
            <script>

                $(document).ready(function () {
                    $(".chosen").chosen();
                });
            </script>



            <%@include file="../footer.jsp" %>