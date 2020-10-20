<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid">
	<div class="row bg-title">
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
			<h4 class="page-title">Chinh sua cong viec</h4>
		</div>
	</div>
	<!-- /.row -->
	<!-- .row -->
	<div class="row">
		<div class="col-md-2 col-12"></div>
		<div class="col-md-8 col-xs-12">
			<div class="white-box">
				<form class="form-horizontal form-material"
					action='<c:url value="/jobs/edit"></c:url>' method="post">
					<div class="form-group">
						<label class="col-md-12">Id</label>
						<div class="col-md-12">
							<input type="text" placeholder="id" value="${ job.id }"
								class="form-control form-control-line" name="id" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Tên công việc</label>
						<div class="col-md-12">
							<input type="text" placeholder="Tên công việc"
								class="form-control form-control-line" name="name">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Ngày bắt đầu</label>
						<div class="col-md-12">
							<input type="text" placeholder="dd/MM/yyyy"
								class="form-control form-control-line" name="start_date">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-12">Ngày kết thúc</label>
						<div class="col-md-12">
							<input type="text" placeholder="dd/MM/yyyy"
								class="form-control form-control-line" name="end_date">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<button type="submit" class="btn btn-success">Lưu lại</button>
							<a href='<c:url value="/jobs"></c:url>' class="btn btn-primary">Quay
								lại</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-2 col-12"></div>
	</div>
	<!-- /.row -->
</div>