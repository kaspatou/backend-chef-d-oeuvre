package gestionMateriel.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the prets database table.
 * 
 */
@Entity
@Table(name="prets")
// @NamedQuery(name="Pret.findAll", query="SELECT p FROM Pret p")
public class Pret implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date debut;

	@Temporal(TemporalType.DATE)
	private Date finPrevue;

	@Temporal(TemporalType.DATE)
	private Date finReelle;

	//bi-directional many-to-many association to Materiel
	// @JsonIgnore
	@ManyToMany
	@JoinTable(
		name="fournit"
		, joinColumns={
			@JoinColumn(name="id_Prets")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id")
			}
		)
	private List<Materiel> materiels;

	//bi-directional many-to-one association to Utilisateur
	// @JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_Utilisateur", nullable = false)
	private Utilisateur utilisateur;

	public Pret() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDebut() {
		return this.debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFinPrevue() {
		return this.finPrevue;
	}

	public void setFinPrevue(Date finPrevue) {
		this.finPrevue = finPrevue;
	}

	public Date getFinReelle() {
		return this.finReelle;
	}

	public void setFinReelle(Date finReelle) {
		this.finReelle = finReelle;
	}

	public List<Materiel> getMateriels() {
		return this.materiels;
	}

	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}