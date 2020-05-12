<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]--></head>
<style type="text/css">
.file {
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
.file input {
    position: absolute;
    font-size: 100px;
    right: 0;
    top: 0;
    opacity: 0;
}
.file:hover {
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
                    <input id="id" name="id" type="hidden" value="${singer.id}">
                     <div class="layui-form-item">
                        <label for="singer" class="layui-form-label">
                            <span class="x-red">*</span>歌手名
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="singer" value="${singer.singer}" name="singer" placeholder="请输入歌手姓名" required="" lay-verify="required" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span>必填项
                       </div>
                   </div>
                   
                    <div class="layui-form-item">
				    <label class="layui-form-label">
				    <span class="x-red">*</span>性别</label>
				    <div class="layui-input-block">
				      <input type="radio" name="sex" value="男" title="男" checked="${singer.sex }">
				      <input type="radio" name="sex" value="女" title="女">
				    </div>
				  </div>
                    
                    <div class="layui-inline">
				      <label class="layui-form-label"><span class="x-red">*</span>歌手类型</label>
					      <div class="layui-input-inline">
					        <select name="singertype" lay-verify="required" lay-search="" id="singertype">
					          <option value="">直接选择或搜索选择</option>
					          <option value="华语歌手">华语歌手</option>
					          <option value="华语组合">华语组合</option>
					          <option value="日韩歌手">日韩歌手</option>
					          <option value="日韩组合">日韩组合</option>
					          <option value="欧美歌手">欧美歌手</option>
					          <option value="欧美组合">欧美组合</option>
					        </select>
					      </div>
					    </div>
                    
                   <div class="layui-inline">
				      <label class="layui-form-label"><span class="x-red">*</span>热门</label>
					      <div class="layui-input-inline">
					        <select name="hot" lay-verify="required" lay-search="" id="hot">
					          <option value="NO">NO</option>
					          <option value="YES">YES</option>
					        </select>
					      </div>
					    </div>
				  
                   <div class="layui-form-item">
                        <label for="url" class="layui-form-label">
                            <span class="x-red">*</span>歌手图片
                        </label>
                        <div class="layui-input-inline">
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <a href="javascript:;" class="file">选择图片<input type="file" name="url" id="url" lay-verify="required" autocomplete="off" class="layui-input"></a>
                            <span class="fileerrorTip"></span>
                            <span class="showFileName"></span>
                       </div>
                   </div>
                                 
                    <div class="layui-form-item layui-form-text">
			            <label for="description" class="layui-form-label">歌手介绍
			            </label>
			            <div class="layui-input-block">
			                <textarea placeholder="请输入歌手介绍" id="description" name="description" class="layui-textarea">
			                ${singer.description}
			                </textarea>
			            </div>
        		  </div>
                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                        </label>
                        <button class="layui-btn" lay-filter="add" lay-submit="">点击修改</button>
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
                    //图片上传
                    var selectedFile=new FormData($('#file')[0]);
                    var singer=$("#singer").val();
                    var sex = $('input[name="sex"]:checked').val();
                    var singertype=$("#singertype").val();
                    var hot=$("#hot").val();
                    var description=$("#description").val();
                    var id=$("#id").val();
                    selectedFile.append("singer",singer);
                    selectedFile.append("sex",sex);
                    selectedFile.append("singertype",singertype);
                    selectedFile.append("hot",hot);
                    selectedFile.append("description",description);
                    selectedFile.append("id",id);
                    //发异步，把数据提交
                    $.ajax({
                    	type: 'post',
                        url: '${pageContext.request.contextPath}/music/editSinger',
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
  $(".file").on("change","input[type='file']",function(){
	    var filePath=$(this).val();
	    if(filePath.indexOf("jpg")!=-1 || filePath.indexOf("jpeg")!=-1 || filePath.indexOf("png")!=-1){
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
    </body>

</html>