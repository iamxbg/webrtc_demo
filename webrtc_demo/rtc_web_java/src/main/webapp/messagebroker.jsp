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

			console.log('try build STOMP connection');

			var sock=new SockJS("testStomp")

			
			var stomp=Stomp.over(sock);

			stomp.heartbeat.outgoing=3000
			stomp.heartbeat.incoming=1000

			

			var headers={login:null,passcode:null}
			
			stomp.connect(headers,function(){
					console.log('connect successful')

				var	subscription=stomp.subscribe('/subscribe', function(msg) {

						console.log('From server:'+msg)
					
					}, {})

				console.log('subscribID:'+subscription.id)
					
				},function(){
					console.log('connect error')
				})
				
				
			
				
			$('#send').on('click',function(){

				var msg=$('#msg').val()
				stomp.send('/topic/send',{},JSON.stringify('{message :" Kessage for stomp! '+msg+' :>"}'))
						
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