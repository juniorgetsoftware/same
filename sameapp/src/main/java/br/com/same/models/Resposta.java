package br.com.same.models;

public class Resposta extends EntidadeBase {

	public Resposta() {
	}

	public Resposta(String descricao) {
		this();
		this.descricao = descricao;
	}

	public Resposta(String descricao, boolean b) {
		this(descricao);
		this.isRespostaCorreta = b;
	}

	private String descricao;
	private boolean isRespostaCorreta = false;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isRespostaCorreta() {
		return isRespostaCorreta;
	}

	public void setRespostaCorreta(boolean isRespostaCorreta) {
		this.isRespostaCorreta = isRespostaCorreta;
	}
	
	@Override
	public String toString() {
		return this.descricao;
	}

}
