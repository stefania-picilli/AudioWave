
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
				
			}else{
				
				if(((itemCategoria == categoriaID) || (categoriaID == "Tutte")) && (itemPrezzo >= prezzoDa && itemPrezzo <= prezzoA)){
					$(this).show();
				}else{
					$(this).hide();
				}
				
				
			}
			
			
		});
		
	
		
	}
	
	
	function filtraOrdini(){
		
		var utente = $('#utente-fil').find(":selected").val();
		
		var dataDa = Date.parse($('#data-da').val());
		var dataA = Date.parse($('#data-a').val());
		
		$(".ordine-row").each(function(){
			
			var itemUtente = $(this).find(".utente-ord").html();
			var itemData =  Date.parse($(this).find(".data-ord a").html());
			
			
			if((utente === itemUtente || utente == "Tutti") && (itemData >= dataDa && itemData <= dataA)){
				$(this).show();
			}else{
				$(this).hide();
			}
			
		});
		
	}
	