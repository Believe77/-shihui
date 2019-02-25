<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<title>Insert title here</title>
</head>
<script>

 var username="${sessionScope.username}";
 var ws;//一个ws对象就是一个通信管道
 var target="ws://localhost:8080/chat/chatSocket?username="+username;
 
 window.onload=function(){
   //一进入页面就开始进入socket通道
  
    if ('WebSocket' in window) {
       ws = new WebSocket(target);
     } else if ('MozWebSocket' in window) {
         ws = new MozWebSocket(target);
     } else {
         alert('WebSocket is not supported by this browser.');
         return;
     }
   
 
   ws.onmessage=function(event){
	   
	   eval("var msg="+event.data+";");
	   if(undefined!=msg.welcome){
		   //console.info(msg.welcome);
		   $("#content").append(msg.welcome);
	   }
	   if(undefined!=msg.username){
		   $("#userList").html("");
		   $(msg.username).each(function(){
			   
			   $("#userList").append("<input type=checkbox value='"+this+"'>"+this+"<br/>");
		   })
		   
	   }
	   if(undefined!=msg.content){
		   $("#content").append(msg.content);
	   } 
   }
 }
 
 function subSend(){
	 
	/*  var val=$("#msg").val();
	 ws.send(val);
	 $("#msg").val(""); */
	 var obj=null;
	 var val=$("#msg").val();
	 var ss=document.querySelectorAll('input[type=checkbox]');
	 //console(ss.length());
	 var n=0;
	 for(var i=0;i<ss.length;i++)
	 {
		 if(ss[i].checked)
			 n++;
	 }
	 if(n==0){
		  obj={
		   msg:val,
		   type:1 //1代表群聊，2代表单聊
		 } 
	 }else{
		 var to=$("#userList :checked").val();
		 console.info(to);
		  obj={
		   to:to,
		   msg:val,
		   type:2 //1代表群聊，2代表单聊
		 } 
	 }
	 var str=JSON.stringify(obj);
	 ws.send(str);
	 $("#msg").val("");
 }

</script>


<body>
<div id="container" style="border:1px solid black;width:400px;height：400px;float:left">
  <div style="border:1px solid black;width:400px;height:70px"><font color="red">这是一个聊天室，可以实现群聊，也可以在在线列表中勾选某一个人实现私聊
 私聊时对方收到的信息将会变成红色的，其他人将看不到</font></div>
  <div id="content" style="height:350px"></div>
  <div  style="border-top:1px solid black;width:400px;height:50px">
     <input id="msg" style="width:300px;height:45px">
     <button style="width:60px;height:50px" onclick="subSend()">send</button>
  </div>
</div>
<div style="border:1px solid black;width:100px;height:470px;float:left">
<div style="border:1px solid black;height:70px">在线列表</div>
<div id="userList" ></div>
</div>
</body>
</html>