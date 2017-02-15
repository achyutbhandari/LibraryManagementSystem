

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../Header.jsp" %>
<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"> Edit Member</h1>
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
                                     <form action="updatemember " method="post" role="form">
                                        <!--div class="form-group">
                                        <a href="../../../../../../../../D:/startbootstrap-sb-admin-2-1.0.0/forms.html"></a>
                                            <label>Id :</label>
                                            <input class=" right col-sm-10 ">
                                           
                                        </div-->
                                         <div class="form-group">
                                            <label>First Name</label>
                                            <input class=" right col-sm-10 " name="fname" value="${member.getFirstname()}">
                                            <input type ="hidden" name="memid" value="${member.getId()}" class="right col-sm-10">
                                        </div>
                                         <div class="form-group">
                                            <label>Last Name</label>
                                            <input class=" right col-sm-10 " name="lname" value="${member.getLastname()}">
                                         </div>
                                         <div class="form-group">
                                            <label>Address</label>
                                            <input class=" right col-sm-10 " name="address" value="${member.getAddress()}">
                                         </div>
                                         <div class="form-group">
                                            <label>Joined</label>
                                            <input class=" right col-sm-10 datetimepicker_dark " name="jdate" value="${member.getJoineddate()}">
                                         </div>
                                         <div class="form-group">
                                            <label>Expiry </label>
                                            <input class=" right col-sm-10 datetimepicker_dark" name="edate" value="${member.getExpirydate()}">
                                         </div>
                                         <div class="form-group">
                                            <label>Phone :</label>
                                            <input class=" right col-sm-10 " name="phone" value="${member.getPhone()}">
                                         </div>
                                         <div class="form-group">
                                            <label>Email</label>
                                            <input class=" right col-sm-10 " name="email" value="${member.getEmail()}">
                                         </div>
                                         <button type="submit" class="btn btn-default">Submit</button>
                                       <button type="reset" class="btn btn-default">Reset</button>
                                         
                                         
                                     </form>
                    </div>
                </div>
     </div>
     <script>
                    $(document).ready(function () {
                        $('.datetimepicker_dark').datetimepicker({
                            theme:'dark',
                         //   yearOffset: 0,
                            lang: 'en',
                            timepicker: false,
                            format: 'd/m/Y',
                            formatDate: 'Y/m/d',
                           // minDate: '-1970/01/02', // yesterday is minimum date
                          //  maxDate: '+1970/01/02' // and tommorow is maximum date calendar
                        });
                    });

                </script>

    
    <%@include file="../footer.jsp" %>

