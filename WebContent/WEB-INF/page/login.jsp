<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="tglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="style/img/apple-icon.png">
<link rel="icon" type="image/png" href="style/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Login For LAF</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
	name='viewport' />
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
<link
	href="${pageContext.request.contextPath}/style/css/login/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/style/css/login/now-ui-kit.css?v=1.1.0"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/style/css/login/demo.css"
	rel="stylesheet" />
<link rel="canonical" href="" />
<meta name="keywords" content="">
<meta name="description" content="">
<style type="text/css">
.page-header {
	margin: 0;
}
</style>
</head>
<body class="login-page sidebar-collapse">

	<!-- End Navbar -->
	<div class="page-header" filter-color="orange">
		<div class="page-header-image"
			style="background-image: url(style/img/login.jpg)"></div>
		<div class="container">
			<div class="col-md-4 content-center">
				<div class="card card-login card-plain">
					<form class="form" method="post" action="admin_login.do">
						<div class="header header-primary text-center">
							<div class="logo-container">
								<img src="style/img/now-logo.png" alt="">
							</div>
						</div>
							<div>${msg}</div>
						<div class="content">
							<div class="input-group form-group-no-border input-lg">
								<span class="input-group-addon"> <i
									class="now-ui-icons users_circle-08"></i>
								</span> <input type="text" name="username" class="form-control"
									placeholder="Your Username...">
							</div>
							<div class="input-group form-group-no-border input-lg">
								<span class="input-group-addon"> <i
									class="now-ui-icons text_caps-small"></i>
								</span> <input type="password" name="password" placeholder="Your Password..."
									class="form-control" />
							</div>
						</div>
						<div class="footer text-center">
							<!-- <a href="#pablo" class="btn btn-primary btn-round btn-lg btn-block">Get Started</a> -->
							<button class="btn btn-primary btn-round btn-lg btn-block"
								type="submit">Get Started</button>
						</div>
						<div class="pull-left">
							<h6>
								<a href="#pablo" class="link">Create Account</a>
							</h6>
						</div>
						<div class="pull-right">
							<h6>
								<a href="#pablo" class="link">Need Help?</a>
							</h6>
						</div>
					</form>
				</div>
			</div>
		</div>
		<footer class="footer">
			<div class="container">
				<nav>
					<ul>
						<li><a href="#"> GitHub-download </a></li>
						<li><a href="#">
								welcome&nbsp;to&nbsp;Background&nbsp;management&nbsp;system </a></li>
					</ul>
				</nav>
				<div class="copyright">
					&copy;
					<script>
						document.write(new Date().getFullYear())
					</script>
					, Designed by MaJiawen. Coded by MaJiawen
				</div>
			</div>
		</footer>
	</div>
</body>

<script
	src="${pageContext.request.contextPath}/style/js/bootstrap.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/style/js/jquery.3.2.1.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/style/js/popper.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/style/js/bootstrap-switch.js"></script>
<script
	src="${pageContext.request.contextPath}/style/js/nouislider.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/style/js/bootstrap-datepicker.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/style/js/jquery.sharrre.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/style/js/now-ui-kit.js?v=1.1.0"
	type="text/javascript"></script>

</html>