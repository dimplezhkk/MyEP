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
  <section id="content" class="m-t-lg wrapper-md animated fadeInUp">    
    <div class="container aside-xl">
      <a class="navbar-brand block" href="${pageContext.request.contextPath}/welcome"><span class="h1 font-bold">鄭氏音乐</span></a>
      <section class="m-b-lg"><span style="color: green">${msg}</span><span style="color: red">${error_mess}</span>
        <header class="wrapper text-center">
          <strong>登录发现有趣，原来你我如此有缘</strong>
        </header>
        <form action="${pageContext.request.contextPath}/home/login" method="post">
          <div class="form-group">
            <input placeholder="请输入账号" name="username" autocomplete="off" pattern="^[a-zA-Z0-9]{3,16}$" required class="form-control rounded input-lg text-center no-border">
          </div>
          <div class="form-group">
             <input type="password" placeholder="请输入密码" name="password" required autocomplete="off" pattern="^[a-zA-Z0-9]\w{5,19}$" class="form-control rounded input-lg text-center no-border">
          </div>
          <div class="checkbox i-checks m-b">
            <label class="m-l">
              <input type="checkbox" required checked=""><i></i> 同意 <a href="${pageContext.request.contextPath}/publicy">条款和政策</a>
            </label>
          </div>
          <button type="submit" class="btn btn-lg btn-warning lt b-white b-2x btn-block btn-rounded"><i class="icon-arrow-right pull-right"></i><span class="m-r-n-lg">登录</span></button>
          <!-- <div class="text-center m-t m-b"><a href="#"><small>忘记  密码?</small></a></div> -->
          <div class="line line-dashed"></div>
          <p class="text-muted text-center"><small>没有帐户?</small></p>
          <a href="${pageContext.request.contextPath}/home/sign-up" class="btn btn-lg btn-info btn-block rounded">创建 账号</a>
        </form>
      </section>
    </div>
  </section>
  <!-- footer -->
  <footer id="footer">
    <div class="text-center padder">
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
</body>
</html>