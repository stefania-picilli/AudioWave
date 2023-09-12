<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
	<head>
		<link rel="stylesheet" href="resources/styles/form.css" type="text/css" > 
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<link rel="stylesheet" href="resources/styles/ordine.css" type="text/css" >
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Inserisci dettagli ordine</title>
	</head>
	
	<body>

		<jsp:include page="/WEB-INF/views/common/header.jsp"/>

		<div id="content">
				
				<div id="ordine-top">
					<h1>Dettagli ordine</h1>
					<p>Inserisci i seguenti dati per completare l'ordine</p>
				</div>
				
				<div id="ordine-center">
				
					<div id="input-box" class="box">
					
						<div id="form-data">
					
							<form action="Ordine" method="POST">
						
								<div id="dettagli">
								
									<div id="indirizzo" class="form-item">
										
										<label for="indirizzo">Indirizzo:</label>
										<input type="text" name="indirizzo" placeholder="Inserire Via/Corso/Piazza, Numero civico, CAP, Città, Provincia" class="box">
										
										<div></div>
									
									</div>
								
									<div id="carta" class="form-group">
									
										<div id="indirizzo" class="form-item">
											<label for="numero">Numero Carta:</label>
											<input type="text" name="numero" placeholder="xxxxxxxxxxxxx" class="box">
											
											<div></div>
											
										</div>
									
										<div id="intestatario" class="form-item">
											<label for="intestatario">Intestatario:</label>
											<input type="text" name="intestatario" placeholder="Luca Bianchi" class="box">
											
											<div></div>
											
										</div>
									
										<div id="scadenza" class="form-item">
											<label for="scadenza">Data di scadenza:</label>
											<input type="text" name="scadenza" placeholder="mm/yy" class="box">
											
											<div></div>
											
										</div>
									
										<div id="cvv" class="form-item">
											<label for="cvv">CVV:</label>
											<input type="text" name="cvv" placeholder="xxx" class="box">
											
											<div></div>
											
										</div>
									
									
									</div>
								
								
								</div>
								
								
								<div id="form-error" class="error-message"></div>
							
								<div id="procedi" class="form-action">
									<input type="submit" value="Procedi" name="procedi" class="cta-button b1">
								</div>
						
							</form>
							
						</div>
				
				
				
					</div>
					
					
					<div id="totale" class="box">
					
					
						<div id="totale-wrap">
					 		
					 		<div class="line-wrap">
					 			<p class="p2 left-item">Importo parziale:</p>
					 			<p class="p2 right-item" id="cellaSubTot">&euro; ----</p>
					 		</div>
					 		
					 		<div class="line-wrap">
					 			<p class="p2">Costo spedizione:</p>
					 			<p class="p2">&euro; ----</p>
					 		</div>
					 		
					 		
					 		
					 		<div class="line"></div>
					 		
					 		
					 		<div class="line-wrap">
					 			<h4>Importo totale:</h4>
					 			<h4 id="cellaTot">&euro; ----</h4>
					 		</div>
					 		
					 		
						 	<div id="acquista-action">
							 	<form action="Ordine" method="POST">
							 		<input type="submit" value="Procedi" class="cta-button b1">
								</form>
						 		
					 		</div>
				 		
				 		
				 		</div>
					
					</div>
					
					
				</div>
		
		</div>


	</body>
</html>