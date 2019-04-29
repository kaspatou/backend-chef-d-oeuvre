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

import gestionMateriel.model.Profil;
import gestionMateriel.model.Utilisateur;
import gestionMateriel.repository.UtilisateurRepository;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("http://localhost:4200")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	/**
	 * Retourne tous les utilisateurs
	 * @return
	 */
	@GetMapping("/getall")
	public ResponseEntity<?> getAllUtilisateurs() {
		List<Utilisateur> utilisateurs = null;
		try {
			utilisateurs = utilisateurRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(utilisateurs);
	}

	/**
	 * Retourne l'utilisateur selon son id
	 * @param id
	 * @return
	 */
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getUtilisateurById(@PathVariable Integer id) {
		Optional<Utilisateur> utilisateur = null;
		try {
			utilisateur = utilisateurRepository.findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(utilisateur);
	}
	
	/**
	 * Retourne les utilisateurs selon le rôle
	 * (dans l'url, {role} correspond à l'identifiant du rôle recherché
	 * @param role
	 * @return
	 */
	@GetMapping("/getbyprofil/{profil}")
	public ResponseEntity<?> getUtilisateurByRole(@PathVariable Profil role) {
		Iterable<Utilisateur> utilisateurs = null;
		try {
			utilisateurs = utilisateurRepository.findByProfil(role);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(utilisateurs);
	}
	/**
	 * Ajoute un utilisateur
	 * @param utilisateur
	 * @return
	 */	
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public ResponseEntity<?> addUtilisateur(@RequestBody Utilisateur utilisateur) {
		Utilisateur utilisateurToAdd = null;
		try {
			utilisateurToAdd = utilisateurRepository.saveAndFlush(utilisateur);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(utilisateurToAdd);
	}
	/**
	 * Modifie un utilisateur
	 * @param utilisateur
	 * @return
	 */
	@PutMapping(value = "/modify", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> modifyUtilisateur(@RequestBody Utilisateur utilisateur) {
		Utilisateur utilisateurToModify = null;
		try {
			utilisateurToModify = utilisateurRepository.saveAndFlush(utilisateur);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(utilisateurToModify);
	}
	/**
	 * Supprime un utilisateur par son id
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteUtilisateur(@PathVariable Integer id) {
		try {
			utilisateurRepository.deleteById(id);
		} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
