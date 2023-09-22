
$(document).ready(function(){	
	

	
});


	function filtraProd(){
		
		let categoriaID = $('#categoria-fil').find(":selected").val();
		
		let prezzoDa = $('#prezzo-da').val();
		let prezzoA = $('#prezzo-a').val();
		
		prezzoDa = Number(prezzoDa);
		prezzoA = Number(prezzoA);
		
		
		$(".prodotto").each(function(){
			
			let itemCategoria = $(this).find(".categoria-hidd").text();
			let itemPrezzo =  $(this).find(".prezzo-hidd").text();
			
			itemPrezzo = Number(itemPrezzo);
			
			if(categoriaID == null){
				
				if(itemPrezzo >= prezzoDa && itemPrezzo <= prezzoA){
					$(this).show();
				}else{
					$(this).hide();
				}
				
			}else if(((itemCategoria == categoriaID) || (categoriaID == "Tutte")) && (itemPrezzo >= prezzoDa && itemPrezzo <= prezzoA)){
				$(this).show();
			}else{
				$(this).hide();
			
			}
			
			
		});
		
	
		
	}
	
	
	function filtraOrdini(){
		
		let utente = $('#utente-fil').find(":selected").val();
		
		let dataDa = Date.parse($('#data-da').val());
		let dataA = Date.parse($('#data-a').val());
		
		$(".ordine-row").each(function(){
			
			let itemUtente = $(this).find(".utente-ord").html();
			let itemData =  Date.parse($(this).find(".data-ord").html());
			
			if((utente === itemUtente || utente == "Tutti") && (itemData >= dataDa && itemData <= dataA)){
				$(this).show();
			}else{
				$(this).hide();
			}
			
		});
		
	}
	