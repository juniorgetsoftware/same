package br.com.same.models;

import static java.util.Objects.isNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "professor")
@Table(name = "professor")
public class Professor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 5, max = 255)
	@Column(nullable = false)
	private String nome;

	@ManyToMany(targetEntity = Disciplina.class)
	@JoinTable(name = "professor_disciplina", joinColumns = {
			@JoinColumn(name = "professor_id") }, inverseJoinColumns = { @JoinColumn(name = "disciplina_id") })
	private List<Disciplina> disciplinas;

	//

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Disciplina> getDisciplinas() {
		if(isNull(disciplinas)) disciplinas = new ArrayList<>();
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void adicionar(Disciplina disciplina) {
		if (disciplina == null) {
			throw new RuntimeException("A disciplina é inválida");
		}
		this.getDisciplinas().add(disciplina);
	}

	public void atualizar(Disciplina disciplina) {
		int index = this.getDisciplinas().indexOf(disciplina);
		this.getDisciplinas().set(index, disciplina);
	}

	public void remover(Disciplina disciplina) {
		this.getDisciplinas().remove(disciplina);
	}

}
