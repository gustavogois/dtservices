package pt.gois.dtservices.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the tbl_utilizador database table.
 * 
 */
@Entity
@Table(name="tbl_utilizador")
@NamedQuery(name="Utilizador.findAll", query="SELECT u FROM Utilizador u")
public class Utilizador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String email;

	private String nome;

	private String senha;

	//bi-directional many-to-many association to Permissao
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_utilizador_permissao", joinColumns = @JoinColumn(name="id_utilizador")
												, inverseJoinColumns = @JoinColumn(name="id_permissao")	)
	private List<Permissao> permissoes;

	public Utilizador() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Permissao> getPermissoes() {
		return this.permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

}