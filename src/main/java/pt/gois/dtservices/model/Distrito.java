package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_ref_distrito database table.
 * 
 */
@Entity
@Table(name="tbl_ref_distrito")
@NamedQuery(name="Distrito.findAll", query="SELECT d FROM Distrito d")
public class Distrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nome;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="tblRefDistrito")
	private List<Endereco> tblEnderecos;

	//bi-directional many-to-one association to Concelho
	@ManyToOne
	@JoinColumn(name="id_concelho")
	private Concelho tblRefConcelho;

	public Distrito() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Endereco> getTblEnderecos() {
		return this.tblEnderecos;
	}

	public void setTblEnderecos(List<Endereco> tblEnderecos) {
		this.tblEnderecos = tblEnderecos;
	}

	public Endereco addTblEndereco(Endereco tblEndereco) {
		getTblEnderecos().add(tblEndereco);
		tblEndereco.setTblRefDistrito(this);

		return tblEndereco;
	}

	public Endereco removeTblEndereco(Endereco tblEndereco) {
		getTblEnderecos().remove(tblEndereco);
		tblEndereco.setTblRefDistrito(null);

		return tblEndereco;
	}

	public Concelho getTblRefConcelho() {
		return this.tblRefConcelho;
	}

	public void setTblRefConcelho(Concelho tblRefConcelho) {
		this.tblRefConcelho = tblRefConcelho;
	}

}