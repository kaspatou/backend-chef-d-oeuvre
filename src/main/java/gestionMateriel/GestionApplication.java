package gestionMateriel;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import gestionMateriel.model.AppUser;
import gestionMateriel.model.Role;
import gestionMateriel.service.AppUserService;


@SpringBootApplication

public class GestionApplication implements CommandLineRunner {
	
	@Autowired
    AppUserService userService;


	public static void main(String[] args) {
		SpringApplication.run(GestionApplication.class, args);

	}
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	/**
     * Init method that loads some data in database.
     * @param params
     * @throws Exception
     */
    @Override
    public void run(String... params) throws Exception {
        AppUser admin = new AppUser("thomas", "toto", new ArrayList<>(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_CREATOR, Role.ROLE_READER)));
        userService.signup(admin);

        AppUser gestionnaire = new AppUser("samsabot", "sam", new ArrayList<>(Arrays.asList(Role.ROLE_CREATOR, Role.ROLE_READER)));
        userService.signup(gestionnaire);
        
        AppUser user = new AppUser("davidP", "dav", new ArrayList<>(Arrays.asList(Role.ROLE_READER)));
        userService.signup(user);
    }

}
