<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid">
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Danh sách thành viên</h4>
		</div>

		<!-- /.col-lg-12 -->
	</div>

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
							<c:forEach items="${ searchResult}" var="item">
								<tr>
									<td>${item.id}</td>
									<td>${item.fullName }</td>
									<td>${item.email }</td>
									<td>${item.avatar }</td>
									<td>${item.role_name }</td>
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
