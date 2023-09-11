<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>   
<%@ page import="model.dto.OrdineBean" %>  
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="resources/styles/utente.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Informazioni utente</title>
	</head>
	<body>
	
		 <jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
		<div id="content">
		
			<div id="dettagli-utente" class="light-card">
			
				<div id="nome-cognome">
					<h1>${account.nome} ${account.cognome}</h1>
					<p>${account.email}</p>
				</div>
				
				<div id="info">
				
					<div class="half-info">
					
						<div class="left-item">
						
							<h3>Nome</h3>
							<p class="card-item">${account.nome}</p>
						
						</div>
						<div class="left-item">
						
							<h3>Cognome</h3>
							<p class="card-item">${account.cognome}</p>
						
						</div>
					
					</div>
					
					<div class="half-info">
					
						<div class="right-item">
						
							<h3>Data di nascita</h3>
							<p class="card-item">${account.dataNascita}</p>
						
						</div>
						<div class="right-item">
						
							<h3>Cellulare</h3>
							<p class="card-item">${account.cellulare}</p>
						
						</div>
					
					</div>
				
				
				</div>
				
				
				<div id="azioni">
			
					<form action="Logout" method="GET">
			
						<input type="hidden" name="action" value="logout">
						<input type="submit" value="Logout" class="cta-button">
			
					</form>
				
			
				</div>
			
			</div>	
		
		
			<div id="ordini">
			
				<div id="tab-ordini">
				
					<h2>Ordini effettuati:</h2>
				
					<%if(request.getAttribute("ordini") == null){%>
				
						<p>Non sono ancora presenti ordini</p>
				
					<%}else{ %>
				
						<table>
					
							<tr>
							
								<th>Data ordine</th>
								<th>Indirizzo</th>
								<th>Stato ordine</th>
								<th>Costo totale</th>
							
							</tr>
					
					
							<c:forEach  items="${ordini}" var="ordine">
							
								<tr>
							
										<td><a href="DettagliOrdine?action=visualizza&num=${ordine.numeroOrdine}">${ordine.data}</a></td>
										<td>${ordine.indirizzo}</td>
										<td>${ordine.statoOrdine}</td>
										<td>&euro; ${ordine.costoTotale}</td>
									
								</tr>
								
							</c:forEach>
					
					
						</table>
				
					<%} %>
				
				</div>
			
			</div>
		
		</div>
		
	
	</body>
</html>