<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xửa thông tin danh mục</title>

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

			<!-------  Page Update --------->
			<div class="right_col" role="main">
				<div class="">
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 ">
							<div class="x_panel">
								<div class="x_title">
									<h2>Sản phẩm Danh mục</h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i
												class="fa fa-chevron-up"></i></a></li>
										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-expanded="false"><i
												class="fa fa-wrench"></i></a></li>
									</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<div class="row">
										<div class="col-sm-12">
											<div class="card-box table-responsive">
												<f:form action="updateCategories.htm" modelAttribute="updateCategories" method="post">
													<span class="section">Cập nhật danh mục</span>
													<div class="field item form-group">
														<label class="col-form-label col-md-3 col-sm-3  label-align">Mã danh mục<span
															class="required">*</span></label>
														<div class="col-md-6 col-sm-6">
															<f:input class="form-control" path="catalogId" readonly="true"/>
														</div>
													</div>
													<div class="field item form-group">
														<label class="col-form-label col-md-3 col-sm-3  label-align">Tên danh mục<span
															class="required">*</span></label>
														<div class="col-md-6 col-sm-6">
															<f:input class="form-control"  path="catalogName" />													
														</div>
													</div>
													<div class="field item form-group">
														<label class="col-form-label col-md-3 col-sm-3  label-align">Danh mục cha<span
															class="required">*</span></label>
														<div class="col-md-6 col-sm-6">
															<f:select path="parentId">
																<c:forEach items="${listUpdateParent }" var="cat">
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
															<f:input class="form-control" path="priorities" required='required' />
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
																<input type="submit" value="Update">
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
</body>
</html>