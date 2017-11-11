package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_ref_categoria_peca database table.
 * 
 */
@Entity
@Table(name="tbl_ref_categoria_peca")
public class CategoriaPeca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_categoria_peca")
	private int idCategoriaPeca;

	private String nome;

	//bi-directional many-to-one association to TblPeca
	@OneToMany(mappedBy="tblRefCategoriaPeca")
	private List<Peca> tblPecas;

	public CategoriaPeca() {
	}

	public int getIdCategoriaPeca() {
		return this.idCategoriaPeca;
	}

	public void setIdCategoriaPeca(int idCategoriaPeca) {
		this.idCategoriaPeca = idCategoriaPeca;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Peca> getTblPecas() {
		return this.tblPecas;
	}

	public void setTblPecas(List<Peca> tblPecas) {
		this.tblPecas = tblPecas;
	}

	public Peca addTblPeca(Peca tblPeca) {
		getTblPecas().add(tblPeca);
		tblPeca.setTblRefCategoriaPeca(this);

		return tblPeca;
	}

	public Peca removeTblPeca(Peca tblPeca) {
		getTblPecas().remove(tblPeca);
		tblPeca.setTblRefCategoriaPeca(null);

		return tblPeca;
	}

}