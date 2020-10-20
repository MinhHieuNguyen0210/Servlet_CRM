<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.myclass.constants.UrlConstants"%>


<div class="container-fluid">
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Danh sách thành viên</h4>
		</div>
		<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
			<a href="<c:url value="${UrlConstants.USER_ADD_URL }"/>"
				class="btn btn-sm btn-success">Thêm mới</a>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
		<li>
			<form role="search" class="app-search hidden-xs" action='<c:url value="/user/search"></c:url>' method="POST">
				<input type="text" placeholder="Search..." class="form-control" name="value">
			
				<button type="submit" class="fa fa-search"></button>
			</form>
		</li>
	</ul>
	<!-- /row -->
	<div class="row">
		<div class="col-sm-12">
			<div class="white-box">
				<div class="table-responsive">
					<table class="table" id="example">
						<thead>
							<tr>
								<th>STT</th>
								<th>First Name</th>
								<th>Email</th>
								<th>Avatar</th>
								<th>Role</th>
								<th>#</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ User }" var="user">
								<tr>
									<td>${user.id}</td>
									<td>${user.fullName }</td>
									<td>${user.email }</td>
									<td>${user.avatar }</td>
									<td>${user.role_name }</td>
									<td><a
										href="<%=request.getContextPath() %>/user/edit?id=${user.id}"
										class="btn btn-sm btn-primary">Sửa</a> <a
										href="<%= request.getContextPath() %>/user/delete?id=${user.id}"
										class="btn btn-sm btn-danger">Xóa</a> <a
										href="<%=request.getContextPath()%>/user/details?id=${user.id}"
										class="btn btn-sm btn-info">Xem</a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- /.row -->
</div>
