<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Chinh sua thành viên</h4>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row">
                    <div class="col-md-2 col-12"></div>
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            <form class="form-horizontal form-material"action="/SERVLET_CRM/user/edit" method="POST">
                            	 <div class="form-group">
                                    <label class="col-md-12">Id</label>
                                    <div class="col-md-12">
                                        <input type="text" name ="id"placeholder=""
                                            class="form-control form-control-line" value="${User.id }" readonly > </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Full Name</label>
                                    <div class="col-md-12">
                                        <input type="text" name="fullname" placeholder=""
                                            class="form-control form-control-line" value=""> </div>
                                </div>
                                <div class="form-group">
                                    <label for="example-email" class="col-md-12">Email</label>
                                    <div class="col-md-12">
                                        <input type="email" name="email"placeholder=""
                                            class="form-control form-control-line" name="example-email"
                                            id="example-email" value=""> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Password</label>
                                    <div class="col-md-12">
                                        <input type="password" name="password" value="" class="form-control form-control-line">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Avatar</label>
                                    <div class="col-md-12">
                                        <input type="text" name ="avatar" placeholder=""
                                            class="form-control form-control-line" value=""> </div>
                                </div>
                                 <div class="form-group">
                                    <label class="col-md-12">Role_id</label>
                                    <div class="col-md-12">
                                        <input type="text" name="role_id" placeholder=""
                                            class="form-control form-control-line" value=""> </div>
                                </div>
                                
                        
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-success">Edit User</button>
                                        <a href="<%=request.getContextPath() %>/user" class="btn btn-primary">Quay lại</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-2 col-12"></div>
                </div>
                <!-- /.row -->
            </div>