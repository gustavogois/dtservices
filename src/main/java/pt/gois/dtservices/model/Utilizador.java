package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String email;

	private String nome;

	private String senha;

	//bi-directional many-to-many association to Permissao
	@ManyToMany(mappedBy="tblUtilizadors")
	private List<Permissao> tblPermissaos;

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

	public List<Permissao> getTblPermissaos() {
		return this.tblPermissaos;
	}

	public void setTblPermissaos(List<Permissao> tblPermissaos) {
		this.tblPermissaos = tblPermissaos;
	}

}