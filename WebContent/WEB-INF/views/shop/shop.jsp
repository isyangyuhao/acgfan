<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
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
<!-- 引入logo使用的网络字库 -->
<link href='//cdn.webfont.youziku.com/webfonts/nomal/21641/46833/582d7e08f629d8136ca2db97.css' rel='stylesheet' type='text/css' />
<!-- 引入类型标题使用的网络字库 -->
<link href='//cdn.webfont.youziku.com/webfonts/nomal/21641/19673/583304a6f629d816742d34f6.css' rel='stylesheet' type='text/css' />
<!-- 引入jQuery库 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/framework/jquery-2.0.2.js"></script>
<!-- 引入Bootstrap框架js部分 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/framework/bootstrap.min.js"></script>
<title>周边商城</title>
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
			/*
			 * Description : 周边页面
			 * Time : 2016 / 11 / 21
			 * Author : li
			 * */

			/*通用样式, 消除默认外边距, 以body元素为基准*/
			* {
				margin: 0;
				padding: 0;
			}
			body {
				width: 100%;
				height: 100%;
				background-color: rgb(248, 248, 248);
			}
			/*  ----------------------------------------------------------------*/
			/*轮播部分*/
			.lunbo{
				height: 400px;
				width:100%;
				vertical-align: middle;
				display: table;
				width: auto;
				margin-left: auto;
				margin-right: auto;
			}
			/*  ----------------------------------------------------------------*/
			/*menu bar 菜单部分*/
			.menu{
				padding: 10px 0px;
				margin: 10px 0px;
				display: table;
				width: auto;
				margin-left: auto;
				margin-right: auto;
			}
			/*  ----------------------------------------------------------------*/
			/*goods 商品部分*/
			.goods{
				/*background-color: aquamarine;*/
				display: table;
				width: auto;
				margin-left: auto;
				margin-right: auto;
			}
			.goods_border{
				border:1px solid gray; 
				
			}
			.goods_img{
				padding-left: 15px;
			}
			.goods_p1{
				height:30px ;
				font-size: 16px;
				padding-bottom: 2px;
				padding-left: 8px
				
			}
			.goods_p2{
				padding-top: 15px;
				color: red;
				padding-left: 8px;
			}
			.goods_p3{
				color: darkgray;
				font-size: 14px;
				padding-left: 8px;
			}
			p {
				color:black;
			}
			/*  ----------------------------------------------------------------*/

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
        <li><a href="shop-shop-show"><i class="glyphicon glyphicon-shopping-cart" style="color:#f36c60; font-size:10px;"></i> 周边商城</a></li>
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

<!-- 商城主站部分 [[ -->
<!--        轮播部分                   -->
		<div id="myCarousel" class="carousel slide hidden-xs" style="margin-top:-22px;">
		<!-- 轮播（Carousel）指标 -->
		<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		</ol>
		<!-- 轮播（Carousel）项目 -->
		<div class="carousel-inner">
		<div class="item active">
		<img src="${pageContext.request.contextPath }/${requestScope.shopShows[0].photoSrc }" alt="First slide">
		</div>
		<div class="item">
		<img src="${pageContext.request.contextPath }/${requestScope.shopShows[1].photoSrc }" alt="Second slide">
		</div>
		
		</div>
		<!-- 轮播（Carousel）导航 -->
<!-- 		<a class="carousel-control left" href="#myCarousel"
		data-slide="prev">
		</a>
		<a class="carousel-control right" href="#myCarousel"
		data-slide="next">
		</a> -->
		</div>
	<script type="text/javascript">
	$('.carousel').carousel({
		  interval: 3000
		})
	</script>
		<br><br>
	<!--       goods 商品部分                   -->
	
	<c:forEach items="${requestScope.goods }" var="g" varStatus="status">
	<c:if test="${status.count % 4 == 1}">
		<div class="row goods">
	</c:if>
		<div class="col-md-3">
			<div class="row goods_img">
			<img src="${pageContext.request.contextPath }/${g.photoDesc}" class="img-rounded" />
			</div>
			<hr width="100%" style="border:1px solid gainsboro;"/>
			<div class="row">
			<a href="#myCarousel">
			<p class="goods_p1">${g.name}</p>
			</a>
			</div>
			<div class="row" style="margin-top:-25px;">
			<p class="goods_p2"><strong><fmt:formatNumber value="${g.price}" type="currency" pattern="$.00"></fmt:formatNumber></strong></p>
			</div>
			<div class="row">
			<p class="goods_p3" style="font-size: 12px;">市场价 <fmt:formatNumber value="${g.price*1.2}" type="currency" pattern="$.00"></fmt:formatNumber> </p>
			</div>
		</div>
	<c:if test="${status.count % 4 == 0}">
		</div>
	</c:if>
	</c:forEach>
	
	
<!-- 商城主站部分 ]] -->

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