//package gestionMateriel.tests.controller;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.TestExecutionListeners.MergeMode;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import gestionMateriel.model.Materiel;
//import gestionMateriel.repository.CategorieRepository;
//import gestionMateriel.repository.DonneesMaterielRepository;
//import gestionMateriel.repository.MaterielRepository;
//import gestionMateriel.repository.PretRepository;
//import gestionMateriel.repository.ProfilRepository;
//import gestionMateriel.repository.UtilisateurRepository;
//
//@RunWith(SpringRunner.class)
//// @WebMvcTest
//@SpringBootTest
//@AutoConfigureMockMvc
//@TestExecutionListeners(mergeMode = MergeMode.MERGE_WITH_DEFAULTS, listeners = {
//        WithSecurityContextTestExecutionListener.class })
//
//public class MaterielControllerTest {
//	
//	@Autowired
//	MockMvc mockMvc;
//	
//	@MockBean
//	MaterielRepository materielRepository;
//	
//	@MockBean
//	CategorieRepository categorieRepository;
//	
//	@MockBean
//	DonneesMaterielRepository donneesMaterielRepository;
//	
//	@MockBean
//	PretRepository pretRepository;
//	
//	@MockBean
//	ProfilRepository roleRepository;
//	
//	@MockBean
//	UtilisateurRepository utilisateurRepository;
//
//	
//	// test de la fonction getMateriel qui renvoie la liste de tout le matériel
//	@Test
//	@WithMockUser(roles = { "ADMIN" })
//	public void getMateriel() throws Exception {
//		when(this.materielRepository.findAll()).thenReturn(new ArrayList<>());
//		this.mockMvc.perform(get("/materiel/getall")).andExpect(status().isOk());
//			
//	}
//	
//	// test de la fonction getMaterielByMarque qui renvoie une liste de matériel en fonction de la marque
//	@Test
//	@WithMockUser(roles = { "ADMIN" })
//	public void getMaterielByName() throws Exception {
//		when(this.materielRepository.findByMarqueContainingIgnoreCase(any())).thenReturn(new ArrayList<>());
//		
//		this.mockMvc.perform(get("/materiel/getbymarque/:marque")).andExpect(status().isOk());
//	}
//	
//	// test de la fonction getMaterielByModele qui renvoie une liste de matériel en fonction du modèle
//		@Test
//		@WithMockUser(roles = { "ADMIN" })
//		public void getMaterielByModele() throws Exception {
//			when(this.materielRepository.findByModeleContainingIgnoreCase(any())).thenReturn(new ArrayList<>());
//						
//			this.mockMvc.perform(get("/materiel/getbymarque/:modele")).andExpect(status().isOk());
//		}
//		
//		// test de la fonction getMaterielByOs qui renvoie un matériel en fonction du système d'exploitation
//		@Test
//		@WithMockUser(roles = { "ADMIN" })
//		public void getMaterielByOS() throws Exception {
//			when(this.materielRepository.findByOsContainingIgnoreCase(any())).thenReturn(new ArrayList<>());
//			
//			this.mockMvc.perform(get("/materiel/getbymarque/:os")).andExpect(status().isOk());
//		}
//		
//		//test de la fonction getById qui renvoie un matériel en fonction de son id 
//		@Test
//		@WithMockUser(roles = { "ADMIN" })
//		public void getMaterielById() throws Exception {
//			Optional<Materiel> opt = Optional.of(new Materiel(1,1,"Samsung", "galaxy", "Android", "DDS2345", "1.12"));
//			
//			when(this.materielRepository.findById(any())).thenReturn(opt);
//			
//			this.mockMvc.perform(get("/materiel/getbyid/1")).andExpect(status().isOk())
//			.andExpect(jsonPath("id").value(1)).andExpect(jsonPath("imei").value(1)).andExpect(jsonPath("marque").value("Samsung"))
//			.andExpect(jsonPath("modele").value("galaxy")).andExpect(jsonPath("os").value("Android")).andExpect(jsonPath("serie").value("DDS2345"))
//			.andExpect(jsonPath("verOs").value("1.12"));
//		}
//
//		//test de la fonction addMateriel qui ajoute un matériel à la BDD
//		@Test
//		@WithMockUser(roles = { "ADMIN" })
//		public void addMateriel() throws Exception {
//			when(this.materielRepository.saveAndFlush(any())).thenReturn(new Materiel(1,1,"Samsung", "galaxy", "Android", "DDS2345", "1.12"));
//			
//			this.mockMvc.perform(post("/materiel/add").contentType(MediaType.APPLICATION_JSON_UTF8)
//					.content("{\"id\": 1, \"imei\": 1, \"marque\": \"Samsung\", \"modele\": \"galaxy\", \"os\": \"Android\", \"serie\": \"DDS2345\", \"verOs\": \"1.12\"}"))
//			.andExpect(status().isCreated()).andExpect(jsonPath("id").value(1)).andExpect(jsonPath("imei").value(1)).andExpect(jsonPath("marque").value("Samsung"))
//			.andExpect(jsonPath("modele").value("galaxy")).andExpect(jsonPath("os").value("Android")).andExpect(jsonPath("serie").value("DDS2345"))
//			.andExpect(jsonPath("verOs").value("1.12"));
//		}
//		
//		//test de la fonction modifyMateriel qui modifie les attributs d'un matériel dans la BDD
//		@Test
//		@WithMockUser(roles = { "ADMIN" })
//		public void modifyMateriel() throws Exception {
//			when(this.materielRepository.saveAndFlush(any())).thenReturn(new Materiel(1,1,"Samsung", "galaxy", "Android", "DDS2345", "1.12"));
//			this.mockMvc.perform(put("/materiel/modify").contentType(MediaType.APPLICATION_JSON_UTF8)
//					.content("{\"id\": 1, \"imei\": 1, \"marque\": \"Samsung\", \"modele\": \"galaxy\", \"os\": \"Android\", \"serie\": \"DDS2345\", \"verOs\": \"1.12\"}")).andExpect(status().isCreated());
//		}
//		
//		//test de la fonction deleteMateriel qui supprime un matériel de la BDD
//		@Test
//		@WithMockUser(roles = { "ADMIN" })
//		public void deleteMateriel() throws Exception {
//			
//		this.mockMvc.perform(delete("/materiel/delete/1")).andExpect(status().isOk());
//	}
//		
//		// test de la fonction getMaterielByWord qui renvoie une liste de matériel en fonction d'un mot ou partie de mot concernant la marque, le modèle ou l'os
//		@Test
//		@WithMockUser(roles = { "ADMIN" })
//		public void getMaterielByWord() throws Exception {
//			when(this.materielRepository.rechercheByWord(any())).thenReturn(new ArrayList<>());
//			
//			this.mockMvc.perform(get("/materiel/getbyword/:word")).andExpect(status().isOk());
//		}
//		
//		
//}
