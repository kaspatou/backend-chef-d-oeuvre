package gestionMateriel.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the materiel database table.
 * 
 */
@Entity
@NamedQuery(name="Materiel.findAll", query="SELECT m FROM Materiel m")
public class Materiel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int imei;

	private String marque;

	private String modele;

	private String os;

	private String serie;

	private String verOs;

	//bi-directional many-to-many association to Pret
	@JsonIgnore
	@ManyToMany(mappedBy="materiels")
	private List<Pret> prets;

	//bi-directional many-to-one association to Categorie
	// @JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_Categorie", nullable = false)
	private Categorie categorie;

	//bi-directional many-to-one association to DonneesMateriel
	// @JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_Donnees_materiel")
	private DonneesMateriel donneesMateriel;

	public Materiel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getImei() {
		return this.imei;
	}

	public void setImei(int imei) {
		this.imei = imei;
	}

	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return this.modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getOs() {
		return this.os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getVerOs() {
		return this.verOs;
	}

	public void setVerOs(String verOs) {
		this.verOs = verOs;
	}

	public List<Pret> getPrets() {
		return this.prets;
	}

	public void setPrets(List<Pret> prets) {
		this.prets = prets;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public DonneesMateriel getDonneesMateriel() {
		return this.donneesMateriel;
	}

	public void setDonneesMateriel(DonneesMateriel donneesMateriel) {
		this.donneesMateriel = donneesMateriel;
	}

}