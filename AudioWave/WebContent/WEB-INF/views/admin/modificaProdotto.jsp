<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="it">
	<head>
		<link rel="stylesheet" href="resources/styles/form.css" type="text/css" > 
		<link rel="stylesheet" href="resources/styles/application.css" type="text/css" >
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Modifica prodotto</title>
	</head>
	<body>

		<jsp:include page="header.jsp"/>
		
		<div id="content">
		
			<div id="form-container" class="box">
		
				<div id="form-wrap">
			
					<div id="info-form">
						<h1>Modifica prodotto</h1>
						<p class="p1">Modifica i campi del prodotto</p>
					</div>
					
					<div id="form-data">
			
						<form action="Amministratore" method="POST" enctype="multipart/form-data">
							
							<div id="nome-prod" class="form-item">
								
								<label for="nome" class="p3">Nome prodotto:</label>
								<input type="text" name="nome" placeholder="Nome" value="${prodotto.nome}" class="box">
								
								<div></div>
								
							</div>
							
							<div id="marca" class="form-item">
								
								<label for="marca" class="p3">Marca:</label>
								<input type="text" name="marca" placeholder="Marca" value="${prodotto.marca}" class="box">
								
								<div></div>
								
							</div>
						
							<div id="descrizione" class="form-item">
								
								<label for="descrizione" class="p3">Descrizione prodotto:</label>
								<textarea name="descrizione" placeholder="Descrizione" rows="10" class="box">${prodotto.descrizione}</textarea>
								
								<div></div>
								
							</div>
							
							
							<div id="immagineMod" class="form-item">
								
								<label for="immagine" class="p3">Immagine prodotto:</label>
								<input type="file" name="immagine" value="${prodotto.immagine}" class="box">
								
								<div></div>
								
							</div>
							
							<div id="tag" class="form-item">
								
								<label for="tag" class="p3">Tag prodotto:</label>
								<textarea name="tag" placeholder="tag1, tag2, tag3, ..." rows="3" class="box">${prodotto.tag}</textarea>
								
								<div></div>
								
							</div>
							
							<div id="categoria" class="form-item">
								
								<label for="categoria" class="p3">Categoria prodotto:</label>
								<select name="categoria" class="box">
								
									<c:forEach  items="${categorie}" var="categoria">
										<option value="${categoria.id}">${categoria.nome}</option>
									</c:forEach>
								
								</select>
								
								<div></div>
								
							</div>
							
							<div id="prezzo" class="form-item">
								
								<label for="prezzo" class="p3">Prezzo prodotto (in Euro):</label>
								<input type="text" name="prezzo" placeholder="00.00" value="${prodotto.prezzo}" class="box">
								
								<div></div>
								
							</div>
							
							<div id="iva" class="form-item">
								
								<label for="iva" class="p3">IVA prodotto (%):</label>
								<input type="text" name="iva" placeholder="00.00" value="${prodotto.iva}" class="box">
								
								<div></div>
								
							</div>
							
							<div id="disponibilita" class="form-item">
								
								<label for="disponibilita" class="p3">Disponibilità prodotto:</label>
								<input type="number" name="disponibilita" placeholder="00" min=0 value="${prodotto.disponibilita}" class="box">
								
								<div></div>
								
							</div>
							
							<div id="form-error" class="error-message"></div>
							
							<input type="hidden" name="id" value="${prodotto.codiceProdotto}">
							<input type="hidden" name="action" value="m-prodotto">
							
							<div class="form-action">
								<input type="submit" value="Applica modifiche" class="cta-button">
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