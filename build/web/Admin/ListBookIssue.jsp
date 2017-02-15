<%-- 
    Document   : ListBooks
    Created on : Mar 28, 2015, 6:02:06 AM
    Author     : Bhandari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../Header.jsp" %>
<div id="page-wrapper">
    <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Books Issue List</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Categories
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="bookissueTable">
                                    <thead>
                                        <tr>
                                            <th>S.No</th>
                                         <!--   <th>Book ID</th> -->
                                             <th>Member Name</th>
                                            <th>Book</th>
                                            <th>Issue Date</th>
                                            <th>Return Date</th>
                                            <th>Fine </th>
                                            <th>Approved By</th>
                                            
                                            <th>Return</th>
                                            <th>Delete</th>
                                    <tbody>
                                        <!--The basic iteration tag, accepting many different collection types and supporting 
                                        subsetting and other functionality . -->
                                        <c:set value="0" var="count" scope="page"/>
                                        <c:forEach var="bookissue" items="${booksissue}" >
                                            <c:set value="${count+1}" var="count" scope="page"/>
                                       <tr class="odd gradeX">
                                            <td>${count}</td>
                                          <!--  <td>${bookissue.getId()}</td> -->
                                            <td>${bookissue.getMemberid().getFirstname()}&nbsp; ${bookissue.getMemberid().getLastname()}</td>
                                            <td>${bookissue.getBookid().getTitle()}</td>
                                            <td>${bookissue.getBookissue()}</td>
                                            <td>${bookissue.getBookreturn()}</td>
                                            <td>${bookissue.getFine()}</td>
                                           
                                            
                                            <td>${bookissue.getSystemuserid().getUserName()}</td>
                                           
                                          
                                            <td>
                                                <a href="returnissue?id=${bookissue.getId()}">
                                                
                                                     <button type="button" class="btn btn-primary"  >
                                                    <i class="fa fa-edit"></i>Return
                                                </button>
                                                
                                            </a>
                                            </td>
                                            <td>
                                                <a href="deleteissue?id=${bookissue.getId()}">
                                                    <button type="button" class="btn btn-danger" onclick="return hello();">
                                                    <i class="fa fa-trash-o"></i>Delete
                                                </button>
                                                </a>
                                            </td>
                                            
                                        </tr> 
                                        </c:forEach >
                                     </tbody>
                                        </tr>
                                     </thead>
                                  </table>
                                    
                              </div>
                            </div>
                        </div>
                    </div>
            </div>
                                     
       <!-- DataTables JavaScript -->
    <script src="Assets/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="Assets/js/plugins/dataTables/dataTables.bootstrap.js"></script>
<!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#bookissueTable').dataTable();
    });
    </script>
    <script>
    function hello() {
	var r=confirm('Are you Sure want to delete. The Action can not be Undo.');
	if(r===true) {
	window.location="deletemember" ;
	}
	else 
	return false;
	}
    </script>

    
                              
                                     
     

<%@include file="../footer.jsp" %>