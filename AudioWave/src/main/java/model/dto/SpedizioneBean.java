package model.dto;

public class SpedizioneBean {

	private String idSpedizione;
	private String corriere;
	private String dataPartenza;
	private String dataArrivo;
	private int numeroOrdine;
	
	public String getIdSpedizione() {
		return idSpedizione;
	}
	public void setIdSpedizione(String idSpedizione) {
		this.idSpedizione = idSpedizione;
	}
	public String getCorriere() {
		return corriere;
	}
	public void setCorriere(String corriere) {
		this.corriere = corriere;
	}
	public String getDataPartenza() {
		return dataPartenza;
	}
	public void setDataPartenza(String dataPartenza) {
		this.dataPartenza = dataPartenza;
	}
	public String getDataArrivo() {
		return dataArrivo;
	}
	public void setDataArrivo(String dataArrivo) {
		this.dataArrivo = dataArrivo;
	}
	public int getNumeroOrdine() {
		return numeroOrdine;
	}
	public void setNumeroOrdine(int numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}
	@Override
	public String toString() {
		return "SpedizioneBean [idSpedizione=" + idSpedizione + ", corriere=" + corriere + ", dataPartenza="
				+ dataPartenza + ", dataArrivo=" + dataArrivo + ", numeroOrdine=" + numeroOrdine + "]";
	}
	
	
	
	
	
}
