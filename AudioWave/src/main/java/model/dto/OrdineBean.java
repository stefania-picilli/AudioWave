package model.dto;

public class OrdineBean {

	private int numeroOrdine;
	private String data;
	private String indirizzo;
	private String statoOrdine;
	private double costoTotale;
	private String metodoPagamento;
	private String email;
	
	
	public int getNumeroOrdine() {
		return numeroOrdine;
	}
	public void setNumeroOrdine(int numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getStatoOrdine() {
		return statoOrdine;
	}
	public void setStatoOrdine(String statoOrdine) {
		this.statoOrdine = statoOrdine;
	}
	public double getCostoTotale() {
		return costoTotale;
	}
	public void setCostoTotale(double costoTotale) {
		this.costoTotale = costoTotale;
	}
	public String getMetodoPagamento() {
		return metodoPagamento;
	}
	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		
		return getClass().getName() + "[numeroOrdine=" + numeroOrdine + ",data=" + data + ",indirizzo=" + indirizzo + ",statoOrdine=" + statoOrdine + "costoTotale=" + costoTotale + ",metodoPagamento=" + metodoPagamento + ",email=" + email+ "]";
		
	}
	
}
