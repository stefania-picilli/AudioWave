<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
	<head>
		<link rel="stylesheet" href="resources/styles/form.css" type="text/css" > 
		<link rel="stylesheet" href="resources/styles/dettagliOrdine.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Informazioni ordine</title>
	</head>
	<body>

		<jsp:include page="header.jsp"/>
		
		<div id="content">
		
			<h1>Numero ordine: ${ordine.numeroOrdine}</h1>
		
		
			<div id="prodotti">
			
				<div id="prodotti-tab">
			
					<c:forEach  items="${prodotti}" var="prodotto">
						
							<div class="prodotto box">
								
									<div class="img">
										<img src="${prodotto.immagine}" alt="IMG" height=220px>
									</div>
									
									<div class="info-prod">
									
										<div class="top-info">
											<h3><a href='${pageContext.request.contextPath}/Amministratore?action=v-prodotto&codice=${prodotto.codiceProdotto}'>${prodotto.nome }</a></h3>
											<p class="p3">${prodotto.marca} </p>
										</div>
										
										<div class="bottom-info">
										
											<div class="prezzo">
												<h3>&euro; ${prodotto.prezzoConIva}</h3> 
											</div>
											
											<div class="quantita">
												<p>Quantit�: ${prodotto.quantita}</p>
											</div>
										
										</div>
									
									</div>
						
							</div>
							
					</c:forEach>
					
				</div>
				
			
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
							<h3>Nome utente</h3>
							<p class="box">${utente.cognome} ${utente.nome}</p>
						</div>
					
						<div class="info-item">
							<h3>E-mail utente</h3>
							<p class="box">${utente.email}</p>
						</div>
					
					</div>
				
				</div>
		
		
		
				<%if(request.getAttribute("spedizione") == null){ %>
					
					<div id="info-spedizione">
					
						<div id="info-form">
							<h1>Spedizione</h1>
							<p class="p1">Inserisci le informazioni riguardanti la spedizione</p>
						</div>
						
						
						<div id="form-data">
						
							<form action="Amministratore" method="POST">
							
								<div id="corriere" class="form-item">
									
									<label for="corriere" class="p3">Corriere:</label>
									<input type="text" name="corriere" placeholder="Corriere" class="box">
									
									<div></div>
									
								</div>
							
								<div id="data-partenza" class="form-item">
									
									<label for="data-partenza" class="p3">Data di partenza:</label>    <!-- Non pu� essere successiva alla data attuale, spedizione deve essere gi� partita -->
									<input type="date" name="data-partenza" class="box">
									
									<div></div>
									
								</div>
							
								<div id="data-arrivo" class="form-item">
									
									<label for="data-arrivo" class="p3">Data stimata di arrivo:</label>
									<input type="date" name="data-arrivo" class="box">
									
									<div></div>
									
								</div>
							
							
								
								<div id="form-error" class="error-message"></div>
							
								<input type="hidden" name="action" value="m-spedizione">
								<input type="hidden" name="numeroOrdine" value="${ordine.numeroOrdine}">
								
								<div class="form-action">
								
									<input type="submit" value="Aggiugi informazioni" class="cta-button">
							
								</div>
							
							</form>
						
						</div>
						
					</div>
				
				<%}else{ %>
				
				
					<div id="info-spedizione">
				
						<h2>Spedizione</h2>
					
						<div id="info-tab">
						
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
								
						
						</div>
				
					</div>
				
				
				<%} %>
				
				
			</div>

		</div>
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

		<script src="resources/scripts/jquery.js"></script>
		<script src="resources/scripts/form.js"></script>

	</body>
</html>