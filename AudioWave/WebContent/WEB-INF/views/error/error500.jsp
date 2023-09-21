<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/esito-errore.css" type="text/css" >
		<meta charset="ISO-8859-1">
		<title>Errore 500</title>
	</head>	
	
	<body>
	
		<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
		<div id="content">
		
			<div id="mess-img">
				<img src="resources/images/error500.jpg" alt="IMG"></img>
			</div>
					
			<div id="mess-info">
				<h1>Errore 500</h1>
				<p class="p1">Ops... Qualcosa è andato storto</p>
			</div>
					
			<div id="mess-btn">
				<form action='${pageContext.request.contextPath}/Home' method="GET">
					<input type="submit" value="Torna alla Home Page" class="cta-button"/>
				</form>
			</div>
		
		</div>
	
	
	</body>




</html>