<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="resources/styles/form.css" type="text/css" > 
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Inserisci dati relativi al prodotto</title>
	</head>
	<body>
	
		<jsp:include page="header.jsp"/>
		
		<div id="content">
	
			<div id="form-container" class="box">
	
				<div id="form-wrap">
				
					<div id="info-form">
						<h1>Aggiungi prodotto</h1>
						<p>Inserisci i dati del prodotto</p>
					</div>
					
					
					<div id="form-data">
					
						<form action="Amministratore" method="POST" enctype="multipart/form-data">
						
							<div id="nome-prod" class="form-item">
								
								<label for="nome" class="p3">Nome prodotto:</label>
								<input type="text" name="nome" placeholder="Nome" class="box">
								
								<div></div>
								
							</div>
							
							<div id="marca" class="form-item">
								
								<label for="marca" class="p3">Marca:</label>
								<input type="text" name="marca" placeholder="Marca" class="box">
								
								<div></div>
								
							</div>
						
							<div id="descrizione" class="form-item">
								
								<label for="descrizione" class="p3">Descrizione prodotto:</label>
								<textarea name="descrizione" rows="10"  placeholder="Descrizione" class="box"></textarea>
								
								<div></div>
								
							</div>
							
							
							<div id="immagine" class="form-item">
								
								<label for="immagine" class="p3">Immagine prodotto:</label>
								<input type="file" name="immagine" class="box">
								
								<div></div>
								
							</div>
							
							
							<div id="tag" class="form-item">
								
								<label for="tag" class="p3">Tag prodotto:</label>
								<input type="text" name="tag" value="${prodotto.tag}" placeholder="tag1, tag2, tag3, ..." class="box">
								
								<div></div>
								
							</div>
							
							
							<div id="categoria" class="form-item">
								
								<label for="categoria" class="p3">Categoria prodotto:</label>
								<select name="categoria" class="box" class="valid-input">
								
									<c:forEach  items="${categorie}" var="categoria">
										<option value="${categoria.id}">${categoria.nome}</option>
									</c:forEach>
								
								</select>
								
								<div></div>
								
							</div>
							
							<div id="prezzo" class="form-item">
								
								<label for="prezzo" class="p3">Prezzo prodotto (in Euro):</label>
								<input type="text" name="prezzo" placeholder="00.00" class="box">
								
	 							<div></div>
								
							</div>
							
							<div id="iva" class="form-item">
								
								<label for="iva" class="p3">IVA prodotto (%):</label>
								<input type="text" name="iva" placeholder="00.00" class="box">
								
								<div></div>
								
							</div>
							
							<div id="disponibilita" class="form-item">
								
								<label for="disponibilita" class="p3">Disponibilità  prodotto:</label>
								<input type="number" name="disponibilita" placeholder="00" min=0 class="box">
								
								<div></div>
								
							</div>
							
							<div id="form-error" class="error-message"></div>
							
							<input type="hidden" name="action" value="c-prodotto">
							
							<div class="form-action">
							
								<input type="submit" value="Aggiungi prodotto" class="cta-button">
							
							</div>
						
						</form>
						
					</div>
					
		
				</div>
	
			</div>
	
		</div>

		

		

	</body>
</html>