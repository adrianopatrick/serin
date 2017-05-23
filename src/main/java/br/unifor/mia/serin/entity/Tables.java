package br.unifor.mia.serin.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Tables {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(notes="id da tabela table gerado.")
	private Long id;
	
	@ApiModelProperty(notes="Nome da tabela.")
	private String nome;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="domain_id")
	@ApiModelProperty(notes="Domínio a qual pertence a tabela.")
	private Domains domain;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="table")
	private List<Columns> colunas;

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

	public Domains getDomain() {
		return domain;
	}

	public void setDomain(Domains domain) {
		this.domain = domain;
	}

	public List<Columns> getColunas() {
		return colunas;
	}

	public void setColunas(List<Columns> colunas) {
		this.colunas = colunas;
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
		Tables other = (Tables) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
