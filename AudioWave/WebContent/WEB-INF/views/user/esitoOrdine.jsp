<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/esitoOrdine.css" type="text/css" >
		<title>Esito ordine</title>
	</head>
	<body>
	
		  <jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
			<div id="content">
	
				<% if( request.getAttribute("esito").equals("positivo")){ %>
	
	
					<div id="esito-img">
					
						<img src="content/img/ordine-eff.jpg" alt="IMG"></img>
					
					</div>
					
					<div id="esito-info">
					
						<h1>Ordine effettuato</h1>
						<p>${message}</p>
					
					</div>
					
					<div id="esito-btn">
					
						<form action='${pageContext.request.contextPath}/Home' method="GET">
							<input type="submit" value="Torna alla Home Page" class="cta-button"/>
						</form>
					
					</div>
				
				<%}else{ %>
				
				
					<div id="esito-img">
					
						<img src="content/img/ordine-non-eff.jpg" alt="IMG"></img>
					
					</div>
					
					<div id="esito-info">
					
						<h1>Ordine non effettuato</h1>
						<p>Ops, non è stato possibile portare a termine l'ordine</p>
					
					</div>
					
					<div id="esito-btn">
					
						<form action='${pageContext.request.contextPath}/Home' method="GET">
							<input type="submit" value="Torna alla Home Page" class="cta-button"/>
						</form>
					
					</div>
				
				<%} %>
	
		</div>

	</body>
</html>