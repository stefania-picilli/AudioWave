package model.dto;

public class ProdottoBean {

	private int codiceProdotto;
	private String nome;
	private String marca;
	private String descrizione;
	private String tag;
	private String immagine;
	private double prezzo;
	private double iva;
	private int disponibilita;
	private int categoriaID;
	
	
	
	public ProdottoBean() {
		
		
		
	}
	
	public void setCodiceProdotto(int num) {
		
		codiceProdotto = num;
		
	}
	
	public void setNome(String str) {
		
		nome = str;
		
	}
	
	public void setMarca(String str) {
		
		marca = str;
		
	}
	
	public void setDescrizione(String str) {
		
		descrizione = str;
		
	}
	
	public void setTag(String str) {
		
		tag = str;
		
	}
	
	
	public void setImmagine(String str) {
		
		immagine = str;
		
	}
	
	
	public void setPrezzo(double fl) {
		
		prezzo = fl;
		
	}
	
	public void setIva(double fl) {
		
		iva = fl;
		
	}
	
	public void setDisponibilita(int n) {
		
		disponibilita = n;
		
	}
	
	public void setCategoriaID(int n) {
		
		categoriaID = n;
		
	}
	
	
	public int getCodiceProdotto() {
		
		return codiceProdotto;
		
	}
	
	public String getNome() {
		
		return nome;
		
	}
	
	public String getMarca() {
		
		return marca;
		
	}
	
	public String getDescrizione() {
		
		return descrizione;
		
	}
	
	public String getTag() {
		
		return tag;
		
	}
	
	public String getImmagine() {
		
		return immagine;
		
	}
	
	public double getPrezzo() {
		
		return prezzo;
		
	}
	
	public double getIva() {
		
		return iva;
		
	}
	
	public double getPrezzoConIva() {
		
		return (double) Math.round((((prezzo * iva) / 100) + prezzo) * 100) / 100;
		//return ((prezzo * iva) / 100) + prezzo;
	}
	
	public int getDisponibilita() {
		
		return disponibilita;
		
	}
	
	public int getCategoriaID() {
		
		return categoriaID;
		
	}
	
	
	public String toString() {
		return "ProdottoBean [codiceProdotto=" + codiceProdotto + ", nome=" + nome + ", marca=" + marca
				+ ", descrizione=" + descrizione + ", tag=" + tag + ", immagine=" + immagine + ", prezzo=" + prezzo
				+ ", iva=" + iva + ", disponibilita=" + disponibilita + ", categoriaID=" + categoriaID + "]";
	}
	
	
	
}
