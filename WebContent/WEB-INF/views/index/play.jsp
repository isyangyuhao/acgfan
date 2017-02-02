<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="org.acg.entities.VideoComment"%>
<%@page import="java.util.HashSet"%>
<%@page import="org.acg.entities.Video"%>
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
<!-- 引入Bootstrap框架样式部分-->
<link rel="stylesheet" href="${pageContext.request.contextPath }/framework/bootstrap.min.css" />
<!-- 引入该页面对应样式表 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" />
<!-- 引入logo使用的网络字库 -->
<link href='//cdn.webfont.youziku.com/webfonts/nomal/21641/46833/582d7e08f629d8136ca2db97.css' rel='stylesheet' type='text/css' />
<!-- 引入类型标题使用的网络字库 -->
<link href='//cdn.webfont.youziku.com/webfonts/nomal/21641/19673/582db26ff629d8136ca2dbc5.css' rel='stylesheet' type='text/css' />
<!-- 引用弹幕播放器相关样式 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css">
<!-- 引入jQuery库 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/framework/jquery-2.0.2.js"></script>
<!-- 引入Bootstrap框架js部分 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/framework/bootstrap.min.js"></script>
<title>ACGFAN,让我们一起搞事情!~</title>
</head>
<script type="text/javascript">
var videoId = ${requestScope.video.id};
</script>
<body>

<c:if test="${requestScope.video.id != 75 }">
	<div class="alert alert-danger" role="alert">
		<p>因为资源有限,我们无法将所有视频资源展示出来,
			如果需要查看播放视频效果请点击下方按钮进入演示页</p>
		<button type="button" class="close" data-dismiss="alert" id="closeBtn">
	  		<span aria-hidden="true">&times;</span>
	  		<span class="sr-only">Close</span>
		</button><br>
	<a href="index-play-show?id=75" type="button" class="btn btn-danger">进入演示页</a>
	<button type="button" class="btn btn-default" id="closeBtn2">不了</button></div>
	</div>
	<script type="text/javascript">
	$("#closeBtn, #closeBtn2").on("click", function() {
		$(".alert-danger").slideUp(500);
		return false;
	})
	</script>
</c:if>



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
			  <li role="presentation"><a href="index-index-show">首页<i class="glyphicon glyphicon-home hidden-xs" style="color:#f36c60"></i></a></li>
			  <li class="nav1" role="presentation"><a href="index-more-show?typeId=${sessionScope.videoTypes[0].id }">${sessionScope.videoTypes[0].typeName }<div class="type_number hidden-xs">${sessionScope.videoCount[0] }</div></a></li>
			  <li class="nav2" role="presentation"><a href="index-more-show?typeId=${sessionScope.videoTypes[1].id }"><div class="type_number hidden-xs">${sessionScope.videoCount[1] }</div>${sessionScope.videoTypes[1].typeName }</a></li>
			  <li class="nav3" role="presentation"><a href="index-more-show?typeId=${sessionScope.videoTypes[2].id }"><div class="type_number hidden-xs">${sessionScope.videoCount[2] }</div>${sessionScope.videoTypes[2].typeName }</a></li>
			  <li class="nav4" role="presentation"><a href="index-more-show?typeId=${sessionScope.videoTypes[3].id }"><div class="type_number hidden-xs">${sessionScope.videoCount[3] }</div>${sessionScope.videoTypes[3].typeName }</a></li>
			  <li class="nav5 hidden-xs" role="presentation"><a href="index-more-show?typeId=${sessionScope.videoTypes[4].id }"><div class="type_number hidden-xs">${sessionScope.videoCount[4] }</div>${sessionScope.videoTypes[4].typeName }</a></li>
			  <li class="nav6 hidden-xs" role="presentation"><a href="index-more-show?typeId=${sessionScope.videoTypes[5].id }"><div class="type_number hidden-xs">${sessionScope.videoCount[5] }</div>${sessionScope.videoTypes[5].typeName }</a></li>
			  <li class="nav7 hidden-xs" role="presentation"><a href="index-more-show?typeId=${sessionScope.videoTypes[6].id }"><div class="type_number hidden-xs">${sessionScope.videoCount[6] }</div>${sessionScope.videoTypes[6].typeName }</a></li>
			  <li class="nav8 hidden-xs" role="presentation"><a href="index-more-show?typeId=${sessionScope.videoTypes[7].id }"><div class="type_number hidden-xs">${sessionScope.videoCount[7] }</div>${sessionScope.videoTypes[7].typeName }</a></li>
			</ul>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
			<h4 style="color:#000; line-height: 1.5em;">${requestScope.video.name }</h4>
			<p style="color:#aaa">类别:${requestScope.video.videoType.typeName } &nbsp;&nbsp;&nbsp;&nbsp; 时间:<fmt:formatDate value="${requestScope.video.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<c:if test="${sessionScope.user != null}">
				<a href="index-like-execute?videoId=${requestScope.video.id}" style="color:grey;" id="addLike">加入收藏</a></p>
			</c:if>
		</div>
	</div>
</div>
	<!-- 收藏操作 -->
	<!-- <script type="text/javascript">
		$("#addLike").on("click", function() {
			var url = "${pageContext.request.contextPath}/index-like-ajax";
			var args = {"videoId":"${requestScope.video.id}", "time":new Date()};
			$.post(url, args, function(data) {
				if (data == 1) {
					alert("收藏成功");
				} else {
					alert("收藏失败");
				}
			});
			return false;
		})
	</script>	 -->
	<!-- 对应类型导航栏高亮 -->
	<script type="text/javascript">
	var className = ".nav${requestScope.video.videoType.id }";
	$(className+" a").css("color", "#f36c60");
	$(className).css("borderBottom", "1px solid #f36c60");
	</script>
<!-- 视频分类导航栏 ]] -->

<!-- 播放视频 [[ -->
<br>
<div class="container">
	<div class="row">
		<div class="col-lg-10 col-lg-offset-1">
			<div id="danmup" style="margin:20px auto" class="hidden-sm hidden-xs"></div>
				<div class="embed-responsive embed-responsive-16by9 hidden-lg hidden-md">
					<video class="embed-responsive-item" src="${pageContext.request.contextPath }/${requestScope.video.avSrc }" controls="controls"></video>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 播放视频 ]] -->

<!-- 评论部分 [[ -->
<hr>
<div class="container">
	<div class="row">
		<div class="col-lg-10 col-lg-offset-1" id="commentSuccess" style="display:none;">
			<h4 class="text-center">恭喜您评论成功√</h4>
		</div>
		<div class="col-lg-10 col-lg-offset-1" id="commentError" style="display:none;">
			<h4 class="text-center">您评论的内容不能为空 ◑▂◐ </h4>
		</div>
		<div class="col-lg-10 col-lg-offset-1" id="commentDiv">
		<c:if test="${sessionScope.user == null }">
			<h4 class="text-center">尚未登录的用户无法评论哦,赶快登录吧~</h4>
		</c:if>
		<c:if test="${sessionScope.user != null }">
			<form action="#!" method="post">
				<textarea class="form-control" rows="3" placeholder="请再次发表您对该视频的看法,下方会随机显示五条用户的评论信息,您的信息有可能会显示其中哦~" id="commentValue"></textarea><br>
				<button type="submit" class="btn btn-default pull-right" style="background-color:#f36c60; color:white;" id="commentBtn">发表评论</button>
			</form>
		</c:if>	
			<script type="text/javascript">
				//提交内容为空
				$("#commentBtn").on("click", function() {
					var value = $("#commentValue").val();
					value = $.trim(value);
					if (value == "") {
						$("#commentError").slideDown(500, function() {
							$("#commentError").slideUp(500);
						});
						return false;
					}
					var url = "${pageContext.request.contextPath}/index-comment-ajax";
					var url2 = "${pageContext.request.contextPath}/index-comment-ajax?content=" + value + "&videoId=${requestScope.video.id }";
					//var args = {"content":value, "videoId":"${requestScope.video.id}", "time":new Date()};
					var args = null;
					$.get(url2, args, function(data) {
						if (data == 1) {
							$("#commentDiv").hide(1000);
							$("#commentSuccess").show(1000, function() {
								$("#commentSuccess, #commentHr").slideUp(1000);
							});
						}
						if (data == 0) {
							alert("评论失败,请检查您的评论内容是否合法!");
						}
					}); 
					return false;
				})
			</script>
		</div>
	</div>
	<hr id="commentHr">
	<div class="row">
		<div class="col-lg-10 col-lg-offset-1" id="commentDiv">
			
			<c:forEach items="${requestScope.video.videoComments }" var="vc" begin="0" end="4">
				<div class="media">
				  <a class="media-left media-middle" href="#">
				    <img src="${pageContext.request.contextPath }/${vc.user.icon }" style="width:25px; height:25px;" class="img-circle">
				  </a>
				  <div class="media-body">
				    <p><strong>@${vc.user.username }</strong> &nbsp;&nbsp;<span style="font-size:12px; color:#aaa"> <fmt:formatDate value="${vc.createTime }" pattern="yyyy-MM-dd hh:mm:ss"/> </span></p>
				    <p>${vc.content }</p>
				  </div>
				</div>
				<hr>
			</c:forEach>
			
		</div>
	</div>
</div>
<!-- 评论部分 ]] -->

	
	
<script src="${pageContext.request.contextPath }/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.shCircleLoader.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.danmu.js"></script>
<script src="${pageContext.request.contextPath }/js/main.js"></script>
<script>
$("#danmup").DanmuPlayer({
	src: "${pageContext.request.contextPath }/${requestScope.video.avSrc }",  //视频播放地址
    height: "480px", //区域的高度
    width: "845px" //区域的宽度
  });

  $("#danmup .danmu-div").danmu("addDanmu",[
	<% 
		Object obj =  request.getAttribute("danmus");
    	ArrayList<String> danmus = (ArrayList<String>) obj;
    	for (int i = 0; i < danmus.size(); ++i) {
    		out.println(danmus.get(i) + ",");
    	}
	%>
  ]);
</script>


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