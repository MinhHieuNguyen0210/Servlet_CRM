<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!DOCTYPE html>

    <link rel="icon" type="image/png" sizes="16x16" href="/SERVLET_CRM/static/plugins/images/favicon.png">

    <!-- Bootstrap Core CSS -->
    <link href="/SERVLET_CRM/static/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="/SERVLET_CRM/static/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <!-- toast CSS -->
    <link href="/SERVLET_CRM/static/plugins/bower_components/toast-master/css/jquery.toast.css" rel="stylesheet">
    <!-- morris CSS -->
    <link href="/SERVLET_CRM/static/plugins/bower_components/morrisjs/morris.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="/SERVLET_CRM/static/css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="/SERVLET_CRM/static/css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="/SERVLET_CRM/static/css/colors/blue-dark.css" id="theme" rel="stylesheet">
    <link rel="stylesheet" href="/SERVLET_CRM/static/css/custom.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

        <!-- Left navbar-header end -->
        <!-- Page Content -->
     

            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Dashboard</h4>
                    </div>
                    <ol class="breadcrumb">
                        <li><a href="#">Dashboard</a></li>
                    </ol>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- row -->
            <div class="row">
                <!--col -->
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="white-box">
                        <div class="col-in row">
                            <div class="col-md-6 col-sm-6 col-xs-6"> <i data-icon="E"
                                    class="linea-icon linea-basic"></i>
                                <h5 class="text-muted vb">MYNEW CLIENTS</h5>
                            </div>
                            <div class="col-md-6 col-sm-6 col-xs-6">
                                <h3 class="counter text-right m-t-15 text-danger">23</h3>
                            </div>
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="progress">
                                    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="40"
                                        aria-valuemin="0" aria-valuemax="100" style="width: 40%"> <span
                                            class="sr-only">40% Complete (success)</span> </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.col -->
                <!--col -->
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="white-box">
                        <div class="col-in row">
                            <div class="col-md-6 col-sm-6 col-xs-6"> <i class="linea-icon linea-basic"
                                    data-icon="&#xe01b;"></i>
                                <h5 class="text-muted vb">NEW PROJECTS</h5>
                            </div>
                            <div class="col-md-6 col-sm-6 col-xs-6">
                                <h3 class="counter text-right m-t-15 text-megna">169</h3>
                            </div>
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="progress">
                                    <div class="progress-bar progress-bar-megna" role="progressbar" aria-valuenow="40"
                                        aria-valuemin="0" aria-valuemax="100" style="width: 40%"> <span
                                            class="sr-only">40% Complete (success)</span> </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.col -->
                <!--col -->
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="white-box">
                        <div class="col-in row">
                            <div class="col-md-6 col-sm-6 col-xs-6"> <i class="linea-icon linea-basic"
                                    data-icon="&#xe00b;"></i>
                                <h5 class="text-muted vb">NEW INVOICES</h5>
                            </div>
                            <div class="col-md-6 col-sm-6 col-xs-6">
                                <h3 class="counter text-right m-t-15 text-primary">157</h3>
                            </div>
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="progress">
                                    <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="40"
                                        aria-valuemin="0" aria-valuemax="100" style="width: 40%"> <span
                                            class="sr-only">40% Complete (success)</span> </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
            <!--row -->
            <div class="row">
                <div class="col-md-12">
                    <div class="white-box">
                        <h3 class="box-title">Sales Difference</h3>
                        <ul class="list-inline text-right">
                            <li>
                                <h5><i class="fa fa-circle m-r-5" style="color: #dadada;"></i>Site A View</h5>
                            </li>
                            <li>
                                <h5><i class="fa fa-circle m-r-5" style="color: #aec9cb;"></i>Site B View</h5>
                            </li>
                        </ul>
                        <div id="morris-area-chart2" style="height: 370px;"></div>
                    </div>
                </div>
            </div>

      

    <!-- jQuery -->
    <script src="/SERVLET_CRM/static/plugins/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="/SERVLET_CRM/static/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Menu Plugin JavaScript -->
    <script src="/SERVLET_CRM/static/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
    <!--slimscroll JavaScript -->
    <script src="/SERVLET_CRM/static/js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="/SERVLET_CRM/static/js/waves.js"></script>
    <!--Counter js -->	
    <script src="/SERVLET_CRM/static/plugins/bower_components/waypoints/lib/jquery.waypoints.js"></script>
    <script src="/SERVLET_CRM/static/plugins/bower_components/counterup/jquery.counterup.min.js"></script>
    <!--Morris JavaScript -->
    <script src="/SERVLET_CRM/static/plugins/bower_components/raphael/raphael-min.js"></script>
    <script src="/SERVLET_CRM/static/plugins/bower_components/morrisjs/morris.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="/SERVLET_CRM/static/js/custom.min.js"></script>
    <script src="/SERVLET_CRM/static/js/dashboard1.js"></script>
    <script src="/SERVLET_CRM/static/plugins/bower_components/toast-master/js/jquery.toast.js"></script>


