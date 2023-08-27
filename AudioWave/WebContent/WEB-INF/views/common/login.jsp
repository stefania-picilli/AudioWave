<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="resources/styles/form.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<title>Effettua il login</title>
	</head>
	
	<body>
	
		 <jsp:include page="header.jsp"/>
		
		<div id="content">
		
			<div id="form-container" class="box">
		
				<div id="form-wrap">
				
				<div id="info-form">
					<h1>Login</h1>
					<p class="p1">Inserisci le tue credenziali per accedere</p>
				</div>
					
					
					<div id="form-data">
					
						<form action="Login" method="POST" >
						
							<div class="form-item" id="email">
								<label for="email" class="p3">Email:</label>
								<input type="text" name="email" placeholder="luca.bianchi@example.com" class="box">
								
								<div></div>
								
							</div>
							
							<div class="form-item" id="password-log">
								<label for="password"  class="p3">Password:</label>
								<input type="password" name="password" placeholder="*********" class="box">
								
								<div></div>
							</div>
							
							
							<% if(request.getAttribute("error") != null){ %>
							
								<div class="error-message">
									<%= request.getAttribute("error") %>
								</div>
						
							<%} %>
						
							<div id="form-error" class="error-message"></div>
						
							<input type="hidden" name="path" value="<%= request.getAttribute("path") %>">
							<input type="hidden" name="type" value="<%= request.getAttribute("type") %>">
							
							<div class="form-action">
							
								<input type="submit" value="Accedi" class="cta-button b1">
						
							</div>
						
						</form>
						
					</div>
					
					<%if(request.getAttribute("type").equals("user")){ %>
					
						<p  id="reg-mess" class="p2">
							Non hai un account? <a href="${pageContext.request.contextPath}/Registrazione?path=<%= request.getAttribute("path") %>">Registrati</a> 
						</p>
				
					<%} %>
			
				</div>
				
			</div>
		
		</div>
		
	
		<script src="https://kit.fontawesome.com/2cee596a25.js" ></script>

	</body>
	
</html>