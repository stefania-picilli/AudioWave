package model.dto;

public class CategoriaBean {

	private int id;
	private String nome;
	
	
	public int getId() {
		
		return id;
		
	}
	
	
	public String getNome() {
		
		return nome;
		
	}
	
	
	public void setId(int str) {  
		
		id = str;
		
	}
	
	
	public void setNome(String str) {
		
		nome = str;
		
	}
	
	public String toString() {
		
		return getClass().getName() + "[id=" + id + ",nome=" + nome + "]";
		
		
	}
	
	
}
