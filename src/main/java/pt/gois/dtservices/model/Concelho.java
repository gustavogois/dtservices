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
public class Concelho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_concelho")
	private int idConcelho;

	private String nome;

	//bi-directional many-to-one association to TblRefLocalidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_localidade")
	private Localidade tblRefLocalidade;

	//bi-directional many-to-one association to TblRefDistrito
	@OneToMany(mappedBy="tblRefConcelho")
	private List<Distrito> tblRefDistritos;

	public Concelho() {
	}

	public int getIdConcelho() {
		return this.idConcelho;
	}

	public void setIdConcelho(int idConcelho) {
		this.idConcelho = idConcelho;
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