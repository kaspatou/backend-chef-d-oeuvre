package gestionMateriel.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the donnees_materiel database table.
 * 
 */
@Entity
@Table(name="donnees_materiel")
@NamedQuery(name="DonneesMateriel.findAll", query="SELECT d FROM DonneesMateriel d")
public class DonneesMateriel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String compteAdministrateur;

	private String compteUtilisateur;

	private String mdpAdministrateur;

	private String mdpUtilisateur;

	private int pin;

	private String urlConfiguration;

	//bi-directional many-to-one association to Materiel
	@JsonIgnore
	@OneToMany(mappedBy="donneesMateriel")
	private List<Materiel> materiels;

	public DonneesMateriel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompteAdministrateur() {
		return this.compteAdministrateur;
	}

	public void setCompteAdministrateur(String compteAdministrateur) {
		this.compteAdministrateur = compteAdministrateur;
	}

	public String getCompteUtilisateur() {
		return this.compteUtilisateur;
	}

	public void setCompteUtilisateur(String compteUtilisateur) {
		this.compteUtilisateur = compteUtilisateur;
	}

	public String getMdpAdministrateur() {
		return this.mdpAdministrateur;
	}

	public void setMdpAdministrateur(String mdpAdministrateur) {
		this.mdpAdministrateur = mdpAdministrateur;
	}

	public String getMdpUtilisateur() {
		return this.mdpUtilisateur;
	}

	public void setMdpUtilisateur(String mdpUtilisateur) {
		this.mdpUtilisateur = mdpUtilisateur;
	}

	public int getPin() {
		return this.pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getUrlConfiguration() {
		return this.urlConfiguration;
	}

	public void setUrlConfiguration(String urlConfiguration) {
		this.urlConfiguration = urlConfiguration;
	}

	public List<Materiel> getMateriels() {
		return this.materiels;
	}

	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}

	public Materiel addMateriel(Materiel materiel) {
		getMateriels().add(materiel);
		materiel.setDonneesMateriel(this);

		return materiel;
	}

	public Materiel removeMateriel(Materiel materiel) {
		getMateriels().remove(materiel);
		materiel.setDonneesMateriel(null);

		return materiel;
	}

}