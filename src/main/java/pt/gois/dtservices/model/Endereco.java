package pt.gois.dtservices.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_endereco database table.
 * 
 */
@Entity
@Table(name="tbl_endereco")
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_imovel")
	private String idImovel;

	@Column(name="codigo_postal")
	private String codigoPostal;

	private String complemento;

	@Column(name="coord_x")
	private String coordX;

	@Column(name="coord_y")
	private String coordY;

	private String latitude;

	private String longitude;

	private String rua;

	@Column(name="tbl_ref_distrito_id_distrito")
	private int tblRefDistritoIdDistrito;

	//bi-directional many-to-one association to Distrito
	@ManyToOne
	@JoinColumn(name="id_distrito")
	private Distrito tblRefDistrito;

	//bi-directional one-to-one association to Imovel
	@OneToOne
	@JoinColumn(name="id_imovel")
	private Imovel tblImovel;

	public Endereco() {
	}

	public String getIdImovel() {
		return this.idImovel;
	}

	public void setIdImovel(String idImovel) {
		this.idImovel = idImovel;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCoordX() {
		return this.coordX;
	}

	public void setCoordX(String coordX) {
		this.coordX = coordX;
	}

	public String getCoordY() {
		return this.coordY;
	}

	public void setCoordY(String coordY) {
		this.coordY = coordY;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getTblRefDistritoIdDistrito() {
		return this.tblRefDistritoIdDistrito;
	}

	public void setTblRefDistritoIdDistrito(int tblRefDistritoIdDistrito) {
		this.tblRefDistritoIdDistrito = tblRefDistritoIdDistrito;
	}

	public Distrito getTblRefDistrito() {
		return this.tblRefDistrito;
	}

	public void setTblRefDistrito(Distrito tblRefDistrito) {
		this.tblRefDistrito = tblRefDistrito;
	}

	public Imovel getTblImovel() {
		return this.tblImovel;
	}

	public void setTblImovel(Imovel tblImovel) {
		this.tblImovel = tblImovel;
	}

}