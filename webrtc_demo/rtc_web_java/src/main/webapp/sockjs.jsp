<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
	<script type="text/javascript" src="js/sockjs.js"></script>
	<script type="text/javascript" src="js/stomp.js"></script>
	<script type="text/javascript">

	$(function(){

			console.log('try build SockJS connection');

			var sock=new SockJS("test")

			
			sock.onopen=function(){
					console.log('sock open')
				}

			sock.onclose=function(){
					console.log('sock close')
				}

			sock.onmessage=function(e){
					console.log('message:'+e.data)
					sock.close()
				}
			
			


			$('#send').on('click',function(){
				
				if(sock){
					console.log('true')
					//var msg=$('#msg').val()
					var msg="Play video"
					sock.send(msg)

				}else{
					console.log('sock was closed')
				}
			})


			$('#close').on('click',function(){
				sock.close();	
				console.log('scok close')
			})
		
	})

	
	</script>
</head>
<body>
	
	<div>
		<input id='msg'/>
		<input id='send' type='submit' value="SEND"/>
		<input id='close' type='button' value="close"/>
	</div>
	
</body>
</html>