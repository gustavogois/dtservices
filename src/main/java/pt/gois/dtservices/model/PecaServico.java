package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_peca_servico database table.
 * 
 */
@Entity
@Table(name="tbl_peca_servico")
@NamedQuery(name="PecaServico.findAll", query="SELECT p FROM PecaServico p")
public class PecaServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	//bi-directional many-to-one association to Peca
	@ManyToOne
	@JoinColumn(name="id_peca")
	private Peca tblPeca;

	//bi-directional many-to-one association to Servico
	@ManyToOne
	@JoinColumn(name="id_servico")
	private Servico tblServico;

	public PecaServico() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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