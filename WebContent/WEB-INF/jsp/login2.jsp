<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统后台管理员登录</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
	  <%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css"> --%>
	  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
</head>
<body class="login-bg">
    
    <div class="login layui-anim layui-anim-up">
        <div class="message">欢迎登录-鄭氏音乐系统后台</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" class="layui-form" >
        <i class="iconfont">&#xe70b;</i>
            <input name="username" placeholder="请输入管理员账号" style="width: 310px;" type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <i class="iconfont">&#xe82b;</i>
            <input name="password" lay-verify="required" placeholder="请输入管理员密码" style="width: 310px;"  type="password" class="layui-input">
            <hr class="hr15">
            <input value="登录" lay-submit lay-filter="login" style="width: 310px;" type="submit">
            <hr class="hr20" >
        </form>
    </div>

    <script>
        $(function  () {
            layui.use('form', function(){
              var form = layui.form;
              // layer.msg('玩命卖萌中', function(){
              //   //关闭后的操作
              //   });
              //监听提交
              form.on('submit(login)', function(data){
            	  
                // alert(888)
                layer.msg(JSON.stringify(data.field),function(){
                    location.href='index.html'
                });
                return false;
              });
            });
        })
    </script>
    <!-- 底部结束 -->
</body>
</html>