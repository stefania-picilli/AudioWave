<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
	<head>
		<link rel="stylesheet" href="resources/styles/ricerca.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/utente.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Lista ordini</title>
	</head>
	<body>
	
		<jsp:include page="header.jsp"/>

		
		<div id="content">
		
			<div id="ordini">
			
				<h1>Ordini:</h1>
				
				
					<div id="filtri">
					
						<div id="item-group">
					
						
							<div class="filtro-item" id="single-item">
							
								<div class="item">
								
									<p class="p3">Utente: </p>
								
								
									<div class="input-item">
								
										<select name="utente" id="utente-fil" class="box p2">
											<option value="Tutti" class="p2">Tutti</option>
											<c:forEach  items="${utenti}" var="utente">
												<option value="${utente.email}" class="p2">${utente.email}</option>
											</c:forEach>
										</select>
									
									</div>
								
								</div>
								
							</div>
								
							<div class="filtro-item" id="double-item">
								
								<div class="item" id="left-item">
								
									<p class="p3">Da:</p>
									<div class="input-item">
										<input type="date" id="data-da" class="box p2" value="${da}">
									</div>
									
								</div>
									
								<div class="item" id="right-item">
									<p class="p3">A:</p>
									<div class="input-item">
										<input type="date" id="data-a" class="box p2" value="${a}">
									</div>
							
								</div>
								
							</div>
							
							
							</div>
						
							<div id="filtro-action">
								<button class="cta-button b1" onclick="filtraOrdini()">Applica</button>
							</div>
						
						
					
					</div>
					
					
					<div class="line"></div>
					
				
					<div id="tab-ordini">
					
					
						<%if(request.getAttribute("ordini") == null){%>
					
							<p class="p2 box">Non sono ancora presenti ordini</p>
					
						<%}else{ %>
					
							<table>
								<caption>Info ordini</caption>
						
								<tr class="colored-box">
								
									<th>Data</th>
									<th>Utente</th>
									<th>Stato</th>
									<th>Importo</th>
								
								</tr>
						
						
								<c:forEach  items="${ordini}" var="ordine">
								
									<tr class="ordine-row" onclick="tableRowClickA(${ordine.numeroOrdine})">
								
											<td class="data-ord">${ordine.data}</td>
											<td class="utente-ord">${ordine.email}</td>
											<td>${ordine.statoOrdine}</td>
											<td>&euro; ${ordine.costoTotale}</td>
										
									</tr>
									
								</c:forEach>
						
						
							</table>
					
						<%} %>
					
					</div>
				
				</div>


		</div>
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
		
		<script src="resources/scripts/jquery.js"></script>
		<script src="resources/scripts/filtri.js"></script>
		<script src="resources/scripts/table.js"></script>

	</body>
</html>