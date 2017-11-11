package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_ref_perfil_utilizador database table.
 * 
 */
@Entity
@Table(name="tbl_ref_perfil_utilizador")
public class PerfilUtilizador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perfil_utilizador")
	private int idPerfilUtilizador;

	private String nome;

	//bi-directional many-to-one association to TblUtilizador
	@OneToMany(mappedBy="tblRefPerfilUtilizador")
	private List<Utilizador> tblUtilizadors;

	public PerfilUtilizador() {
	}

	public int getIdPerfilUtilizador() {
		return this.idPerfilUtilizador;
	}

	public void setIdPerfilUtilizador(int idPerfilUtilizador) {
		this.idPerfilUtilizador = idPerfilUtilizador;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Utilizador> getTblUtilizadors() {
		return this.tblUtilizadors;
	}

	public void setTblUtilizadors(List<Utilizador> tblUtilizadors) {
		this.tblUtilizadors = tblUtilizadors;
	}

	public Utilizador addTblUtilizador(Utilizador tblUtilizador) {
		getTblUtilizadors().add(tblUtilizador);
		tblUtilizador.setTblRefPerfilUtilizador(this);

		return tblUtilizador;
	}

	public Utilizador removeTblUtilizador(Utilizador tblUtilizador) {
		getTblUtilizadors().remove(tblUtilizador);
		tblUtilizador.setTblRefPerfilUtilizador(null);

		return tblUtilizador;
	}

}