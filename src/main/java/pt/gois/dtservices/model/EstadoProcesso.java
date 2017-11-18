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
@NamedQuery(name="EstadoProcesso.findAll", query="SELECT e FROM EstadoProcesso e")
public class EstadoProcesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim")
	private Date dtFim;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio")
	private Date dtInicio;

	//bi-directional many-to-one association to Processo
	@ManyToOne
	@JoinColumn(name="id_processo")
	private Processo tblProcesso;

	//bi-directional many-to-one association to TipoEstado
	@ManyToOne
	@JoinColumn(name="id_tipo_estado")
	private TipoEstado tblRefTipoEstado;

	public EstadoProcesso() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public TipoEstado getTblRefTipoEstado() {
		return this.tblRefTipoEstado;
	}

	public void setTblRefTipoEstado(TipoEstado tblRefTipoEstado) {
		this.tblRefTipoEstado = tblRefTipoEstado;
	}

}