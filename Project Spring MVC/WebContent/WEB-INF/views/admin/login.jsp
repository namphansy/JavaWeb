<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Đăng nhập | Quản trị</title>

<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/custom.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/fonts/css/all.min.css" />"
	rel="stylesheet">

</head>
<body class="login">
	<div>
		<a class="hiddenanchor" id="signup"></a> <a class="hiddenanchor"
			id="signin"></a>

		<div class="login_wrapper">
			<div class="animate form login_form">
				<section class="login_content">
					<form action="<c:url value='loginAction'/>" method="post" id="formLogin">
						<h1>Đăng nhập</h1>
						<div>
							<input type="text" class="form-control" name="username" placeholder="Tên đăng nhập" /> 
						</div>
						<div>
							<input type="password" class="form-control" name="password" placeholder="Mật khẩu" />		
						</div>
						<div style="margin-bottom: 10px">
							Duy trì đăng nhập: <input type="checkbox" name="remember-me" />
						</div>
						<div>
							<input type="submit" value="Đăng nhập">
						</div>
						<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
						<div class="clearfix"></div>	
					</form>
					<h2>${message}</h2>
				</section>
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
		$('#formLogin').validate({
			rules: {
				"username":{
					required: true,
				},
				"password":{
					required: true,
				}
			},
			
		messages: {
			"productId":{
				required: "Chưa nhập tên đăng nhập",
			},
			"password":{
				required: "Chưa nhập mật khẩu",
			},
		 }
		});
	});
	</script>			
</body>
</html>