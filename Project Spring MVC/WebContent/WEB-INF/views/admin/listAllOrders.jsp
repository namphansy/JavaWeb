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
<title>Hóa đơn | Quản trị</title>

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
									<h2>Hóa đơn</h2>
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
														<!-- Bảng hiển thị -->
												<table id="datatable"
													class="table table-striped table-bordered"
													style="width: 100%">
													<thead>
														<tr>
															<th>Mã hóa đơn</th>
															<th>Giá trị hóa đơn</th>
															<th>Ngày tạo</th>
															<th>Trạng thái</th>
															<th>Tên tài khoản</th>
															<th>Hành động</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${listOrders}" var="order">
															<tr>
																<td>${order.orderId}</td>
																<td>
																	<c:set var = "totalAmount" 
																		value = "${order.totalAmount}" />
																	 <fmt:formatNumber type = "number" 
																	 	maxFractionDigits = "3" value = "${totalAmount}" /> đ
																</td>
																<td>
																	<fmt:formatDate value="${order.created}" pattern="yyyy/MM/dd" />
																</td>
																<td>
																	<c:choose>
																		<c:when test="${order.orderStatus}">
																			<p style="color: green">Active</p>
																		</c:when>
																		<c:otherwise>
																			<p style="color: red">Inactive</p>
																		</c:otherwise>
																	</c:choose>
																</td>
																<td>${order.webUserOrders.userName}</td>
																<td>
  																	<a href="updateOrders.htm?ordersId=${order.orderId}">
  																		<i class="far fa-edit"></i>
  																	</a>
  																	<button id="getId" value="${order.orderId}">
  																		Hiển thị chi tiết		
  																	</button>
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
										<div style="margin-top:20px">
											<h3>Hiển thị chi tiết</h3>
											<table class="table">
												<thead class="thead-light">
													<tr>
														<th>ma san pham</th>
														<th>tong gia</th>
														<th>so luong</th>
													</tr>
												</thead>
												<tbody id="showDetail">
																				
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
	
	<script type="text/javascript">
		$(document).ready(function(){
			$('#getId').click(function(){
				var URL = "/Final_Exam/adminGetOrderDetailsById";
				let txt = $(this).val();
				$.ajax({
	                type: 'GET',
	                url: URL+'?orderId='+txt,
	                dataType: 'json',
	                success: function(res) {
	                    //console.log(res);
	                    var rows = "";
	                    for(var item of res){
	                    	console.log(item.price);
	                    	rows += '<tr><td>'+item.price+'</td><td>'+item.quantity+'</td></tr>';
	                    };
	                    $("#showDetail").html(rows);
	                    console.log(rows);
	                }
	            })
			})
		});
	</script>	
	
</body>
</html>