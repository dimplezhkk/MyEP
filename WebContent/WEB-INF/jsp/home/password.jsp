<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>音乐添加</title>
<meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form layui-form-pane" method="post" action="${pageContext.request.contextPath}/home/editPassword">
                <input type="hidden" name="id" id="id" value="${consumer.id}">
                    <div class="layui-form-item">
                        <label for="password" class="layui-form-label">
                            	新密码
                        </label>
                        <div class="layui-input-inline">
                            <input type="password" id="password" autocomplete="off" name="password"
                     placeholder="请输入6~20位密码" pattern="^[a-zA-Z0-9]\w{5,19}$" required oninput="this.setCustomValidity('')"
               oninvalid="this.setCustomValidity('请输入6~20位密码！')" onchange="checkpassword()" 
                class="layui-input">
                        </div>
                   </div>
                   
                   <div class="layui-form-item">
                        <label for="repassword" class="layui-form-label">
                            	确认密码
                        </label>
                        <div class="layui-input-inline">
                            <input type="password" id="repassword" autocomplete="off" name="repassword"
                     placeholder="请输入确认密码" pattern="^[a-zA-Z0-9]\w{5,19}$"
                     required onchange="checkpassword()" class="layui-input">
                        </div>
                   </div>
                   
                    <div class="layui-form-item">
                        <button class="layui-btn" type="submit">修改</button>
                    </div>
                </form>
            </div>
        </div>
  <script src="${pageContext.request.contextPath}/js/login.js"></script>
    <script type="text/javascript">
		    function checkpassword(){
		        var pass1 = document.getElementById("password");
		        var pass2 = document.getElementById("repassword");
		        if(pass1.value != pass2.value){
		            pass2.setCustomValidity("两次密码输入不一致");
		        }else{
		            pass2.setCustomValidity("");
		        }
		    }
    </script>
  </body>
  </html>