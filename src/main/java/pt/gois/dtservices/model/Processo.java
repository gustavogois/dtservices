package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tbl_processo database table.
 * 
 */
@Entity
@Table(name="tbl_processo")
public class Processo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_processo")
	private String idProcesso;

	@Column(name="cod_externo")
	private String codExterno;

	@Column(name="cod_interno")
	private String codInterno;

	@Column(name="com_chaves")
	private byte comChaves;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim")
	private Date dtFim;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio")
	private Date dtInicio;

	private String observacoes;

	private String requisitante;

	//bi-directional many-to-one association to TblEstadoProcesso
	@OneToMany(mappedBy="tblProcesso")
	private List<EstadoProcesso> tblEstadoProcessos;

	//bi-directional many-to-one association to TblImovel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_imovel")
	private Imovel tblImovel;

	//bi-directional many-to-one association to TblServico
	@OneToMany(mappedBy="tblProcesso")
	private List<Servico> tblServicos;

	public Processo() {
	}

	public String getIdProcesso() {
		return this.idProcesso;
	}

	public void setIdProcesso(String idProcesso) {
		this.idProcesso = idProcesso;
	}

	public String getCodExterno() {
		return this.codExterno;
	}

	public void setCodExterno(String codExterno) {
		this.codExterno = codExterno;
	}

	public String getCodInterno() {
		return this.codInterno;
	}

	public void setCodInterno(String codInterno) {
		this.codInterno = codInterno;
	}

	public byte getComChaves() {
		return this.comChaves;
	}

	public void setComChaves(byte comChaves) {
		this.comChaves = comChaves;
	}

	public Date getDtFim() {
		return this.dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public Date getDtInicio() {
		return this.dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public String getObservacoes() {
		return this.observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getRequisitante() {
		return this.requisitante;
	}

	public void setRequisitante(String requisitante) {
		this.requisitante = requisitante;
	}

	public List<EstadoProcesso> getTblEstadoProcessos() {
		return this.tblEstadoProcessos;
	}

	public void setTblEstadoProcessos(List<EstadoProcesso> tblEstadoProcessos) {
		this.tblEstadoProcessos = tblEstadoProcessos;
	}

	public EstadoProcesso addTblEstadoProcesso(EstadoProcesso tblEstadoProcesso) {
		getTblEstadoProcessos().add(tblEstadoProcesso);
		tblEstadoProcesso.setTblProcesso(this);

		return tblEstadoProcesso;
	}

	public EstadoProcesso removeTblEstadoProcesso(EstadoProcesso tblEstadoProcesso) {
		getTblEstadoProcessos().remove(tblEstadoProcesso);
		tblEstadoProcesso.setTblProcesso(null);

		return tblEstadoProcesso;
	}

	public Imovel getTblImovel() {
		return this.tblImovel;
	}

	public void setTblImovel(Imovel tblImovel) {
		this.tblImovel = tblImovel;
	}

	public List<Servico> getTblServicos() {
		return this.tblServicos;
	}

	public void setTblServicos(List<Servico> tblServicos) {
		this.tblServicos = tblServicos;
	}

	public Servico addTblServico(Servico tblServico) {
		getTblServicos().add(tblServico);
		tblServico.setTblProcesso(this);

		return tblServico;
	}

	public Servico removeTblServico(Servico tblServico) {
		getTblServicos().remove(tblServico);
		tblServico.setTblProcesso(null);

		return tblServico;
	}

}