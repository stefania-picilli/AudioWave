<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
	<head>
	
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/header.css" type="text/css" >
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<title>Header</title>
		
	</head>
	
		<body>
		
		
			<header>	
			
				<div id="left">
				
					<div id="logo">
						<a href='${pageContext.request.contextPath}/Home'><img src="resources/images/logo-prova.jpg" alt="logo"  height="50px"></img></a>
					</div>
				
					<nav>
						<ul>
							<c:forEach  items="${categorie}" var="categoria">
								<li>
									<a href='${pageContext.request.contextPath}/Ricerca?categoria=${categoria.nome}'>${categoria.nome}</a>
								</li>
							</c:forEach>
						</ul>
					</nav>
					
				
				</div>
			
			
				<div id="right">
				
				
					<div id="barra-ricerca">
				
						<form action='${pageContext.request.contextPath}/Ricerca' method="get">
							<input type="text" class="search-bar" name="search" placeholder="Cerca prodotti" size="60">
							<i  class="fa fa-search search-icon grey-action-icon"></i>
						</form>
					
					</div>
				
				
					<div id="pulsanti">
					
						<div id="cart" class="pulsante">
							<a href='${pageContext.request.contextPath}/Carrello'><i class="fa fa-cart-shopping action-icon"></i></a>
						</div>
						
						<div id="user" class="pulsante">
							<a href='${pageContext.request.contextPath}/Utente'><i class="fa fa-solid fa-user fa-3x action-icon"></i></a>
						</div>
						
					</div>
				
				</div>
			
			
			</header>
		
		
		</body>
		
</html>