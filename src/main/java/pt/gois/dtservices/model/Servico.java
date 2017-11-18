package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tbl_servico database table.
 * 
 */
@Entity
@Table(name="tbl_servico")
@NamedQuery(name="Servico.findAll", query="SELECT s FROM Servico s")
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private String observacoes;

	private BigDecimal valor;

	//bi-directional many-to-one association to EstadoServico
	@OneToMany(mappedBy="tblServico")
	private List<EstadoServico> tblEstadoServicos;

	//bi-directional many-to-one association to PecaServico
	@OneToMany(mappedBy="tblServico")
	private List<PecaServico> tblPecaServicos;

	//bi-directional many-to-one association to Processo
	@ManyToOne
	@JoinColumn(name="id_processo")
	private Processo tblProcesso;

	//bi-directional many-to-one association to TpServico
	@ManyToOne
	@JoinColumn(name="id_tp_servico")
	private TipoDeServico tblRefTpServico;

	public Servico() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getObservacoes() {
		return this.observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<EstadoServico> getTblEstadoServicos() {
		return this.tblEstadoServicos;
	}

	public void setTblEstadoServicos(List<EstadoServico> tblEstadoServicos) {
		this.tblEstadoServicos = tblEstadoServicos;
	}

	public EstadoServico addTblEstadoServico(EstadoServico tblEstadoServico) {
		getTblEstadoServicos().add(tblEstadoServico);
		tblEstadoServico.setTblServico(this);

		return tblEstadoServico;
	}

	public EstadoServico removeTblEstadoServico(EstadoServico tblEstadoServico) {
		getTblEstadoServicos().remove(tblEstadoServico);
		tblEstadoServico.setTblServico(null);

		return tblEstadoServico;
	}

	public List<PecaServico> getTblPecaServicos() {
		return this.tblPecaServicos;
	}

	public void setTblPecaServicos(List<PecaServico> tblPecaServicos) {
		this.tblPecaServicos = tblPecaServicos;
	}

	public PecaServico addTblPecaServico(PecaServico tblPecaServico) {
		getTblPecaServicos().add(tblPecaServico);
		tblPecaServico.setTblServico(this);

		return tblPecaServico;
	}

	public PecaServico removeTblPecaServico(PecaServico tblPecaServico) {
		getTblPecaServicos().remove(tblPecaServico);
		tblPecaServico.setTblServico(null);

		return tblPecaServico;
	}

	public Processo getTblProcesso() {
		return this.tblProcesso;
	}

	public void setTblProcesso(Processo tblProcesso) {
		this.tblProcesso = tblProcesso;
	}

	public TipoDeServico getTblRefTpServico() {
		return this.tblRefTpServico;
	}

	public void setTblRefTpServico(TipoDeServico tblRefTpServico) {
		this.tblRefTpServico = tblRefTpServico;
	}

}