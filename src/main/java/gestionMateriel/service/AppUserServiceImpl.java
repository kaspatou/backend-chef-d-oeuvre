package gestionMateriel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import gestionMateriel.exception.ExistingUsernameException;
import gestionMateriel.exception.InvalidCredentialsException;
import gestionMateriel.model.AppUser;
import gestionMateriel.repository.AppUserRepository;
import gestionMateriel.security.JwtTokenProvider;

@Service
public class AppUserServiceImpl implements AppUserService {

    private AppUserRepository appUserRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;
    private AuthenticationManager authenticationManager;

    public AppUserServiceImpl(AppUserRepository appUserRepository, BCryptPasswordEncoder passwordEncoder,
                              JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String signin(String username, String password) throws InvalidCredentialsException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, appUserRepository.findByUsername(username).get().getRoleList());
        } catch (AuthenticationException e) {
            throw new InvalidCredentialsException();
        }
    }

    @Override
    public String signup(AppUser user) throws ExistingUsernameException {
        if (!appUserRepository.existsByUsername(user.getUsername())) {
            AppUser userToSave = new AppUser(user.getUsername(), passwordEncoder.encode(user.getPassword()), user.getRoleList());
            appUserRepository.save(userToSave);
            return jwtTokenProvider.createToken(user.getUsername(), user.getRoleList());
        } else {
            throw new ExistingUsernameException();
        }
    }

    @Override
    public List<AppUser> findAllUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public Optional<AppUser> findUserByUserName(String username) {
        return appUserRepository.findByUsername(username);
    }
}
