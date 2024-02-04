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
			
				<div class="line"></div>
			
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
							<p class="p3">Stato</p>
							<p class="box p2">${ordine.statoOrdine}</p>
						</div>
							
						<div class="info-item">
							<p class="p3">Importo</p>
							<p class="box p2">&euro; ${ordine.costoTotale}</p>
						</div>
						
						<div class="info-item">
							<p class="p3">Data</p>
							<p class="box p2">${ordine.data}</p>
						</div>
							
						<div class="info-item">
							<p class="p3">Indirizzo</p>
							<p class="box p2">${ordine.indirizzo}</p>
						</div>
							
						<div class="info-item">
							<p class="p3">Metodo di pagamento</p>
							<p class="box p2">*****${ordine.metodoPagamento}</p>
						</div>
						
					</div>
					
					<div id="fattura">
					
						<form action="DettagliOrdine" method="GET">
					
							<input type="hidden" name="action" value="fattura">
							<input type="hidden" name="num" value="${ordine.numeroOrdine}">
							<input type="submit" value="Ottieni fattura" class="cta-button b2">
						
						</form>
					
					</div>
				
				</div>
				
			
				<!--<div class="line"></div>-->
			
				<div id="info-spedizione">
				
					<h2>Spedizione</h2>
					
					<div id="info-tab" >
					
						<% if(request.getAttribute("spedizione") == null){ %>
							<div class="info-item"><p class="box p2">L'ordine non è ancora stato spedito</p></div>
						<%}else{ %>
					
							<div class="info-item">
								<p class="p3">Data di partenza</p>
								<p class="box p2">${spedizione.dataPartenza}</p>
							</div>
								
							<div class="info-item">
								<p class="p3">Data stimata di arrivo</p>
								<p class="box p2">${spedizione.dataArrivo}</p>
							</div>
							
							<div class="info-item">
								<p class="p3">Corriere</p>
								<p class="box p2">${spedizione.corriere}</p>
							</div>
					
						<%} %>
						
					</div>
				
				</div>
				
				
			</div>
		
		</div>

		
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

	</body>
</html>