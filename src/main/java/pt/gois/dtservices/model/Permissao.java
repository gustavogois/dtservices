package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_permissao database table.
 * 
 */
@Entity
@Table(name="tbl_permissao")
@NamedQuery(name="Permissao.findAll", query="SELECT p FROM Permissao p")
public class Permissao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String descricao;

	//bi-directional many-to-many association to Utilizador
	@ManyToMany
	@JoinTable(
		name="tbl_utilizador_permissao"
		, joinColumns={
			@JoinColumn(name="id_permissao")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_usuario")
			}
		)
	private List<Utilizador> tblUtilizadors;

	public Permissao() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Utilizador> getTblUtilizadors() {
		return this.tblUtilizadors;
	}

	public void setTblUtilizadors(List<Utilizador> tblUtilizadors) {
		this.tblUtilizadors = tblUtilizadors;
	}

}