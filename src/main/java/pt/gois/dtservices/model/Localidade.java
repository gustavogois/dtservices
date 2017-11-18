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
@NamedQuery(name="Localidade.findAll", query="SELECT l FROM Localidade l")
public class Localidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nome;

	//bi-directional many-to-one association to Concelho
	@OneToMany(mappedBy="tblRefLocalidade")
	private List<Concelho> tblRefConcelhos;

	public Localidade() {
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