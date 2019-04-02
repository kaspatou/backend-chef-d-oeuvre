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

import gestionMateriel.model.Materiel;
import gestionMateriel.repository.MaterielRepository;
//import gestionMateriel.repository.RechercheRepository;

@RestController
@RequestMapping("/materiel")
@CrossOrigin("http://localhost:4200")

public class MaterielController {
	
	@Autowired
	private MaterielRepository materielRepository;
	
	
		
	/**
	 * Retourne la liste de tout le matériel
	 * 
	 * @return
	 */
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllMateriel() {
		List<Materiel> materielList = null;
		try {
			materielList = materielRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(materielList);
		}

	/**
	 * Retourne un matériel selon son id
	 * 
	 * @param id
	 * @return
	 */
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getMaterielById(@PathVariable Integer id) {
		Optional<Materiel> materiel = null;
		try {
			materiel = materielRepository.findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(materiel);
	}
	
	/**
	 * Ajoute un matériel à la BDD
	 * 
	 * @param materiel
	 * @return
	 */
	
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> addMateriel(@RequestBody Materiel materiel) {
		Materiel materielToAdd = null;
		try {
			materielToAdd = materielRepository.saveAndFlush(materiel);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(materielToAdd);
	}
	
	/**
	 * Modifie un matériel dans la BDD
	 * 
	 * @param materiel
	 * @return
	 */
	
	@PutMapping(value = "/modify", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> modifyMateriel(@RequestBody Materiel materiel) {
		Materiel materielToModify = null;
		try {
			materielToModify = materielRepository.saveAndFlush(materiel);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
			}
		return ResponseEntity.status(HttpStatus.CREATED).body(materielToModify);
	}
	
	/**
	 * Supprime de la BDD un matériel par son id
	 * 
	 * @param id
	 * @return
	 */
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteMateriel(@PathVariable Integer id) {
		try { 
			materielRepository.deleteById(id);
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	/**
	 * Retourne le matériel dont la marque contient {marque}
	 * 
	 * @param marque
	 * @return
	 */
	
	@GetMapping("/getbymarque/{marque}")
	public ResponseEntity<?> getMaterielByMarque(@PathVariable String marque) {
		Iterable<Materiel> materiaux = null;
		try {
			materiaux = materielRepository.findByMarqueContainingIgnoreCase(marque);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(materiaux);
	}
	
	/**
	 * Retourne le matériel dont le modèle contient {modele}
	 * 
	 * @param modele
	 * @return
	 */
	
	@GetMapping("/getbymodele/{modele}")
	public ResponseEntity<?> getMaterielByModele(@PathVariable String modele) {
		Iterable<Materiel> materiaux = null;
		try {
			materiaux = materielRepository.findByModeleContainingIgnoreCase(modele);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(materiaux);
	}
	
	/**
	 * Retourne le matériel dont le système d'exploitation (OS) contient {os}
	 * 
	 * @param os
	 * @return
	 */
	
	@GetMapping("getbyos/{os}")
	public ResponseEntity<?> getMaterielByOs(@PathVariable String os) {
		Iterable<Materiel> materiaux = null;
		try {
			materiaux = materielRepository.findByOsContainingIgnoreCase(os);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(materiaux);
	}
	
	/**
	 * Retourne le matériel dont la marque, le modèle ou l'os contient {word}
	 * 
	 * @Param word
	 * @return
	 */
	
	@GetMapping("/getbyword/{word}")
	public ResponseEntity<?> getMaterielByWord(@PathVariable String word) {
		
		Iterable<Materiel> materiaux = null;
		try {
			materiaux = materielRepository.rechercheByWord(word);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(materiaux);
	}
	
	
}
