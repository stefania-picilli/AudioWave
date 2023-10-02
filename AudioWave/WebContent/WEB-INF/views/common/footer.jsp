<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/footer.css" type="text/css" >
		<meta charset="ISO-8859-1">
		<title>Footer</title>
	</head>
	
	
	<body>
	
		<footer>
	
			<div class="footer-item">
				<p class="p2"><a href='${pageContext.request.contextPath}/Home'>Home</a></p>
			</div>
		
			<div id="center"  class="footer-item">
				<p class="p2">Contatti:</p>
				<div id="contatti">
					<p class="p3">prova@email.com</p>
					<p class="p3">+39 012 3456789</p>
					<p class="p3"><i class="fa-brands fa-instagram"></i><i class="fa-brands fa-facebook"></i><i class="fa-brands fa-x-twitter"></i><i class="fa-brands fa-tiktok"></i></p>
				</div>
			</div>
		
			<div class="footer-item">
				<p class="p2"><a href='${pageContext.request.contextPath}/Home'>About us</a></p>
			</div>
		
		</footer>
	
	</body>
</html>