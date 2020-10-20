<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="/SERVLET_CRM/static/plugins/images/favicon.png">
<title>Pixel Admin - Responsive Admin Dashboard Template build
	with Twitter Bootstrap</title>
<!-- Bootstrap Core CSS -->
<link href="/SERVLET_CRM/static/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


<!-- Menu CSS -->
<link
	href="/SERVLET_CRM/static/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css"
	rel="stylesheet">
<!-- Animation CSS -->
<link href="/SERVLET_CRM/static/css/animate.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="/SERVLET_CRM/static/css/style.css" rel="stylesheet">
<!-- color CSS you can use different color css from css/colors folder -->
<!-- We have chosen the skin-blue (blue.css) for this starter
          page. However, you can choose any other skin from folder css / colors .
-->
<link href="/SERVLET_CRM/static/css/colors/blue-dark.css" id="theme"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
	<!-- Preloader -->
	<div class="preloader">
		<div class="cssload-speeding-wheel"></div>
	</div>
	<div id="wrapper">
		<!-- Navigation -->
		<jsp:include page="/WEB-INF/views/layout/navigation.jsp"></jsp:include>
		<!-- Left navbar-header -->
		<jsp:include page="/WEB-INF/views/layout/leftnavbar.jsp"></jsp:include>

		<!-- Left navbar-header end -->
		<!-- Page Content -->
		<div id="page-wrapper">
			<!-- Noi dung tung page o day -->
			<dec:body></dec:body>
			<!-- /.container-fluid -->
			<footer class="footer text-center"> 2018 &copy; myclass.com
			</footer>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
	<!-- jQuery -->
	<script
		src="/SERVLET_CRM/static/plugins/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="/SERVLET_CRM/static/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Menu Plugin JavaScript -->
	<script
		src="/SERVLET_CRM/static/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
	<!--slimscroll JavaScript -->
	<script src="/SERVLET_CRM/static/js/jquery.slimscroll.js"></script>
	<!--Wave Effects -->
	<script src="/SERVLET_CRM/static/js/waves.js"></script>
	<!-- Custom Theme JavaScript -->
	<script src="/SERVLET_CRM/static/js/custom.min.js"></script>


	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap.min.js"></script>

	<script>
		$(document).ready(function() {
			$('#example').DataTable();
		});
	</script>


</body>

</html>