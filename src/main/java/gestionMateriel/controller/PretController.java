package gestionMateriel.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import gestionMateriel.model.Pret;
import gestionMateriel.repository.PretRepository;

@RestController
@RequestMapping("/prets")
@CrossOrigin("http://localhost:4200")

public class PretController {
	
	@Autowired
	private PretRepository pretRepository;
	
	/**
	 * Retourne tous les prêts
	 * 
	 * @Return
	 */
	
	@GetMapping("/getall")
//	public ResponseEntity<?> getAllPrets() {
//		List<Pret> listePrets = null;
//		try {
//			listePrets = pretRepository.findAll();
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(listePrets);
	List<Pret> listePrets(){	
		return this.pretRepository.findAll();
	}

	/**
	 * Retourne un prêt selon son id
	 * 
	 * @param id
	 * return
	 */
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getPretById(@PathVariable Integer id) {
		Optional<Pret> pret = null;
		try {
			pret = pretRepository.findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(pret);
	}
	
	/**
	 * Ajouter un prêt
	 * 
	 * @param pret
	 * @return
	 */
	
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> addPret(@RequestBody Pret pret) {
		Pret nouveauPret = null;
		try {
			nouveauPret = pretRepository.saveAndFlush(pret);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(nouveauPret);
	}
	
	/**
	 * Modifier un pret
	 * 
	 * @param pret
	 * @return
	 */
	
	@PutMapping(value = "/modify", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> modifyPret(@RequestBody Pret pret) {
		Pret pretToModify = null;
		try {
			pretRepository.saveAndFlush(pret);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(pretToModify);
	}
	
	/**
	 * Supprimer un pret
	 * 
	 * @param id
	 * @return
	 */
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePret(@PathVariable Integer id) {
		try {
			pretRepository.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	/**
	 * Retourne les prêts en fonction de l'emprunteur
	 * 
	 * @param id
	 * @return
	 */
	
	@GetMapping("/getpretsbyutilisateur/{utilisateurId}")
	public ResponseEntity<?> getPretsByUtilisateur(@PathVariable Integer utilisateurId) {
		Iterable <Pret> pretsByUtilisateur = null;
		try {
			pretsByUtilisateur = pretRepository.findByUtilisateurId(utilisateurId);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(pretsByUtilisateur);
	}
	
	/**
	 * retourne les prêts en fonction du matériel
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getPretsByMateriel/{materielsId}")
	// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<?> getPretsByMateriel(@PathVariable Integer materielsId) {
		Iterable <Pret> pretsByMateriel = null;
		try {
			pretsByMateriel = pretRepository.findByMaterielsId(materielsId);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(pretsByMateriel);
	}
	
}
