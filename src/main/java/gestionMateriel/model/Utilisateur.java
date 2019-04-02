package gestionMateriel.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String adresseMail;

	private String identifiant;

	private String password;

	//bi-directional many-to-one association to Pret
	@JsonIgnore
	@OneToMany(mappedBy="utilisateur")
	private List<Pret> prets;

	//bi-directional many-to-one association to Role
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;

	public Utilisateur() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresseMail() {
		return this.adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getIdentifiant() {
		return this.identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Pret> getPrets() {
		return this.prets;
	}

	public void setPrets(List<Pret> prets) {
		this.prets = prets;
	}

	public Pret addPret(Pret pret) {
		getPrets().add(pret);
		pret.setUtilisateur(this);

		return pret;
	}

	public Pret removePret(Pret pret) {
		getPrets().remove(pret);
		pret.setUtilisateur(null);

		return pret;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}