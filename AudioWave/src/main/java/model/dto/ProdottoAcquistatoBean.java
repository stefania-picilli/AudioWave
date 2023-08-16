package model.dto;

public class ProdottoAcquistatoBean {

	private int id;
	private int numeroOrdine;
	private String nome;
	private String marca;
	private String immagine;
	private double prezzo;
	private double iva;
	private int quantita;
	private int codiceProdotto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumeroOrdine() {
		return numeroOrdine;
	}
	public void setNumeroOrdine(int numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public int getCodiceProdotto() {
		return codiceProdotto;
	}
	public void setCodiceProdotto(int codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}
	
	
	public double getPrezzoConIva() {
		
		double totale = ((prezzo * iva) / 100) + prezzo;
		
		return (double) Math.round(totale * 100) / 100;
		
	}
	
	
	
	public String toString() {
		
		return getClass().getName() + "[id=" + id + ",numeroOrdine=" + numeroOrdine + ",nome=" + nome + ",marca=" + marca + ",prezzo=" + prezzo + ",iva=" + iva + ",quantita=" + quantita + ",codiceProdotto=" + codiceProdotto + "]";
		
	}
	
	
	
}
