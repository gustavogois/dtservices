package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_estado_servico database table.
 * 
 */
@Entity
@Table(name="tbl_estado_servico")
public class EstadoServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_servico")
	private String idEstadoServico;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim")
	private Date dtFim;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio")
	private Date dtInicio;

	//bi-directional many-to-one association to TblRefTipoEstado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_estado")
	private TipoEstado tblRefTipoEstado;

	//bi-directional many-to-one association to TblServico
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_servico")
	private Servico tblServico;

	//bi-directional many-to-one association to TblUtilizador
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_utilizador")
	private Utilizador tblUtilizador;

	public EstadoServico() {
	}

	public String getIdEstadoServico() {
		return this.idEstadoServico;
	}

	public void setIdEstadoServico(String idEstadoServico) {
		this.idEstadoServico = idEstadoServico;
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

	public TipoEstado getTblRefTipoEstado() {
		return this.tblRefTipoEstado;
	}

	public void setTblRefTipoEstado(TipoEstado tblRefTipoEstado) {
		this.tblRefTipoEstado = tblRefTipoEstado;
	}

	public Servico getTblServico() {
		return this.tblServico;
	}

	public void setTblServico(Servico tblServico) {
		this.tblServico = tblServico;
	}

	public Utilizador getTblUtilizador() {
		return this.tblUtilizador;
	}

	public void setTblUtilizador(Utilizador tblUtilizador) {
		this.tblUtilizador = tblUtilizador;
	}

}