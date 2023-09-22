<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>   
<%@ page import="model.dto.OrdineBean" %>  
<!DOCTYPE html>
<html lang="it">
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
		
			<div id="dettagli-utente">
			
				<div id="nome-cognome">
					<h1>${account.nome} ${account.cognome}</h1>
					<p>${account.email}</p>
				</div>
				
				<div id="info">
					
					<div class="info-item">
						<h3>Nome</h3>
						<p class="box">${account.nome}</p>
					</div>
					
					<div class="info-item">
						<h3>Cognome</h3>
						<p class="box">${account.cognome}</p>
					</div>
					
					<div class="info-item">
						<h3>Data di nascita</h3>
						<p class="box">${account.dataNascita}</p>
					</div>
					
					<div class="info-item">
						<h3>Cellulare</h3>
						<p class="box">${account.cellulare}</p>
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
				
						<p class="p2 box">Non sono ancora presenti ordini</p>
				
					<%}else{ %>
				
						<table>
							<caption>Info ordini</caption>
					
							<tr class="colored-box">
							
								<th>Data</th>
								<th>Indirizzo</th>
								<th>Stato</th>
								<th>Importo</th>
							
							</tr>
					
					
							<c:forEach  items="${ordini}" var="ordine">
							
								<tr class="box" onclick="tableRowClickU(${ordine.numeroOrdine})">
							
										<td>${ordine.data}</td>
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
		
		<script src="resources/scripts/jquery.js"></script>
		<script src="resources/scripts/table.js"></script>
	
	</body>
</html>