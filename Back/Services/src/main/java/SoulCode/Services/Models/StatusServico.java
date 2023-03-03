package SoulCode.Services.Models;

public enum StatusServico {
	
	RECEBIDO("Recebido"),
	ATRIBUIDO("Atribuido"),
	CONCLUIDO("Concluido"),
	ARQUIVADO("Arquivado");
	
	private String descricao;
	
	//consrutor do enum
	private StatusServico(String descricao){
		this.descricao = descricao;
	}

	//get atributo descricao
	public String getDescricao() {
		return descricao;
	}

}
