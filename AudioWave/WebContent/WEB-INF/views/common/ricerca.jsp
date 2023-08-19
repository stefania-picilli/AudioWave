<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="it">
	<head>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="resources/styles/ricerca.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Risultati ricerca</title>
	</head>
	
	<body>
		
		<jsp:include page="header.jsp"/>
		
			
		<div id="content">
		
			<h1>${title} </h1>
			
			
			<div id="filtri">
				
				<div id="item-group">
						
					<% if(request.getAttribute("rimuovicat") == null){ %>
					
							<div class="filtro-item">
							
								<div>
							
									<label>Categoria: </label>
									
									<select name="categoria" id="categoria-fil" class="box">
											
										<option value="Tutte">Tutte</option>
										<c:forEach  items="${categorie}" var="categoria">
											<option value="${categoria.id}">${categoria.nome}</option>
										</c:forEach>
											
									</select>
									
								</div>
							
							</div>
						
						<%} %>
						
						
						<div class="filtro-item">
						
							<div>
									
								<label>Da: &euro; </label>
								<input type="number" step="0.01" min="0" id="prezzo-da" class="box" value="0">
									
							</div>
								
							<div>
									
								<label>A: &euro; </label>
								<input type="number" step="0.01" min="0" id="prezzo-a" class="box" value="${maxPrezzo}">
									
							</div>
						
						</div>
						
					</div>
						
					<div class="filtro-action">
					
						<div><button class="cta-button" onclick="filtraProd()">Applica</button></div>
					
					</div>
				
				</div>
			
			
			<div class="line"></div>
			
			
			<%if(request.getAttribute("prodotti") == null){ %>
			
				<div id="no-ris"><h2>Nessun risultato</h2></div>
			
			<%}else{ %>
		
				<div class="tab-prodotti">
						 
					 <c:forEach  items="${prodotti}" var="prodotto">
						 
						<div class="prodotto box" >
						
							<div class="hidden-info categoria-hidd">${prodotto.categoriaID}</div>
							<div class="hidden-info prezzo-hidd">${prodotto.prezzoConIva}</div>
											
							<div class="img">
					
								<img src="${prodotto.immagine}" alt="IMG" height=220px>
					
							</div>
				
							<div class="info">
									
								<h3><a href='${pageContext.request.contextPath}/Prodotto?id=${prodotto.codiceProdotto}'>${prodotto.nome}<br></a></h3>
								<span>${prodotto.marca}</span><br>
								<h3>&euro; ${prodotto.prezzoConIva}</h3>
								
					
					
							</div>
										
						</div>		
						
					</c:forEach>
						
				
				</div>
				
			<%} %>
		
		</div>
		



		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="resources/scripts/filtri.js"></script>


	</body>
	
</html>