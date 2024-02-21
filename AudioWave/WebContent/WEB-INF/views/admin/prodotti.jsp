<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
	<head>
		<link rel="stylesheet" href="resources/styles/ricerca.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/prodotti-admin.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Catalogo</title>
	</head>
	<body>
	
		<jsp:include page="header.jsp"/>
		
		
		<div id="content">
		
		
			<h1>${title}</h1>
		
		
			<div id="nuovo-prod">
			
				<div class="line"></div>
			
				<p class="p1">Hai un nuovo prodotto da aggiungere al catalogo? </p>
				
				<form action="Amministratore" method="GET">
					<input type="hidden" name="action" value="c-prodotto">
					<input type="submit" class="cta-button b2" value="Aggiungi prodotto">
				</form>
				
				<div class="line"></div>
				
			</div>
			
		
			
			<div id="filtri">
						
				<div id="item-group">
				
					<div class="filtro-item" id="single-item">
						
						<div class="item">
							
								<p class="p3">Categoria: </p>
									
								<div class="input-item">
									
									<select name="categoria" id="categoria-fil" class="box p2">	
										<option value="Tutte" class="p2">Tutte</option>
										<c:forEach  items="${categorie}" var="categoria">
											<option value="${categoria.id}" class="p2">${categoria.nome}</option>
										</c:forEach>
									</select>
										
								</div>
									
							</div>
						
					</div>
					
					
					
					
					
					
					
					<div class="filtro-item" id="double-item">
					
						<div class="item" id="left-item">
									
							<p class="p3">Da: &euro; </p>
							<div class="input-item">
								<input type="number" step="0.01" min="0" id="prezzo-da" class="box p2" value="0.00">
							</div>
									
						</div>
								
						<div class="item" id="right-item">
									
							<p class="p3">A: &euro; </p>
							<div class="input-item">
								<input type="number" step="0.01" min="0" id="prezzo-a" class="box p2" value="${maxPrezzo}">
							</div>
									
						</div>
					
					</div>
					
					
				</div>	
				
					
				<div id="filtro-action">
					<button class="cta-button b1" onclick="filtraProd()">Applica</button>
				</div>
				
			</div>
			
			
			<div class="line"></div>
			
			
			<%if(request.getAttribute("prodotti") == null){ %>
			
				<div id="no-ris"><h2>Nessun risultato</h2></div>
			
			<%}else{ %>
			
				<div class="tab-prodotti">
							 
					 <c:forEach  items="${prodotti}" var="prodotto">
							 
						<div class="prodotto box">
							
							<div class="hidden-info categoria-hidd">${prodotto.categoriaID}</div>
							<div class="hidden-info prezzo-hidd">${prodotto.prezzoConIva}</div>
												
							<div class="img">
								<img src="${prodotto.immagine}" alt="IMG">
							</div>
							
							<div class="info">
									
								<div class="top-info">
									<h3><a href='${pageContext.request.contextPath}/Amministratore?action=v-prodotto&codice=${prodotto.codiceProdotto}'>${prodotto.nome}</a></h3>	
									<p class="p3">${prodotto.marca}</p>
								</div>
								
								<div class="bottom-info">
									<h3>&euro; ${prodotto.prezzoConIva}</h3>
								</div>				
						
							</div>
							
							
							<div class="azioni">
							
								<form action="Amministratore" method="POST">
								
									<input type="hidden" name="action" value="r-prodotto">
									<input type="hidden" name="codice" value="${prodotto.codiceProdotto}">
									<input type="submit" value="Rimuovi" class="reverse-red-button b2">
								
								</form>
							
								<form action="Amministratore" method="GET">
								
									<input type="hidden" name="action" value="m-prodotto">
									<input type="hidden" name="codice" value="${prodotto.codiceProdotto}">
									<input type="submit" value="Modifica" class="cta-button b2">
								
								</form>
								
							
							</div>
											
						</div>		
							
					</c:forEach>
							
					
				</div>
		
		<%} %>
			
		</div>
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
		
		<script src="resources/scripts/jquery.js"></script>
		<script src="resources/scripts/filtri.js"></script>

	</body>
</html>