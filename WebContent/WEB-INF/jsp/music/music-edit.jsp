<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>欢迎</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/imagePreview.js"></script>
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]--></head>
<style type="text/css">
.music {
    position: relative;
    display: inline-block;
    background: #D0EEFF;
    border: 1px solid #99D3F5;
    border-radius: 4px;
    padding: 4px 12px;
    overflow: hidden;
    color: #1E88C7;
    text-decoration: none;
    text-indent: 0;
    line-height: 20px;
}
.music input {
    position: absolute;
    font-size: 100px;
    right: 0;
    top: 0;
    opacity: 0;
}
.music:hover {
    background: #AADFFD;
    border-color: #78C3F3;
    color: #004974;
    text-decoration: none;
}
img{
    width: 100px;
    height: 100px;
	}   
.image {
    position: relative;
    display: inline-block;
    background: #D0EEFF;
    border: 1px solid #99D3F5;
    border-radius: 4px;
    padding: 4px 12px;
    overflow: hidden;
    color: #1E88C7;
    text-decoration: none;
    text-indent: 0;
    line-height: 20px;
}
.image input {
    position: absolute;
    font-size: 100px;
    right: 0;
    top: 0;
    opacity: 0;
}
.image:hover {
    background: #AADFFD;
    border-color: #78C3F3;
    color: #004974;
    text-decoration: none;
    }      
</style>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" method="post" enctype="multipart/form-data" id="file" action="#">
                	<input id="id" name="id" type="hidden" value="${music.id}">
                    <div class="layui-inline">
                        <label for="musicname" class="layui-form-label">
                            <span class="x-red">*</span>歌曲名
                        </label>
                        <div class="layui-input-inline" style="width: 212px;">
                            <input type="text" id="musicname" value="${music.musicname}" placeholder="请输入歌手姓名吧" name="musicname" required="" lay-verify="required" autocomplete="off" class="layui-input">
                        </div>
                        
                   </div>
                    <div class="layui-inline">
                        <label for="singer" class="layui-form-label">
                            <span class="x-red">*</span>歌手
                        </label>
                        <div class="layui-input-inline" style="width: 186px;">
                            <input type="text" value="${music.singer}" id="singer" placeholder="请输入歌手姓名吧" name="singer" required="" lay-verify="required" autocomplete="off" class="layui-input">
                       </div>
                    </div>
                    
                    <div class="layui-inline">
				      <label class="layui-form-label"><span class="x-red">*</span>专辑</label>
					      <div class="layui-input-inline" style="padding-top: 15px;">
					        <select name="album" id="album">
					          <option value="">直接选择或搜索选择</option>
					          <c:forEach items="${list}" var="album">
					          <option value="${album.id}">${album.name}</option>
					          </c:forEach>
					        </select>
					      </div>
					    </div>
                    
                    <div class="layui-inline" style="padding-top: 16px;">
                        <label for="description" class="layui-form-label">
                            <span class="x-red"></span>描述
                        </label>
                        <div class="layui-input-inline" style="width: 186px;">
                            <input type="text" value="${music.description}" id="description" name="description" placeholder="请输入描述，建议20词之内" required="" lay-verify="required" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    
                   <div class="layui-inline">
                        <label for="url" class="layui-form-label">
                            <span class="x-red">*</span>音频
                        </label>
                        <div class="layui-input-inline">
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <a href="javascript:;" class="music">选择音频<input type="file" name="url" id="url" lay-verify="required" autocomplete="off" class="layui-input"></a>
                            <span class="fileerrorTip"></span>
                            <span class="showFileName"></span>
                       </div>
                   </div>
                      
                      <div class="layui-form-item">
                        <label for="url" class="layui-form-label">
                            <span class="x-red">*</span>音乐图片
                        </label>
                        <div class="layui-input-inline">
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <a href="javascript:;" class="image">选择文件<input type="file" name="image" id="image" onchange="showImg(this)" lay-verify="required" autocomplete="off" class="layui-input"></a>
                            <img src="" alt="" id="img">
                            <span class="fileerrorTipImage"></span>
                            <span class="showFileNameImage"></span>
                       </div>
                   </div>

			         <input placeholder="请输入歌词吧" id="lyric" value="${music.lyric}" type="hidden" name="lyric" class="layui-textarea"/>
			         		       
                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                        </label>
                        <button class="layui-btn" lay-filter="add" lay-submit="" >点击修改</button>
                    	
                        </div>
                </form>
            </div>
        </div>
        <script>layui.use(['form', 'layer','jquery'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;

                //监听提交
                form.on('submit(add)',
                function(data) {
                    console.log(data);
                    //文件上传
                    var selectedFile=new FormData($('#file')[0]);
                    var musicname=$("#musicname").val();
                    var singer=$("#singer").val();
                    var album=$("#album").val();
                    var description=$("#description").val();
                    var lyric=$("#lyric").val();
                    var id = $("#id").val();
                    selectedFile.append("musicname",musicname);
                    selectedFile.append("singer",singer);
                    selectedFile.append("album",album);
                    selectedFile.append("description",description);
                    selectedFile.append("lyric",lyric);
                    selectedFile.append("id",id);
                    //发异步，把数据提交
                    $.ajax({
                    	type: 'post',
                        url: '${pageContext.request.contextPath}/music/editMusic',
                        cache: false,
                        async: true,
                        data: selectedFile,
                        processData:false,
                        contentType:false
                    });
                    layer.alert("修改成功", {
                        icon: 6
                    },
                    function() {
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);
                     // 可以对父窗口进行刷新 
                        xadmin.father_reload();
                    });
                    return false;
                });

            });</script>
        <script>var _hmt = _hmt || []; (function() {
                var hm = document.createElement("script");
                hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(hm, s);
            })();
</script>

<script type="text/javascript">
  $(".music").on("change","input[type='file']",function(){
	    var filePath=$(this).val();
	    if(filePath.indexOf("mp3")!=-1 || filePath.indexOf("wma")!=-1){
	        $(".fileerrorTip").html("").hide();
	        var arr=filePath.split('\\');
	        var fileName=arr[arr.length-1];
	        $(".showFileName").html(fileName);
	    }else{
	    	filePath = $(this).val("");
	        $(".showFileName").html("");
	        $(".fileerrorTip").html("您未上传文件，或者您上传文件类型有误！").show();
	        return null;
	    }
	})
  </script>
  
  <script type="text/javascript">
  $(".image").on("change","input[type='file']",function(){
	    var filePath=$(this).val();
	    if(filePath.indexOf("jpg")!=-1 || filePath.indexOf("png")!=-1 || filePath.indexOf("jpeg")!=-1){
	        $(".fileerrorTipImage").html("").hide();
	        var arr=filePath.split('\\');
	        var fileName=arr[arr.length-1];
	        $(".showFileNameImage").html(fileName);
	    }else{
	    	filePath = $(this).val("");
	        $(".showFileNameImage").html("");
	        $(".fileerrorTipImage").html("您未上传图片，或者您上传图片类型有误！").show();
	        return null;
	    }
	})
</script>
    </body>
</html>