package br.com.same.models.tdb;

import br.com.models.Escola;

public class EscolaTDB {

	private Escola escola;

	public EscolaTDB(Escola escola) {
		this.escola = escola;
	}

	public static EscolaTDB umaEscola() {
		Escola escola = new Escola.Builder().comId(1l).comNome("E. E. B. Capitão José Raimundo Evangelista").build();
		return new EscolaTDB(escola);
	}

	public EscolaTDB comId(Long id) {
		escola.setId(id);
		return this;
	}

	public EscolaTDB comNome(String nome) {
		escola.setNome(nome);
		return this;
	}

	public Escola agora() {
		return escola;
	}

}
