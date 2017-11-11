package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_estado_processo database table.
 * 
 */
@Entity
@Table(name="tbl_estado_processo")
public class EstadoProcesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_processo")
	private String idEstadoProcesso;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim")
	private Date dtFim;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio")
	private Date dtInicio;

	//bi-directional many-to-one association to TblProcesso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_processo")
	private Processo tblProcesso;

	//bi-directional many-to-one association to TblUtilizador
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_utilizador")
	private Utilizador tblUtilizador;

	//bi-directional many-to-one association to TblRefTipoEstado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipo_estado")
	private TipoEstado tblRefTipoEstado;

	public EstadoProcesso() {
	}

	public String getIdEstadoProcesso() {
		return this.idEstadoProcesso;
	}

	public void setIdEstadoProcesso(String idEstadoProcesso) {
		this.idEstadoProcesso = idEstadoProcesso;
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

	public Processo getTblProcesso() {
		return this.tblProcesso;
	}

	public void setTblProcesso(Processo tblProcesso) {
		this.tblProcesso = tblProcesso;
	}

	public Utilizador getTblUtilizador() {
		return this.tblUtilizador;
	}

	public void setTblUtilizador(Utilizador tblUtilizador) {
		this.tblUtilizador = tblUtilizador;
	}

	public TipoEstado getTblRefTipoEstado() {
		return this.tblRefTipoEstado;
	}

	public void setTblRefTipoEstado(TipoEstado tblRefTipoEstado) {
		this.tblRefTipoEstado = tblRefTipoEstado;
	}

}