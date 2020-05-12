<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MV添加</title>
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
        <![endif]-->
<style type="text/css">
.video {
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
.video input {
    position: absolute;
    font-size: 100px;
    right: 0;
    top: 0;
    opacity: 0;
}
.video:hover {
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
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" method="post" enctype="multipart/form-data" id="file" action="#">
                	<input type="hidden" name="id" id="id" value="${mv.id}">
                    <div class="layui-inline">
                        <label for="name" class="layui-form-label">
                            <span class="x-red">*</span>MV名称
                        </label>
                        <div class="layui-input-inline" style="width: 186px;">
                            <input type="text" id="name" name="name" value="${mv.name}" placeholder="请输入MV名称" required="" lay-verify="required" autocomplete="off" class="layui-input">
                        </div>
                        
                   </div>
                   
                   <div class="layui-inline">
                        <label for="singer" class="layui-form-label">
                            <span class="x-red">*</span>MV歌手
                        </label>
                        <div class="layui-input-inline" style="width: 186px;">
                            <input type="text" id="singer" value="${mv.singer}" name="singer" placeholder="请输入MV歌手" required="" lay-verify="required" autocomplete="off" class="layui-input">
                        </div>
                   </div>
                    
                   <div class="layui-inline">
				      <label class="layui-form-label" for="type"><span class="x-red">*</span>MV类型</label>
					      <div class="layui-input-inline" style="padding-top: 15px;">
					        <select name="type" lay-verify="required" lay-search="" id="type">
					          <option value="">直接选择或搜索选择</option>
					          <option value="演唱会">演唱会</option>
					          <option value="影视原声">影视原声</option>
					          <option value="KTV">KTV</option>
							  <option value="动漫">动漫</option>
							  <option value="游戏">游戏</option>
					          <option value="广告">广告</option>
					          <option value="古风">古风</option>
							  <option value="弹奏">弹奏</option>
							  <option value="舞曲">舞曲</option>
					        </select>
					      </div>
					    </div>
                  
                    <div class="layui-inline">
				      <label class="layui-form-label" for="area"><span class="x-red">*</span>MV地区</label>
					      <div class="layui-input-inline" style="padding-top: 15px;">
					        <select name="area" lay-verify="required" lay-search="" id="area">
					          <option value="">直接选择或搜索选择</option>
					          <option value="华语">华语</option>
					          <option value="日本">日本</option>
					          <option value="韩国">韩国</option>
							  <option value="欧美">欧美</option>
					        </select>
					      </div>
					    </div>
                    
                
                  <div class="layui-inline" style="padding-top: 15px;">
				      <label class="layui-form-label"><span class="x-red">*</span>热门</label>
					      <div class="layui-input-inline">
					        <select name="hot" lay-verify="required" lay-search="" id="hot">
					          <option value="NO">NO</option>
					          <option value="YES">YES</option>
					        </select>
					      </div>
					    </div>
					   
					    <div class="layui-inline" style="padding-top: 15px;">
				      <label class="layui-form-label" for="age"><span class="x-red">*</span>专辑年代</label>
					      <div class="layui-input-inline">
					        <select name="age" lay-verify="required" lay-search="" id="age">
					          <option value="">直接选择或搜索选择</option>
					          <option value="2020">2020</option>
					          <option value="2019">2019</option>
					          <option value="2018">2018</option>
							  <option value="2017">2017</option>
							  <option value="2016">2016</option>
					          <option value="2015">2015</option>
					          <option value="2014">2014</option>
							  <option value="2013">2013</option>
							  <option value="2012">2012</option>
					          <option value="2011">2011</option>
					          <option value="2010">2010</option>
					        </select>
					      </div>
					    </div>

					<div class="layui-form-item">
                        <label for="url" class="layui-form-label">
                            <span class="x-red">*</span>MV视频
                        </label>
                        <div class="layui-input-inline">
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <a href="javascript:;" class="video">选择文件<input type="file" name="video" id="video" lay-verify="required" autocomplete="off" class="layui-input"></a>
                            <span class="fileerrorTipVideo"></span>
                            <span class="showFileNameVideo"></span>
                       </div>
                   </div>
                   
                   <div class="layui-form-item">
                        <label for="url" class="layui-form-label">
                            <span class="x-red">*</span>MV图片
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
        		  
        		  
                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                        </label>
                        <button class="layui-btn" lay-filter="add" lay-submit="">修改MV</button>
                    	
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
                    var selectedFile=new FormData($('#file')[0]);
                    var id=$("#id").val();
                    var name=$("#name").val();
                    var singer=$("#singer").val();
                    var area=$("#area").val();
                    var hot=$("#hot").val();
                    var type=$("#type").val();
                    var age = $("#age").val();
                    
                    selectedFile.append("name",name);
                    selectedFile.append("singer",singer);
                    selectedFile.append("area",area);
                    selectedFile.append("hot",hot);
                    selectedFile.append("type",type);
                    selectedFile.append("age",age);
                    selectedFile.append("id",id);
                    //发异步，把数据提交
                    $.ajax({
                    	type: 'post',
                        url: '${pageContext.request.contextPath}/mv/editMusicVideo',
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
  $(".video").on("change","input[type='file']",function(){
	    var filePath=$(this).val();
	    if(filePath.indexOf("mp4")!=-1 || filePath.indexOf("avi")!=-1 || filePath.indexOf("flv")!=-1){
	        $(".fileerrorTipVideo").html("").hide();
	        var arr=filePath.split('\\');
	        var fileName=arr[arr.length-1];
	        $(".showFileNameVideo").html(fileName);
	    }else{
	    	filePath = $(this).val("");
	        $(".showFileNameVideo").html("");
	        $(".fileerrorTipVideo").html("您未上传视频，或者您上传视频类型有误！视频类型：mp4，avi，flv").show();
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