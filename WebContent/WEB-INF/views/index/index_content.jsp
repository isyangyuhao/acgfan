<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<!-- 引入Title图标 -->
<link href="${pageContext.request.contextPath }/favicon.ico" type="image/x-icon" rel="shortcut icon" /> 
<!-- 声明页面信息与字符编码集 -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 声明移动端响应式布局-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 引入Title图标 -->
<link href="${pageContext.request.contextPath }/favicon.ico" type="image/x-icon" rel="shortcut icon" /> 
<!-- 引入Bootstrap框架样式部分-->
<link rel="stylesheet" href="${pageContext.request.contextPath }/framework/bootstrap.min.css" />
<!-- 引入该页面对应样式表 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" />
<!-- 引入logo使用的网络字库 -->
<link href='//cdn.webfont.youziku.com/webfonts/nomal/21641/46833/582d7e08f629d8136ca2db97.css' rel='stylesheet' type='text/css' />
<!-- 引入类型标题使用的网络字库 -->
<link href='//cdn.webfont.youziku.com/webfonts/nomal/21641/19673/582db26ff629d8136ca2dbc5.css' rel='stylesheet' type='text/css' />
<link href='//cdn.webfont.youziku.com/webfonts/nomal/21641/19673/584044bff629d80748ce1c7d.css' rel='stylesheet' type='text/css' />
<!-- 引入jQuery库 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/framework/jquery-2.0.2.js"></script>
<!-- 引入Bootstrap框架js部分 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/framework/bootstrap.min.js"></script>
<title>ACGFAN,让我们一起搞事情!~</title>
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

<!-- 主站bar图 [[ -->
	<div class="index_bar"></div>
<!-- 主站bar图 ]] -->

<!-- 视频分类导航栏 [[ -->
<div class="container-fluid" style="background-color: white; color:red;">
	<div class="row">
		<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
			<ul class="nav nav-tabs">
			  <li role="presentation" style="border-bottom:1px solid #f36c60"><a href="index-index-show" style="color:#f36c60">首页<i class="glyphicon glyphicon-home hidden-xs" ></i></a></li>
			  <li role="presentation"><a href="index-more-show?typeId=${sessionScope.videoTypes[0].id }">${sessionScope.videoTypes[0].typeName }<div class="type_number hidden-xs">${sessionScope.videoCount[0] }</div></a></li>
			  <li role="presentation"><a href="index-more-show?typeId=${sessionScope.videoTypes[1].id }"><div class="type_number hidden-xs">${sessionScope.videoCount[1] }</div>${sessionScope.videoTypes[1].typeName }</a></li>
			  <li role="presentation"><a href="index-more-show?typeId=${sessionScope.videoTypes[2].id }"><div class="type_number hidden-xs">${sessionScope.videoCount[2] }</div>${sessionScope.videoTypes[2].typeName }</a></li>
			  <li role="presentation"><a href="index-more-show?typeId=${sessionScope.videoTypes[3].id }"><div class="type_number hidden-xs">${sessionScope.videoCount[3] }</div>${sessionScope.videoTypes[3].typeName }</a></li>
			  <li class="hidden-xs" role="presentation"><a href="index-more-show?typeId=${sessionScope.videoTypes[4].id }"><div class="type_number hidden-xs">${sessionScope.videoCount[4] }</div>${sessionScope.videoTypes[4].typeName }</a></li>
			  <li class="hidden-xs" role="presentation"><a href="index-more-show?typeId=${sessionScope.videoTypes[5].id }"><div class="type_number hidden-xs">${sessionScope.videoCount[5] }</div>${sessionScope.videoTypes[5].typeName }</a></li>
			  <li class="hidden-xs" role="presentation"><a href="index-more-show?typeId=${sessionScope.videoTypes[6].id }"><div class="type_number hidden-xs">${sessionScope.videoCount[6] }</div>${sessionScope.videoTypes[6].typeName }</a></li>
			  <li class="hidden-xs" role="presentation"><a href="index-more-show?typeId=${sessionScope.videoTypes[7].id }"><div class="type_number hidden-xs">${sessionScope.videoCount[7] }</div>${sessionScope.videoTypes[7].typeName }</a></li>
			</ul>
		</div>
	</div>
</div>
<!-- 视频分类导航栏 ]] -->
<br>
<!-- 视频展示区 [[ -->
	<div class="container">
		<div class="row">
		<!-- 视频轮播图 [[ -->
			<!-- 大屏轮播图 -->
			<div class="col-lg-6 visible-lg">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
				  <!-- Indicators -->
				  <ol class="carousel-indicators">
				    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
				    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
				    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
				  </ol>
				
				  <!-- Wrapper for slides -->
				  <div class="carousel-inner" role="listbox">
				    <div class="item active">
				      <a href="#!"><img src="${pageContext.request.contextPath }/${requestScope.indexShows[0].src}" alt="${requestScope.indexShows[0].title}"></a>
				      <div class="carousel-caption">
					    <p>${requestScope.indexShows[0].title}</p>
					  </div>
				    </div>
				    <div class="item">
				       <a href="#!"><img src="${pageContext.request.contextPath }/${requestScope.indexShows[1].src}" alt="${requestScope.indexShows[1].title}"></a>
				      <div class="carousel-caption">
					    <p>${requestScope.indexShows[1].title}</p>
					  </div>
				    </div>
				   	<div class="item">
				       <a href="#!"><img src="${pageContext.request.contextPath }/${requestScope.indexShows[2].src}" alt="${requestScope.indexShows[2].title}"></a>
				      <div class="carousel-caption">
					    <p>${requestScope.indexShows[2].title}</p>
					  </div>
				    </div>
				  </div>
				</div>	
			</div>
			<!-- 小屏轮播图 -->
			<div class="col-md-6 col-md-offset-3 hidden-lg">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
				  <!-- Indicators -->
				  <ol class="carousel-indicators">
				    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
				    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
				    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
				  </ol>
				
				  <!-- Wrapper for slides -->
				  <div class="carousel-inner" role="listbox">
				    <div class="item active">
				      <a href="#!"><img src="${pageContext.request.contextPath }/${requestScope.indexShows[0].src}" alt="${requestScope.indexShows[0].src}"></a>
				      <div class="carousel-caption">
					    <p>${requestScope.indexShows[0].title}</p>
					  </div>
				    </div>
				    <div class="item">
				       <a href="#!"><img src="${pageContext.request.contextPath }/${requestScope.indexShows[1].src}" alt="${requestScope.indexShows[1].src}"></a>
				      <div class="carousel-caption">
					    <p>${requestScope.indexShows[1].title}</p>
					  </div>
				    </div>
				   	<div class="item">
				       <a href="#!"><img src="${pageContext.request.contextPath }/${requestScope.indexShows[2].src}" alt="${requestScope.indexShows[2].src}"></a>
				      <div class="carousel-caption">
					    <p>${requestScope.indexShows[2].title}</p>
					  </div>
				    </div>
				  </div>
				</div>	
				<br>
			</div>
			<!-- 视频轮播图 ]] -->
			<div class="col-lg-6 col-md-12 hidden-xs">
				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"><a href="index-play-show?id=${requestScope.videos6[0].id }"><div class="topPhoto" style="background-image: url(${pageContext.request.contextPath}/${requestScope.videos6[0].src })"></div></a></div>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"><a href="index-play-show?id=${requestScope.videos2[0].id }"><div class="topPhoto" style="background-image: url(${pageContext.request.contextPath}/${requestScope.videos2[0].src })"></div></a></div>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"><a href="index-play-show?id=${requestScope.videos7[0].id }"><div class="topPhoto" style="background-image: url(${pageContext.request.contextPath}/${requestScope.videos7[0].src })"></div></a></div>
				</div>
				<br>
				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"><a href="index-play-show?id=${requestScope.videos4[0].id }"><div class="topPhoto" style="background-image: url(${pageContext.request.contextPath}/${requestScope.videos4[0].src })"></div></a></div>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"><a href="index-play-show?id=${requestScope.videos5[0].id }"><div class="topPhoto" style="background-image: url(${pageContext.request.contextPath}/${requestScope.videos5[0].src })"></div></a></div>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"><a href="index-play-show?id=${requestScope.videos8[0].id }"><div class="topPhoto" style="background-image: url(${pageContext.request.contextPath}/${requestScope.videos8[0].src })"></div></a></div>
				</div>
			</div>
			<div class="col-lg-6 col-md-12 visible-xs">
			<br>
				<div class="row">
					<div class="col-xs-6"><a href="index-play-show?id=${requestScope.videos6[0].id }"><div class="topPhoto" style="background-image: url(${pageContext.request.contextPath}/${requestScope.videos6[0].src })"></div></a></div>
					<div class="col-xs-6"><a href="index-play-show?id=${requestScope.videos2[0].id }"><div class="topPhoto" style="background-image: url(${pageContext.request.contextPath}/${requestScope.videos2[0].src })"></div></a></div>
				</div>
				<br>
				<div class="row">
					<div class="col-xs-6"><a href="index-play-show?id=${requestScope.videos7[0].id }"><div class="topPhoto" style="background-image: url(${pageContext.request.contextPath}/${requestScope.videos7[0].src })"></div></a></div>
					<div class="col-xs-6"><a href="index-play-show?id=${requestScope.videos4[0].id }"><div class="topPhoto" style="background-image: url(${pageContext.request.contextPath}/${requestScope.videos4[0].src })"></div></a></div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$('.carousel').carousel({
		  interval: 3000
		})
	</script>
<!-- 视频展示区 ]] -->

<!-- 视频主体1 [[ -->
	<div class="container" style="border-bottom:1px solid #dddddd">
		<h3 class="css76035d43b5489" style="color:#f36c60; font-weight: bold;"><img src="${pageContext.request.contextPath }/photo/index/title_logo.png" width="50" height="35""></img>${sessionScope.videoTypes[0].typeName }</h3>
	</div>
	<br>
	<div class="container">
		<div class="row">
		  <c:forEach items="${requestScope.videos1 }" var="v" begin="0" end="3">
			  <div class="col-lg-3 col-md-3 col-sm-3">
			    <a href="index-play-show?id=${v.id }" class="thumbnail">
			      <img src="${pageContext.request.contextPath }/${v.src}">
			      <div class="caption">
			        <p class="text-center">${v.name }</p>
			        <p class="text-center" style="color:grey; font-size: 2px;"><fmt:formatDate value="${v.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
			      </div>
			    </a>
			  </div>
		  </c:forEach>	  
		</div>
		<div class="row">
		  <c:forEach items="${requestScope.videos1 }" var="v" begin="4" end="7">
			  <div class="col-lg-3 col-md-3 col-sm-3">
			    <a href="index-play-show?id=${v.id }" class="thumbnail">
			      <img src="${pageContext.request.contextPath }/${v.src}"">
			      <div class="caption">
			        <p class="text-center">${v.name }</p>
			        <p class="text-center" style="color:grey; font-size: 2px;"><fmt:formatDate value="${v.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
			      </div>
			    </a>
			  </div>
		  </c:forEach>	  
		</div>
	</div>
<!-- 视频主体1 ]] -->

<!-- 视频主体2 [[ -->
	<div class="container" style="border-bottom:1px solid #dddddd">
		<h3 class="css76035d43b5489" style="color:#f36c60; font-weight: bold;"><img src="${pageContext.request.contextPath }/photo/index/title_logo.png" width="50" height="35""></img>${sessionScope.videoTypes[1].typeName }</h3>
	</div>
	<br>
	<div class="container">
		<div class="row">
		  <c:forEach items="${requestScope.videos2 }" var="v" begin="0" end="3">
			  <div class="col-lg-3 col-md-3 col-sm-3">
			    <a href="index-play-show?id=${v.id }" class="thumbnail">
			      <img src="${pageContext.request.contextPath }/${v.src}">
			      <div class="caption">
			        <p class="text-center">${v.name }</p>
			        <p class="text-center" style="color:grey; font-size: 2px;"><fmt:formatDate value="${v.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
			      </div>
			    </a>
			  </div>
		  </c:forEach>	  
		</div>
		<div class="row">
		  <c:forEach items="${requestScope.videos2 }" var="v" begin="4" end="7">
			  <div class="col-lg-3 col-md-3 col-sm-3">
			    <a href="index-play-show?id=${v.id }" class="thumbnail">
			      <img src="${pageContext.request.contextPath }/${v.src}"">
			      <div class="caption">
			        <p class="text-center">${v.name }</p>
			        <p class="text-center" style="color:grey; font-size: 2px;"><fmt:formatDate value="${v.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
			      </div>
			    </a>
			  </div>
		  </c:forEach>	  
		</div>
	</div>
<!-- 视频主体2 ]] -->

<!-- 视频主体3 [[ -->
	<div class="container" style="border-bottom:1px solid #dddddd">
		<h3 class="css76035d43b5489" style="color:#f36c60; font-weight: bold;"><img src="${pageContext.request.contextPath }/photo/index/title_logo.png" width="50" height="35""></img>${sessionScope.videoTypes[2].typeName }</h3>
	</div>
	<br>
	<div class="container">
		<div class="row">
		  <c:forEach items="${requestScope.videos3 }" var="v" begin="0" end="3">
			  <div class="col-lg-3 col-md-3 col-sm-3">
			    <a href="index-play-show?id=${v.id }" class="thumbnail">
			      <img src="${pageContext.request.contextPath }/${v.src}">
			      <div class="caption">
			        <p class="text-center">${v.name }</p>
			        <p class="text-center" style="color:grey; font-size: 2px;"><fmt:formatDate value="${v.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
			      </div>
			    </a>
			  </div>
		  </c:forEach>	  
		</div>
		<div class="row">	
		  <c:forEach items="${requestScope.videos3 }" var="v" begin="4" end="7">
			  <div class="col-lg-3 col-md-3 col-sm-3">
			    <a href="index-play-show?id=${v.id }" class="thumbnail">
			      <img src="${pageContext.request.contextPath }/${v.src}"">
			      <div class="caption">
			        <p class="text-center">${v.name }</p>
			        <p class="text-center" style="color:grey; font-size: 2px;"><fmt:formatDate value="${v.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
			      </div>
			    </a>
			  </div>
		  </c:forEach>	  
		</div>
	</div>
<!-- 视频主体3 ]] -->

<!-- 视频主体4 [[ -->
	<div class="container" style="border-bottom:1px solid #dddddd">
		<h3 class="css76035d43b5489" style="color:#f36c60; font-weight: bold;"><img src="${pageContext.request.contextPath }/photo/index/title_logo.png" width="50" height="35""></img>${sessionScope.videoTypes[3].typeName }</h3>
	</div>
	<br>
	<div class="container">
		<div class="row">
		  <c:forEach items="${requestScope.videos4 }" var="v" begin="0" end="3">
			  <div class="col-lg-3 col-md-3 col-sm-3">
			    <a href="index-play-show?id=${v.id }" class="thumbnail">
			      <img src="${pageContext.request.contextPath }/${v.src}">
			      <div class="caption">
			        <p class="text-center">${v.name }</p>
			        <p class="text-center" style="color:grey; font-size: 2px;"><fmt:formatDate value="${v.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
			      </div>
			    </a>
			  </div>
		  </c:forEach>	  
		</div>
		<div class="row">	
		  <c:forEach items="${requestScope.videos4 }" var="v" begin="4" end="7">
			  <div class="col-lg-3 col-md-3 col-sm-3">
			    <a href="index-play-show?id=${v.id }" class="thumbnail">
			      <img src="${pageContext.request.contextPath }/${v.src}"">
			      <div class="caption">
			        <p class="text-center">${v.name }</p>
			        <p class="text-center" style="color:grey; font-size: 2px;"><fmt:formatDate value="${v.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
			      </div>
			    </a>
			  </div>
		  </c:forEach>	  
		</div>
	</div>
<!-- 视频主体4 ]] -->

<!-- 视频主体5 [[ -->
	<div class="container" style="border-bottom:1px solid #dddddd">
		<h3 class="css76035d43b5489" style="color:#f36c60; font-weight: bold;"><img src="${pageContext.request.contextPath }/photo/index/title_logo.png" width="50" height="35""></img>${sessionScope.videoTypes[4].typeName }</h3>
	</div>
	<br>
	<div class="container">
		<div class="row">
		  <c:forEach items="${requestScope.videos5 }" var="v" begin="0" end="3">
			  <div class="col-lg-3 col-md-3 col-sm-3">
			    <a href="index-play-show?id=${v.id }" class="thumbnail">
			      <img src="${pageContext.request.contextPath }/${v.src}">
			      <div class="caption">
			        <p class="text-center">${v.name }</p>
			        <p class="text-center" style="color:grey; font-size: 2px;"><fmt:formatDate value="${v.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
			      </div>
			    </a>
			  </div>
		  </c:forEach>	  
		</div>
		<div class="row">	
		  <c:forEach items="${requestScope.videos5 }" var="v" begin="4" end="7">
			  <div class="col-lg-3 col-md-3 col-sm-3">
			    <a href="index-play-show?id=${v.id }" class="thumbnail">
			      <img src="${pageContext.request.contextPath }/${v.src}"">
			      <div class="caption">
			        <p class="text-center">${v.name }</p>
			        <p class="text-center" style="color:grey; font-size: 2px;"><fmt:formatDate value="${v.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
			      </div>
			    </a>
			  </div>
		  </c:forEach>	  
		</div>
	</div>
<!-- 视频主体5 ]] -->

<!-- 视频主体6 [[ -->
	<div class="container" style="border-bottom:1px solid #dddddd">
		<h3 class="css76035d43b5489" style="color:#f36c60; font-weight: bold;"><img src="${pageContext.request.contextPath }/photo/index/title_logo.png" width="50" height="35""></img>${sessionScope.videoTypes[5].typeName }</h3>
	</div>
	<br>
	<div class="container">
		<div class="row">
		  <c:forEach items="${requestScope.videos6 }" var="v" begin="0" end="3">
			  <div class="col-lg-3 col-md-3 col-sm-3">
			    <a href="index-play-show?id=${v.id }" class="thumbnail">
			      <img src="${pageContext.request.contextPath }/${v.src}">
			      <div class="caption">
			        <p class="text-center">${v.name }</p>
			        <p class="text-center" style="color:grey; font-size: 2px;"><fmt:formatDate value="${v.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
			      </div>
			    </a>
			  </div>
		  </c:forEach>	  
		</div>
		<div class="row">	
		  <c:forEach items="${requestScope.videos6 }" var="v" begin="4" end="7">
			  <div class="col-lg-3 col-md-3 col-sm-3">
			    <a href="index-play-show?id=${v.id }" class="thumbnail">
			      <img src="${pageContext.request.contextPath }/${v.src}"">
			      <div class="caption">
			        <p class="text-center">${v.name }</p>
			        <p class="text-center" style="color:grey; font-size: 2px;"><fmt:formatDate value="${v.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
			      </div>
			    </a>
			  </div>
		  </c:forEach>	  
		</div>
	</div>
<!-- 视频主体6 ]] -->

<!-- 视频主体7 [[ -->
	<div class="container" style="border-bottom:1px solid #dddddd">
		<h3 class="css76035d43b5489" style="color:#f36c60; font-weight: bold;"><img src="${pageContext.request.contextPath }/photo/index/title_logo.png" width="50" height="35""></img>${sessionScope.videoTypes[6].typeName }</h3>
	</div>
	<br>
	<div class="container">
		<div class="row">
		  <c:forEach items="${requestScope.videos7 }" var="v" begin="0" end="3">
			  <div class="col-lg-3 col-md-3 col-sm-3">
			    <a href="index-play-show?id=${v.id }" class="thumbnail">
			      <img src="${pageContext.request.contextPath }/${v.src}">
			      <div class="caption">
			        <p class="text-center">${v.name }</p>
			        <p class="text-center" style="color:grey; font-size: 2px;"><fmt:formatDate value="${v.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
			      </div>
			    </a>
			  </div>
		  </c:forEach>	  
		</div>
		<div class="row">	
		  <c:forEach items="${requestScope.videos7 }" var="v" begin="4" end="7">
			  <div class="col-lg-3 col-md-3 col-sm-3">
			    <a href="index-play-show?id=${v.id }" class="thumbnail">
			      <img src="${pageContext.request.contextPath }/${v.src}"">
			      <div class="caption">
			        <p class="text-center">${v.name }</p>
			        <p class="text-center" style="color:grey; font-size: 2px;"><fmt:formatDate value="${v.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
			      </div>
			    </a>
			  </div>
		  </c:forEach>	  
		</div>
	</div>
<!-- 视频主体7 ]] -->

<!-- 视频主体8 [[ -->
	<div class="container" style="border-bottom:1px solid #dddddd">
		<h3 class="css76035d43b5489" style="color:#f36c60; font-weight: bold;"><img src="${pageContext.request.contextPath }/photo/index/title_logo.png" width="50" height="35""></img>${sessionScope.videoTypes[7].typeName }</h3>
	</div>
	<br>
	<div class="container">
		<div class="row">
		  <c:forEach items="${requestScope.videos8 }" var="v" begin="0" end="3">
			  <div class="col-lg-3 col-md-3 col-sm-3">
			    <a href="index-play-show?id=${v.id }" class="thumbnail">
			      <img src="${pageContext.request.contextPath }/${v.src}">
			      <div class="caption">
			        <p class="text-center">${v.name }</p>
			        <p class="text-center" style="color:grey; font-size: 2px;"><fmt:formatDate value="${v.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
			      </div>
			    </a>
			  </div>
		  </c:forEach>	  
		</div>
		<div class="row">	
		  <c:forEach items="${requestScope.videos8 }" var="v" begin="4" end="7">
			  <div class="col-lg-3 col-md-3 col-sm-3">
			    <a href="index-play-show?id=${v.id }" class="thumbnail">
			      <img src="${pageContext.request.contextPath }/${v.src}"">
			      <div class="caption">
			        <p class="text-center">${v.name }</p>
			        <p class="text-center" style="color:grey; font-size: 2px;"><fmt:formatDate value="${v.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </p>
			      </div>
			    </a>
			  </div>
		  </c:forEach>	  
		</div>
	</div>
<!-- 视频主体8 ]] -->
</div>
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