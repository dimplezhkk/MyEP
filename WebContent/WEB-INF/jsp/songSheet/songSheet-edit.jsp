<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专辑添加</title>
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
img{
    width: 100px;
    height: 100px;
	}     
        
</style>
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" method="post" enctype="multipart/form-data" id="file" action="#">
                	<input name="id" id="id" type="hidden" value="${songSheet.id}">
                    <div class="layui-form-item">
                        <label for="creator" class="layui-form-label">
                            <span class="x-red">*</span>创建人
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="creator" value="${songSheet.creator}" name="creator" placeholder="请输入创建人" required="" lay-verify="required" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span>必填项
                       </div>
                   </div>
                   
                   <div class="layui-form-item">
                        <label for="label" class="layui-form-label">
                            <span class="x-red">*</span>歌单标签
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" id="label" value="${songSheet.label}" name="label" placeholder="请输入歌单标签" required="" lay-verify="required" autocomplete="off" class="layui-input">
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
                            <span class="x-red">*</span>歌单图片
                        </label>
                        <div class="layui-input-inline">
                        </div>
                            <a href="javascript:;" class="file">选择文件<input type="file" name="url" id="url" onchange="showImg(this)" lay-verify="required" autocomplete="off" class="layui-input"></a>
                            <img src="" alt="" id="img">
                            <span class="fileerrorTip"></span>
                            <span class="showFileName"></span>
                   </div>
        		  
        		  <div class="layui-form-item layui-form-text">
			            <label for="description" class="layui-form-label">歌单描述
			            </label>
			            <div class="layui-input-block">
			                <textarea placeholder="请输入歌单描述吧" id="description" name="description" class="layui-textarea">
			                ${songSheet.description}</textarea>
			            </div>
        		  </div>
        		  
                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                        </label>
                        <button class="layui-btn" lay-filter="add" lay-submit="">修改歌单</button>
                    	
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
                    var creator=$("#creator").val();
                    var label=$("#label").val();
                    var hot=$("#hot").val();
                    var description=$("#description").val();

                    selectedFile.append("id",id);
                    selectedFile.append("creator",creator);
                    selectedFile.append("label",label);
                    selectedFile.append("hot",hot);
                    selectedFile.append("description",description);
                    
                    //发异步，把数据提交
                    $.ajax({
                    	type: 'post',
                        url: '${pageContext.request.contextPath}/songSheet/editSongSheet',
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
  $(".file").on("change","input[type='file']",function(){
	    var filePath=$(this).val();
	    if(filePath.indexOf("jpg")!=-1 || filePath.indexOf("png")!=-1 || filePath.indexOf("jpeg")!=-1){
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