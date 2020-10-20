<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid">
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Danh sách quyền</h4>
		</div>
		<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
			<a href="<%=request.getContextPath()%>/role/add"
				class="btn btn-sm btn-success">Thêm mới</a>
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
								<th>Tên Quyền</th>
								<th>Mô Tả</th>
								<th>Hành Động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ roles }" var="role">
								<tr>
									<td>${ role.id}</td>
									<td>${role.name }</td>
									<td>${role.description} </td>
									<td><a href='<c:url value="/role/edit?id=${role.id }"/>' class="btn btn-sm btn-primary">Sửa</a> <a
										href='<c:url value="/role/delete?id=${role.id }"></c:url>' class="btn btn-sm btn-danger">Xóa</a></td>
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