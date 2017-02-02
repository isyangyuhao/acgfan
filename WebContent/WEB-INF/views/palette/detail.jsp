<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
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
<title>画友</title>
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
	#introduce {
		color: #f36c60;
	}
	a:hover {
		text-decoration: none;
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
        <li class=""><a href="index-index-show"><i class="glyphicon glyphicon-film" style="font-size:10px;"></i> 主站</a></li>
        <li><a href="palette-palette-show"><i class="glyphicon glyphicon-picture" style="color:#f36c60; font-size:10px;"></i> 画友</a></li>
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

<!-- 网站主体 [[ -->

<div class="container" style="background-color: rgb(245,245,245);">
	<div class="row" style="margin-bottom: 50px;">
		<!--用户信息[[-->
		<div class="col-lg-1 col-md-1 col-sm-2 col-xs-3" style="margin-right: 50px;">
			<div class="row">
				<a href="#">
					<img src="${pageContext.request.contextPath }/${requestScope.palette.user.icon}" class="img-circle col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center" alt="Responsive image"/>
				</a>
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="row"><br/></div>
					<div class="row">
						<a style="color:black;"><h5 class="text-center">${requestScope.palette.user.username}</h5></a>
					</div>
				</div>	
			</div>
		</div>
		<!--]]用户信息-->
		
		<!--作品信息[[-->
		<div class="col-lg-10 col-md-10 col-sm-9 col-xs-7">
			<div class="row">
				<h3 class="text-center">${requestScope.palette.name}</h3>
			</div>
			<div class="row text-center" style="background-color: white;">
				<h6>
					&nbsp; TAG:${requestScope.palette.paletteType.typeName} &nbsp;&nbsp; / 
					&nbsp;&nbsp;<span class="glyphicon glyphicon-time"></span> <fmt:formatDate value="${requestScope.palette.createTime}" pattern="yyyy-MM-dd hh:mm:ss" /> &nbsp;&nbsp;
				</h6>
			</div>
		</div>
		<!--]]作品信息-->
	</div>
	<div class="row" style="border:1px solid; border-color: rgb(221,221,221); margin-bottom: 50px;">
		<!--图片展示[[-->
		<div class="row" style="background-color: rgb(251,251,251); padding-top: 40px; padding-bottom: 40px; margin-left: 0px; margin-right: 0px;">
			<div class="col-lg-3 col-md-3 col-xs-3" style="padding: 0px;"></div>
			<img src="${pageContext.request.contextPath }/${requestScope.palette.src}" class="col-md-6 col-xs-6 text-center" alt="Responsive image" style="padding: 0px;"/>
			<div class="col-lg-3 col-md-3 col-xs-3" style="padding: 0px;"></div>
		</div>
		<!--]]图片展示-->
	</div>
</div>

<!-- 网站主体 ]] -->

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
</body>
</html>