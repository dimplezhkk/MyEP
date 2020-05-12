<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html class="x-admin-sm">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>鄭氏音乐</title>
        <meta name="renderer" content="webkit|ie-comp|ie-stand">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <meta http-equiv="Cache-Control" content="no-siteapp" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
        <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script>
            // 是否开启刷新记忆tab功能
            // var is_remember = false;
        </script>
    </head>
    <body class="index">
        <!-- 顶部开始 -->
        <div class="container">
            <div class="logo">
                <a href="#"><img width="180px" height="42px" src="${pageContext.request.contextPath}/images/logo2.jpg"></a></div>
            <div class="left_open">
                <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
            </div>
           
            <ul class="layui-nav right" lay-filter="">
                <li class="layui-nav-item">
                  <a href="javascript:;">
                    <font color="#1C41A7" size="20px"><font color="#000">尊敬的：</font>${sessionScope.user.realname}</font>
                    </a>
                    <dl class="layui-nav-child">
                        <!-- 二级菜单 -->
                        <dd>
                            <a onclick="xadmin.open('设置信息','${pageContext.request.contextPath}/admin/user-edit?userId=${sessionScope.user.id}',500,300)">
                            <i class="iconfont" style="color: green">&#xe6ae;</i>设置信息</a>
                       </dd>
                       <dd>
                            <a onclick="xadmin.open('修改密码','${pageContext.request.contextPath}/admin/editPassword?userId=${sessionScope.user.id}',550,300)" href="javascript:;">
                                        <i class="iconfont" style="color: red">&#xe82b;</i>修改密码
                           </a>
                       </dd>
                        <dd>
                            <a href="javascript:;" onclick="switchUser()"><i class="iconfont" style="color: Purple">&#xe6ce;</i>切换账号</a>
                       </dd>
                        <dd>
                            <a href="javascript:;" onclick="quit()"><i class="iconfont" style="color: red">&#xe6b7;</i>退出</a>
                       </dd>
                    </dl>
                </li>
                <li class="layui-nav-item to-index">
                    <a href="${pageContext.request.contextPath}/welcome">前台首页</a></li>
            </ul>
        </div>
        <!-- 顶部结束 -->
        <!-- 中部开始 -->
        <!-- 左侧菜单开始 -->
        <div class="left-nav">
            <div id="side-nav">
                <ul id="nav">
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="音乐中心">&#xe6c7;</i>
                            <cite>音乐中心</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('统计页面','${pageContext.request.contextPath}/user/welcome')">
                                    <i class="iconfont">&#xe6b4;</i>
                                    <cite>统计页面</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('歌曲管理','${pageContext.request.contextPath}/music/music-list')">
                                    <i class="iconfont">&#xe6bc;</i>
                                    <cite>歌曲管理</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('歌手管理','${pageContext.request.contextPath}/music/singer-list',true)">
                                    <i class="iconfont">&#xe6f5;</i>
                                    <cite>歌手管理</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('歌词管理','${pageContext.request.contextPath}/music/lyric-list')">
                                    <i class="iconfont">&#xe724;</i>
                                    <cite>歌词管理</cite></a>
                            </li>
                            
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="专辑中心">&#xe723;</i>
                            <cite>专辑中心</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                        
                            <li>
                                <a onclick="xadmin.add_tab('专辑管理','${pageContext.request.contextPath}/album/album-list')">
                                    <i class="iconfont">&#xe83d;</i>
                                    <cite>专辑管理</cite></a>
                            </li>
                            
                        </ul>
                    </li>
                    
                    
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="歌单中心">&#xe6fa;</i>
                            <cite>歌单中心</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('歌单管理','${pageContext.request.contextPath}/songSheet/songSheet_list')">
                                    <i class="iconfont">&#xe756;</i>
                                    <cite>歌单管理</cite></a>
                            </li>
                        </ul>
                    </li>
                    
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="MusicVideo中心">&#xe820;</i>
                            <cite>MusicVideo中心</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                            <li>
                                <a onclick="xadmin.add_tab('MusicVideo管理','${pageContext.request.contextPath}/mv/mv-list')">
                                    <i class="iconfont">&#xe736;</i>
                                    <cite>MusicVideo管理</cite></a>
                            </li>
                        </ul>
                    </li>
                    
                    <li>
                        <a href="javascript:;">
                            <i class="iconfont left-nav-li" lay-tips="管理员中心">&#xe726;</i>
                            <cite>管理员中心</cite>
                            <i class="iconfont nav_right">&#xe697;</i></a>
                        <ul class="sub-menu">
                        	<li>
                                <a onclick="xadmin.add_tab('轮播图管理','${pageContext.request.contextPath}/rotation/rotation-list')">
                                    <i class="iconfont">&#xe6a8;</i>
                                    <cite>轮播图管理</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('管理员列表','${pageContext.request.contextPath}/admin/user-list')">
                                    <i class="iconfont">&#xe726;</i>
                                    <cite>管理员列表</cite></a>
                            </li>
                            <li>
                                <a onclick="xadmin.add_tab('用户管理','${pageContext.request.contextPath}/consumer/consumer-list')">
                                    <i class="iconfont">&#xe753;</i>
                                    <cite>用户管理</cite></a>
                            </li>
                          
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        
        <!-- <div class="x-slide_left"></div> -->
        <!-- 左侧菜单结束 -->
        <!-- 右侧主体开始 -->
        <div class="page-content">
            <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
                <ul class="layui-tab-title">
                    <li class="home">
                        <i class="layui-icon">&#xe68e;</i>我的桌面</li></ul>
                
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <iframe src='${pageContext.request.contextPath}/user/welcome' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
                    </div>
                </div>
                <div id="tab_show"></div>
            </div>
        </div>
        <div class="page-content-bg"></div>
        <!-- 右侧主体结束 -->
        <!-- 中部结束 -->
        <script type="text/javascript">
            function quit() {
    			layui.use('layer', function() {
    				var layer = layui.layer;
    				layer.confirm('确定要告辞了吗?', {icon: 3, title:'退出'}, function(index){
    					  location.href="${pageContext.request.contextPath}/user/quit";
    					  layer.close(index);
    				});
    			});
    		}
            
            function switchUser() {
    			layui.use('layer', function() {
    				var layer = layui.layer;
    				layer.confirm('确定要切换账号吗?', {icon: 3, title:'切换账号'}, function(index){
    					  location.href="${pageContext.request.contextPath}/user/quit";
    					  layer.close(index);
    				});
    			});
    		}
            </script>
    </body>
</html>