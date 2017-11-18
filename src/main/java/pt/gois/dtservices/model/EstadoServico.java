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
@NamedQuery(name="EstadoServico.findAll", query="SELECT e FROM EstadoServico e")
public class EstadoServico implements Serializable {
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

	//bi-directional many-to-one association to TipoEstado
	@ManyToOne
	@JoinColumn(name="id_tipo_estado")
	private TipoEstado tblRefTipoEstado;

	//bi-directional many-to-one association to Servico
	@ManyToOne
	@JoinColumn(name="id_servico")
	private Servico tblServico;

	public EstadoServico() {
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

}