package br.unifor.mia.serin.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import io.swagger.annotations.ApiModelProperty;

@Entity
@NamedQueries({
	@NamedQuery(name = "Domains.findByName",
			query = "select d from Domains d where d.name = :name")
})
public class Domains {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "id gerado para tabela domain.")
	private Long id;
	
	@ApiModelProperty(notes = "Nome do domínio.")
	private String name;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="domain")
	private List<Tables> tabelas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Tables> getTabelas() {
		return tabelas;
	}

	public void setTabelas(List<Tables> tabelas) {
		this.tabelas = tabelas;
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
		Domains other = (Domains) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
