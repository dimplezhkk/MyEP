<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录注册</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	
	<style type="text/css">
		
		 input:required,select:required{
			
		}
		input:required:valid,select:required:valid{
			
			box-shadow: 0 0 5px green;
			border-color: green;
		}
		input:focus:required:invalid,select:focus:required:invalid{
			
			box-shadow: 0 0 5px red;
			border-color: red;
			outline: red solid 1px;
		} 
	</style>
</head>
<body>
    <div class="content">
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        <div class="form sign-in">
        	<h3>${msg}</h3>
        	 <!-- 错误信息提示 -->
			  <h3 style="color:red">${error_mess}</h3>
            <h2>欢迎登录-系统后台</h2>
            <label for="signin-email">
                <span>管理员账号</span>
                <input type="text" class="form-control" id="signin-email" 
		placeholder="请输入管理员账号" name="username" 
		required oninput="this.setCustomValidity('')" 
			oninvalid="this.setCustomValidity('请输入管理员账号！')"/>
            </label>
            <label for="signin-password">
                <span>密码</span>
                <input type="password" class="form-control" id="signin-password" 
		autocomplete="off" name="password"  placeholder="请输入密码" pattern="^[a-zA-Z0-9]\w{5,19}$"
		required oninput="this.setCustomValidity('')"
               oninvalid="this.setCustomValidity('请输入密码！')"/>
            </label>
            <%-- <p class="forgot-pass"><a href="${pageContext.request.contextPath}/forgetPassword">忘记密码？</a></p> --%>
            <button type="submit" class="submit">登 录</button>
        </div>
        </form>
        <div class="sub-cont">
            <div class="img">
                <div class="img__text m--up">
                    <h2>换个姿势？</h2>
                    <p>立即登录，发现原来你我如此有缘^_^</p>
                </div>
                <div class="img__text m--in">
                    <h2>换个姿势？</h2>
                    <p>立即登录，发现原来你我如此有缘^_^</p>
                </div>
                <div class="img__btn">
                   <span class="m--up">登 录</span>
                    <span class="m--in">登 录</span>
                </div>
            </div>
            <form action="${pageContext.request.contextPath}/user/login" method="post">
            <div class="form sign-up">
                <h2>欢迎登录-系统后台</h2>
                <h3>${msg}</h3>
        	 <!-- 错误信息提示 -->
			  <h3 style="color:red">${error_mess}</h3>
            <label for="signin-email">
                <span>管理员账号</span>
                <input type="text" class="form-control" id="signin-email" 
		placeholder="请输入管理员账号" name="username" 
		required oninput="this.setCustomValidity('')" 
			oninvalid="this.setCustomValidity('请输入管理员账号！')"/>
            </label>
            <label for="signin-password">
                <span>密码</span>
                <input type="password" class="form-control" id="signin-password" 
		autocomplete="off" name="password"  placeholder="请输入密码" pattern="^[a-zA-Z0-9]\w{5,19}$"
		required oninput="this.setCustomValidity('')"
               oninvalid="this.setCustomValidity('请输入密码！')"/>
            </label>
            <%-- <p class="forgot-pass"><a href="${pageContext.request.contextPath}/forgetPassword">忘记密码？</a></p> --%>
            <button type="submit" class="submit">登 录</button>
            </div>
            </form>
        </div>
    </div>
	<script src="${pageContext.request.contextPath}/js/login.js"></script>
</body>
</html>