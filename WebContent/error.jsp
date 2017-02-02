<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 声明页面信息与字符编码集 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 声明移动端响应式布局-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 3秒钟后跳转回首页 -->
<meta http-equiv="refresh" content="4; url=${pageContext.request.contextPath }/index.jsp">
<!-- 引入Bootstrap框架样式部分-->
<link rel="stylesheet" href="${pageContext.request.contextPath }/framework/bootstrap.min.css" />
<!-- 引入该页面对应样式表 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" />
<!-- 引入logo使用的网络字库 -->
<link href='//cdn.webfont.youziku.com/webfonts/nomal/21641/46833/582d7e08f629d8136ca2db97.css' rel='stylesheet' type='text/css' />
<!-- 引入类型标题使用的网络字库 -->
<link href='//cdn.webfont.youziku.com/webfonts/nomal/21641/19673/582db26ff629d8136ca2dbc5.css' rel='stylesheet' type='text/css' />
<!-- 引入jQuery库 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/framework/jquery-2.0.2.js"></script>
<!-- 引入Bootstrap框架js部分 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/framework/bootstrap.min.js"></script>
<title>出错啦~</title>
<style type="text/css">
	body {
		background: no-repeat center 100px;
	}
</style>
</head>
<body style="background-image: url(${pageContext.request.contextPath }/photo/index/error.png)">
<br><br><br>
<h1 style="text-align: center">人在途中,何无犯错</h1>
<h1 style="margin-left:50px; text-align: center">加油 (ง •̀_•́)ง (*•̀ㅂ•́)و</h1>
<br>
<h3  style="text-align: center; color:333;">ErrorMsg: ${requestScope.errorMsg } <span id="returnNumber">3</span>s后跳转回首页...</h3>
</body>
<script type="text/javascript">
 	$(function() {
		setTimeout(function() {
			$("#returnNumber").html("2");
		}, 1000);
		setTimeout(function() {
			$("#returnNumber").html("1");
		}, 2000);
		setTimeout(function() {
			$("#returnNumber").html("0");
		}, 3000);
	}) 
</script>
</html>