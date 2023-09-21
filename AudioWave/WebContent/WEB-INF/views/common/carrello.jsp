<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="model.dto.CarrelloBean" %> 
<%@ page import="model.dto.ProdottoNelCarrelloBean" %> 
<!DOCTYPE html>
<html lang="it">
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Carrello</title>
		<link rel="stylesheet" href="resources/styles/carrello.css" type="text/css" />
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
	</head>
	
	<body>

		<jsp:include page="header.jsp" />
		 
		 <div id="content">
		 
			 <div><h1>Il tuo carrello</h1></div>
			 	
			 <div id="messaggi"></div>
			 
		 
			 <div id="center"> 
			 
			 	<div id="prodotti">
			 	
			 		<div class="line"></div>
			 		
			 		 <c:forEach  items="${carrello.prodotti}" var="prodotto">
			 		
				 		<div class="prodotto box" id="${prodotto.prodotto.codiceProdotto}">
				 		
				 			<div class="img">
				 				<img src="${prodotto.prodotto.immagine}" alt="IMG" height="200px">
				 			</div>
				 			
				 			<div class="info-prod">
				 			
				 				<div class="top-info">
				 					<h3><a href='${pageContext.request.contextPath}/Prodotto?id=${prodotto.prodotto.codiceProdotto}'>${prodotto.prodotto.nome}</a></h3>
				 					<p class="p3">${prodotto.prodotto.marca}</p>
				 				</div>
				 				
				 				<div class="bottom-info">
				 				
				 					<div class="prezzo">
						 				<h3>&euro; ${prodotto.prodotto.prezzoConIva}</h3>
						 			</div>
				 				
					 				<div class="pulsanti">
					 				
					 					<div class="pulsanti-wrap">
					 				
						 					<div class="quantita">
						 					
						 						<button class="minus b2" onclick="remove(${prodotto.prodotto.codiceProdotto})" >-</button> <!-- da usare solo se q >= 2, rendere non cliccabile con js se q=1 -->
						 						<span class="spanQnt">${prodotto.quantita}</span>
						 						<button onclick="add(${prodotto.prodotto.codiceProdotto})" class="add cta-button b2">+</button>
						 					
						 					</div>
						 					<div class="rimuovi">
						 					
						 						<button onclick="removeAll(${prodotto.prodotto.codiceProdotto})" class="reverse-button b2">Rimuovi</button>
						 					
						 					</div>
						 					
						 				</div>
					 				
					 				</div>
				 				
				 				</div>
				 			
				 			</div>	
				 		
				 		</div>
			 	
			 		 </c:forEach>
			 	
			 	</div>
			 	
			 	<%CarrelloBean carrello = (CarrelloBean) session.getAttribute("carrello"); %>
			 
			 	<% if(carrello.isEmpty()){ %>
			 	
			 		<div id="totale" class="box">
			 		
			 			Il carrello è vuoto
			 		
			 		</div>
			 	
			 	<%}else{ %>
			 	
			 	
			 		<div id="totale" class="box">
				 		
				 		<div id="totale-wrap">
					 		
					 		<div class="line-wrap">
					 			<p class="p2 left-item">Importo parziale:</p>
					 			<p class="p2 right-item" id="cellaSubTot">&euro; ${carrello.totale}</p>
					 		</div>
					 		
					 		<div class="line-wrap">
					 			<p class="p2">Costo spedizione:</p>
					 			<p class="p2">&euro; ${costoSpedizione}</p>
					 		</div>
					 		
					 		
					 		
					 		<div class="line"></div>
					 		
					 		
					 		<div class="line-wrap">
					 			<h4>Importo totale:</h4>
					 			<h4 id="cellaTot">&euro; ${carrello.totaleConSpedizione}</h4>
					 		</div>
					 		
					 		
						 	<div id="acquista-action">
							 	<form method="GET" action="Ordine">
							 		
							 		<input type="hidden" name="totale" value="${carrello.totale}">
							 		<input type="submit" value="Acquista" class="cta-button b1">
				
								</form>
						 		
					 		</div>
				 		
				 		
				 		</div>
				 		
				 	</div>
			 	
			 
			 	<%} %>
			 
			 </div>
			 

		</div>
		
		
		<script src="resources/scripts/jquery.js"></script>
		<script src="resources/scripts/carrello.js"></script>

	</body>
</html>