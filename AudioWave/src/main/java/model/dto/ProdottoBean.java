package model.dto;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(categoriaID, codiceProdotto, descrizione, disponibilita, immagine, iva, marca, nome, prezzo,
				tag);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdottoBean other = (ProdottoBean) obj;
		return categoriaID == other.categoriaID && codiceProdotto == other.codiceProdotto
				&& Objects.equals(descrizione, other.descrizione) && disponibilita == other.disponibilita
				&& Objects.equals(immagine, other.immagine)
				&& Double.doubleToLongBits(iva) == Double.doubleToLongBits(other.iva)
				&& Objects.equals(marca, other.marca) && Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(prezzo) == Double.doubleToLongBits(other.prezzo)
				&& Objects.equals(tag, other.tag);
	}
	
	
	
}
