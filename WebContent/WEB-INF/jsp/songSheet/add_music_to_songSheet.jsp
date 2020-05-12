<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xadmin.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/xadmin.js"></script>
    	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" method="post" action="#">
                   <input type="hidden" value="${songSheetId}" name="songSheetId" id="songSheetId">
				      <label class="layui-form-label"><span class="x-red">*</span>歌曲名称</label>
					      <div class="layui-input-inline">
					        <select name="id" id="id">
					          <option value="">直接选择或搜索选择</option>
					          <c:forEach items="${list}" var="music">
					          <option value="${music.id}">${music.musicname}</option>
					          </c:forEach>
					        </select>
					      </div>
                    
                    <div class="layui-form-item" style="padding-top: 200px;">
                        <label for="L_repass" class="layui-form-label"></label>
                        <button class="layui-btn" lay-filter="save" lay-submit="">添加</button>
                        
                     </div>
                </form>
            </div>
        </div>
        <script>layui.use(['form', 'layer'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;

                //监听提交
                form.on('submit(save)',
                function(data) {
                    console.log(data);
                    var music = new FormData();
                    var id = $("#id").val();
                    var songSheetId = $("#songSheetId").val();
                    music.append("id",id);
                    music.append("songSheetId",songSheetId);
                  //发异步，把数据提交
                    $.ajax({
                    	type: 'post',
                        url: '${pageContext.request.contextPath}/songSheet/addMusicToSongSheet',
                        cache: false,
                        async: true,
                        data: music,
                        //必须false才会避开jQuery对 formdata 的默认处理
        	            //XMLHttpRequest会对 formdata 进行正确的处理
                        processData:false,
                      //必须false才会自动加上正确的Content-Type
                        contentType:false
                    });
                    
                    layer.alert("添加成功", {
                        icon: 6
                    },
                    function() {
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);
                    });
                    return false;
                });

            });</script>
    </body>
</html>