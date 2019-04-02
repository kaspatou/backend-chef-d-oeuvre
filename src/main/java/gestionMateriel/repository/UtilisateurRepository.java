package gestionMateriel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionMateriel.model.Role;
import gestionMateriel.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{
	
	Iterable<Utilisateur> findByRole(Role role);

}
