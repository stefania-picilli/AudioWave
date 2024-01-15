<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
	<head>
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/form.css" type="text/css" > 
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Registrati</title>
	</head>
	
	<body>
		
		 <jsp:include page="header.jsp"/>
		
		<div id="content">
		
			<div id="form-container" class="box">
		
				<div id="form-wrap">
			
			
					<div id="info-form">
						<h1>Registrati</h1>
						<p class="p1">Inserisci le tue informazioni</p>
					</div>
		
					<div id="form-data">
		
						<form method="POST" action="Registrazione">
				
							<div id="auth-info" class="form-group">
							
							
								<div class="form-group">
						
								<div id="nome" class="form-item">
								
									<label for="nome">Nome:</label>
									<input type="text" name="nome" placeholder="Luca" class="box">
									
									<div></div>
								
								</div>
								
								<div id="cognome" class="form-item">
								
									<label for="cognome">Cognome:</label>
									<input type="text" name="cognome" placeholder="Bianchi" class="box">
									
									<div></div>
								
								</div>
						
							</div>
						
								<div id="email" class="form-item">
							
									<label for="email">Email:</label>
									<input type="text" name="email" id="email" placeholder="luca.bianchi@example.com" class="box">
									
									<div></div>
							
								</div>
								
								<div id="password" class="form-item">
								
									<label for="password">Password:</label>
									<input type="password" name="password" id="password" placeholder="**********" class="box">
									
									<div></div>
								
								</div>
						
							</div>
			
					
							<div class="form-group">
					
								<div id="nascita" class="form-item">
							
									<label for="nascita">Data di nascita:</label>
									<input type="date" name="nascita" class="box">
									
									<div></div>
							
								</div>
							
							
								<div id="cellulare" class="form-item">
							
									<label for="cellulare">Cellulare:</label>
									<input type="text" name="cellulare" placeholder="000 000 0000" class="box">
									
									<div></div>
							
								</div>
					
							</div>
							
							<% if(request.getAttribute("messaggio") != null){ %>
								<div class="error-message">
									<%= request.getAttribute("messaggio") %>
								</div>
							<%} %>
							
							<div id="form-error" class="error-message"></div>
			
							
							
							<div class="form-action">
								<input type="submit" value="Registrati" class="cta-button b1">
							</div>
			
			
						</form>
						
					</div>
			
				</div>

			</div>

		</div>
		
		<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

		<script src="resources/scripts/jquery.js"></script>
		<script src="resources/scripts/form.js"></script>

	</body>
	
</html>