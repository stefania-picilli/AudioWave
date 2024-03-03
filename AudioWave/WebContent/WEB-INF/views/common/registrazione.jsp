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
		
						<form class="form-val" method="POST" action="Registrazione">
				
							<div id="auth-info" class="form-group">
							
							
								<div class="form-group">
						
								<div id="nome" class="form-item">
								
									<label for="nome" class="p3">Nome:</label>
									<input type="text" name="nome" placeholder="Luca" class="box p2">
									
									<div></div>
								
								</div>
								
								<div id="cognome" class="form-item">
								
									<label for="cognome" class="p3">Cognome:</label>
									<input type="text" name="cognome" placeholder="Bianchi" class="box p2">
									
									<div></div>
								
								</div>
						
							</div>
						
								<div id="email" class="form-item">
							
									<label for="email" class="p3">Email:</label>
									<input type="text" name="email" id="email" placeholder="luca.bianchi@example.com" class="box p2">
									
									<div></div>
							
								</div>
								
								<div id="password" class="form-item">
								
									<label for="password" class="p3">Password:</label>
									<input type="password" name="password" id="password" placeholder="**********" class="box p2">
									
									<div></div>
								
								</div>
						
							</div>
			
					
							<div class="form-group">
					
								<div id="nascita" class="form-item">
							
									<label for="nascita" class="p3">Data di nascita:</label>
									<input type="date" name="nascita" class="box p2">
									
									<div></div>
							
								</div>
							
							
								<div id="cellulare" class="form-item">
							
									<label for="cellulare" class="p3">Cellulare:</label>
									<input type="text" name="cellulare" placeholder="000 000 0000" class="box p2">
									
									<div></div>
							
								</div>
					
							</div>
							
							
							<div id="form-error" class="error-message">
							
								<% if(request.getAttribute("messaggio") != null){ %>
							
									<i class='fas fa-exclamation-triangle'></i> <%= request.getAttribute("messaggio") %>

								<%} %>
							
							
							</div>
			
							
							
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