<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
	<head>
		<link rel="stylesheet" href="resources/styles/fattura.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Fattura</title>
	</head>
	<body>
		
		<div id="content">
			
			<div id="top">
			
				<img src="resources/imgages/logo.jpg" alt="logo" height="70px"></img>
				
				<h1>Fattura num. ${ordine.numeroOrdine}</h1>
			
			</div>
			
			<div class="table-tab">
			
				<table>
					<caption>Info fattura</caption>
				
				
				
					<tr>
					
						<th>Numero fattura</th>
						<th>Data</th>
						<th>Cliente</th>
						<th>Indirizzo spedizione</th>
					
					</tr>
					
					<tr>
					
						<td>${ordine.numeroOrdine}</td>
						<td>${ordine.data}</td>
						<td>${account.nome} ${account.cognome}</td>
						<td>${ordine.indirizzo}</td>
					
					</tr>
				
				</table>
			
			</div>
			
			<div class="table-tab">
			
				<table>
					<caption>Info prodotti</caption>
				
					<tr>
						
						<th>Descrizione</th>
						<th>Q.tà</th>
						<th>Prezzo unitario (IVA esclusa)</th>
						<th>IVA</th>
						<th>Prezzo unitario (IVA inclusa)</th>
										
					</tr>
				
					 <c:forEach  items="${prodotti}" var="prodotto">
						 
						 <tr>
						 
						 	<td>${prodotto.nome}</td>
						 	<td>${prodotto.quantita}</td>
						 	<td>&euro; ${prodotto.prezzo}</td>
						 	<td>${prodotto.iva} %</td>
						 	<td>&euro; ${prodotto.prezzoConIva}</td>
						 
						 </tr>
						 
					 </c:forEach>
				
				
				
				</table>
			
			
			</div>
			
			<div id="last-table">
			
				<table>
					<caption>Info importo</caption>
				
				
					<tr>
					
						<th>Imponibile</th>
						<td>&euro; ${imponibile}</td>
					
					</tr>
					
					<tr>
					
						<th>Imposta IVA</th>
						<td>&euro; ${impostaIVA}</td>
					
					</tr>
					
					<tr>
					
						<th>Totale parziale</th>
						<td>&euro; ${totaleParziale}</td>
					
					</tr>
				
					<tr>
					
						<th>Costo spedizione</th>
						<td>&euro; 5.00</td>
					
					</tr>
				
					<tr id="totale-tr">
					
						<th>TOTALE</th>
						<td>&euro; ${ordine.costoTotale}</td>
					
					</tr>
				
				
				</table>
			
			
			
			</div>
		
		</div>


	</body>
</html>