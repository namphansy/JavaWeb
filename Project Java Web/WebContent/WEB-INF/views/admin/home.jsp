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
<title>Trang chủ | Quản trị</title>

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
					<div class="row" style="display: inline-block;">
						<div class="top_tiles">
							<div class="animated flipInY col-lg-3 col-md-3 col-sm-6 ">
								<div class="tile-stats">
									<div class="count">${{totalProductActive}}</div>
									<h3>Số sản phẩm đang hoạt động</h3>
								</div>
							</div>
							<div class="animated flipInY col-lg-3 col-md-3 col-sm-6 ">
								<div class="tile-stats">
									<div class="count">${{totalProductInActive}}</div>
									<h3>Số lượng sản phẩm trong kho</h3>
								</div>
							</div>
							<div class="animated flipInY col-lg-3 col-md-3 col-sm-6 ">
								<div class="tile-stats">
									<div class="count">${{totalAccountUser}}</div>
									<h3>Số lượng tài khoản người dùng</h3>
								</div>
							</div>
							<div class="animated flipInY col-lg-3 col-md-3 col-sm-6 ">
								<div class="tile-stats">
									<div class="icon">
										<i class="fa fa-check-square-o"></i>
									</div>
									<div class="count">179</div>
									<h3>New Sign ups</h3>
									<p>Lorem ipsum psdea itgum rixt.</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
                			<div class="x_panel">
                  				<div class="x_title">
                  					<h2>Số hóa đơn theo ngày</h2>
								</div>
								<div class="x_content">
									<canvas id="mybarChart"></canvas>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /page content -->
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
		src="<c:url value="/resources/js/chart/Chart.min.js"/>"
		type="text/javascript"></script>
	
	<script type="text/javascript"> 

	
		if ($('#mybarChart').length) {

	        var ctx = document.getElementById("mybarChart").getContext('2d');;
	        var mybarChart = new Chart(ctx, {
	            type: 'bar',
	            data: {
	                labels: [<c:forEach var="item" items="${listReportItem}">'${item.time}',</c:forEach>],
	                datasets: [{
	                    label: 'lượt order trong ngày',
	                    backgroundColor: "#26B99A",
	                    data: [<c:forEach var="item" items="${listReportItem}">${item.value},</c:forEach>]
	                }]
	            },

	            options: {
	                scales: {
	                    yAxes: [{
	                        ticks: {
	                            beginAtZero: true
	                        }
	                    }]
	                }
	            }
	        });
		}
	</script>	
</body>