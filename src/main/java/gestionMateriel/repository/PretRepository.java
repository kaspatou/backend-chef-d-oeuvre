package gestionMateriel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import gestionMateriel.model.Pret;
import gestionMateriel.model.Utilisateur;

public interface PretRepository extends JpaRepository<Pret, Integer>{
	
	
//	Optional<Pret> getPretByUtilisateur (Utilisateur utilisateur);
	
	public Iterable <Pret> findByUtilisateurId(Integer utilisateurId);
	
	 public Iterable <Pret> findByMaterielsId(Integer materielsId);


}
