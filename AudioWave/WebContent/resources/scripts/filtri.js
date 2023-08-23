
$(document).ready(function(){	
	

	
});


	function filtraProd(){
		
		let categoriaID = $('#categoria-fil').find(":selected").val();
		
		let prezzoDa = $('#prezzo-da').val();
		let prezzoA = $('#prezzo-a').val();
		
		prezzoDa = Number(prezzoDa);
		prezzoA = Number(prezzoA);
		
		
		/*console.log("categoriaID=" + categoriaID);
		console.log("prezzoDa=" + prezzoDa + ",prezzoA=" + prezzoA);*/
		
		$(".prodotto").each(function(){
			
			let itemCategoria = $(this).find(".categoria-hidd").text();
			let itemPrezzo =  $(this).find(".prezzo-hidd").text();
			
			itemPrezzo = Number(itemPrezzo);
			
			if(categoriaID == null){
				
				
				//console.log("si");
				
				if(itemPrezzo >= prezzoDa && itemPrezzo <= prezzoA){
					$(this).show();
				}else{
					$(this).hide();
				}
				
			}else{
				
				//console.log("no");
				
				if(((itemCategoria == categoriaID) || (categoriaID == "Tutte")) && (itemPrezzo >= prezzoDa && itemPrezzo <= prezzoA)){
					$(this).show();
					/*console.log("itemPrezzo >= prezzoDa=" + (itemPrezzo >= prezzoDa) + "itemPrezzo <= prezzoA=" + (itemPrezzo <= prezzoA));
					console.log(itemPrezzo + " >= " + prezzoDa + " = " + (itemPrezzo >= prezzoDa) + ", " + itemPrezzo + " <= " +  prezzoA + "=" + (itemPrezzo <= prezzoA));
					console.log("primo. itemCategoria=" + itemCategoria + ", itemPrezzo=" + itemPrezzo + " prezzoDa=" + prezzoDa + ",prezzoA=" + prezzoA);*/
				}else{
					$(this).hide();
					/*console.log("itemPrezzo maggiore di prezzoDa=" + (itemPrezzo >= prezzoDa) + "itemPrezzo minore di prezzoA=" + (itemPrezzo <= prezzoA));
					console.log(itemPrezzo + " >= " + prezzoDa + " = " + (itemPrezzo >= prezzoDa) + ", " + itemPrezzo + " <= " +  prezzoA + "=" + (itemPrezzo <= prezzoA));
					console.log("secondo. itemCategoria=" + itemCategoria + ", itemPrezzo=" + itemPrezzo + " prezzoDa=" + prezzoDa + ",prezzoA=" + prezzoA);*/
				}
				
				
			}
			
			
		});
		
	
		
	}
	