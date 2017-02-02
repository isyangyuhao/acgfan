<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 引入Title图标 -->
<link href="${pageContext.request.contextPath }/favicon.ico" type="image/x-icon" rel="shortcut icon" /> 
<!-- 声明页面信息与字符编码集 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 声明移动端响应式布局-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 引入Bootstrap框架样式部分-->
<link rel="stylesheet" href="${pageContext.request.contextPath }/framework/bootstrap.min.css" />
<!-- 引入该页面对应样式表 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" />
<!-- 引入logo使用的网络字库 -->
<link href='//cdn.webfont.youziku.com/webfonts/nomal/21641/46833/582d7e08f629d8136ca2db97.css' rel='stylesheet' type='text/css' />
<!-- 引入类型标题使用的网络字库 -->
<link href='//cdn.webfont.youziku.com/webfonts/nomal/21641/19673/583304a6f629d816742d34f6.css' rel='stylesheet' type='text/css' />
<!-- 引入jQuery库 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/framework/jquery-2.0.2.js"></script>
<!-- 引入Bootstrap框架js部分 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/framework/bootstrap.min.js"></script>
<title>用户注册</title>
<style type="text/css">
	.register_bar {
		width: 100%;
		height: 300px;
		background-color: orange;
		margin-top: -21px;
		background: url(${pageContext.request.contextPath}/photo/account/register_bar.png) no-repeat center center;
		background-size: cover;
	}
	td p {
		margin-left: 40px;
	}
	td h4 {
		margin-left: 30px;
	}
</style>
</head>
<body>
<!-- 网站主体导航栏 [[ -->
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>	
      <a class="navbar-brand css716dd981b5489" href="index-index-show" style="color:#f36c60; font-size:28px;">ACGFAN</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class=""><a href="index-index-show"><i class="glyphicon glyphicon-film" style="color:#f36c60;font-size:10px;"></i> 主站</a></li>
        <li><a href="palette-palette-show"><i class="glyphicon glyphicon-picture" style="font-size:10px;"></i> 画友</a></li>
        <li><a href="shop-shop-show"><i class="glyphicon glyphicon-shopping-cart" style="font-size:10px;"></i> 周边商城</a></li>
      	<li><a href="game-game-show"><i class="glyphicon glyphicon glyphicon-fire" style="font-size:10px;"></i> 游戏</a></li>
      </ul>
           <form class="navbar-form navbar-right" role="search" action="index-search-execute" method="post">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="来啊, 搜我呀~" name="search">
        </div>
        <button type="submit" class="btn btn-default" style="background-color:#f36c60;">
        	<i class="glyphicon glyphicon-search" style="color:white;"></i>
        </button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <c:if test="${sessionScope.user != null}">
        	<li><a href="account-collect-show">收藏夹</a></li>
        </c:if>   
        <li class="dropdown">
          <!-- 用户未登录显示部分 -->
          <c:if test="${sessionScope.user == null}">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" >登录/注册 <span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	            <li><a href="account-login-show"><i class="glyphicon glyphicon-user" style="color:#f36c60;"></i> 用户登录</a></li>
	            <li class="divider"></li>
	            <li><a href="account-question-show"><i class="glyphicon glyphicon-plus-sign" style="color:#f36c60;"></i> 注册账号</a></li>
	          </ul>
          </c:if>
          <!-- 用户已登录显示部分 -->
          <c:if test="${sessionScope.user != null}">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" >${sessionScope.user.username } <span class="caret"></span></a>
	          <ul class="dropdown-menu" role="menu">
	            <li><a href="account-myself-show"><i class="glyphicon glyphicon-home" style="color:#f36c60;"></i> 个人中心</a></li>
	            <li><a href="account-edit-show"><i class="glyphicon glyphicon-pencil" style="color:#f36c60;"></i> 修改资料</a></li>
	            <li class="divider"></li>
	            <li><a href="account-exit-execute"><i class="glyphicon glyphicon-circle-arrow-left" style="color:#f36c60;"></i> 退出登录</a></li>
	          </ul>
          </c:if>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<!-- 网站主体导航栏 ]] -->
<!-- bar图 [[ -->
<!-- 	<div class="register_bar"></div>
 --><!-- bar图 ]] -->
<br>
<br>
<!-- 注册表单 [[ -->
<form action="account-register-execute" method="post">
<div class="container">
	<div class="row">
		<div class="col-lg-6 col-lg-offset-3">
			<table class="table table-bordered" style="text-align: center;">
				<tr>
					<td><h3><img src="${pageContext.request.contextPath }/photo/index/title_logo.png" width="50" height="35"></img><span class="css72c7373005489">恭喜您答对了全部的问题,现在可以注册啦!</span></h3></td>
				</tr>
				<tr>
					<td>
					<form>
						<br>
						<div class="input-group">
						  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
						  <input type="text" class="form-control" placeholder="用户名" name="username" id="usernameInput" value="">
						  <!--用户名不存在显示--><span class="glyphicon glyphicon-ok form-control-feedback" style="display:none" id="noExistName" ></span>
						  <!--用户名存在显示--><span class="glyphicon glyphicon-remove form-control-feedback" style="display:none" id="existName" ></span>
						</div>
						<br>
						<div class="input-group">
						  <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
						  <input type="password" class="form-control" placeholder="密码" name="password" id="passwordInput" value="">
						</div>
						<br>
						<div class="input-group">
						  <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
						  <input type="text" class="form-control" placeholder="个性签名" name="introduce" id="introduceInput" value="">
						</div>
						<br>
						<div class="input-group">
						  <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
						  <input type="date" class="form-control" title="出生日期" name="birth">
						</div>
						<br>
						<div>
						    <label>
						    	<span>性别 : </span>&nbsp;&nbsp;&nbsp;&nbsp;
						      <input type="radio" name="sex" value="m" checked="checked"> ♂男 &nbsp;&nbsp;
						      <input type="radio" name="sex" value="f"> ♀女
						    </label>
						 </div>
				    	<br>
					  <button type="submit" class="btn btn-info" id="registerBtn">注册</button>
					</form>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
</form>
<!-- 注册表单 ]] -->
<br><br><br>
<!-- 友情链接部分 [[ -->
<div class="container-fluid" style="background-color:rgb(236,236,236)" id="footer">
<br>
	<div class="container">
		<h4 style="color:#bbb">友情链接</h4>
		<div class="row">
			<div class="col-lg-4 col-md-4">
				<ul style="list-style: none;">
					<li><a href="${sessionScope.friendLinks[0].src }">${sessionScope.friendLinks[0].name }</a></li>
					<li><a href="${sessionScope.friendLinks[1].src }">${sessionScope.friendLinks[1].name }</a></li>
					<li><a href="${sessionScope.friendLinks[2].src }">${sessionScope.friendLinks[2].name }</a></li>
				</ul>
			</div>
			<div class="col-lg-4 col-md-4">
				<ul style="list-style: none;">
					<li><a href="${sessionScope.friendLinks[3].src }">${sessionScope.friendLinks[3].name }</a></li>
					<li><a href="${sessionScope.friendLinks[4].src }">${sessionScope.friendLinks[4].name }</a></li>
					<li><a href="${sessionScope.friendLinks[5].src }">${sessionScope.friendLinks[5].name }</a></li>
				</ul>
			</div>
			<div class="col-lg-4 col-md-4" style="font-size:16px;">
				<ul>
					<li>您可以下载我们的移动客户端</li>
					<li>也欢迎您关注我们的微博和微信<img src="${pageContext.request.contextPath }/photo/index/title_logo.png" width="50" height="35""></img></li>
				</ul>
			</div>
		</div>
	</div>
	<br>
</div>
<!-- 友情链接部分 ]] -->
<script type="text/javascript">
alert("恭喜您注册成功!");
window.location.href = "${pageContext.request.contextPath}/index.jsp";
$(function() {
	$("#registerBtn").on("click", function() {
		if ($("#usernameInput").val() == "" || $("#passwordInput").val() == "") {
			alert("用户名或密码不能为空!");
			return false;
		}
	});
	$("#usernameInput").on("change", function() {
		var val = $(this).val();
		val = $.trim(val);
		$(this).val(val);
		var url = "${pageContext.request.contextPath}/account-username-ajax";
		var args = {"username":val, "time":new Date()};
		$.post(url, args, function(data) {
			if (data == 1) {
				$("#existName").css("display", "inline");
				$("#noExistName").css("display", "none");
			} else if (data == -1) {
				$("#existName").css("display", "none");
				$("#noExistName").css("display", "inline");
			} else if (data == 0) {
				$("#existName").css("display", "none");
				$("#noExistName").css("display", "none");
			}
		});
	});
})
</script>
</body>
</html>