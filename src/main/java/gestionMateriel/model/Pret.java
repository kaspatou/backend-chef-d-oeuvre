package gestionMateriel.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date debut;

	@Temporal(TemporalType.DATE)
	private Date finPrevue;

	@Temporal(TemporalType.DATE)
	private Date finReelle;

	//bi-directional many-to-many association to Materiel
	// @JsonIgnore
//	@ManyToMany( fetch= FetchType.LAZY,
//			cascade = {					
//			CascadeType.MERGE,
//			CascadeType.PERSIST})
//	@JoinTable(
//		name="fournit"
//		, joinColumns={
//			@JoinColumn(name="id_Prets")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="id")
//			}
//		)	
//	private List<Materiel> materiels;
	
	@ManyToOne
	@JoinColumn(name="id_Materiel", nullable = false)
	private Materiel materiels;

	//bi-directional many-to-one association to Utilisateur
	// @JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_Utilisateur", nullable = false)
	private Utilisateur utilisateur;
	
	public Pret() {
		
	}

	public Pret(int id, Date debut, Date finPrevue, Date finReelle, Materiel materiels, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.debut = debut;
		this.finPrevue = finPrevue;
		this.finReelle = finReelle;
		this.materiels = materiels;
		this.utilisateur = utilisateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFinPrevue() {
		return finPrevue;
	}

	public void setFinPrevue(Date finPrevue) {
		this.finPrevue = finPrevue;
	}

	public Date getFinReelle() {
		return finReelle;
	}

	public void setFinReelle(Date finReelle) {
		this.finReelle = finReelle;
	}

	public Materiel getMateriels() {
		return materiels;
	}

	public void setMateriels(Materiel materiels) {
		this.materiels = materiels;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

//	public Pret() {
//	}
//
//	public int getId() {
//		return this.id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public Date getDebut() {
//		return this.debut;
//	}
//
//	public void setDebut(Date debut) {
//		this.debut = debut;
//	}
//
//	public Date getFinPrevue() {
//		return this.finPrevue;
//	}
//
//	public void setFinPrevue(Date finPrevue) {
//		this.finPrevue = finPrevue;
//	}
//
//	public Date getFinReelle() {
//		return this.finReelle;
//	}
//
//	public void setFinReelle(Date finReelle) {
//		this.finReelle = finReelle;
//	}
//
//	public List<Materiel> getMateriels() {
//		return this.materiels;
//	}
//
//	public void setMateriels(List<Materiel> materiels) {
//		this.materiels = materiels;
//	}
//
//	public Utilisateur getUtilisateur() {
//		return this.utilisateur;
//	}
//
//	public void setUtilisateur(Utilisateur utilisateur) {
//		this.utilisateur = utilisateur;
//	}
	
	

}