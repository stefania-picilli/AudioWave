<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html lang="it">
	<head>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/ricerca.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/home.css" type="text/css" >
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Home Page</title>
	</head>
	<body>

		 <jsp:include page="header.jsp"/>
		
		<div id="hero-wrap">
		
			<div id="hero">
				
				<div id="left-hero">
					<p class="h6">AudioWave</p>
					<p class="p1">Trova facilmente ciò che stai cercando esplorando le diverse categorie di prodotti audio disponibili nel nostro negozio</p>
				</div>
				
				<div id="right-hero">
					<div id="hero-img">
						<img src="resources/images/hero.png" alt="IMG">
					</div>
				</div>
				
			</div>
		
		</div>
		
		
		
		<div id="content">
		
		
			<div id="categorie">
			
				<h1>Categorie</h1>
				
				
				<div id="categorie-wrap">
				
					<div class="categoria">
				
					
						<div class="cat-img">
							<a href="${pageContext.request.contextPath}/Ricerca?categoria=Cuffie">
								<img src="resources/images/cuffie-icon.jpg" alt="IMG">
							</a>
						</div>
						
						<div class="cat-tit">
							<h4><a href="${pageContext.request.contextPath}/Ricerca?categoria=Cuffie">Cuffie</a></h4>
						</div>
						
				
					
					</div>
					
					
					<div class="categoria">
					
						<div class="cat-img">
							<a href="${pageContext.request.contextPath}/Ricerca?categoria=Auricolari">
								<img src="resources/images/auricolari-icon.jpg" alt="IMG">
							</a>
						</div>
						
						<div class="cat-tit">
							<h4><a href="${pageContext.request.contextPath}/Ricerca?categoria=Auricolari">Auricolari</a></h4>
						</div>
					
					</div>
					
					
					<div class="categoria">
					
						<div class="cat-img">
							<a href="${pageContext.request.contextPath}/Ricerca?categoria=Speaker">
								<img src="resources/images/speaker-icon.jpg" alt="IMG">
							</a>
						</div>
						
						<div class="cat-tit">
							<h4><a href="${pageContext.request.contextPath}/Ricerca?categoria=Speaker">Speaker</a></h4>
						</div>
					
					</div>
					
				
				</div>
			
			
			</div>
		
		
			<div class="line"></div>
		
		
			<div id="prodotti">
			
				<h1>Prodotti in evidenza</h1>
				
								
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
										<h3><a href='${pageContext.request.contextPath}/Prodotto?id=${prodotto.codiceProdotto}'>${prodotto.nome}</a></h3>
										<p class="p3">${prodotto.marca}</p>
									</div>
									<div class="bottom-info">
										<h3>&euro; ${prodotto.prezzoConIva}</h3>
									</div>
						
								</div>
											
							</div>
						
						
						
					</c:forEach>
						
				
				</div>
				
			
			</div>
		
		
			
			<div class="line"></div>
			
			<div id="about-us">
		
				<h1>About us</h1>
				
				<p class="p1">Trova facilmente ciò che stai cercando esplorando le diverse categorie di prodotti audio disponibili nel nostro negozio</p>
			
			
			</div>
			
		
		</div>
		
		
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
		
		
	</body>
</html>