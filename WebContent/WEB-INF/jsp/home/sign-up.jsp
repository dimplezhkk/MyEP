<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
</head>
<body class="bg-info dker">
  <section id="content" class="m-t-lg wrapper-md animated fadeInDown">
    <div class="container aside-xl">
      <a class="navbar-brand block" href="${pageContext.request.contextPath}/welcome"><span class="h1 font-bold">鄭氏音乐</span></a>
      <section class="m-b-lg">
        <header class="wrapper text-center">
          <strong>注册发现有趣，原来你我如此有缘</strong>
        </header>
        <form action="${pageContext.request.contextPath}/home/register" method="post">
          <div class="form-group"><span id="usernameInfo"></span>
            <input placeholder="请输入账号" autocomplete="off" name="username" id="username" pattern="^[a-zA-Z0-9]{3,16}$"
             required class="form-control rounded input-lg text-center no-border"/>
          </div>
          <div class="form-group"><span id="emailInfo"></span>
            <input type="email" placeholder="请输入邮箱" autocomplete="off" name="email" id="email" required class="form-control rounded input-lg text-center no-border">
          </div>
          <div class="form-group">
             <input type="password" autocomplete="off" placeholder="请输入6~20位密码" pattern="^[a-zA-Z0-9]\w{5,19}$" name="password" required class="form-control rounded input-lg text-center no-border">
          </div>
          <div class="checkbox i-checks m-b">
            <label class="m-l">
              <input type="checkbox" required checked=""><i></i> 同意 <a href="${pageContext.request.contextPath}/publicy">条款和政策</a>
            </label>
          </div>
          <button type="submit" class="btn btn-lg btn-warning lt b-white b-2x btn-block btn-rounded"><i class="icon-arrow-right pull-right"></i><span class="m-r-n-lg">注册</span></button>
          <div class="line line-dashed"></div>
          <p class="text-muted text-center"><small>已经有帐户了？</small></p>
          <a href="${pageContext.request.contextPath}/home/sign-in" class="btn btn-lg btn-info btn-block btn-rounded">登录</a>
        </form>
      </section>
    </div>
  </section>
  <!-- footer -->
  <footer id="footer">
    <div class="text-center padder clearfix">
      <p>
        <small>鄭氏音乐<br>&copy; 2020</small>
      </p>
    </div>
  </footer>
  <!-- / footer -->
  <script src="${pageContext.request.contextPath}/home/js/jquery.min.js"></script>
  <!-- Bootstrap -->
  <script src="${pageContext.request.contextPath}/home/js/bootstrap.js"></script>
  <!-- App -->
  <script src="${pageContext.request.contextPath}/home/js/app.js"></script>
  <script src="${pageContext.request.contextPath}/home/js/slimscroll/jquery.slimscroll.min.js"></script>
  <script src="${pageContext.request.contextPath}/home/js/app.plugin.js"></script>
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