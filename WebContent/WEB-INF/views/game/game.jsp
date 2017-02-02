<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<link href='//cdn.webfont.youziku.com/webfonts/nomal/21641/46833/582d7e08f629d8136ca2db97.css' rel='stylesheet' type='text/css' />
<!-- 引入logo使用的网络字库 -->
<link href='//cdn.webfont.youziku.com/webfonts/nomal/21641/46833/582d7e08f629d8136ca2db97.css' rel='stylesheet' type='text/css' />
<!-- 引入类型标题使用的网络字库 -->
<link href='//cdn.webfont.youziku.com/webfonts/nomal/21641/19673/582db26ff629d8136ca2dbc5.css' rel='stylesheet' type='text/css' />
<link href='//cdn.webfont.youziku.com/webfonts/nomal/21641/19673/584044bff629d80748ce1c7d.css' rel='stylesheet' type='text/css' />
<!-- 引入jQuery库 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/framework/jquery-2.0.2.js"></script>
<!-- 引入Bootstrap框架js部分 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/framework/bootstrap.min.js"></script>
<title>游戏中心</title>
<style type="text/css">
#moreGame a {
	color: grey;
}
#moreGame a:hover {
	color: skyblue;
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
        <li><a href="palette-palette-show"><i class="glyphicon glyphicon-picture" style="font-size:10px;"></i> 画友</a></li>
        <li><a href="shop-shop-show"><i class="glyphicon glyphicon-shopping-cart" style="font-size:10px;"></i> 周边商城</a></li>
        <li><a href="game-game-show"><i class="glyphicon glyphicon glyphicon-fire" style="color:#f36c60;font-size:10px;"></i> 游戏</a></li>
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

	<!--轮播-->
	<div id="myCarousel" class="carousel slide" style="margin-top:-20px;">
		<!-- 轮播（Carousel）指标 -->
		<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
		<li data-target="#myCarousel" data-slide-to="3"></li>
		</ol>
		<!-- 轮播（Carousel）项目 -->
		<div class="carousel-inner">
		<div class="item active">
		<img src="${pageContext.request.contextPath }/${requestScope.gameShows[0].src}" alt="First slide">
		</div>
		<div class="item">
		<img src="${pageContext.request.contextPath }/${requestScope.gameShows[1].src}" alt="Second slide">
		</div>
		<div class="item">
		<img src="${pageContext.request.contextPath }/${requestScope.gameShows[2].src}" alt="Third slide">
		</div>
		<div class="item">
		<img src="${pageContext.request.contextPath }/${requestScope.gameShows[3].src}" alt="Third slide">
		</div>
		
		</div>
		</div>
		<br /><br /><br />
			<script type="text/javascript">
			$('.carousel').carousel({
				  interval: 3000
				})
		</script>
		<!--轮播结束-->
		<!--第三部分-->
		
		<c:forEach items="${requestScope.games }" var="g" varStatus="status">
			<div class="row">
			<div class="col-md-6 col-md-offset-2" >
				<img src="${pageContext.request.contextPath }/${g.src}"  class="img-responsive" alt="Responsive image"/>
			</div>
			<div class="col-md-2">
				<span style="color: grey;font-size: 18px;font-weight: bold;">
				${g.name}
				</span>
				<br/><br/>
				<div style="background-color: lightseagreen;
					height: 2px;width: 200px;">
				</div>
				<br/>
				<p style="color: grey;">${g.title}</p>
				<br/><br/>
			</div>
		</div>
		<br>
		</c:forEach>
		
		
		<!--第三部分结束-->
		<br /><br /><br />
		<!--各种游戏-->
		<div class="row" id="moreGame">
			<div class="col-md-2 col-md-offset-2" style="border: 1px solid;border-color: darkgray;">
				<div class="row" style="background-color:lightgray;
					padding: 5px 0px 5px 8px;">
					<b style="font-size: 20dp;">手机游戏</b>
				</div>
				<div class="row" style="padding:3px 0px 3px 8px;height: 350px;">
					<p style="color: orange;">新游推荐</p>
					<c:forEach items="${requestScope.intro1 }" var="i" >
						<a href="#">${i.name }</a><br />
					</c:forEach>
				</div>
			</div>
			<div class="col-md-4" style="border: 1px solid;border-color: darkgray; margin-left:-1px; margin-right:-1px;">
				<div class="row" style="background-color:lightgray;
					padding: 5px 0px 5px 8px;height: 30.5px;">
					<b style="font-size: 20dp;"></b>
				</div>
				<div class="row" style="padding:3px 0px 3px 8px;height: 350px;">
					<p style="color: orange;">热门推荐</p>
					<div class="row">
						<c:forEach items="${requestScope.intro2 }" var="i" varStatus="status">
						<c:if test="${status.count % (requestScope.intro2size/2)  == 1}">
						<div class="col-md-6">
						</c:if>
							<a href="#">${i.name }</a><br />
						<c:if test="${status.count % (requestScope.intro2size/2) == 0}">
						</div>
						</c:if>
						</c:forEach>
					</div>
					
				</div>
			</div>
			<div class="col-md-2" style="border: 1px solid;border-color: darkgray;">
				<div class="row" style="background-color:lightgray;
					padding: 5px 0px 5px 8px;">
					<b style="font-size: 20dp;">网页游戏</b>
				</div>
				<div class="row" style="padding:3px 0px 3px 8px;height: 350px;">
					<p style="color: orange;">网游推荐</p>
					<c:forEach items="${requestScope.intro3 }" var="i" >
						<a href="#">${i.name }</a><br />
					</c:forEach>
				</div>
			</div>
			
		</div>
		<!--各种游戏结束-->
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