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
<title>Thêm sản phẩm mới | Quản trị</title>

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
									<f:form action="insertProduct.htm" modelAttribute="newProduct"
										method="post" id="formSave">
										<span class="section">Thêm sản phẩm mới</span>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Mã
												sản phẩm<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6">
												<f:input class="form-control" path="productId"
													name="productId" />
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Tên
												sản phẩm<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6">
												<f:input class="form-control" path="productName"
													name="productName" />
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Ảnh
												sản phẩm<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6">
												<input class="form-control" type="file" name="imageLink"
													id="imageLink" accept="image/png, image/jpeg" />
											</div>
											<div>
												<img alt="ImagePreview" id="thumbnail" height="100"
													width="100">
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Danh
												mục cha<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6">
												<f:select path="catalog.catalogId">
													<c:forEach items="${listCat }" var="cat">
														<f:option value="${cat.catalogId }">${cat.catalogName }</f:option>
													</c:forEach>
												</f:select>
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Giá
												bán <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6">
												<f:input class="form-control" path="price" name="price" />
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Tiêu
												đề <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6">
												<f:input class="form-control" path="title" name="title" />
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Mô
												tả sản phẩm <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6">
												<f:input class="form-control" path="descriptions"
													name="descriptions" />
											</div>
										</div>
										<!--  
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Ngày
												tạo<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6">
												<input class="form-control" class='date' type="date"
													name="created">
											</div>
										</div>
										-->
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Trạng
												thái<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6">
												<f:select path="productStatus">
													<f:option value="true">Hoạt động</f:option>
													<f:option value="false">Không hoạt động</f:option>
												</f:select>
											</div>
										</div>

										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Giảm
												giá %<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6">
												<f:input path="discount" type="number" name="discount" />
											</div>
										</div>

										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Thương
												hiệu <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6">
												<f:select path="brandProduct.brandId">
													<c:forEach items="${listBrand }" var="brand">
														<f:option value="${brand.brandId }">${brand.brandName}</f:option>
													</c:forEach>
												</f:select>
											</div>
										</div>
										<div class="field item form-group">
											<label class="col-form-label col-md-3 col-sm-3  label-align">Chất
												liệu<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6">
												<f:select path="materialProduct.materialId">
													<c:forEach items="${listMaterials }" var="mate">
														<f:option value="${mate.materialId }">${mate.materialName}</f:option>
													</c:forEach>
												</f:select>
											</div>
										</div>
										<div class="ln_solid">
											<div class="form-group">
												<div class="col-md-6 offset-md-3">
													<input type="submit" value="Tạo mới">
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

	<!---------- Show Image ---------------->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#imageLink').change(function() {
				showImageThumbnail(this);
			});
		});

		function showImageThumbnail(fileInput) {
			file = fileInput.files[0];
			reader = new FileReader();

			reader.onload = function(e) {
				$('#thumbnail').attr('src', e.target.result);
			};

			reader.readAsDataURL(file);
		}
	</script>
	
	
	<!---------- Validate Form ---------------->
	<script type="text/javascript">
		$(document).ready(function() {
			
			// Kiểm tra mã sản phẩm nhập vào //
			var isSuccess = false;
		    $.validator.addMethod(
		        "uniqueProductId", 
		        function(value, element) {
		            $.ajax({
		                type: "GET",
		                url: "/Final_Exam/checkProductId",
		                data: "productId="+value,
		                async: false,
		                //dataType:"html",
		                success: function(msg)
		                {
		                	isSuccess = (msg == "true") ? false : true;
		                    console.log(isSuccess);
		                }
		             });
		            return isSuccess; 
		        },
		        "ProductId đã tồn tại"
		    );
			
			$('#formSave').validate({
				rules : {
					"productId" : {
						required : true,
						maxlength : 5,
						uniqueProductId: true
					},
					"productName" : {
						required : true,
						minlength : 5
					},
					"price" : {
						required : true,
						min : 100000,
						max : 10000000
					},
					"title" : {
						required : true
					},
					"descriptions" : {
						required : true
					},
					"created" : {
						required : true
					},
					"discount" : {
						required : true,
						min : 0,
						max : 99
					}
				},

				messages : {
					"productId" : {
						required : "Bắt buộc nhập mã sản phẩm",
						maxlength : "Nhập tối đa 5 ký tự",
						uniqueProductId: "Mã sản phẩm đã tồn tại" 
					},
					"productName" : {
						required : "Bắt buộc nhập tên sản phẩm",
						minlength : "Nhập tối thiểu 5 ký tự"
					},
					"price" : {
						required : "Bắt buộc nhập giá bán",
						min : "Giá ban tren 100k",
						max : "Giá bán quá lớn"
					},
					"title" : {
						required : "Bắt buộc nhập tiêu đề",
					},
					"descriptions" : {
						required : "Bắt buộc nhập mô tả sản phẩm",
					},
					"created" : {
						required : "Bắt buộc nhập ngày",
					},
					"discount" : {
						required : "Bắt buộc nhập số giảm giá %",
						max: "Mã giảm giá phải nhỏ hơn 100"
					}
				}
			});
		});
	</script>
</body>
</html>