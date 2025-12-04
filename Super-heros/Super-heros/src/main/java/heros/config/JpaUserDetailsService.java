package heros.config;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import heros.model.Admin;
import heros.model.ChefAgence;
import heros.model.Compte;
import heros.repo.CompteRepository;


@Service
public class JpaUserDetailsService implements UserDetailsService {
	
    @Autowired
    private CompteRepository compteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Function<Compte, String> roleMapper = (compte) -> {
            return switch (compte) {
                case ChefAgence a   -> "CHEFAGENCE";
                case Admin a  -> "ADMIN";
                default  -> "NONE";
            };
        };

        return this.compteRepository.findByLogin(username)
            .map(compte -> User
                    .withUsername(username)
                    .password(compte.getPassword())
                    .roles(roleMapper.apply(compte))
                    .build()
            )
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
