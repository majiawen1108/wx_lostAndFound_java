<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="tglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="http://fonts.googleapis.com/css?family=Oxygen|Marck+Script"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/style/css/bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/style/css/font-awesome.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/style/css/admin.css"
	rel="stylesheet">
<style type="text/css">
.container {
	width: 100%;
}

.span10 {
	width: 1280px;
}

.span5 {
	width: 1280px;
}

.row {
	float: left;
}
</style>
</head>
<body>
	<div class="container">

		<div class="row">

			<div class="span2">

				<div class="main-left-col">

					<h1>
						<i class="icon-shopping-cart icon-large"></i> laf_admin
					</h1>

					<ul class="side-nav">

						<li class="active"><a href="admin.do"><i
								class="icon-home"></i> 主&nbsp;页</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="collapse" data-target="#website-dropdown" href="#"><i
								class="icon-sitemap"></i> 单据信息库 <b class="caret"></b></a>
							<ul id="website-dropdown" class="collapse">
								<li id="found"><a href="bg_found.do">拾物仓库</a></li>
								<li id="search"><a href="bg_search.do">失物仓库</a></li>
							</ul></li>

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="collapse" data-target="#members-dropdown" href="#"><i
								class="icon-group"></i> 用户信息库 <b class="caret"></b></a>
							<ul id="members-dropdown" class="collapse">
								<li><a href="bg_userinfo.do">用户信息库</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="collapse" data-target="#settings-dropdown" href="#"><i
								class="icon-cogs"></i> 超级管理员 <b class="caret"></b></a>
							<ul id="settings-dropdown" class="collapse">
								<li><a href="bg_superadmin.do">管理员</a></li>
							</ul></li>
					</ul>

				</div>
				<!-- end main-left-col -->

			</div>
			<!-- end span2 -->

			<div id="main" class="span10">

				<div class="secondary-masthead">

					<ul class="nav nav-pills pull-right">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"><i class="icon-user"></i>${list6.username} <b
								class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li><a href="admin_login.do">Logout</a></li>
							</ul></li>
					</ul>

					<ul class="breadcrumb">
						<li><a href="#">Admin</a> <span class="divider">/</span></li>
						<li class="active">用户信息库</li>
					</ul>

				</div>

				<div class="main-area dashboard">
					<div class="row">
						<div class="span5">
							<div class="slate">
								<div class="page-header">
									<h2>
										<a class="pull-right iconlink" href=""><i class="icon-rss">
										</i></a>Informations
									</h2>
								</div>
								<table class="table table-striped">
									<thead>
										<tr>
											<th>微信昵称</th>
											<th>性别</th>
											<th>城市</th>
											<th>省份</th>
											<th>国家</th>
											<th>openid</th>
											<th>授权时间</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="list" items="${ list }" varStatus="st">
											<tr>
												<td>${fn:substring(list.nickName,0,9)}</td>
												<td>${fn:substring(list.sex,0,3)}</td>
												<td>${fn:substring(list.city,0,10)}</td>
												<td>${fn:substring(list.province,0,12)}</td>
												<td>${fn:substring(list.country,0,10)}</td>
												<td>${fn:substring(list.def1,0,14)}</td>
												<td>${fn:substring(list.def3,0,20)}</td>
												<td><a href="admin_delete_userinfo.do?id=${ list.id }">删除</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="row">

						<div class="span10 footer">

							<p>&copy; Website Name 2020</p>

						</div>

					</div>

				</div>

			</div>
			<!-- end span10 -->

		</div>
		<!-- end row -->

	</div>
	<!-- end container -->

	<!-- Le javascript
================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${pageContext.request.contextPath}/style/js/index.js"></script>
	<script src="${pageContext.request.contextPath}/style/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/style/js/bootstrap.js"></script>
	<script
		src="${pageContext.request.contextPath}/style/js/excanvas.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/style/js/jquery.flot.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/style/js/jquery.flot.resize.js"></script>
	<script type="text/javascript">
		$(function() {
			var d1 = [];
			d1.push([ 0, 32 ]);
			d1.push([ 1, 30 ]);
			d1.push([ 2, 24 ]);
			d1.push([ 3, 17 ]);
			d1.push([ 4, 11 ]);
			d1.push([ 5, 25 ]);
			d1.push([ 6, 28 ]);
			d1.push([ 7, 36 ]);
			d1.push([ 8, 44 ]);
			d1.push([ 9, 52 ]);
			d1.push([ 10, 53 ]);
			d1.push([ 11, 50 ]);
			d1.push([ 12, 45 ]);
			d1.push([ 13, 42 ]);
			d1.push([ 14, 40 ]);
			d1.push([ 15, 36 ]);
			d1.push([ 16, 34 ]);
			d1.push([ 17, 24 ]);
			d1.push([ 18, 17 ]);
			d1.push([ 19, 17 ]);
			d1.push([ 20, 20 ]);
			d1.push([ 21, 28 ]);
			d1.push([ 22, 36 ]);
			d1.push([ 23, 38 ]);

			$.plot($("#placeholder"), [ d1 ], {
				grid : {
					backgroundColor : 'white',
					color : '#999',
					borderWidth : 1,
					borderColor : '#DDD'
				},
				colors : [ "#FC6B0A" ],
				series : {
					lines : {
						show : true,
						fill : true,
						fillColor : "rgba(253,108,11,0.4)"
					}
				}
			});
		});
	</script>
</body>
</html>