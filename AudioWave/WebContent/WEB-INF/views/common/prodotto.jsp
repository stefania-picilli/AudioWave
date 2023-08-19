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
					<div>
						<h3>Hai aggiunto il seguente prodotto:</h3>
						<h4>${prodotto.nome}</h4>
					</div>
				</div>
			
				<div class="mess-btn-wrap">
			
					<div class="message-btn">
						<button class="reverse-button" onclick="eliminaMess()">Continua</button>
					</div>
				
					<div class="message-btn">

						<form action='${pageContext.request.contextPath}/Carrello' method="get">
							<button class="cta-button" value="Vai al carrello" >Vai al carrello</button>
						</form>
						
					</div>
				
				</div>
			
			</div>
			
			
			<div id="prod-non-aggiunto" class="message light-color-box">
			
				<div class="message-txt">
				
					<div>
						<h3>Impossibile aggiungere il prodotto</h3>
					</div>
				</div>
				
				<div class="mess-btn-wrap">
			
					<div class="message-btn">
						<button class="cta-button" onclick="eliminaMess()">Continua</button>
					</div>
			
				</div>
				
			</div>
		
		
			<div id="prodotto" >
		
				<div id="immagine" class="box">	
					<img src="${prodotto.immagine}" alt="IMG" height="500px">	
				</div>
				
				
				<div id="info-prod">
				
					<div>
						<h1>${prodotto.nome}</h1>
						<span id="prodSpan">${prodotto.marca}</span><br>
					</div>
				
					<div class="line"></div>
				
					<div>
						<span id="prezzoTit">Prezzo:</span>
						<span id="prezzoSpan">&euro; ${prodotto.prezzoConIva}</span> <br>
					</div>
					
					<div class="line"></div>
				
					<div>
						<span id="dispSpan" class="${colore}" >${disponibilita}</span><br>
					</div>
				
					<div id="prod-action">
						<div id="carrello-btn"><button onclick="addFromProd(${prodotto.codiceProdotto})" id="${prodotto.codiceProdotto}" class="reverse-button">Aggiungi al carrello</button></div>
						<div id="acquista-btn"><button id="${prodotto.codiceProdotto}" class="cta-button">Acquista</button></div>
					</div>
				
				</div>
			
			</div>
			
			<div class="line"></div>
			
			<div id="descrizione">
				
				<h2>Descrizione</h2>
				<p>${prodotto.descrizione}</p>
				
			</div>
		
		</div>
		
		
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		
		
	</body>

</html>