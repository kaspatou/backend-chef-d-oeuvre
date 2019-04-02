package gestionMateriel.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the categorie database table.
 * 
 */
@Entity
@NamedQuery(name="Categorie.findAll", query="SELECT c FROM Categorie c")
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nom;

	//bi-directional many-to-one association to Materiel
	@JsonIgnore
	@OneToMany(mappedBy="categorie")
	private List<Materiel> materiels;

	public Categorie() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Materiel> getMateriels() {
		return this.materiels;
	}

	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}

	public Materiel addMateriel(Materiel materiel) {
		getMateriels().add(materiel);
		materiel.setCategorie(this);

		return materiel;
	}

	public Materiel removeMateriel(Materiel materiel) {
		getMateriels().remove(materiel);
		materiel.setCategorie(null);

		return materiel;
	}

}