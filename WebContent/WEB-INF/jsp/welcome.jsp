<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>欢迎页面</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
        <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">

			<div class="layui-col-sm12 layui-col-md6">
                    <div class="layui-card">
                        <div class="layui-card-header"><i class="iconfont" style="color: #1E90FF">&#xe753;</i>用户数目:</div>
                        <div class="layui-card-body" style="min-height: 100px;">
                            <div id="main2" class="layui-col-sm12" style="padding-left:60px;height: 110px;font-size: 30px;">${consumer}</div>

                        </div>
                    </div>
                </div>
                
                <div class="layui-col-sm12 layui-col-md6">
                    <div class="layui-card">
                        <div class="layui-card-header"><i class="iconfont" style="color: #B22222">&#xe6f5;</i>歌手数目:</div>
                        <div class="layui-card-body" style="min-height: 100px;">
                            <div id="main2" class="layui-col-sm12" style="padding-left:60px;height: 110px;font-size: 30px;">${singer}</div>

                        </div>
                    </div>
                </div>
                
                
                <div class="layui-col-sm12 layui-col-md6">
                    <div class="layui-card">
                        <div class="layui-card-header"><i class="iconfont" style="color: #32CD32">&#xe6bc;</i>歌曲数目:</div>
                        <div class="layui-card-body" style="min-height: 100px;">
                            <div id="" class="layui-col-sm12" style="padding-left:60px;height: 110px;font-size: 30px;">${music}</div>

                        </div>
                    </div>
                </div>
                <div class="layui-col-sm12 layui-col-md6">
                    <div class="layui-card">
                        <div class="layui-card-header"><i class="iconfont" style="color: #FA8072">&#xe83d;</i>专辑数目:</div>
                        <div class="layui-card-body" style="min-height: 100px;">
                            <div id="main2" class="layui-col-sm12" style="padding-left:60px;height: 110px;font-size: 30px;">${album}</div>

                        </div>
                    </div>
                </div>
                <div class="layui-col-sm12 layui-col-md6">
                    <div class="layui-card">
                        <div class="layui-card-header"><i class="iconfont" style="color: #FF4500">&#xe756;</i>歌单数目:</div>
                        <div class="layui-card-body" style="min-height: 100px;">
                            <div id="main3" class="layui-col-sm12" style="padding-left:60px;height: 110px;font-size: 30px;">${songSheet}</div>

                        </div>
                    </div>
                </div>
                <div class="layui-col-sm12 layui-col-md6">
                    <div class="layui-card">
                        <div class="layui-card-header"><i class="iconfont" style="color: #FFD700">&#xe736;</i>M V数目</div>
                        <div class="layui-card-body" style="min-height: 100px;">
                            <div id="main4" class="layui-col-sm12" style="padding-left:60px;height: 110px;font-size: 30px;">${mv}</div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>