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
                <form class="layui-form" method="post" enctype="multipart/form-data" id="file" action="#">
                	
                	<input type="hidden" name="id" id="id" value="${user.id}"/>
                	
                    <div class="layui-form-item">
                        <label for="username" class="layui-form-label">
                            <span class="x-red">*</span>管理员账号
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="username" value="${user.username}" name="username" placeholder="请输入管理员账号" lay-reqtext="用户账号是必填项，岂能为空？" required="" lay-verify="required" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span>必填项<span id="usernameInfo"></span>
                       </div>
                   </div>
                   
                    <input type="hidden" id="password" name="password" value="${user.password}" >
                   
                    <div class="layui-form-item">
                        <label for="realname" class="layui-form-label">
                            <span class="x-red">*</span>真实姓名
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="realname" name="realname" value="${user.realname}" placeholder="请输入管理员真实姓名" required="" lay-verify="required" autocomplete="off" class="layui-input">
                        </div><span id="emailInfo"></span>
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
				
                //监听提交
                form.on('submit(add)',
                function(data) {
                    console.log(data);
                    var selectedFile=new FormData();
                    var id=$("#id").val();
                    var username=$("#username").val();
                    var password=$("#password").val();
                    var realname=$("#realname").val();
                    selectedFile.append("id",id);
                    selectedFile.append("username",username);
                    selectedFile.append("password",password);
                    selectedFile.append("realname",realname);
                    //发异步，把数据提交
                    $.ajax({
                    	type: 'post',
                        url: '${pageContext.request.contextPath}/admin/editUser',
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
    $(function(){
    $("#username").blur(function(){
      var usernameInput = $(this).val();
      $.get(
              "${pageContext.request.contextPath}/home/checkUsername",
              {"username":usernameInput},
              function(data){
                var isExist = data.isExist;
                var usernameInfo = "";
                if(usernameInput== ""){
                	usernameInfo = "";
                }else{
                 if(isExist){
                  usernameInfo = "该账号已经存在";
                  $("#usernameInfo").css("color","red");
                }else{
                  usernameInfo = "该账号可以使用"
                  $("#usernameInfo").css("color","green");
                }
              }
                $("#usernameInfo").html(usernameInfo);
              },
              "json"
      );
    });
});
    $(function(){
        $("#email").blur(function(){
           var emailInput = $(this).val();
           $.get(
                   "${pageContext.request.contextPath}/home/checkEmail",
                   {"email":emailInput},
                   function(data){
                     var emailExist = data.emailExist;
                     var emailInfo = "";
                     if(emailInput== ""){
                     	emailInfo = "";
                     }else{
                      if(emailExist){
                       emailInfo = "该邮箱已经使用";
                       $("#emailInfo").css("color","red");
                     }else{
                       emailInfo = "该邮箱可以使用"
                       $("#emailInfo").css("color","green");
                     }
                   }
                     $("#emailInfo").html(emailInfo);

                   },
                   "json"
           );
         });
    });
</script>
  </body>
  </html>