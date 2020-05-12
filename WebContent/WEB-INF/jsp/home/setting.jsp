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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/bootstrap.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/animate.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/font-awesome.min.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/simple-line-icons.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/font.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/app.css" type="text/css" /> 
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
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
          <section class="hbox stretch">
            <section>
              <section class="vbox">
                <section class="scrollable padder-lg w-f-md" id="bjax-target">
                   <h3 class="font-thin">用户设置</h3>
                   <jsp:include page="set.jsp"></jsp:include>
                   
                  <!-- /主体部分到此结束 -->
                </section>
              </section>
            </section>
            <!-- 播放器到此结束 -->
           
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