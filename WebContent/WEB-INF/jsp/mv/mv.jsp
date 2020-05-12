<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" class="app">
<head>  
  <meta charset="utf-8" />
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
</head>
<body class="">
  <section class="vbox">
    <header class="bg-white-only header header-md navbar navbar-fixed-top-xs">
      <div class="navbar-header aside bg-primary nav-xs">
        <a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen,open" data-target="#nav,html">
          <i class="icon-list"></i>
        </a>
        <a href="${pageContext.request.contextPath}/welcome" class="navbar-brand text-lt">
          <i class="icon-earphones"></i>
          <img src="${pageContext.request.contextPath}/home/images/logo.png" class="hide">
          <span class="hidden-nav-xs m-l-sm">鄭氏音乐</span>
        </a>
        <a class="btn btn-link visible-xs" data-toggle="dropdown" data-target=".user">
          <i class="icon-settings"></i>
        </a>
      </div>      <ul class="nav navbar-nav hidden-xs">
        <li>
          <a href="#nav,.navbar-header" data-toggle="class:nav-xs,nav-xs" class="text-muted">
            <i class="fa fa-indent text"></i>
            <i class="fa fa-dedent text-active"></i>
          </a>
        </li>
      </ul>
      <!-- 这个form表单用来搞定搜索功能的 -->
      <form class="navbar-form navbar-left input-s-lg m-t m-l-n-xs hidden-xs" role="search" action="${pageContext.request.contextPath}/home/search">
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-btn">
              <button type="submit" class="btn btn-sm bg-white btn-icon rounded"><i class="fa fa-search"></i></button>
            </span>
            <input type="text" name="keyword" style="width: 200px;border: 1px solid #000" class="form-control input-sm no-border rounded" placeholder="搜索 歌曲,歌手,专辑,MV">
          </div>
        </div>
      </form>
      
        <!-- 这个div标签用来处理用户设置与用户退出功能 -->
      <div class="navbar-right">
        <ul class="nav navbar-nav m-n hidden-xs nav-user user">
          <li class="dropdown">
          <c:if test="${empty sessionScope.consumer}">
          <div style="padding-right: 50px;padding-top: 20px;">
          <span><a href="${pageContext.request.contextPath}/home/sign-in">登录</a>&nbsp;|&nbsp;</span>
          <span><a href="${pageContext.request.contextPath}/home/sign-up">注册</a></span>
          </div>
          </c:if>
          <c:if test="${!empty sessionScope.consumer}">
            <a href="javascript:void(0);" class="dropdown-toggle bg clear" data-toggle="dropdown" style="height: 60px;">
            <c:if test="${empty sessionScope.consumer.image}">
              <span class="thumb-sm avatar pull-right m-t-n-sm m-b-n-sm m-l-sm">
                <img src="${pageContext.request.contextPath}/images/头像.jpg">
              </span>
              </c:if>
              <c:if test="${!empty sessionScope.consumer.image}">
              <span class="thumb-sm avatar pull-right m-t-n-sm m-b-n-sm m-l-sm">
                <img src="http://localhost:8080/${sessionScope.consumer.image}">
              </span>
              </c:if>
              <c:if test="${empty sessionScope.consumer.nickname}">
              ${sessionScope.consumer.username}<b class="caret"></b>
              </c:if>
              <c:if test="${!empty sessionScope.consumer.nickname}">
              ${sessionScope.consumer.nickname}<b class="caret"></b>
              </c:if>
            </a>
            </c:if>
            <ul class="dropdown-menu animated fadeInRight">            
              <li>
                <span class="arrow top"></span>
                <a href="${pageContext.request.contextPath}/home/setting?username=${sessionScope.consumer.username}">设置</a>
              </li>
              <li class="divider"></li>
              <li>
                <a href="${pageContext.request.contextPath}/home/setPassword?username=${sessionScope.consumer.username}">
                	修改密码</a>
              </li>
              <li class="divider"></li>
              <li>
                <a href="${pageContext.request.contextPath}/home/quit">告辞了</a>
              </li>
              
            </ul>
          </li>
        </ul>
      </div>
    </header>
    <section>
      <section class="hbox stretch">
        <!-- .aside -->
        <aside class="bg-black dk nav-xs aside hidden-print" id="nav">          
          <section class="vbox">
            <section class="w-f-md scrollable">
              <div class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0" data-size="10px" data-railOpacity="0.2">
              
                <!-- nav -->                 
                <nav class="nav-primary hidden-xs">
                  <ul class="nav bg clearfix">
                    <li class="hidden-nav-xs padder m-t m-b-sm text-xs text-muted">
                      	发现
                    </li>
                    <li>
                      <a href="${pageContext.request.contextPath}/home">
                        <i class="icon-disc icon text-success"></i>
                        <span class="font-bold">惊喜</span>
                      </a>
                    </li>
                    <li>
                      <a href="${pageContext.request.contextPath}/home">
                        <i class="icon-music-tone-alt icon text-info"></i>
                        <span class="font-bold">歌曲</span>
                      </a>
                    </li>
                   <li>
                      <a href="${pageContext.request.contextPath}/singer">
                        <i class="icon-users icon  text-info-dker"></i>
                        <span class="font-bold">歌手</span>
                      </a>
                    </li>
                     <li>
                      <a href="${pageContext.request.contextPath}/album">
                        <i class="icon-drawer icon text-primary-lter"></i>
                        <span class="font-bold">专辑</span>
                      </a>
                    </li>
                    <li>
                      <a href="${pageContext.request.contextPath}/SongSheet">
                        <i class="icon-list icon  text-info-dker"></i>
                        <span class="font-bold">歌单</span>
                      </a>
                    </li>
                    <li>
                      <a href="${pageContext.request.contextPath}/musicVideo" data-target="#content" data-el="#bjax-el" data-replace="true">
                        <i class="icon-social-youtube icon  text-primary"></i>
                        <span class="font-bold">MV</span>
                      </a>
                    </li>
                    <li class="m-b hidden-nav-xs"></li>
                  </ul>
                </nav>
              </div>
            </section>
          </section>
        </aside>
   <!-- 主体部分 -->
  <section id="content">
          <section class="vbox" id="bjax-el">
            <section class="scrollable padder-lg">
              <h2 class="font-thin m-b">NEW Video</h2>
              <div class="row row-sm">
              <c:forEach items="${pageInfo.list}" var="musicVideo">
                <div class="col-xs-12 col-sm-4">
                  <div class="item">
                    <div class="pos-rlt">
                      <div class="item-overlay opacity r r-2x bg-black">
                        <div class="center text-center m-t-n">
                          <a href="${pageContext.request.contextPath}/home/showMusicVideoInfo?mvId=${musicVideo.id}"><i class="fa fa-play-circle i-2x"></i></a>
                        </div>
                      </div>
                      <div class="top">
                        <span class="badge bg-dark m-l-sm m-t-sm">${musicVideo.type}</span>
                      </div>
                      <a href="${pageContext.request.contextPath}/home/showMusicVideoInfo?mvId=${musicVideo.id}"><img width="395" height="200" src="http://localhost:8080/${musicVideo.image}" alt="" class="r r-2x img-full"></a>
                    </div>
                    <div class="padder-v">
                      <a href="${pageContext.request.contextPath}/home/showMusicVideoInfo?mvId=${musicVideo.id}" class="text-ellipsis">${musicVideo.name}</a>
                      <a href="${pageContext.request.contextPath}/home/showSingerInfo?singer=${musicVideo.singer}" class="text-ellipsis text-xs text-muted">${musicVideo.singer}</a>
                    </div>
                  </div>
                </div>
              </c:forEach>
              </div>
              
              <h3 class="font-thin m-b">Video List</h3>
              <div class="row row-sm">
              <c:forEach items="${MusicVideoinfo.list}" var="musicVideo">
                <div class="col-xs-6 col-sm-4 col-md-3">
                  <div class="item">
                    <div class="pos-rlt">
                      <div class="item-overlay opacity r r-2x bg-black">
                        <div class="center text-center m-t-n">
                          <a href="${pageContext.request.contextPath}/home/showMusicVideoInfo?mvId=${musicVideo.id}"><i class="fa fa-play-circle i-2x"></i></a>
                        </div>
                      </div>
                      <a href="${pageContext.request.contextPath}/home/showMusicVideoInfo?mvId=${musicVideo.id}"><img width="290" height="145" src="http://localhost:8080/${musicVideo.image}" alt="" class="r r-2x img-full"></a>
                    </div>
                    <div class="padder-v">
                      <a href="${pageContext.request.contextPath}/home/showMusicVideoInfo?mvId=${musicVideo.id}" class="text-ellipsis">${musicVideo.name}</a>
                      <a href="${pageContext.request.contextPath}/home/showSingerInfo?singer=${musicVideo.singer}" class="text-ellipsis text-xs text-muted">${musicVideo.singer}</a>
                    </div>
                  </div>
                </div>
                </c:forEach> 
              </div>
              <!-- 分页 -->
              <ul class="pagination pagination">
                      <!--上一页-->
                      <c:if test="${MusicVideoinfo.pageNum==1}">
                        <li><a href="javascript:void(0);"><i class="fa fa-chevron-left"></i></a></li>
                      </c:if>
                      <c:if test="${MusicVideoinfo.pageNum!=1}">
                      <li><a href="${pageContext.request.contextPath}/musicVideo?page=${MusicVideoinfo.pageNum-1}"><i class="fa fa-chevron-left"></i></a></li>
                      </c:if>
                      <c:forEach items="${MusicVideoinfo.navigatepageNums}" var="page">
                      <!-- 判断当前页 -->
                     	 <c:if test="${MusicVideoinfo.pageNum==page}">
                        <li class="active"><a href="javascript:void(0);">${page}</a></li>
                      	</c:if>
                      	<c:if test="${MusicVideoinfo.pageNum!=page}">
                        <li><a href="${pageContext.request.contextPath}/musicVideo?page=${page}">${page}</a></li>
                        </c:if>
                      </c:forEach>
                      <!-- 下一页 -->
                      <c:if test="${MusicVideoinfo.pageNum==MusicVideoinfo.pages}">
                        <li><a href="javascript:void(0);"><i class="fa fa-chevron-right"></i></a></li>
                     </c:if>
                     <c:if test="${MusicVideoinfo.pageNum!=MusicVideoinfo.pages}">
                     <li><a href="${pageContext.request.contextPath}/musicVideo?page=${MusicVideoinfo.pageNum+1}"><i class="fa fa-chevron-right"></i></a></li>
                     </c:if>
                      </ul>
                      
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
    <script src="${pageContext.request.contextPath}/home/js/masonry/tiles.min.js"></script>
  <script src="${pageContext.request.contextPath}/home/js/masonry/demo.js"></script>
  <script src="${pageContext.request.contextPath}/home/js/app.plugin.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/home/js/jPlayer/jquery.jplayer.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/home/js/jPlayer/add-on/jplayer.playlist.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/home/js/jPlayer/demo.js"></script>

</body>
</html>