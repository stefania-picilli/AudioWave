<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<%@ page import="java.util.List" %> 
  
<!DOCTYPE html>
<html lang="it">
	<head>
		<link rel="stylesheet" href="resources/styles/prodotto.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>${prodotto.nome}</title>
		
		
	</head>
	
	<body>
	
		<jsp:include page="header.jsp"/>
	
	
		<div id="content">
		
		
			<div id="prod-aggiunto" class="message light-color-box">
			
				<div class="message-txt">
					<h4>Hai aggiunto il prodotto:</h4>
					<p class="p3">${prodotto.nome}</p>
				</div>
			
				<div class="mess-btn-wrap">
				
					<div class="message-btn">

						<form action='${pageContext.request.contextPath}/Carrello' method="get">
							<button class="cta-button b2" value="Vai al carrello" >Vai al carrello</button>
						</form>
						
					</div>
					
					<div class="message-btn">
						<button class="reverse-button b2" onclick="eliminaMess()">Continua</button>
					</div>
				
				</div>
			
			</div>
			
			
			<div id="prod-non-aggiunto" class="message light-color-box">
			
				<div class="message-txt">
				
					<div>
						<h4>Impossibile aggiungere il prodotto</h4>
					</div>
				</div>
				
				<div class="mess-btn-wrap">
			
					<div class="message-btn">
						<button class="cta-button b2" onclick="eliminaMess()">Continua</button>
					</div>
			
				</div>
				
			</div>
		
		
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
						<div id="carrello-btn"><button onclick="addFromProd(${prodotto.codiceProdotto})" id="${prodotto.codiceProdotto}" class="reverse-button b1">Aggiungi al carrello</button></div>
						<div id="acquista-btn"><button id="${prodotto.codiceProdotto}" class="cta-button b1">Acquista</button></div>
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
		
		
	</body>

</html>