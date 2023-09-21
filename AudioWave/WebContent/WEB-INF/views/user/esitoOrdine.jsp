<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/esito-errore.css" type="text/css" >
		<title>Esito ordine</title>
	</head>
	<body>
	
		  <jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
			<div id="content">
	
				<% if(request.getAttribute("esito").equals("positivo")){ %>
	
					<div id="mess-img">
						<img src="resources/images/ordine-eff.jpg" alt="IMG"></img>
					</div>
					
					<div id="mess-info">
						<h1>Ordine effettuato</h1>
						<p class="p1">${message}</p>
					</div>
					
					<div id="mess-btn">
						<form action='${pageContext.request.contextPath}/Home' method="GET">
							<input type="submit" value="Torna alla Home Page" class="cta-button"/>
						</form>
					</div>
				
				<%}else{ %>
				
					<div id="mess-img">
						<img src="resources/images/ordine-non-eff.jpg" alt="IMG"></img>
					</div>
					
					<div id="mess-info">
						<h1>Ordine non effettuato</h1>
						<p class="p1">${message}</p>
					</div>
					
					<div id="mess-btn">
						<form action='${pageContext.request.contextPath}/Home' method="GET">
							<input type="submit" value="Torna alla Home Page" class="cta-button"/>
						</form>
					</div>
				
				<%} %>
	
		</div>

	</body>
</html>