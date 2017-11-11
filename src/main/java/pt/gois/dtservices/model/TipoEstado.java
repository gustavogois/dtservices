package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_ref_tipo_estado database table.
 * 
 */
@Entity
@Table(name="tbl_ref_tipo_estado")
public class TipoEstado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_estado")
	private int idTipoEstado;

	private String categoria;

	private String nome;

	//bi-directional many-to-one association to TblEstadoProcesso
	@OneToMany(mappedBy="tblRefTipoEstado")
	private List<EstadoProcesso> tblEstadoProcessos;

	//bi-directional many-to-one association to TblEstadoServico
	@OneToMany(mappedBy="tblRefTipoEstado")
	private List<EstadoServico> tblEstadoServicos;

	public TipoEstado() {
	}

	public int getIdTipoEstado() {
		return this.idTipoEstado;
	}

	public void setIdTipoEstado(int idTipoEstado) {
		this.idTipoEstado = idTipoEstado;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<EstadoProcesso> getTblEstadoProcessos() {
		return this.tblEstadoProcessos;
	}

	public void setTblEstadoProcessos(List<EstadoProcesso> tblEstadoProcessos) {
		this.tblEstadoProcessos = tblEstadoProcessos;
	}

	public EstadoProcesso addTblEstadoProcesso(EstadoProcesso tblEstadoProcesso) {
		getTblEstadoProcessos().add(tblEstadoProcesso);
		tblEstadoProcesso.setTblRefTipoEstado(this);

		return tblEstadoProcesso;
	}

	public EstadoProcesso removeTblEstadoProcesso(EstadoProcesso tblEstadoProcesso) {
		getTblEstadoProcessos().remove(tblEstadoProcesso);
		tblEstadoProcesso.setTblRefTipoEstado(null);

		return tblEstadoProcesso;
	}

	public List<EstadoServico> getTblEstadoServicos() {
		return this.tblEstadoServicos;
	}

	public void setTblEstadoServicos(List<EstadoServico> tblEstadoServicos) {
		this.tblEstadoServicos = tblEstadoServicos;
	}

	public EstadoServico addTblEstadoServico(EstadoServico tblEstadoServico) {
		getTblEstadoServicos().add(tblEstadoServico);
		tblEstadoServico.setTblRefTipoEstado(this);

		return tblEstadoServico;
	}

	public EstadoServico removeTblEstadoServico(EstadoServico tblEstadoServico) {
		getTblEstadoServicos().remove(tblEstadoServico);
		tblEstadoServico.setTblRefTipoEstado(null);

		return tblEstadoServico;
	}

}