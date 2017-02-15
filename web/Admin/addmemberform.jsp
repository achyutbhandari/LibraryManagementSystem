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
            <h1 class="page-header">Add Member</h1>
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
                            <form role="form" method="post" action="addmembers" >

                                <div class="form-group" >
                                    <label>First Name </label>
                                    <input class=" right col-sm-10" name="fname" placeholder="First Name"    />

                                </div>
                                <div class="form-group">
                                    <label>Last Name </label>
                                    <input class=" right col-sm-10 " name="lname"/>

                                </div>
                                <div class="form-group">
                                    <label>Address </label>
                                    <input class=" right col-sm-10 " name="address"  />

                                </div>
                                <div class="form-group">
                                    <label>Joined </label>
                                    <input type="text" class=" right col-sm-10 datetimepicker_dark " name="jdate"/>

                                </div>
                                <div class="form-group">
                                    <label>Expiry </label>
                                    <input type="text" class=" right col-sm-10 datetimepicker_dark" name="expdate" />
                                </div>

                                <div class="form-group">
                                    <label>Phone</label>
                                    <input class=" right col-sm-10 " name="phno"/>
                                </div>  


                                <div class="form-group">
                                    <label>Email </label>
                                    <input class=" right col-sm-10 " name="email"/>
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