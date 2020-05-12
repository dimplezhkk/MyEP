<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>鄭氏音乐</title>
<meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/home/js/jPlayer/jplayer.flat.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/bootstrap.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/animate.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/font-awesome.min.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/simple-line-icons.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/font.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/app.css" type="text/css" />  
    <!--[if lt IE 9]>
    <script src="js/ie/html5shiv.js"></script>
    <script src="js/ie/respond.min.js"></script>
    <script src="js/ie/excanvas.js"></script>
  <![endif]-->
</head>
<body class="">
  <section class="vbox">
  <!-- 头部 -->
    <jsp:include page="../commons/homeTop.jsp"></jsp:include>
    <section>
      <section class="hbox stretch">
       <!--引入左边导航栏 -->
       <jsp:include page="../commons/leftNav.jsp"></jsp:include>
        
	<!-- 主体部分 -->
       <section id="content">
          <section class="vbox" id="bjax-el">
            <section class="scrollable wrapper-lg">
              <div class="row">
                <div class="col-sm-8">
                  <div class="panel wrapper-lg">
                    <div class="row">
                      <div class="col-sm-5">
                      
                        <img src="http://localhost:8080/${singer.image}" class="img-full m-b">
                      </div>
                      <div class="col-sm-7">
                        <h2 class="m-t-none text-black">${singer.singer}</h2>
                        
                        <div class="m-b-lg">
                        </div>
                        <div>
                        	  标签:<a href="javascript:void(0);" class="badge bg-light">${singer.sex}</a>
                        	   <a href="javascript:void(0);" class="badge bg-light">${singer.singertype}</a>
                        	  <a href="javascript:void(0);" class="badge bg-light">${description}</a>
                        </div>
                      </div>
                    </div>
                    <div class="m-t">
                      <p>${singer.description}</p>
                    </div>
                    <h4 class="m-t-lg m-b">歌曲播放列表</h4>
                    <ul class="list-group list-group-lg">
                    	<c:forEach items="${list}" var="musicList">
                    	
                      <li class="list-group-item">
                        <div class="pull-right m-l">
                          <a href="http://localhost:8080/${musicList.url}" class="m-r-sm"><i class="icon-cloud-download"></i></a>
                          <!-- <a href="#" class="m-r-sm"><i class="icon-plus"></i></a>
                          <a href="#"><i class="icon-close"></i></a> -->
                        </div>
                        <a href="${pageContext.request.contextPath}/home/showMusic?musicId=${musicList.id}" target="_blank" class="jp-play-me m-r-sm pull-left">
                          <i class="icon-control-play text"></i>
                          <i class="icon-control-pause text-active"></i>
                        </a>
                        <div class="clear text-ellipsis">
                          <span>${musicList.musicname}</span>
                          <span class="text-muted"> -- ${musicList.singer}</span>
                        </div>
                      </li>
                      </c:forEach>
                    </ul>
                  </div>
                </div>
                
                <!-- 歌手专辑列表 -->
                <div class="col-sm-4">
                  <div class="panel panel-default">
                    <div class="panel-heading">歌手专辑</div>
                    <div class="panel-body">
                    <c:forEach items="${album}" var="album">
                      <article class="media">
                        <a href="${pageContext.request.contextPath}/home/showAlbumInfo?albumId=${album.id}" class="pull-left thumb-md m-t-xs" style="width: 66px;height: 66px;">
                          <img src="http://localhost:8080/${album.image}" style="border-radius:25%">
                        </a>
                        <div class="media-body">                        
                          <a href="${pageContext.request.contextPath}/home/showAlbumInfo?albumId=${album.id}" class="font-semibold">${album.name}</a>
                          <div class="text-xs block m-t-xs"><a href="javascript:void(0);">${album.singer}</a> ${album.age}</div>
                        </div>
                      </article>
                      </c:forEach>
                    </div>
                  </div>
                </div>
              </div>
            </section>
          </section>
        </section>
      </section>
    </section>    
  </section>
  <script src="${pageContext.request.contextPath}/home/js/jquery.min.js"></script>
  <!-- Bootstrap -->
  <script src="${pageContext.request.contextPath}/home/js/bootstrap.js"></script>
  <!-- App -->
  <script src="${pageContext.request.contextPath}/home/js/app.js"></script>  
  <script src="${pageContext.request.contextPath}/home/js/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="${pageContext.request.contextPath}/home/js/app.plugin.js"></script>
</body>
</html>