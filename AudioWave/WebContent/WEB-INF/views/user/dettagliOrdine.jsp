<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
	<head>
		<link rel="stylesheet" href="resources/styles/dettagliOrdine.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Dettagli ordine</title>
	</head>
	
	<body>

		 <jsp:include page="/WEB-INF/views/common/header.jsp"/>

		<div id="content">
			
			<h1>Numero ordine: ${ordine.numeroOrdine}</h1>
				
			<div id="prodotti">
			
				<c:forEach  items="${prodotti}" var="prodotto">
						
						<div class="prodotto box" >
								
								<div class="img">
									<img src="${prodotto.immagine}" alt="IMG" height=220px>
								</div>
								
								<div class="info-prod">
									
									<div class="top-info">
										<h3><a href='${pageContext.request.contextPath}/Prodotto?id=${prodotto.codiceProdotto}'>${prodotto.nome }</a></h3>
										<p class="p3">${prodotto.marca} </p>
									</div>
									
									<div class="bottom-info">
										
										<div class="prezzo">
											<h3>&euro; ${prodotto.prezzoConIva}</h3>
										</div> 
										
										<div class="quantita">
											<p>Quantità: ${prodotto.quantita}</p>
										</div>
										
									</div>
									
								</div>
				
						</div>
							
				</c:forEach>
				
			</div>
			
			
		
			<div id="info-wrap">
			
		
				<div id="info-ordine">
					
					<h2>Dettagli ordine</h2>
						
					<div id="info-tab">
						
						<div class="info-item">
							<h3>Stato</h3>
							<p class="box">${ordine.statoOrdine}</p>
						</div>
							
						<div class="info-item">
							<h3>Importo</h3>
							<p class="box">&euro; ${ordine.costoTotale}</p>
						</div>
						
						<div class="info-item">
							<h3>Data</h3>
							<p class="box">${ordine.data}</p>
						</div>
							
						<div class="info-item">
							<h3>Indirizzo</h3>
							<p class="box">${ordine.indirizzo}</p>
						</div>
							
						<div class="info-item">
							<h3>Metodo di pagamento</h3>
							<p class="box">*****${ordine.metodoPagamento}</p>
						</div>
						
					</div>
					
					<div id="fattura">
					
						<form action="DettagliOrdine" method="GET">
					
							<input type="hidden" name="action" value="fattura">
							<input type="hidden" name="num" value="${ordine.numeroOrdine}">
							<input type="submit" value="Ottieni fattura" class="cta-button">
						
						</form>
					
					</div>
				
				</div>
				
			
				
			
				<div id="info-spedizione">
				
					<h2>Spedizione</h2>
					
					<div id="info-tab" >
					
						<% if(request.getAttribute("spedizione") == null){ %>
							<div class="info-item"><p class="box">L'ordine non è ancora stato spedito</p></div>
						<%}else{ %>
					
							<div class="info-item">
								<h3>Data di partenza</h3>
								<p class="box">${spedizione.dataPartenza}</p>
							</div>
								
							<div class="info-item">
								<h3>Data stimata di arrivo</h3>
								<p class="box">${spedizione.dataArrivo}</p>
							</div>
							
							<div class="info-item">
								<h3>Corriere</h3>
								<p class="box">${spedizione.corriere}</p>
							</div>
					
						<%} %>
						
					</div>
				
				</div>
				
				
			</div>
		
		</div>


	</body>
</html>