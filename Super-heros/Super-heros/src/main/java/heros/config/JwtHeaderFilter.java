package heros.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import heros.model.Admin;
import heros.model.ChefAgence;
import heros.model.Compte;
import heros.repo.CompteRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtHeaderFilter extends OncePerRequestFilter {
	
	@Autowired
	private CompteRepository compteRepository;
	
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (header != null) {
            String token = header.substring(7); 

            Optional<String> optUsername = JwtUtils.validateAndGetSubjet(token);

            if (optUsername.isPresent()) {
                Compte compte = this.compteRepository.findByLogin(optUsername.get()).orElseThrow();
                
                List<GrantedAuthority> autorities = new ArrayList<>();

                if (compte instanceof ChefAgence) {
                    autorities.add(new SimpleGrantedAuthority("ROLE_CHEFAGENCE"));
                }

                else if (compte instanceof Admin) {
                    autorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                }

                // Créer, pour Spring Security, un nouvel User, avec le nom d'utilisateur, pas de mdp, et la liste des autorités
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(optUsername.get(), null, autorities);

                // Injecter notre nouvel authentication dans le contexte de Spring Security
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        // Important pour chainer sur le filtre suivant
        filterChain.doFilter(request, response);
    }
}

