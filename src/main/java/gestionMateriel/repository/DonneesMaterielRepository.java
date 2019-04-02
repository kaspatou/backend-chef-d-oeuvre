package gestionMateriel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionMateriel.model.DonneesMateriel;

public interface DonneesMaterielRepository extends JpaRepository<DonneesMateriel, Integer> {

}
