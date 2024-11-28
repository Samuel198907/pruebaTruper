package prueba;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	
	AuthenticationManager auth;
	
	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration conf) throws Exception{
		auth=conf.getAuthenticationManager();
		return auth;
	}
	
	@Bean
	public InMemoryUserDetailsManager usersdetais() throws Exception{
		List<UserDetails> users=List.of(
				User
				.withUsername("user1")
				
				.password("{noop}user1")
				.roles("USERS")
				.build()
				); //Creamos solo un usuario para prueba, con rol de USERS		
		return new InMemoryUserDetailsManager(users);					
	}
	
	/*@Bean //solo si se va a utilizar encriptación
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}*/
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf(cus->cus.disable())
		.authorizeHttpRequests(aut->
			aut.requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET,"/consulta/orden")).hasRole("USERS")
			.requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.POST,"/guardar/orden")).hasRole("USERS")
			.requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET,"/consulta/sucursales")).hasRole("USERS")
			.requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET,"/consulta/productos")).hasRole("USERS")
			.requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.PUT,"/modifica/precio")).hasRole("USERS")

			.anyRequest().permitAll()
			)
		.addFilter(new JWTAuthorizationFilter(auth));
		return http.build();
	}
}
