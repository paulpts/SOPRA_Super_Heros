package heros.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.security.config.Customizer;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	private final static Logger log = LoggerFactory.getLogger(SecurityConfig.class);

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, JwtHeaderFilter jwtFilter) throws Exception {
		log.error("Configuration {} du filter chain {}", "var1", "var2");


		http.authorizeHttpRequests(auth -> {

			auth.requestMatchers("/api/auth").anonymous();
             auth.requestMatchers(HttpMethod.GET, "/api/heros").permitAll();
             auth.requestMatchers(HttpMethod.PUT, "/api/heros/**").permitAll();
			 auth.requestMatchers(HttpMethod.GET, "/api/heros/**").permitAll();
            auth.requestMatchers(HttpMethod.GET, "/api/alpha").permitAll();
            auth.requestMatchers(HttpMethod.GET, "/api/beta").permitAll();
            auth.requestMatchers(HttpMethod.GET, "/api/omega").permitAll();
            auth.requestMatchers(HttpMethod.GET, "/api/mission").permitAll(); 
            auth.requestMatchers(HttpMethod.GET, "/api/chefagence/**").permitAll(); 
            auth.requestMatchers("/api/agence/**").permitAll();
			
            
            auth.requestMatchers(HttpMethod.GET,
					//"/api/chefAgence",
					"/api/agence/**", 
					"/api/heros/**", 
					"/api/alpha/**", 
					"/api/beta/**", 
					"/api/omega/**", 
					"/api/mission/**").hasRole("CHEFAGENCE");
			auth.requestMatchers(HttpMethod.PUT, 
					//"/api/agence/**", 
					//"/api/heros/**", 
					"/api/alpha/**", 
					"/api/beta/**", 
					"/api/omega/**", 
					"/api/mission/**").hasRole("CHEFAGENCE");

			auth.requestMatchers(HttpMethod.GET,
					"/api/admin/**",
					// "/api/chefAgence/**",
					"/api/agence/**", 
					"api/heros/**", 
					"/api/alpha/**",
					// "/api/alpha/**", 
					"/api/beta/**", 
					"/api/omega/**", 
					"/api/mission/**").hasRole("ADMIN");
			auth.requestMatchers(HttpMethod.POST, 
					"/api/chefAgence/**",
					//"/api/admin/**",
					"/api/agence/**", 
					"/api/heros/**", 
					"/api/alpha/**", 
					"/api/beta/**", 
					"/api/omega/**", 
					"/api/mission/**").hasRole("ADMIN");
			auth.requestMatchers(HttpMethod.PUT, 
					"/api/chefAgence/**",
					//"/api/admin/**",
					//"/api/agence/**", 
					"/api/heros/**", 
					"/api/alpha/**", 
					"/api/beta/**", 
					"/api/omega/**", 
					"/api/mission/**").hasRole("ADMIN");
			auth.requestMatchers(HttpMethod.DELETE,
					"/api/chefAgence/**",
					//"/api/admin/**",
					//"/api/agence/**", 
					"/api/heros/**", 
					"/api/alpha/**", 
					"/api/beta/**", 
					"/api/omega/**", 
					"/api/mission/**").hasRole("ADMIN");


			auth.requestMatchers("/**").authenticated();
		});

		/*    http.formLogin(form -> {
            form.loginPage("/login"); 
            form.loginProcessingUrl("/process_login");
            form.defaultSuccessUrl("/home", true);
            form.permitAll();
        });*/

		http.logout(logout -> {
			logout.logoutUrl("/logout") 
			.logoutRequestMatcher(request -> "GET".equals(request.getMethod()) && request.getRequestURI().equals("/logout")); // Cette ligne est pour autoriser le GET sur /logout, car par défaut c'est du POST que Spring Security crée

			logout.logoutSuccessUrl("/login");
		});

		/* http.csrf(csrf -> csrf.ignoringRequestMatchers("/api/**")); */

        http.csrf(csrf -> csrf.disable());
        http.cors(Customizer.withDefaults());
		 /*http.cors(cors -> {
			CorsConfigurationSource source = request -> {
				CorsConfiguration config = new CorsConfiguration();

				config.setAllowedHeaders(List.of("*"));
				config.setAllowedMethods(List.of("*"));
				config.setAllowedOrigins(List.of("http://localhost:4200/"));

				return config;
			};

			cors.configurationSource(source);
		}); */ 

        

		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//System.out.println("\r\nMot de passe ===> " + passwordEncoder.encode("chef2") + "\r\n");
		return passwordEncoder;
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

     @Bean
    CorsConfigurationSource corsConfigurationSource() {
    UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
    CorsConfiguration corsConfiguration = new CorsConfiguration();

    corsConfiguration.setAllowedHeaders(List.of("*"));
    corsConfiguration.setAllowedMethods(List.of("*"));
    corsConfiguration.setAllowedOrigins(List.of("*"));

    corsSource.registerCorsConfiguration("/**", corsConfiguration);

    return corsSource;
}
}