package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_peca_servico database table.
 * 
 */
@Entity
@Table(name="tbl_peca_servico")
public class PecaServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_peca_servico")
	private String idPecaServico;

	//bi-directional many-to-one association to TblPeca
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_peca")
	private Peca tblPeca;

	//bi-directional many-to-one association to TblServico
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_servico")
	private Servico tblServico;

	public PecaServico() {
	}

	public String getIdPecaServico() {
		return this.idPecaServico;
	}

	public void setIdPecaServico(String idPecaServico) {
		this.idPecaServico = idPecaServico;
	}

	public Peca getTblPeca() {
		return this.tblPeca;
	}

	public void setTblPeca(Peca tblPeca) {
		this.tblPeca = tblPeca;
	}

	public Servico getTblServico() {
		return this.tblServico;
	}

	public void setTblServico(Servico tblServico) {
		this.tblServico = tblServico;
	}

}