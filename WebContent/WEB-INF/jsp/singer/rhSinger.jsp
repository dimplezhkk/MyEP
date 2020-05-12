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
          <section class="vbox">
            <section class="w-f-md" id="bjax-target">
              <section class="hbox stretch">
                <!-- side content -->
                <aside class="aside bg-light dk" id="sidebar">
                  <section class="vbox animated fadeInUp">
                    <section class="scrollable hover">
                      <div id="menu" class="list-group no-radius no-border no-bg m-t-n-xxs m-b-none auto">
                        <a href="${pageContext.request.contextPath}/singer" class="list-group-item">
                          	全部
                        </a>
                        <a href="${pageContext.request.contextPath}/hySinger" class="list-group-item ">
                          	华语歌手
                        </a>
                        <a href="${pageContext.request.contextPath}/hyCompose" class="list-group-item">
                          	华语组合
                        </a>
                        <a href="${pageContext.request.contextPath}/rhSinger" class="list-group-item active">
                          	日韩歌手
                        </a>
                        <a href="${pageContext.request.contextPath}/rhCompose" class="list-group-item">
                          	日韩组合
                        </a>
                        <a href="${pageContext.request.contextPath}/omSinger" class="list-group-item">
                          	欧美歌手
                        </a>
                        <a href="${pageContext.request.contextPath}/omCompose" class="list-group-item">
                          	欧美组合
                        </a>
                      </div>
                    </section>
                  </section>
                </aside>
                <!-- / side content -->
                <section>
                  <section class="vbox">
                    <section class="scrollable padder-lg">
                      <h2 class="font-thin m-b">日韩歌手</h2>
                      <div class="row row-sm">
                      <c:forEach items="${pageInfo.list}" var="singer">
                        <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                          <div class="item">
                            <div class="pos-rlt">
                              <div class="item-overlay opacity r r-2x bg-black">
                                <div class="center text-center m-t-n">
                                  <a href="${pageContext.request.contextPath}/home/showSingerInfo?singer=${singer.singer}"
                                  target="_blank"><img width="155" height="155" style="border-radius:50%;" src="http://localhost:8080/${singer.image}" alt="" class="r r-2x img-full"></a>
                                </div>
                              </div>
                              <img width="155" style="border-radius:50%;" height="155" src="http://localhost:8080/${singer.image}" alt="" class="r r-2x img-full">
                            </div>
                            <div class="padder-v" style="text-align: center;">
                              ${singer.singer}
                            </div>
                          </div>
                        </div>
                        </c:forEach>
                      </div>
                      <!-- 分页 -->
                      <ul class="pagination pagination">
                      <!--上一页-->
                      <c:if test="${pageInfo.pageNum==1}">
                        <li><a href="javascript:void(0);"><i class="fa fa-chevron-left"></i></a></li>
                      </c:if>
                      <c:if test="${pageInfo.pageNum!=1}">
                      <li><a href="${pageContext.request.contextPath}/rhSinger?page=${pageInfo.pageNum-1}"><i class="fa fa-chevron-left"></i></a></li>
                      </c:if>
                      <c:forEach items="${pageInfo.navigatepageNums}" var="page">
                      <!-- 判断当前页 -->
                     	 <c:if test="${pageInfo.pageNum==page}">
                        <li class="active"><a href="#">${page}</a></li>
                      	</c:if>
                      	<c:if test="${pageInfo.pageNum!=page}">
                        <li><a href="${pageContext.request.contextPath}/rhSinger?page=${page}">${page}</a></li>
                        </c:if>
                      </c:forEach>
                      <!-- 下一页 -->
                      <c:if test="${pageInfo.pageNum==pageInfo.pages}">
                        <li><a href="javascript:void(0);"><i class="fa fa-chevron-right"></i></a></li>
                     </c:if>
                     <c:if test="${pageInfo.pageNum!=pageInfo.pages}">
                     <li><a href="${pageContext.request.contextPath}/rhSinger?page=${pageInfo.pageNum+1}"><i class="fa fa-chevron-right"></i></a></li>
                     </c:if>
                      </ul>
                      
                    </section>                    
                  </section>
                </section>
              </section>
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