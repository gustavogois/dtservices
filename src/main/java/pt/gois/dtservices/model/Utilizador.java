package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_utilizador database table.
 * 
 */
@Entity
@Table(name="tbl_utilizador")
public class Utilizador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_utilizador")
	private int idUtilizador;

	private String nome;

	//bi-directional many-to-one association to TblEstadoProcesso
	@OneToMany(mappedBy="tblUtilizador")
	private List<EstadoProcesso> tblEstadoProcessos;

	//bi-directional many-to-one association to TblEstadoServico
	@OneToMany(mappedBy="tblUtilizador")
	private List<EstadoServico> tblEstadoServicos;

	//bi-directional many-to-one association to TblRefPerfilUtilizador
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_perfil_utilizador")
	private PerfilUtilizador tblRefPerfilUtilizador;

	public Utilizador() {
	}

	public int getIdUtilizador() {
		return this.idUtilizador;
	}

	public void setIdUtilizador(int idUtilizador) {
		this.idUtilizador = idUtilizador;
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
		tblEstadoProcesso.setTblUtilizador(this);

		return tblEstadoProcesso;
	}

	public EstadoProcesso removeTblEstadoProcesso(EstadoProcesso tblEstadoProcesso) {
		getTblEstadoProcessos().remove(tblEstadoProcesso);
		tblEstadoProcesso.setTblUtilizador(null);

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
		tblEstadoServico.setTblUtilizador(this);

		return tblEstadoServico;
	}

	public EstadoServico removeTblEstadoServico(EstadoServico tblEstadoServico) {
		getTblEstadoServicos().remove(tblEstadoServico);
		tblEstadoServico.setTblUtilizador(null);

		return tblEstadoServico;
	}

	public PerfilUtilizador getTblRefPerfilUtilizador() {
		return this.tblRefPerfilUtilizador;
	}

	public void setTblRefPerfilUtilizador(PerfilUtilizador tblRefPerfilUtilizador) {
		this.tblRefPerfilUtilizador = tblRefPerfilUtilizador;
	}

}