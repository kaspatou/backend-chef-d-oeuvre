package gestionMateriel.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PreRemove;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the materiel database table.
 * 
 */
@Entity
@NamedQuery(name="Materiel.findAll", query="SELECT m FROM Materiel m")
public class Materiel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int imei;

	private String marque;

	private String modele;

	private String os;

	private String serie;

	private String verOs;

	//bi-directional many-to-many association to Pret
	@JsonIgnore
	// @ManyToMany(mappedBy="materiels")
	// @ManyToMany(mappedBy="materiels", cascade= {CascadeType.ALL})
	@ManyToMany(mappedBy="materiels", fetch = FetchType.LAZY)
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

	

	public Materiel(int id, int imei, String marque, String modele, String os, String serie, String verOs) {
		super();
		this.id = id;
		this.imei = imei;
		this.marque = marque;
		this.modele = modele;
		this.os = os;
		this.serie = serie;
		this.verOs = verOs;
	}

@PreRemove
private void removeMaterielsFromPret() {
	for(Pret p : prets) {
		p.getMateriels().remove(this);
	}
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