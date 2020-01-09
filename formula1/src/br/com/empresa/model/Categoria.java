package br.com.empresa.model;

public enum Categoria {

	JUNIOR("Júnior"),
	SENIOR("Sênior"),
	MASTER("Master"),
	FULL("Full");
	
	private String descricao;
	
	Categoria(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

}
