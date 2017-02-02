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
<link href='//cdn.webfont.youziku.com/webfonts/nomal/21641/19673/582db26ff629d8136ca2dbc5.css' rel='stylesheet' type='text/css' />
<!-- 引入jQuery库 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/framework/jquery-2.0.2.js"></script>
<!-- 引入Bootstrap框架js部分 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/framework/bootstrap.min.js"></script>
<title>用户登录</title>
<style type="text/css">
	body {
		background-color: rgb(251, 251, 251);
	}
	button {
		margin-left: 20px;
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
<br><br>
<!-- 登录主题内容 [[ -->
<form action="account-login-execute" method="post">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6"><img src="${pageContext.request.contextPath }/photo/account/account_background.png" alt="" class="img-responsive" /></div>
			<div class="col-lg-4 col-md-6 col-lg-offset-1">
					<br><br><br><br>
				  <h3><img src="${pageContext.request.contextPath }/photo/index/title_logo.png" width="50" height="35""></img>登录 <span style="font-weight: bold;" class="css716dd981b5489">ACGFAN</span></h3>
				  <div class="form-group">
				    <div class="input-group">
				      <div class="input-group-addon"><i class="glyphicon glyphicon-user"></i></div>
				      <input class="form-control" type="text" placeholder="请输入用户名" id="usernameInput" name="username">
				     	<!--用户名存在显示--><span class="glyphicon glyphicon-ok form-control-feedback" style="display:none" id="existName"></span>
						<!--用户名不存在显示--><span class="glyphicon glyphicon-remove form-control-feedback" style="display:none" id="noExistName"></span>
					</div>
				    <br>
				  <div class="input-group">
				      <div class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></div>
				      <input class="form-control" type="password" placeholder="请输入密码" name="password" id="passwordInput">
				    </div>
				  </div>
					  <a type="button" class="btn btn-default pull-right" id="registerBtn" style="margin-left:20px" href="account-question-show">&nbsp;&nbsp;注册&nbsp;&nbsp;</a>
 					  <button type="submit" class="btn btn-default pull-right" style="background-color:#f36c60;color:white;" id="loginBtn">&nbsp;&nbsp;登录&nbsp;&nbsp;</button>	
			</div>
		</div>
	</div>
</form>
<!-- 登录主题内容 ]] -->

<!-- 管理员登录模态框 [[ -->
<!-- Large modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm" id="myModal" style="display:none;">Admin Login</button>

<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <h2 style="text-align: center;">Admin Login</h2>
<form role="form" action="admin-login" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">&nbsp;&nbsp;<i class="glyphicon glyphicon-briefcase"></i> Admin</label>
    <input type="text" class="form-control" id="" placeholder="请输入管理员名" name="username">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">&nbsp;&nbsp;<i class="glyphicon glyphicon-lock"></i>Password</label>
    <input type="password" class="form-control" id="" placeholder="请输入管理员密码" name="password">
  </div>
  <br>
  <button type="submit" class="btn btn-default center-block">登录</button>
  <br>
</form>
    </div>
  </div>
</div>
<!-- 管理员登录模态框 ]] -->

<script type="text/javascript">
$("#usernameInput").change(function() {
	var val = $(this).val();
	val = $.trim(val);
	$(this).val(val);
	if (val == "$admin") {
		$("#existName").css("display", "none");
		$("#noExistName").css("display", "none");
		$("#usernameInput").val("");
		$("#myModal").click();
		return ;
	}
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
$("#loginBtn").on("click", function() {
	if ($("#usernameInput").val() == "" || $("#passwordInput").val() == "") {
		alert("用户名或密码不能为空,请检查后重试!");
		return false;
	}
})
</script>
</body>
</html>