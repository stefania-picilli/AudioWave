package model.dto;

import java.util.LinkedList;
import java.util.List;

public class CarrelloBean {

	private List<ProdottoNelCarrelloBean> prodotti;
	private double totale;
	
	public static final float COSTO_SPEDIZIONE = 5;
	
	public CarrelloBean(){
		
		prodotti = new LinkedList<>();
		totale = 0;
		
	}

	
	public List<ProdottoNelCarrelloBean> getProdotti() {
		return prodotti;
	}
	
	public double getTotale() {
		
		return (double) Math.round(totale * 100) / 100;
		
	}
	
	
	public double getTotaleConSpedizione() {
		
		return (double) Math.round((totale + COSTO_SPEDIZIONE) * 100) / 100;
		
	}

	public boolean isEmpty() {
		
		return prodotti.isEmpty();
		
	}
	
	
	public boolean add(ProdottoBean prodotto) {
		
		System.out.println("Carrello prima: " + this.prodotti);
		System.out.println("Nome prodotto=" + prodotto.getNome() + ", Disp prodotto=" + prodotto.getDisponibilita());
		
		if(prodotto.getDisponibilita() <= 0)
			return false;
		
		
		int index = getIndex(prodotto.getCodiceProdotto());
		
		if(index < 0) {
			
			//se prodotto non ancora presente nel carrello
			ProdottoNelCarrelloBean prodottoC = new ProdottoNelCarrelloBean();
			prodottoC.setProdotto(prodotto);
			prodottoC.setQuantita(1);
			prodotti.add(prodottoC);
			
		}else {
			
			//se i dati del prodotto sono stati modificati, si aggiorna il bean presente nel carrello
			if(!prodotto.equals(prodotti.get(index).getProdotto())) {
				
				ProdottoNelCarrelloBean prodottoC = new ProdottoNelCarrelloBean();
				prodottoC.setProdotto(prodotto);
				int quant = prodotti.get(index).getQuantita();
				prodottoC.setQuantita(quant);
				prodotti.set(index, prodottoC);
				
			}
			
			
			int quantita = prodotti.get(index).getQuantita();
			
			//se disponibita' ok, incrementa quantita'
			if(prodotti.get(index).getQuantita() < prodotti.get(index).getProdotto().getDisponibilita())
				prodotti.get(index).setQuantita(quantita + 1);
			else
				return false;
			
		}
		
		
		calcolaTotale();
		
		System.out.println("Carrello dopo: " + this.prodotti);
		return true;
		
	}
	
	
	public boolean remove(int codiceProdotto) {
		
		int index = getIndex(codiceProdotto);
		
		if(index < 0)
			return false;
		
		int quantita = prodotti.get(index).getQuantita();
	
		if(quantita > 1) {
			
			prodotti.get(index).setQuantita(quantita - 1);
			calcolaTotale();
			return true;
			
		}else
			return false;
		
	}
	
	
	public boolean removeAll(int codiceProdotto) {
		
		int index = getIndex(codiceProdotto);
		
		if(index < 0)
			return false;
			
		prodotti.remove(getIndex(codiceProdotto));
		calcolaTotale();
		return true;
			
		
		
	}
	
	
	public void calcolaTotale() {
		
		totale = 0;
		
		for(ProdottoNelCarrelloBean prod : prodotti) 
			totale += prod.getProdotto().getPrezzoConIva() * prod.getQuantita(); 
			
		//arrotonda il totale a due cifre decimali 
		totale = (double) Math.round(totale * 100) / 100;
		
	}
	
	
	public int getIndex(int codiceProdotto) {
		
		for(int i = 0; i < prodotti.size(); i++) {
			
			if(prodotti.get(i).getProdotto().getCodiceProdotto() == codiceProdotto)
				return i;
			
		}
		
		return -1;
		
	}            
	
	
	public void svuota() {
		
		prodotti = new LinkedList<>();
		totale = 0;
		
	}
	
	
	
	
}
