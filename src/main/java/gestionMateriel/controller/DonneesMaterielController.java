package gestionMateriel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gestionMateriel.model.DonneesMateriel;
import gestionMateriel.repository.DonneesMaterielRepository;

@RestController
@RequestMapping("/donnees")
@CrossOrigin("http://localhost:4200")

public class DonneesMaterielController {
	
	@Autowired
	private DonneesMaterielRepository donneesMaterielRepository;
	
	/** retourne la liste de toutes les données
	 * 
	 * @return
	 */
	@GetMapping("/getall")
	public ResponseEntity<?> getAllDonneesMateriel() {
		List<DonneesMateriel> donneesMaterielList = null;
		try {
			donneesMaterielList = donneesMaterielRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(donneesMaterielList);
	}
	
	/**
	 * Retourne une donnée selon son id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getDonneesById(@PathVariable Integer id) {
		Optional<DonneesMateriel> donneesMateriel = null;
		try {
			donneesMateriel = donneesMaterielRepository.findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(donneesMateriel);
	}

	/**
	 * Ajoute des données à la BDD
	 * 
	 * @param donneesMateriel
	 * @return
	 */
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> addDonneesMateriel(@RequestBody DonneesMateriel donneesMateriel) {
		DonneesMateriel donneesMaterielToAdd = null;
		try {
			donneesMaterielToAdd = donneesMaterielRepository.saveAndFlush(donneesMateriel);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(donneesMaterielToAdd);
	}
	/**
	 * Modifie une donnée dans la BDD
	 * 
	 * @param donneesMateriel
	 * @return
	 */
	@PutMapping(value = "/modify", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> modifyDonneesMateriel(@RequestBody DonneesMateriel donneesMateriel) {
		DonneesMateriel donneesMaterielToModify = null;
		try {
			donneesMaterielToModify = donneesMaterielRepository.saveAndFlush(donneesMateriel);
		} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(donneesMaterielToModify);
	}
	/**
	 * Supprime de la BDD une donnée par son id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteDonneesMateriel(@PathVariable Integer id) {
		try {
			donneesMaterielRepository.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
