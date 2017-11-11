package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tbl_imovel database table.
 * 
 */
@Entity
@Table(name="tbl_imovel")
public class Imovel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_imovel")
	private String idImovel;

	private String crp;

	private String nome;

	//bi-directional one-to-one association to TblEndereco
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_imovel")
	private Endereco tblEndereco;

	//bi-directional many-to-one association to TblProcesso
	@OneToMany(mappedBy="tblImovel")
	private List<Processo> tblProcessos;

	public Imovel() {
	}

	public String getIdImovel() {
		return this.idImovel;
	}

	public void setIdImovel(String idImovel) {
		this.idImovel = idImovel;
	}

	public String getCrp() {
		return this.crp;
	}

	public void setCrp(String crp) {
		this.crp = crp;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getTblEndereco() {
		return this.tblEndereco;
	}

	public void setTblEndereco(Endereco tblEndereco) {
		this.tblEndereco = tblEndereco;
	}

	public List<Processo> getTblProcessos() {
		return this.tblProcessos;
	}

	public void setTblProcessos(List<Processo> tblProcessos) {
		this.tblProcessos = tblProcessos;
	}

	public Processo addTblProcesso(Processo tblProcesso) {
		getTblProcessos().add(tblProcesso);
		tblProcesso.setTblImovel(this);

		return tblProcesso;
	}

	public Processo removeTblProcesso(Processo tblProcesso) {
		getTblProcessos().remove(tblProcesso);
		tblProcesso.setTblImovel(null);

		return tblProcesso;
	}

}