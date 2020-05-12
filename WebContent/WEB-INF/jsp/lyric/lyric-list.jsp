<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html class="x-admin-sm">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>鄭氏音乐</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
        <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="${pageContext.request.contextPath}/user/welcome">首页</a>
            <a href="javascript:void(0);">音乐中心</a>
            <a>
              <cite>歌词管理</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form class="layui-form layui-col-space5" method="post" action="${pageContext.request.contextPath}/music/lyric-search">
                               
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="keyword" id="keyword"  placeholder="请输入歌手/歌曲名" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                        </div>
                        
                        <div class="layui-card-body layui-table-body layui-table-main" style="text-align: center;">
                        <!-- 数据表格 -->
	<table id="users" lay-filter="users"></table>
                             <table class="layui-table layui-form" style="table-layout: fixed;">
                                <thead>
                                  <tr>
                                    <th style="text-align: center;">
                                      <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                                    </th>
                                    <th style="text-align: center;">编号</th>
                                    <th style="text-align: center;">歌手</th>
                                    <th style="text-align: center;">歌曲</th>
                                    <th style="text-align: center;">歌词地址</th>
                                    <!-- <th>状态</th> -->
                                    <th style="text-align: center;">操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                
                                <c:forEach items="${pageInfo.list}" var="music" varStatus="status">
                                  <tr>
                                    <td>
                                      <input type="checkbox" name="id" value="${status.index}"   lay-skin="primary"> 
                                    </td>
                                    <td>${music.id}</td>
                                   <td>${music.singer }</td>
                                    <td>${music.musicname }</td>
                                    
                                   <td>${music.lyric }</td>
                                   
                                    <td class="td-manage">
                                     
                                      <a title="添加歌词"  onclick="xadmin.open('添加歌词','${pageContext.request.contextPath}/music/lyric-edit?musicId=${music.id}',530,300)" href="javascript:;">
                                        <i class="layui-icon">&#xe642;</i>
                                      </a>

                                    </td>
                                  </tr>
                                 </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="layui-card-body ">
                            <div class="page">
                                <div>
                                	
                                	<!-- 首页 -->
                                  <!-- 判断当前页 -->
                                  <c:if test="${pageInfo.pageNum==1}">
                                  <span class="current" style="border-radius:35px;display:none">GO首页</span>
                                  </c:if>
                                  <c:if test="${pageInfo.pageNum!=1}">
                                  <a class="num" href="${pageContext.request.contextPath}/music/lyric-list?page=1">
                                  GO首页
                                  </a>
                                  </c:if>
                                
                                	<!--上一页-->
                                	<c:if test="${pageInfo.pageNum==1}">
                                	<a class="prev" href="javascript:void(0);">&lt;&lt;
                                	</a>
                                	</c:if>
                                	<c:if test="${pageInfo.pageNum!=1}">
                                	<a class="prev" href="${pageContext.request.contextPath}/music/lyric-list?page=${pageInfo.pageNum-1}">&lt;&lt;
                                </a>
                                	</c:if>
                                
                                  <c:forEach items="${pageInfo.navigatepageNums}" var="page">
                                  <!-- 判断当前页 -->
                                  <c:if test="${pageInfo.pageNum==page}">
                                  <span class="current" style="border-radius:35px">${page}</span>
                                  </c:if>
                                  <c:if test="${pageInfo.pageNum!=page}">
                                  <a class="num" href="${pageContext.request.contextPath}/music/lyric-list?page=${page}">
                                  ${page}
                                  </a>
                                  </c:if>
                                  </c:forEach>
                                  
                                  <!-- 下一页 -->
                                  <c:if test="${pageInfo.pageNum==pageInfo.pages}">
                                  		<a class="next" href="javascript:void(0);">&gt;&gt;</a>
                                  </c:if>
                                  <c:if test="${pageInfo.pageNum!=pageInfo.pages}">
                                  <a class="next" href="${pageContext.request.contextPath}/music/lyric-list?page=${pageInfo.pageNum+1}">&gt;&gt;
                                  </a>
                                  </c:if>
                                  
                                  <!-- 尾页 -->
                                  <!-- 判断当前页 -->
                                  <c:if test="${pageInfo.pageNum==pageInfo.pages}">
                                  <span class="current" style="border-radius:35px;display:none">GO首页</span>
                                  </c:if>
                                  <c:if test="${pageInfo.pageNum!=pageInfo.pages}">
                                  <a class="num" href="${pageContext.request.contextPath}/music/lyric-list?page=${pageInfo.pages}">
                                  GO尾页
                                  </a>
                                  </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
</html>