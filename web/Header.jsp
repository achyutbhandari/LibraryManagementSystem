<%@page import="edu.ittn.librarymanagement.module.LoginModel"%>
<!DOCTYPE html>
<!-- JSTL Tags-->
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>


<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
     
    <title>Library Management System</title>


     
    <!-- Bootstrap Core CSS -->
    <link href="Assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="Assets/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="Assets/css/plugins/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="Assets/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="Assets/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="Assets/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- from choosen -->
     <link href="Assets/css/plugins/chosen.css" rel="stylesheet">
     <link href="Assets/css/plugins/jquery.datetimepicker.css" rel="stylesheet">
     <!-- DataTables CSS -->
    <link href="Assets/css/plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
 <!-- jQuery -->
    <script src="Assets/js/jquery.js"></script>

    
    
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Library Management System</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                
               
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <% LoginModel model =(LoginModel) session.getAttribute("user");%>
                        <label><%= model.getUserName() %></label>
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search..." >
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a class="active" href="#"><i class="fa fa-dashboard fa-fw"></i>Dashboard</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Categories<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li><a href="addcategoryform"><i class="fa fa-plus fa-fw"></i> Add Category</a></li>
                                <li><a href="listcategories"><i class="fa fa-edit fa-fw"></i>View Category</a></li>
                            </ul>
                            
                           
                            <!-- /.nav-second-level -->
                        </li> 
                        <li>
                            <a href="#"><i class="fa fa-book fa-fw"></i> Books<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li><a href="addbookform"><i class="fa fa-plus fa-fw"></i> Add Book</a></li>
                                <li><a href="listbooks"><i class="fa fa-edit fa-fw"></i>View Book</a></li>
                            </ul>
                            
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-male fa-fw"></i> Members<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li><a href="addmemberform"><i class="fa fa-plus fa-fw"></i> Add Member</a></li>
                                <li><a href="listmembers"><i class="fa fa-edit fa-fw"></i>Display Member</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bookmark fa-fw"></i>Book Issue<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li><a href="addbookissueform"><i class="fa fa-plus fa-fw"></i> Add Book Issue</a></li>
                                <li><a href="listbookissue"><i class="fa fa-edit fa-fw"></i>Display</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i>System User<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li><a href="addsystemuserform"><i class="fa fa-plus fa-fw"></i> Add User</a></li>
                                <li><a href="listusers"><i class="fa fa-edit fa-fw"></i>Display User</a></li>
                            </ul>
                            
                            <!-- /.nav-second-level -->
                        </li>
                        
                        
                                
                               
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

   