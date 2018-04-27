<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
	<script type="text/javascript" src="js/sockjs.js"></script>
	<script type="text/javascript">

	$(function(){
		


			console.log('try build connection');

			var sock=new SockJS("http://localhost:8080/rtc_web_java/test")

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
					var msg=$('#msg').val()
					sock.send(msg)
					//sock.close()
				}else{
					console.log('sock was closed')
				}
			})
			
	})
	
	

	
	
	</script>
</head>
<body>
	
	<div>
		<input id='msg'/>
		<input id='send' type='submit' value="SEND"/>
	</div>
	
</body>
</html>