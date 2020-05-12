<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>音乐播放器</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/music/css/music-player.css" rel="stylesheet"/>
    <style type="text/css">

    </style>
  </head>
  <body style="overflow:hidden">
    <!--导航栏-->
    <header class="title">
      <span id="currentSong" style="font-size: 22px;color: #40E0D0"></span>
    </header>
    <!--主要内容-->
    <div>
    <article class="mainbody">
      <section class="showlyrics" style="height: 440px;">
        <div id="lyricslist" style="height:400px;background-image:url(http://localhost:8080/${music.image});"></div>
        <input id="PageContext" type="hidden" value="http://localhost:8080/MyEP"/>
        <input id="musicname" type="hidden" value="${music.musicname}">
        <input id="lyricFile" type="hidden" value="${music.lyric}">
        <audio id="audio" src="http://localhost:8080/${music.url}" controls="controls">
        </audio>
      </section>
      <!--播放列表-->
      <aside class="songlist">
        <ul class="list">
        <c:forEach items="${list}" var="music">
          <a href="${pageContext.request.contextPath}/home/showMusic?musicId=${music.id}"><li>${music.musicname}</li></a>
         </c:forEach>
        </ul>
      </aside>
    </article>
  </div>


  <script type="text/javascript" src="${pageContext.request.contextPath}/music/js/music-player.js"></script>

  </body>
</html>
