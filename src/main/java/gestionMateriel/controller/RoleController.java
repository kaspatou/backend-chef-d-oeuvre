package gestionMateriel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionMateriel.model.Role;
import gestionMateriel.repository.RoleRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class RoleController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("role/getall")
	public ResponseEntity<?> getAll() {
		List<Role> roleList = null;
		try {
			roleList = roleRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(roleList);
	}

}
