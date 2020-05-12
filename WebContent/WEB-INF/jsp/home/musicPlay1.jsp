<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
      <h1>鄭氏音乐播放界面<span id="currentSong" style="font-size: 22px;color: #40E0D0"></span></h1>
      
    </header>
    <!--主要内容-->
    <div>
    <article class="mainbody">
      <section class="showlyrics" style="height: 540px;">
        <div id="lyricslist" style="height:400px;background-image:url(http://localhost:8080/${music.image});"></div>
        <input id="PageContext" type="hidden" value="http://localhost:8080/MyEP"/>
        <input id="musicname" type="hidden" value="${music.musicname}">
        <input id="lyricFile" type="hidden" value="${music.lyric}">
        <audio id="audio" src="http://localhost:8080/${music.url}" controls="controls" >
        </audio>
      </section>
      <!--播放列表-->
      <aside class="songlist">
        <ul class="list" id="songlist">
          <li id="xuezhiqian-actor">薛之谦--演员</li>
          <li id="xuezhiqian-yi-ban">薛之谦--一半</li>
          <li id="xuezhiqian-ni-hai-yao-wo-zen-yang">薛之谦--你还要我怎样</li>
          <li id="xuezhiqain-wo-zhi-dao-ni-dou-zhi-dao">薛之谦--我知道你都知道</li>
          <li id="lvyanxi-fei-niao-he-yu">吕妍熙--飞鸟和鱼</li>
          <li id="zhanglei-yi-xiang-ren">张磊--异乡人</li>
          <li id="lijian-chun-feng-shi-li-bu-ru-ni">李健--春风十里不如你</li>
          <li id="zhuqiang-che-zhan">朱强--车站</li>
          <li id="taopaojihua-yi-wan-ci-bei-shang">逃跑计划--一万次悲伤</li>
        </ul>
      </aside>
    </article>
  </div>


  <script type="text/javascript" src="${pageContext.request.contextPath}/music/js/music-player.js"></script>

  </body>
</html>
