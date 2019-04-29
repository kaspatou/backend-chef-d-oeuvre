package gestionMateriel.model;

import java.io.Serializable;
import javax.persistence.*;

// import org.springframework.security.core.GrantedAuthority;

import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Profil.findAll", query="SELECT p FROM Profil p")
public class Profil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String fonction;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="profil")
	private List<Utilisateur> utilisateurs;

	public Profil() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFonction() {
		return this.fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setProfil(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setProfil(null);

		return utilisateur;
	}
	
//	/**
//	 * User possible roles.
//	 */
//	public enum role implements GrantedAuthority {
//
//	    ADMIN, GESTIONNAIRE, EMPRUNTEUR;
//
//	    @Override
//	    public String getAuthority() {
//	        return name();
//	    }
//	}
//

}