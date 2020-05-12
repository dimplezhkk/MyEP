function showImg(obj) {
            var file=$(obj)[0].files[0];    //获取文件信息
            var imgdata='';
            if(file)
            {
                var reader=new FileReader();  //调用FileReader
                reader.readAsDataURL(file); //将文件读取为 DataURL(base64)
                reader.onload=function(evt){   //读取操作完成时触发。
                    $("#img").attr('src',evt.target.result)  //将img标签的src绑定为DataURL
                };
            }
            else{
                alert("上传失败");
            }
        }