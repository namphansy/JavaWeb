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
<title>Bài viết | Quản trị</title>

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
						<div class="col-md-12 col-sm-12 ">
							<div class="x_panel">
								<div class="x_title">
									<h2>Bài viết</h2>
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
												
														<!-- Thêm sản phẩm mới -->
												<button type="button" class="btn btn-primary" >
  													<a href="adminInitSaveBlog.htm">Thêm sản phẩm mới</a> 
												</button>
														<!-- Bảng hiển thị -->
												<table id="datatable"
													class="table table-striped table-bordered"
													style="width: 100%">
													<thead>
														<tr>
															<th>Mã bài viết</th>
															<th>Tên bài viết</th>
															<th>Tiêu đề</th>
															<th>Ngày tạo</th>
															<th>Trạng thái</th>
															<th>Hành động</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${listBlog}" var="blog">
															<tr>
																<td>${blog.blogId}</td>
																<td>${blog.blogName}</td>
																<td>${blog.title}</td>
																<td>
																	<fmt:formatDate value="${blog.created}" pattern="yyyy/MM/dd" />
																</td>
																<td><c:choose>
																		<c:when test="${blog.blogStatus}">Active</c:when>
																		<c:otherwise>Inactive</c:otherwise>
																	</c:choose></td>
																<td>
  																	<a href="adminInitUpdateBlog.htm?blogId=${blog.blogId}">
  																		<i class="far fa-edit"></i>
  																	</a>
  																	<a href="removeBlog.htm?blogId=${blog.blogId}">
  																		<i class="fas fa-sync"></i>
  																	</a>  
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
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
	<script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"
		type="text/javascript"></script>
	<script src="<c:url value="/resources/js/custom.js"/>"
		type="text/javascript"></script>
	<script
		src="<c:url value="/resources/js/datatables.net/js/jquery.dataTables.min.js"/>"
		type="text/javascript"></script>
</body>
</html>