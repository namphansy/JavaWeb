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
<title>Thêm danh mục mới | Quản trị</title>

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
									<f:form action="insertCategories.htm"  modelAttribute="saveCategories" method="post" id="formSave">
										<span class="section">Thêm danh mục mới</span>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Tên danh mục<span
												class="required">*</span></label>
											<div class="col-md-6 col-sm-6">
												<f:input class="form-control" path="catalogName" name="catalogName"/>
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Mô tả danh mục<span
												class="required">*</span></label>
											<div class="col-md-6 col-sm-6">
												<f:input class="form-control"  path="descriptions" name="descriptions"/>													
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Danh mục cha<span
												class="required">*</span></label>
											<div class="col-md-6 col-sm-6">
												<f:select path="parentId">
													<c:forEach items="${listCate }" var="cat">
														<f:option value="${cat.catalogId }">${cat.catalogName }</f:option>
													</c:forEach>
												</f:select>
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Độ ưu tiên
												<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6">
												<f:input class="form-control" path="priorities" type="number" name="priorities"/>
												 
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Trạng thái<span
												class="required">*</span></label>
											<div class="col-md-6 col-sm-6">
												<f:select path="catalogStatus">
													<f:option value="true">Hoạt động</f:option>
													<f:option value="false">Không hoạt động</f:option>
												</f:select>
											</div>
										</div>
										<div class="ln_solid">
											<div class="form-group">
												<div class="col-md-6 offset-md-3">
													<input type="submit" value="Thêm mới">
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
	<script src="<c:url value="/resources/js/jquery.validate.min.js"/>"
		type="text/javascript"></script>	
	<script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"
		type="text/javascript"></script>
	<script src="<c:url value="/resources/js/custom.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value="/resources/js/datatables.net/js/jquery.dataTables.min.js"/>"
		type="text/javascript"></script>
		
		<!---------- Validate Form ----------------> 
	<script type="text/javascript">
	$(document).ready(function() {
		$('#formSave').validate({
			rules: {
				"catalogName":{
					required: true,
					minlength: 5
				},
				"descriptions":{
					required: true,
					minlength: 5
				},
				"priorities":{
					required: true
				},
			},
			
		messages: {
			"catalogName": {
				required: "Bắt buộc nhập tên danh mục",
				minlength: "Hãy nhập ít nhất 5 ký tự"
			},
			"descriptions": {
				required: "Bắt buộc nhập mô tả danh mục",
				minlength: "Hãy nhập ít nhất 5 ký tự"
			},
			"priorities": {
				required: "Bắt buộc nhập độ ưu tiên",
			},
		}
		});
	});
	</script>		
</body>
</html>