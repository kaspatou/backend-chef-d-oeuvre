package gestionMateriel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionMateriel.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
