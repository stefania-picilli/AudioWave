
$(document).ready(function(){	
	

	
});


	function filtraProd(){
		
		var categoriaID = $('#categoria-fil').find(":selected").val();
		
		var prezzoDa = $('#prezzo-da').val();
		var prezzoA = $('#prezzo-a').val();
		
		prezzoDa = Number(prezzoDa);
		prezzoA = Number(prezzoA);
		
		
		console.log("categoriaID=" + categoriaID);
		console.log("prezzoDa=" + prezzoDa + ",prezzoA=" + prezzoA);
		
		$(".prodotto").each(function(){
			
			var itemCategoria = $(this).find(".categoria-hidd").text();
			var itemPrezzo =  $(this).find(".prezzo-hidd").text();
			
			itemPrezzo = Number(itemPrezzo);
			
			if(categoriaID == null){
				
				
				console.log("si");
				
				if(itemPrezzo >= prezzoDa && itemPrezzo <= prezzoA){
					$(this).show();
				}else{
					$(this).hide();
				}
				
			}else{
				
				console.log("no");
				
				if(((itemCategoria == categoriaID) || (categoriaID == "Tutte")) && (itemPrezzo >= prezzoDa && itemPrezzo <= prezzoA)){
					$(this).show();
					console.log("itemPrezzo >= prezzoDa=" + (itemPrezzo >= prezzoDa) + "itemPrezzo <= prezzoA=" + (itemPrezzo <= prezzoA));
					console.log(itemPrezzo + " >= " + prezzoDa + " = " + (itemPrezzo >= prezzoDa) + ", " + itemPrezzo + " <= " +  prezzoA + "=" + (itemPrezzo <= prezzoA));
					console.log("primo. itemCategoria=" + itemCategoria + ", itemPrezzo=" + itemPrezzo + " prezzoDa=" + prezzoDa + ",prezzoA=" + prezzoA);
				}else{
					$(this).hide();
					console.log("itemPrezzo maggiore di prezzoDa=" + (itemPrezzo >= prezzoDa) + "itemPrezzo minore di prezzoA=" + (itemPrezzo <= prezzoA));
					console.log(itemPrezzo + " >= " + prezzoDa + " = " + (itemPrezzo >= prezzoDa) + ", " + itemPrezzo + " <= " +  prezzoA + "=" + (itemPrezzo <= prezzoA));
					console.log("secondo. itemCategoria=" + itemCategoria + ", itemPrezzo=" + itemPrezzo + " prezzoDa=" + prezzoDa + ",prezzoA=" + prezzoA);
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
	