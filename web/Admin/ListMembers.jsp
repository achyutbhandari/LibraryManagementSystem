<%-- 
    Document   : ListCategory
    Created on : Mar 27, 2015, 8:44:17 AM
    Author     : Bhandari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../Header.jsp" %>
<div id="page-wrapper">
    <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"> Members List</h1>
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
                                <table class="table table-striped table-bordered table-hover" id="memberTable">
                                    <thead>
                                        <tr>
                                            <th>S.No</th>
                                         
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Address</th>
                                            <th>Joined Date</th>
                                            <th>Expiry Date</th>
                                            <th>Phone</th>
                                            <th>Email</th>
                                            <th>Edit</th>
                                            <th>Delete</th>
                                    <tbody>
                                        <!--The basic iteration tag, accepting many different collection types and supporting 
                                        subsetting and other functionality . -->
                                        <c:set value="0" var="count" scope="page"/>
                                        <c:forEach var="members" items="${dmember}" >
                                            <c:set value="${count+1}" var="count" scope="page"/>
                                       <tr class="odd gradeX">
                                            <td>${count}</td>
                                            
                                            <td>${members.getFirstname()}</td>
                                            <td>${members.getLastname()}</td>
                                            <td>${members.getAddress()}</td>
                                            <td>${members.getJoineddate()}</td>
                                            <td>${members.getExpirydate()}</td>
                                            <td>${members.getPhone()}</td>
                                            <td>${members.getEmail()}</td>
                                            
                                            
                                            <td>
                                                <a href="editmember?id=${members.getId()}"
                                                   <button type="button" class="btn btn-primary"  >
                                                    <i class="fa fa-edit"></i>Edit
                                                </button>
                                            </a>
                                            </td>
                                            <td>
                                                <a href="deletemember?id=${members.getId()}"
                                                <button type="button" class="btn btn-danger" onclick="return hello()" >
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
        $('#memberTable').dataTable();
    });
    </script>
    <script>
    function hello() {
	var r=confirm('Are you Sure want to delete');
	if(r===true) {
	window.location="deletemember" ;
	}
	else 
	return false;
	}
    </script>


<%@include file="../footer.jsp" %>