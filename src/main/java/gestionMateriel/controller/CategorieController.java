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

import gestionMateriel.model.Categorie;
import gestionMateriel.repository.CategorieRepository;

@RestController
@RequestMapping("/categorie")
@CrossOrigin("http://localhost:4200")

public class CategorieController {
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	/** retourne la liste de toutes les catégories
	 * 
	 * @return
	 */
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllCategories() {
		List<Categorie> categorieList = null;
		try {
			categorieList = categorieRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(categorieList);
	}
	
	/**
	 * Retourne la catégorie selon son id = {id}
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> categorieById(@PathVariable Integer id) {
		Optional<Categorie> categorie = null;
		try {
			categorie = categorieRepository.findById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(categorie);
	}
	
	/**
	 * Ajoute une catégorie 
	 * 
	 * @param style
	 * @return
	 */
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> addCategorie(@RequestBody Categorie categorie) {
		Categorie categorieToAdd = null;
		try {
			categorieToAdd = categorieRepository.saveAndFlush(categorie);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(categorieToAdd);
	}

	/**
	 * Modifie une catégorie
	 * 
	 * @param categorie
	 * @return
	 */
	
	@PutMapping(value = "/modify", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> modifyCategorie(@RequestBody Categorie categorie) {
		Categorie categorieToModify = null;
		try {
			categorieToModify = categorieRepository.saveAndFlush(categorie);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(categorieToModify);
	}
	
	/**
	 * Supprime la catégorie à partir de son id = {id}
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteCategorie(@PathVariable Integer id) {
		try {
			categorieRepository.deleteById(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
