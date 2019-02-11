<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>  
<title>Insert title here</title>

<script>
    /*  $(function() {
        $('#submit').click(function{
            $.ajax({
                url : "http://47.112.20.73/web-novel/user/upload.action",
                type : 'POST',
                data : new FormData($("#form")[0]),
                dataType: 'JSON',  
                    cache: false,  
                            processData: false,  
                        contentType: false,
                success : function(result) {
                },
                error : function(err) {
                }
            });
        })  
    })  */
</script>

</head>
<body>
   
 <form id="form"  method="post" action="http://47.112.20.73/web-novel/user/upload.action"
         enctype="multipart/form-data" >
    <input type="file" name="file"> 
    <input type="text" name="name">
     <input type="text" name="author">
      <input type="text" name=type>
       <input type="text" name="style">
        <input type="text" name="message">
    <input type="submit" value="提交">
   
</form>


</body>
</html>