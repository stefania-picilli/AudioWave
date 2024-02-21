<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="resources/styles/form.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
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
						
							<div class="form-item form-item-login" id="email-log">
								<label for="email" class="p3">Email:</label>
								<input type="text" name="email" placeholder="luca.bianchi@example.com" class="box p2">
								
								<div></div>
								
							</div>
							
							<div class="form-item form-item-login" id="password-log">
								<label for="password"  class="p3">Password:</label>
								<input type="password" name="password" placeholder="*********" class="box p2">
								
								<div></div>
							</div>
							
							
							<% if(request.getAttribute("error") != null){ %>
							
								<div class="error-message" id="form-error">
									<i class='fas fa-exclamation-triangle'></i> <%= request.getAttribute("error") %>
								</div>
						
							<%} %>
						
							
							<div class="form-action">
							
								<input type="submit" value="Accedi" class="cta-button b1">
						
							</div>
						
						</form>
						
					</div>
					
					
					<p  id="reg-mess" class="p3">
						Non hai un account? <a href="${pageContext.request.contextPath}/Registrazione">Registrati</a> 
					</p>
				
			
				</div>
				
			</div>
		
		</div>
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
		
		<script src="resources/scripts/jquery.js"></script>
		<script src="resources/scripts/form.js"></script>

	</body>
	
</html>