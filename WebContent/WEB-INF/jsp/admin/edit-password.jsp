<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户添加</title>
<meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/imagePreview.js"></script>
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" method="post" action="#">
                	
                	<input type="hidden" name="id" id="id" value="${user.id}"/>
                	
                    <div class="layui-form-item">
                        <label for="password" class="layui-form-label">
                            <span class="x-red">*</span>管理员密码
                        </label>
                        <div class="layui-input-inline">
                            <input type="password" id="password" name="password" placeholder="请输入6~20位密码" lay-verify="pass"
                            class="layui-input">
                        </div>
                        <div class="layui-form-mid layui-word-aux">请填写6到20位密码</div>
                   </div>
                   
                    <div class="layui-form-item">
                        <label for="repassword" class="layui-form-label">
                            <span class="x-red">*</span>确认密码
                        </label>
                        <div class="layui-input-inline">
                            <input type="password" id="repassword" name="repassword" placeholder="请输入确认密码"
                            lay-verify="pass|confirmPass"
                            id="repassword" autocomplete="off" name="repassword"
                      autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-form-mid layui-word-aux">请填写6到20位密码</div>
                   </div>
                   
                  <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                        </label>
                        <button class="layui-btn" lay-filter="add" lay-submit="">修改</button>
                  </div>
                </form>
            </div>
        </div>
        <script>
        layui.use(['form', 'layer','jquery'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;
             // 校验两次密码是否一致
             //自定义验证规则
                form.verify({
                 pass: [
                    /^[\S]{6,20}$/
                    ,'密码必须6到20位，且不能出现空格'
                  ],
                confirmPass:function(value){
                    if($('input[name=password]').val() !== value)
                        return '两次密码输入不一致！';
                }
                });
                //监听提交
                form.on('submit(add)',
                function(data) {
                    console.log(data);
                    var selectedFile=new FormData();
                    var id=$("#id").val();
                    var password=$("#password").val();
                    selectedFile.append("id",id);
                    selectedFile.append("password",password);
                    //发异步，把数据提交
                    $.ajax({
                    	type: 'post',
                        url: '${pageContext.request.contextPath}/admin/editPassword',
                        cache: false,
                        async: true,
                        data: selectedFile,
                        //必须false才会避开jQuery对 formdata 的默认处理
        	            //XMLHttpRequest会对 formdata 进行正确的处理
                        processData:false,
                      //必须false才会自动加上正确的Content-Type
                        contentType:false
                    });
                   
                    layer.alert("修改成功", {
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