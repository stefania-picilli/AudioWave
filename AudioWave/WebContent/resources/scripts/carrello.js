	
	$(document).ready(function(){
		
		$(".prodotto").each(function(){
			controlloPulsante($(this).attr("id"));
		});
		
		
	});
		
		function controlloPulsante(codice){
			
			if($("#" + codice + " .spanQnt").html() === "1"){
				
				$("#" + codice + " .minus").prop("disabled", true);
				$("#" + codice + " .minus").removeClass("cta-button");
				$("#" + codice + " .minus").addClass("disabled-button");
			
			}else{
				
				$("#" + codice + " .minus").prop("disabled", false);
				$("#" + codice + " .minus").removeClass("disabled-button");
				$("#" + codice + " .minus").addClass("cta-button");
				
			}
				
		}
	
		function addFromProd(codice){
				
				$.ajaxSetup({timeout: 10000});
				var cxt = "/AudioWave";
				
				$.post(cxt + "/Carrello", {"add": codice}, function(data, status){
					
					//elimina div messaggio se già presente
					if($('.message').is(':visible')){
					  	$('.message').fadeOut();
					}
					
					var array = data.messaggi;
					
					if(array.length == 0){
						
						$("#prod-aggiunto").fadeIn();
						setTimeout(() => {
						  $("#prod-aggiunto").fadeOut();
						}, "5000")
						
						
					}else{
						
						$("#prod-non-aggiunto h4").html(array);
						$("#prod-non-aggiunto").fadeIn();
						setTimeout(() => {
						  $("#prod-non-aggiunto").fadeOut();
						}, "5000")
					
					}	
					
				});
				
				
			}
		
		
		function eliminaMess(){
			
			$('.message').fadeOut();
			
		}
		
		
		function add(codice){
				
				$.ajaxSetup({timeout: 10000});
				var cxt = "/AudioWave";
				
				$.post(cxt + "/Carrello", {"add": codice}, function(data, status){
					
					$("#cellaSubTot").html("<p class='p2'>&euro; " + data.subTotale + "</p>");
					$("#cellaTot").html("<h4>&euro; " + data.totale + "</h4>");
					
					var nuovaQuant = parseInt($("#" + codice + " .spanQnt").html()) + data.quantita;
					$("#" + codice + " .spanQnt").html(nuovaQuant);
					
					controlloPulsante(codice);
					
					$("#messaggi").empty();
					
					for(var i = 0; i < data.messaggi.length; i++)
						$("#messaggi").append("<p>" + data.messaggi[i] + "</p>");
				
						
					
					
				});
				
				
			}
			
		function remove(codice){
				
				$.ajaxSetup({timeout: 10000});
				var cxt = "/AudioWave";
				
				$.post(cxt + "/Carrello", {"remove": codice}, function(data, status){
					
					$("#cellaSubTot").html("<p class='p2'>&euro; " + data.subTotale + "</p>");
					$("#cellaTot").html("<h4>&euro; " + data.totale + "</h4>");
					
					var nuovaQuant = parseInt($("#" + codice + " .spanQnt").html()) + data.quantita;
					$("#" + codice + " .spanQnt").html(nuovaQuant);
					
					controlloPulsante(codice);
					
					$("#messaggi").empty();
					
					for(var i = 0; i < data.messaggi.length; i++)
						$("#messaggi").append("<p>" + data.messaggi[i] + "</p>");
					
					
				});
				
				
			}
		
		
		function removeAll(codice){
		
			$.ajaxSetup({timeout: 10000});
			var cxt = "/AudioWave";
			
			$.post(cxt + "/Carrello", {"removeAll": codice}, function(data, status){
				
				$("#cellaSubTot").html("&euro; " + data.subTotale);
				$("#cellaTot").html("&euro; " + data.totale);
				
				$("#" + codice).remove();
				
				if($("#prodotti .prodotto").length == 0){
					
					$("#totale").empty();
					$("#totale").html("Carrello ancora vuoto");
					
				}
				
				controlloPulsante(codice);
			
				$("#messaggi").empty();
					
				for(var i = 0; i < data.messaggi.length; i++)
					$("#messaggi").append("<p>" + data.messaggi[i] + "</p>");
				
			});
			
			
		}
		
	
	