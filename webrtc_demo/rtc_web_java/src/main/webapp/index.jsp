<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
	<script type="text/javascript">

			var app=angular.module('app',[]);


			$(function(){
				console.log('load jquery successfully!')

				var video=$('#video')

				video.css('border','1px solid red')

				console.log('ok')


				window.navigator.mediaDevices.getUserMedia({video:true,audio:false})
					.then(function(stream){
						console.log('nothing...')
					}).catch(function(err){
						console.log('errorName:'+err.name)
						console.error(err)
					})
					
			});	
			
			
	</script>
</head>
<body ng-app="app">
		
		<video  id="video"  width="500px" heigt="500px" style="border:1px solid blue;"></video>
</body>
</html>