<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="it">
	<head>
	
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/header.css" type="text/css" >
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<title>Header</title>
		
	</head>
	
		<body>
		
		
			<header>	
				
					<div id="logo">
						<a href='${pageContext.request.contextPath}/Home'><img src="resources/images/logo.jpg" alt="logo"  height="50px"></img></a>
					</div>
				
					<nav id="header-nav">
						<ul>
							<c:forEach  items="${categorie}" var="categoria">
								<li>
									<a href='${pageContext.request.contextPath}/Ricerca?categoria=${categoria.nome}' class="b2">${categoria.nome}</a>
								</li>
							</c:forEach>
						</ul>
					</nav>
					
				
				
					<div id="pulsanti-header">
						
						<div id="user" class="pulsante">
							<a href='${pageContext.request.contextPath}/Utente'><i class="fa-solid fa-user fa-2xl action-icon"></i></a>
						</div>
						
						<div id="cart" class="pulsante">
							<a href='${pageContext.request.contextPath}/Carrello'><i class="fa-solid fa-cart-shopping fa-2xl action-icon"></i></a>
						</div>
						
					</div>
				
				
					<div id="barra-ricerca">
				
						<form action='${pageContext.request.contextPath}/Ricerca' method="get">
							<input type="text" class="search-bar b2" name="search" placeholder="Cerca prodotti" size="60">
							<button type="submit" class="search-icon"><i  class="fa fa-search grey-action-icon"></i></button>
							<!-- <i  class="fa fa-search search-icon grey-action-icon"></i> --> 
						</form>
					
					</div>
				
			
			
			</header>
		
		
		</body>
		
</html>