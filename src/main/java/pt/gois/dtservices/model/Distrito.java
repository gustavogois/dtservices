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
public class Distrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_distrito")
	private int idDistrito;

	private String nome;

	//bi-directional many-to-one association to TblEndereco
	@OneToMany(mappedBy="tblRefDistrito")
	private List<Endereco> tblEnderecos;

	//bi-directional many-to-one association to TblRefConcelho
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_concelho")
	private Concelho tblRefConcelho;

	public Distrito() {
	}

	public int getIdDistrito() {
		return this.idDistrito;
	}

	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
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