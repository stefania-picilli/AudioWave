


$(document).ready(function(){
	
	$("#form-data form").submit(function(){
		
		//se tutte le classi sono 'valid-input' allora i dati vengono inviati al server
		
		let items = $(".form-item :input");
		let valid = true;
		
		items.each(function(){
			
			if(!$(this).hasClass("valid-input")){
				
				$(this).trigger("change");
				
				if(!$(this).hasClass("valid-input"))
					valid = false;
					
			}
	
		});
		
		if(!valid)
			$("#form-error").html("<i class='fas fa-exclamation-triangle'></i> I dati inseriti non sono validi");
		else
			$("#form-error").html("");
		
		
		return valid;
		
	});
	
	
	function validInput(item){
		
		let divError = $(item).parent().children("div");
		
		$(item).removeClass("invalid-input");
		$(item).removeClass("box");
		$(item).removeClass("focus-input");
		$(item).addClass("valid-input");
			
		$(divError).removeClass("error-message");
		$(divError).html("");
		
	}
	
	function invalidInput(item, errorMessage){
		
		let divError = $(item).parent().children("div");
		
		$(item).removeClass("valid-input");
		$(item).removeClass("box");
		$(item).removeClass("focus-input");
		$(item).addClass("invalid-input");
			
		$(divError).addClass("error-message");
		$(divError).html("<i class='fas fa-exclamation-triangle'></i>  " + errorMessage);
		
		
	}
	
	function validateFormItem(item, regex, errorMessage){
		
		let value = $(item).val();
		value = value.trim();
		$(item).val(value);
		
		if(value.match(regex))
			validInput(item);
		else
			invalidInput(item, errorMessage);
		
	}
	
	
	function controlloDate(data1, data2, item, message){
		
		if(data1 <= data2)
			validInput(item);
		else
			invalidInput(item, message);
		
	}
	
	function controlloImmagine(item, message){
		
		let filePath = $(item).val();
        let allowedExtensions = /(\.jpg|\.jpeg|\.png)$/i;
        
        if (!allowedExtensions.exec(filePath))
			invalidInput(item, message);
		else
			validInput(item);
		
	}
	
	
	
	/*Registrazione */
	$("#email input").change(function(){
		validateFormItem(this, /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/, "Inserire una e-mail valida. Il formato dell'email non &egrave; valido")
	});
	
	$("#password input").change(function(){ 
		validateFormItem(this, /^(?=.*\d)(?=.*[!@#$%^&*?+-])(?=.*[a-z])(?=.*[A-Z]).{8,}$/, "La password deve contenere almeno 8 caratteri, almeno una lettera maiuscola e una lettera minuscola, almeno un numero e almeno un carattere speciale")
	});
	
	$("#nascita input").change(function(){
		
		if(!$(this).val()){
			invalidInput(this, "Inserire una data di nascita valida");
		}else{
			
			//controlla se maggiorenne
			let dataAttuale = new Date();
			let data = new Date(dataAttuale.getFullYear() - 18, dataAttuale.getMonth(), dataAttuale.getDate());
			let dataItem = new Date($(this).val())
			
			controlloDate(dataItem, data, this, "Inserire una data di nascita valida. Per registrarsi bisogna essere maggiorenni");
				
		}
		
		
	});
	
	$("#nome input").change(function(){
		validateFormItem(this, /^[A-z ',.-]+$/, "Inserire un nome valido. Il nome non pu&ograve; contenere numeri o caratteri speciali")
	});
	
	$("#cognome input").change(function(){
		validateFormItem(this, /^[A-z ',.-]+$/, "Inserire un cognome valido. Il cognome non pu&ograve; contenere numeri o caratteri speciali")
	});
	
	$("#cellulare input").change(function(){
		validateFormItem(this, /^([0-9]{3})([-.\s]?)([0-9]{3})([-.\s]?)([0-9]{4})$/, "Inserire un numero di cellulare valido (formato: 000 000 0000)")
	});


	/*Ordine utente*/
	$("#indirizzo input").change(function(){
		validateFormItem(this, /^[A-z0-9',.-\s]+$/, "Inserire un indirizzo valido. L'indirizzo non pu&ograve; contenere caratteri speciali")
	});
	
	$("#carta input").change(function(){
		validateFormItem(this, /^[0-9]{13,16}$/, "Inserire un numero di carta valido. Esso pu&ograve; avere dalle 13 alle 16 cifre")
	});
	
	$("#intestatario input").change(function(){
		validateFormItem(this, /^[A-z\s',.-]+$/, "Inserire un intestatario valido. Esso non pu&ograve; contenere numeri o caratteri speciali")
	});
	
	$("#scadenza input").change(function(){
		
		//?????
		
		if(!($(this).val().match(/^(0|1|\s)([0-9])([-|/])([0-9]{2})$/))){
		
			invalidInput(this, "Inserire una data di scadenza valida (formato: MM/YY)");
			
		}else{
				
			validInput(this);
				
		}
		
	});
	
	$("#cvv input").change(function(){
		validateFormItem(this, /^[0-9]{3}$/, "Inserire un CVV valido. Il CVV deve contenere 3 cifre")
	});
	
	
	/*CreaProdotto / ModificaProdotto */
	$("#nome-prod input").change(function(){
		validateFormItem(this, /^[A-z0-9',.-\s]+$/, "Inserire un nome valido. Il nome del prodotto non pu&ograve; contenere caratteri speciali")
	});
	
	$("#marca input").change(function(){
		validateFormItem(this, /^[A-z0-9',.-\s]+$/, "Inserire una marca valida. La marca non pu&ograve; contenere caratteri speciali")
	});
	
	$("#descrizione textarea").change(function(){
		validateFormItem(this, /^.{1,1500}$/, "Inserire una descrizione valida. Essa non pu&ograve; contenere pi&ugrave; di 1500 caratteri")
	});
	
	$("#immagine input").change(function(){
		
		controlloImmagine(this, "Inserire un'immagine valida (formati accettati: jpg, jpeg, png)");
        
	});
	
	$("#immagineMod input").change(function(){
		
		
		if(this.files.length != 0){
		
			controlloImmagine(this, "Inserire un'immagine valida (formati accettati: jpg, jpeg, png)");
		
		}else 
			validInput(this);
        
	});
	
	$("#tag textarea").change(function(){
		validateFormItem(this, /^[A-z0-9',.-\s]+$/, "Inserire lista di tag validi (formato: tag1, tag2, ...)")
	});
	
	$("#categoria select").change(function(){
		validInput(this);
	});
	
	$("#prezzo input").change(function(){
		validateFormItem(this, /^([0-9]+)(.([0-9]{1,2}))?$/, "Inserire un prezzo valido (formato: 00.00)")
	});
	
	$("#iva input").change(function(){
		validateFormItem(this, /^([0-9]+)(.([0-9]{1,2}))?$/, "Inserire IVA valida (formato: 00.00)")
	});
	
	$("#disponibilita input").change(function(){
		validateFormItem(this, /^[0-9]+$/, "Inserire un valore numerico intero")
	});
	
	
	
	/*Ordine admin */
	$("#corriere input").change(function(){
		validateFormItem(this, /^[A-z0-9',.-\s]+$/, "Inserire un corriere valido. Esso non pu&ograve; contenere caratteri speciali")
	});
	
	$("#data-partenza input").change(function(){
		
		if(!$(this).val()){
			invalidInput(this, "Inserire una data di partenza valida");
		}else
			validInput(this);
		
	});
	
	$("#data-arrivo input").change(function(){
		
		let dataArr = $(this).val();
		let dataPart = $("#data-partenza input").val(); 
		
		let message = "Inserire una data stimata di arrivo valida. Essa non pu&ograve; essere precedente la data di partenza";
		
		if(!$(this).val()){
			invalidInput(this, message);
		}else
			controlloDate(dataPart, dataArr, this, message);
	
	});
	
	
	//Focus
	
	$(".form-item input, .form-item textarea").focus(function(){
		
		$(this).removeClass("invalid-input");
		$(this).removeClass("box");
		$(this).removeClass("valid-input");
		$(this).addClass("focus-input");
		
	});
	
	$(".form-item input, .form-item textarea").focusout(function(){
		
		$(this).trigger("change");
		
	});
	
	
})