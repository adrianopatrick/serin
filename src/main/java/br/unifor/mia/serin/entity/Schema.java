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
@NamedQueries({ @NamedQuery(name = "Schema.findByName", query = "select s from Schema s where s.name = :name"),
		@NamedQuery(name = "Schema.findByNameAndVersion", query = "select s from Schema s where s.name= :name and s.version = :version") })
public class Schema {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "id gerado para tabela domain.")
	private Long id;

	@ApiModelProperty(notes = "Nome do domínio.")
	private String name;

	@ApiModelProperty(notes = "Indica qual é a versão do schema.")
	private String version;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "schema")
	private List<Subjects> subjects;

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

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
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
		Schema other = (Schema) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
