<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<!--  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="content/css/ricerca.css" type="text/css" >
		<link rel="stylesheet" href="content/css/application.css" type="text/css" >-->
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Risultati ricerca</title>
	</head>
	
	<body>
		
		<jsp:include page="header.jsp"/>
		
			
		<div id="content">
		
			<h1>Risultati ricerca:</h1>
			
			
			<div id="filtri">
				
				<h2>Filtri</h2>
						
				<% if(request.getAttribute("rimuovicat") == null){ %>
				
						<div class="filtro-item">
						
							<label>Categoria</label>
							
							<select name="categoria" id="categoria-fil">
									
								<option value="Tutte">Tutte</option>
								<c:forEach  items="${categorie}" var="categoria">
									<option value="${categoria.id}">${categoria.nome}</option>
								</c:forEach>
									
							</select>
						
						</div>
					
					<%} %>
					
					
					<div class="filtro-item" >
					
						<label>Prezzo</label>
						<div>
								
							<label>Da:</label>
							<input type="number" step="0.01" min="0" id="prezzo-da" value="0">
								
						</div>
							
						<div>
								
							<label>A:</label>
							<input type="number" step="0.01" min="0" id="prezzo-a" value="${maxPrezzo}">
								
						</div>
					
					</div>
					
					<div class="filtro-item">
					
						<input type="button" value="Applica" onclick="filtraProd()"/>
					
					</div>
				
				</div>
			
			
			<%if(request.getAttribute("prodotti") == null){ %>
			
				<div id="no-ris"><h2>Nessun risultato</h2></div>
			
			<%}else{ %>
		
				<div class="tab-prodotti">
						 
					 <c:forEach  items="${prodotti}" var="prodotto">
						 
						<div class="prodotto" >
						
							<div class="hidden-info categoria-hidd">${prodotto.categoriaID}</div>
							<div class="hidden-info prezzo-hidd">${prodotto.prezzoConIva}</div>
											
							<div class="img">
					
								<img src="/resources/images/prova.jpg" alt="IMG" height=220px>
					
							</div>
				
							<div class="info">
									
								<span class="prodSpan">${prodotto.produttore}</span><br>
								<span class="nomeSpan"><a href='${pageContext.request.contextPath}/Prodotto?id=${prodotto.codiceProdotto}'>${prodotto.nome}<br></a></span>
								<span class="prezzoSpan">&euro; ${prodotto.prezzoConIva}</span>
					
					
							</div>
										
						</div>		
						
					</c:forEach>
						
				
				</div>
				
			<%} %>
		
		</div>
		

		<!--<jsp:include page="footer.jsp" />



		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="content/script/filtri.js"></script>-->


	</body>
	
</html>