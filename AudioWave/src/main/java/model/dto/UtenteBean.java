package model.dto;

public class UtenteBean {
	private String email;
	private String password;
	private String ruolo;
	private String nome;
	private String cognome;
	private String cellulare;
	private String dataNascita;
	
	
	public void setEmail(String str) {
		
		email = str;
		
	}
	
	public void setPassword(String str) {
		
		password = str;
		
	}
	
	public void setRuolo(String str) {
		
		ruolo = str;
		
	}
	
	public void setNome(String str) {
		
		nome = str;
		
	}

	public void setCognome(String str) {
	
		cognome = str;
	
	}
	
	public void setCellulare(String str) {
		
		cellulare = str;
		
	}
	
	public void setDataNascita(String str) {
		
		dataNascita = str;
		
	}
	
	public String getEmail() {
		
		return email;
		
	}
	
	public String getPassword() {
		
		return password;
		
	}
	
	public String getRuolo() {
		
		return ruolo;
		
	}
	
	public String getNome() {
		
		return nome;
		
	}

	public String getCognome() {
	
		return cognome;
	
	}
	
	public String getCellulare() {
		
		return cellulare;
		
	}
	
	public String getDataNascita() {
		
		return dataNascita;
		
	}

	public String toString() {
		
		
		return getClass().getName() + "[email=" + email + ",password=" + password +  ",nome=" + nome +  ",cognome=" + cognome + ",dataNascita=" + dataNascita + ",cellulare=" + cellulare + "]";
		
	}
	
}
