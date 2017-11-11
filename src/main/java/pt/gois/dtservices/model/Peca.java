package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_peca database table.
 * 
 */
@Entity
@Table(name="tbl_peca")
public class Peca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_peca")
	private int idPeca;

	private String nome;

	//bi-directional many-to-one association to TblRefCategoriaPeca
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_categoria_peca")
	private CategoriaPeca tblRefCategoriaPeca;

	//bi-directional many-to-one association to TblPecaServico
	@OneToMany(mappedBy="tblPeca")
	private List<PecaServico> tblPecaServicos;

	public Peca() {
	}

	public int getIdPeca() {
		return this.idPeca;
	}

	public void setIdPeca(int idPeca) {
		this.idPeca = idPeca;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CategoriaPeca getTblRefCategoriaPeca() {
		return this.tblRefCategoriaPeca;
	}

	public void setTblRefCategoriaPeca(CategoriaPeca tblRefCategoriaPeca) {
		this.tblRefCategoriaPeca = tblRefCategoriaPeca;
	}

	public List<PecaServico> getTblPecaServicos() {
		return this.tblPecaServicos;
	}

	public void setTblPecaServicos(List<PecaServico> tblPecaServicos) {
		this.tblPecaServicos = tblPecaServicos;
	}

	public PecaServico addTblPecaServico(PecaServico tblPecaServico) {
		getTblPecaServicos().add(tblPecaServico);
		tblPecaServico.setTblPeca(this);

		return tblPecaServico;
	}

	public PecaServico removeTblPecaServico(PecaServico tblPecaServico) {
		getTblPecaServicos().remove(tblPecaServico);
		tblPecaServico.setTblPeca(null);

		return tblPecaServico;
	}

}