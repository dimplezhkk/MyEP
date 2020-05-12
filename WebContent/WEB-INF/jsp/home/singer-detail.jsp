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
  <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script> 
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script> 
</head>
<body class="">
  <section class="vbox">
  <!-- 这里应该是包含了搜索部分，用户设置部分，用户退出部分的功能 -->
    <header class="bg-white-only header header-md navbar navbar-fixed-top-xs">
      <div class="navbar-header aside bg-info dk nav-xs">
        <a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen,open" data-target="#nav,html">
          <i class="icon-list"></i>
        </a>
        <a href="${pageContext.request.contextPath}/welcome" class="navbar-brand text-lt">
          <i class="icon-earphones"></i>
          <img src="${pageContext.request.contextPath}/home/images/logo.png" alt="." class="hide">
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
       <!-- 左边导航栏 -->
        <aside class="bg-dark dk nav-xs aside hidden-print" id="nav">          
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
                        <i class="icon-disc icon"></i>
                        <span class="font-bold">惊喜</span>
                      </a>
                    </li>
                    <li>
                      <a href="${pageContext.request.contextPath}/music">
                        <i class="icon-music-tone-alt icon"></i>
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
                        <i class="icon-social-youtube icon  text-info-dker"></i>
                        <span class="font-bold">MV</span>
                      </a>
                    </li>
                    <li class="m-b hidden-nav-xs"></li>
                  </ul>
                </nav>
                <!-- / nav -->
              </div>
            </section>
          </section>
        </aside>
        <!-- /.左边导航栏到此结束 -->
        
	<!-- 主体部分 -->
       <section id="content">
          <section class="vbox" id="bjax-el">
            <section class="scrollable wrapper-lg">
              <div class="row">
                <div class="col-sm-8">
                  <div class="panel wrapper-lg">
                    <div class="row">
                      <div class="col-sm-5">
                      
                        <img src="http://localhost:8080/${musicinfo.image}" class="img-full m-b">
                      </div>
                      <div class="col-sm-7">
                        <h2 class="m-t-none text-black">${musicinfo.musicname}</h2>
                        <div class="clearfix m-b-lg">
                          <a href="${pageContext.request.contextPath}/home/showMusic?musicId=${musicinfo.id}" target="_blank" class="thumb-sm pull-left m-r">
                            <img src="http://localhost:8080/${musicinfo.image}" class="img-circle">
                          </a>
                          <div class="clear">
                          
                            <a href="${pageContext.request.contextPath}/home/showSingerInfo?singer=${musicinfo.singer}" class="text-info">${musicinfo.singer}</a>
                            <!-- <small class="block text-muted">2,415 粉丝 / 225 粉丝</small> -->
                          </div>
                        </div>
                        <div class="m-b-lg">
                          <a href="${pageContext.request.contextPath}/home/showMusic?musicId=${musicinfo.id}" class="btn btn-info" target="_blank">播放</a>
                        </div>
                        <div>
                        	  标签:
                        	   <a href="javascript:void(0);" class="badge bg-light">${singer.singertype}</a>
                        	  <a href="javascript:void(0);" class="badge bg-light">${musicinfo.description}</a>
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
                    
                    <h4 class="m-t-lg m-b">评论区</h4>
                    <section class="comment-list block" style="height: 350px;overflow: auto;">
                    <c:forEach items="${pageInfo.list}" var="comment" varStatus="status">
                      <article id="comment-id-1" class="comment-item">
                      <c:if test="${empty comment.image}">
                      <a class="pull-left thumb-sm">
                          <img src="${pageContext.request.contextPath}/images/头像.jpg" class="img-circle">
                       </a>
                      </c:if>
                      <c:if test="${!empty comment.image}">
                        <a class="pull-left thumb-sm">
                          <img src="http://localhost:8080/${comment.image}" class="img-circle">
                       </a>
                       </c:if>
                        <section class="comment-body m-b">
                          <header>
                            <!-- <a href="javascript:void(0);"><strong>姓名</strong></a> -->
                            <label class="label bg-info m-l-xs">${comment.username}</label>
                            <span class="text-muted text-xs block m-t-xs">
                              	${comment.time}
                            </span>
                          </header>
                          <div class="m-t-sm">${comment.content}</div>
                        </section>
                      </article>
                      </c:forEach>
                    </section>
                    <h4 class="m-t-lg m-b">留下评论</h4>
                    <c:if test="${empty sessionScope.consumer}">
                    <h5>请先<a id="login" href="${pageContext.request.contextPath}/home/sign-in">登录</a>吧</h5>
                    </c:if>
                    <c:if test="${!empty sessionScope.consumer}">
                    <form id="addFrom" method="post" action="">
                      <div class="form-group pull-in clearfix">
                        <div class="col-sm-3">
                        <c:if test="${empty sessionScope.consumer.nickname}">
                          <label>你的账号</label>
                          <input type="text" class="form-control" name="username" id="username" readonly="readonly" value="${sessionScope.consumer.username}">
                        </c:if>
                        <c:if test="${!empty sessionScope.consumer.nickname}">
                          <label>你的昵称</label>
                          <input type="text" class="form-control" name="username" id="username" readonly="readonly" value="${sessionScope.consumer.nickname}">
                        </c:if>
                          <input type="hidden" name="userId" id="userId" value="${sessionScope.consumer.id}">
                          <input type="hidden" name="musicId" id="musicId" value="${musicinfo.id}">
                          <input type="hidden" name="image" id="image" value="${sessionScope.consumer.image}">
                        </div>
                        <div class="col-sm-3">
                          <label >评分</label>
                          <select class="form-control" name="scores" id="scores">
                          	<option value="0">0分</option>
                          	<option value="1">1分</option>
                          	<option value="2">2分</option>
                          	<option value="3">3分</option>
                          	<option value="4">4分</option>
                          	<option value="5">5分</option>
                          	<option value="6">6分</option>
                          	<option value="7">7分</option>
                          	<option value="8">8分</option>
                          	<option value="9">9分</option>
                          	<option value="10">10分</option>
                          </select>
                        </div>
                      </div>
                      <div class="form-group">
                        <label>评论</label>
                        <textarea class="form-control" placeholder="请输入您的评论,50词以内。" maxlength="50"
                        style="height:70px;width:670px;resize: none;" required="" id="comment" name="comment"></textarea>
                      </div>
                      <div class="form-group">
                        <button class="btn btn-success" lay-filter="add" lay-submit="">提交评论</button>
                      </div>
                    </form>
                    </c:if>
                  </div>
                </div>
                <div class="col-sm-4">
                  <div class="panel panel-default">
                    <div class="panel-heading">为您推荐</div>
                    <div class="panel-body">
                    <c:if test="${empty sessionScope.consumer}">
                    <h5>查看推荐,请先<a id="login" href="${pageContext.request.contextPath}/home/sign-in">登录</a>吧</h5>
                    </c:if>
                    <c:if test="${!empty sessionScope.consumer}">
                    <c:forEach items="${rlist}" var="recommend">
                      <article class="media">
                        <a href="${pageContext.request.contextPath}/home/showMusic?musicId=${recommend.id}" target="_blank" class="pull-left thumb-md m-t-xs">
                          <img src="http://localhost:8080/${recommend.image}">
                        </a>
                        <div class="media-body">                     
                          <a href="${pageContext.request.contextPath}/home/showMusicInfo?musicSinger=${recommend.singer}&musicName=${recommend.musicname}" class="font-semibold">
                          ${recommend.musicname}</a>
                          <div class="text-xs block m-t-xs"><a href="${pageContext.request.contextPath}/home/showSingerInfo?singer=${recommend.singer}">
                          ${recommend.singer}</a>&nbsp;&nbsp;${recommend.description}</div>
                        </div>
                      </article>
                      </c:forEach>
                      </c:if>
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
    <script>
        $(document).ready(function() {
            var href = $('#login').attr('href');
            var url = window.location.href;
            $('#login').attr('href', href + '?redirect=' + url);
        });
    </script>
   <script>
        layui.use(['form', 'layer','jquery'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;
                //监听提交
                form.on('submit(add)',
                function(data) {
                    console.log(data);
                    var selectedFile=new FormData();
                    var username=$("#username").val();
                    var userId=$("#userId").val();
                    var musicId=$("#musicId").val();
                    var scores=$("#scores").val();
                    var comment=$("#comment").val();
                    var image=$("#image").val();
                    
                    selectedFile.append("username",username);
                    selectedFile.append("userId",userId);
                    selectedFile.append("musicId",musicId);
                    selectedFile.append("scores",scores);
                    selectedFile.append("comment",comment);
                    selectedFile.append("image",image);
                    //发异步，把数据提交
                    $.ajax({
                    	type: 'post',
                        url: '${pageContext.request.contextPath}/comment/addComment',
                        cache: false,
                        async: true,
                        data: selectedFile,
                        //必须false才会避开jQuery对 formdata 的默认处理
        	            //XMLHttpRequest会对 formdata 进行正确的处理
                        processData:false,
                      //必须false才会自动加上正确的Content-Type
                        contentType:false
                    });
                    layer.alert("评论成功", {
                        icon: 6
                    },
                    function() {
                        //关闭当前frame
                         xadmin.close();
                        // 可以对父窗口进行刷新 
                        xadmin.father_reload();
                    });
                    return false;
                });
            });
</script>
</body>
</html>