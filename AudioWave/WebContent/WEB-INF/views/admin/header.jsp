<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="resources/styles/header-admin.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Insert title here</title>
	</head>
	<body>
		
		<header>


			

				<!-- <div id="left-header">-->

					<div id="logo">
						<a href='${pageContext.request.contextPath}/Amministratore?action=v-prodotti'><img src="resources/images/logo-prova.jpg" alt="logo" height="50px"></img></a>
					</div>
						
						
					<nav id="header-nav">
						<ul>
							<li><a href='${pageContext.request.contextPath}/Amministratore?action=v-prodotti'>Prodotti</a></li>
							<li><a href='${pageContext.request.contextPath}/Amministratore?action=v-ordini'>Ordini</a></li>
						</ul>
					</nav>
				
				
				<!-- </div>-->
				
					
				<div id="pulsante-header">
					<button onclick='location.href="<%=request.getContextPath()%>/Logout?action=logout"' class="cta-button b2" type="button">Logout</button>
				</div>
				
				
				<div id="barra-ricerca">
					<form action='${pageContext.request.contextPath}/Ricerca' method="get">
						<input type="hidden" name="admin" value="true">
						<input type="text" name="search" class="search-bar" placeholder="Barra di ricerca" size="60">
						<i  class="fa fa-search search-icon grey-action-icon"></i>
					</form>
				</div>
			

		</header>

	</body>
</html>