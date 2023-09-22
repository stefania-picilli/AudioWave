$(document).ready(function(){
	
	$("#ordini tr").mouseover(function() { 
	    
	    $(this).removeClass("box");
	    $(this).addClass("box-hover");
	    
	});
	
	$("#ordini tr").mouseleave(function() { 
	    
	    $(this).removeClass("box-hover");
	    $(this).addClass("box");
	    
	});
		
});

function tableRowClickU(numeroOrdine){
	window.location = "DettagliOrdine?action=visualizza&num=" + numeroOrdine;
}

function tableRowClickA(numeroOrdine){
	window.location = "Amministratore?action=v-ordine&num=" + numeroOrdine;
}