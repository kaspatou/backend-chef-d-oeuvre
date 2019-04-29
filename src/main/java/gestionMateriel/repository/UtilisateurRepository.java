package gestionMateriel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionMateriel.model.Profil;
import gestionMateriel.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{
	
	Iterable<Utilisateur> findByProfil(Profil profil);

}
