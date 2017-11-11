package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_ref_localidade database table.
 * 
 */
@Entity
@Table(name="tbl_ref_localidade")
public class Localidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_localidade")
	private int idLocalidade;

	private String nome;

	//bi-directional many-to-one association to TblRefConcelho
	@OneToMany(mappedBy="tblRefLocalidade")
	private List<Concelho> tblRefConcelhos;

	public Localidade() {
	}

	public int getIdLocalidade() {
		return this.idLocalidade;
	}

	public void setIdLocalidade(int idLocalidade) {
		this.idLocalidade = idLocalidade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Concelho> getTblRefConcelhos() {
		return this.tblRefConcelhos;
	}

	public void setTblRefConcelhos(List<Concelho> tblRefConcelhos) {
		this.tblRefConcelhos = tblRefConcelhos;
	}

	public Concelho addTblRefConcelho(Concelho tblRefConcelho) {
		getTblRefConcelhos().add(tblRefConcelho);
		tblRefConcelho.setTblRefLocalidade(this);

		return tblRefConcelho;
	}

	public Concelho removeTblRefConcelho(Concelho tblRefConcelho) {
		getTblRefConcelhos().remove(tblRefConcelho);
		tblRefConcelho.setTblRefLocalidade(null);

		return tblRefConcelho;
	}

}