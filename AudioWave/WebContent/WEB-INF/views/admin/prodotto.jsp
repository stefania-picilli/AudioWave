<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<%@ page import="java.util.List" %> 
  
<!DOCTYPE html>
<html lang="it">
	<head>
		<link rel="stylesheet" href="resources/styles/prodotto.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/prodotti-admin.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>${prodotto.nome}</title>
		
		
	</head>
	
	<body>
	
		<jsp:include page="header.jsp"/>
	
	
		<div id="content">
		
		
			<div id="prodotto" >
		
				<div id="immagine" class="box">	
					<img src="${prodotto.immagine}" alt="IMG" height="500px">	
				</div>
				
				
				<div id="info-prod">
				
					<div id="nome-div">
						<h1>${prodotto.nome}</h1>
						<h5>${prodotto.marca}</h5><br>
					</div>
				
					<div class="line"></div>
				
					
					<h2>&euro; ${prodotto.prezzoConIva}</h2>
				
					
					<div class="line"></div>
				
					<p class="${colore} p2" >${disponibilita}</p>
					
				
					<div id="prod-action">
					
						<form action="Amministratore" method="POST" class="item-btn">
							<input type="hidden" name="action" value="r-prodotto">
							<input type="hidden" name="codice" value="${prodotto.codiceProdotto}">
							<input type="submit" value="Rimuovi" class="reverse-red-button b1">
						</form>
					
						<form action="Amministratore" method="GET" class="item-btn">
							<input type="hidden" name="action" value="m-prodotto">
							<input type="hidden" name="codice" value="${prodotto.codiceProdotto}">
							<input type="submit" value="Modifica" class="cta-button b1">
						</form>
					
					</div>
				
				</div>
			
			</div>
			
			<div class="line"></div>
			
			<div id="descrizione">
				
				<h2>Descrizione</h2>
				<p class="p1">${prodotto.descrizione}</p>
				
			</div>
		
		</div>
		
		
		<script src="resources/scripts/jquery.js"></script>
		<script src="resources/scripts/carrello.js"></script>
		
		
	</body>

</html>