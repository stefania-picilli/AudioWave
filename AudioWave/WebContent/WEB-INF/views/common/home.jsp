<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="resources/styles/home.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Home Page</title>
	</head>
	<body>

		 <jsp:include page="header.jsp"/>
		
		
		<div id="content">
		
		
			<div>
			
				<h1>Benvenuti</h1>
				
			</div>
		
		
		
			<div id="venduti" class="gruppo-prodotti">
			
				<div class="info-prodotti">
				
					<h1>I più venduti</h1>
				
				</div>
			
				<div class="riga-prodotti">
					
					 <c:forEach  items="${venduti}" var="prodotto">
						 
						<div class="prodotto" >
										
							<div class="img">
				
								<img src="${prodotto.immagine}" alt="IMG" height=220px>
				
							</div>
			
							<div class="info">
								
								<span class="nomeSpan"><a href='${pageContext.request.contextPath}/Prodotto?id=${prodotto.codiceProdotto}'>${prodotto.nome}<br></a></span>
								<span class="prodSpan">${prodotto.marca}</span><br>
								
								<span class="prezzoSpan">&euro; ${prodotto.prezzoConIva}</span>
				
							</div>
									
						</div>		
					
					</c:forEach>
					
				</div>
					
					
				<div class="altro">
						<!-- <a href='${pageContext.request.contextPath}/Ricerca?param=ven'>Visualizza altro</a>-->
						<form action='${pageContext.request.contextPath}/Ricerca' method="get">
							 <input type="hidden" name="param" value="ven">
						 	 <button class="cta-button">Visualizza altro</button>
						</form>
				</div>
					
					
				
			
			</div>
		
		
				
		
		</div>
		
		
		
		<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>-->
		
		
	</body>
</html>