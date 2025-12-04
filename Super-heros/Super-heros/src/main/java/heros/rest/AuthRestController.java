package heros.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import heros.config.JwtUtils;
import heros.dto.request.AuthUserRequest;
import heros.dto.response.AuthResponse;
import heros.model.Compte;
import heros.service.CompteService;

@RestController
@RequestMapping("/api")
public class AuthRestController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passEncoder;

    @Autowired
    private CompteService compteSrv;

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthUserRequest request) {
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(request.getLogin(),
                request.getPassword());

        // On demande à Spring Security si le user / password sont OK
        this.authenticationManager.authenticate(auth);

        Compte compte = compteSrv.getByLogin(request.getLogin());

        return new AuthResponse(JwtUtils.generate(auth,compte.getId()), compte.getId());
    }
}
