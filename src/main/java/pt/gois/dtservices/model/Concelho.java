package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_ref_concelho database table.
 * 
 */
@Entity
@Table(name="tbl_ref_concelho")
@NamedQuery(name="Concelho.findAll", query="SELECT c FROM Concelho c")
public class Concelho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nome;

	//bi-directional many-to-one association to Localidade
	@ManyToOne
	@JoinColumn(name="id_localidade")
	private Localidade tblRefLocalidade;

	//bi-directional many-to-one association to Distrito
	@OneToMany(mappedBy="tblRefConcelho")
	private List<Distrito> tblRefDistritos;

	public Concelho() {
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

	public Localidade getTblRefLocalidade() {
		return this.tblRefLocalidade;
	}

	public void setTblRefLocalidade(Localidade tblRefLocalidade) {
		this.tblRefLocalidade = tblRefLocalidade;
	}

	public List<Distrito> getTblRefDistritos() {
		return this.tblRefDistritos;
	}

	public void setTblRefDistritos(List<Distrito> tblRefDistritos) {
		this.tblRefDistritos = tblRefDistritos;
	}

	public Distrito addTblRefDistrito(Distrito tblRefDistrito) {
		getTblRefDistritos().add(tblRefDistrito);
		tblRefDistrito.setTblRefConcelho(this);

		return tblRefDistrito;
	}

	public Distrito removeTblRefDistrito(Distrito tblRefDistrito) {
		getTblRefDistritos().remove(tblRefDistrito);
		tblRefDistrito.setTblRefConcelho(null);

		return tblRefDistrito;
	}

}