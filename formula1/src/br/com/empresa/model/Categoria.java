package br.com.empresa.model;

public enum Categoria {

	JUNIOR("J�nior"),
	SENIOR("S�nior"),
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
