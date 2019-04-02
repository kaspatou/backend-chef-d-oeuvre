package gestionMateriel.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import gestionMateriel.model.Materiel;

public interface MaterielRepository extends JpaRepository<Materiel, Integer>{
	Iterable <Materiel> findByMarqueContainingIgnoreCase (String marque);
	
	Iterable <Materiel> findByModeleContainingIgnoreCase (String modele);
	
	Iterable <Materiel> findByOsContainingIgnoreCase (String os);
	
	 @Query("FROM Materiel m WHERE modele LIKE %?1% OR marque LIKE %?1% OR os LIKE %?1%")
	 Iterable <Materiel> rechercheByWord (String word);

}
