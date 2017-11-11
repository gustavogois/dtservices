package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tbl_ref_tp_servico database table.
 * 
 */
@Entity
@Table(name="tbl_ref_tp_servico")
public class TipoServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tp_servico")
	private int idTpServico;

	private String nome;

	private BigDecimal valor;

	//bi-directional many-to-one association to TblServico
	@OneToMany(mappedBy="tblRefTpServico")
	private List<Servico> tblServicos;

	public TipoServico() {
	}

	public int getIdTpServico() {
		return this.idTpServico;
	}

	public void setIdTpServico(int idTpServico) {
		this.idTpServico = idTpServico;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<Servico> getTblServicos() {
		return this.tblServicos;
	}

	public void setTblServicos(List<Servico> tblServicos) {
		this.tblServicos = tblServicos;
	}

	public Servico addTblServico(Servico tblServico) {
		getTblServicos().add(tblServico);
		tblServico.setTblRefTpServico(this);

		return tblServico;
	}

	public Servico removeTblServico(Servico tblServico) {
		getTblServicos().remove(tblServico);
		tblServico.setTblRefTpServico(null);

		return tblServico;
	}

}