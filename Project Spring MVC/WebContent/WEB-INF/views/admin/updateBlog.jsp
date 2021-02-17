<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cập nhật bài viết | Quản trị</title>

<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/custom.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/fonts/css/all.min.css" />"
	rel="stylesheet">

</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<jsp:include page="component/sidebar.jsp" />
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12">
							<div class="x_panel">
								<div class="x_content">
									<f:form action="updateBlog.htm"  modelAttribute="updateBlog" method="post">
										<span class="section">Cập nhật bài viết</span>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Tên bài viết<span
												class="required">*</span></label>
											<div class="col-md-6 col-sm-6">
												<f:input class="form-control" path="blogName" name="blogName"/>
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Tiêu đề bài viết<span
												class="required">*</span></label>
											<div class="col-md-6 col-sm-6">
												<f:input class="form-control"  path="title" name="title"/>													
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Ngày tạo<span
												class="required">*</span></label>
											<div class="col-md-6 col-sm-6">
												<input class="form-control" class='date' type="date" name="created">
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Nội dung bài viết<span
												class="required">*</span></label>
											<div class="col-md-6 col-sm-6">
												<f:textarea class="form-control"  path="content" rows="10" name="content"/>													
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Trạng thái<span
												class="required">*</span></label>
											<div class="col-md-6 col-sm-6">
												<f:select path="blogStatus">
													<f:option value="true">Hoạt động</f:option>
													<f:option value="false">Không hoạt động</f:option>
												</f:select>
											</div>
										</div>
										<div class="ln_solid">
											<div class="form-group">
												<div class="col-md-6 offset-md-3">
													<input type="submit" value="Tạo">
													<button type='reset' class="btn btn-success">Reset</button>
												</div>
											</div>
										</div>
									</f:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- import script -->
	<script src="<c:url value="/resources/js/jquery-3.5.1.min.js"/>"
		type="text/javascript"></script>
	<script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"
		type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery.validate.min.js"/>"
		type="text/javascript"></script>	
	<script src="<c:url value="/resources/js/custom.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value="/resources/js/datatables.net/js/jquery.dataTables.min.js"/>"
		type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$('#updateBlog').validate({
			rules: {
				"blogName":{
					required: true,
					minlength: 8
				},
				"title":{
					required: true,
					minlength: 5
				},
				"created":{
					required: true
				},
				"content":{
					required: true,
					minlength: 10
				}	
			},
			
		messages: {
			"blogName": {
				required: "Bắt buộc nhập tên bài viết",
				minlength: "Hãy nhập ít nhất 8 ký tự"
			},
			"title": {
				required: "Bắt buộc nhập tiêu đề",
				minlength: "Hãy nhập ít nhất 5 ký tự"
			},
			"created": {
				required: "Bắt buộc nhập tiêu đề",
			},
			"content": {
				required: "Bắt buộc nhập nội dung",
				minlength: "Hãy nhập ít nhất 10 ký tự"
			}
		}
		});
	});
	</script>		
</body>
</html>