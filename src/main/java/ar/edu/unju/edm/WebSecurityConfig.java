package ar.edu.unju.edm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.edm.tracking.Service.LoginUsuarioServiceImp;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AutenticationSuccessHandler autenticacion;
	
	String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**","/webjars/**"
	};
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(resources).permitAll()
				.antMatchers("/", "/nuevoUsuario", "/saveUsuario").permitAll()
				//Acceso para registradores
				.antMatchers("/indexRegistrador", "/agregarRegistro", "/nuevoVehiculo", "/nuevoTripulante", "/buscarTripulante", "/buscarVehiculo").hasAuthority("Registrador")
				//Acceso para BD
				.antMatchers("/indexBD", "/listarUsuario", "/editarUsuario/{id}", "/deleteUsuario/{id}", "/nuevaLocalidad", "/listarLocalidad", "/saveLocalidad", "/deleteLocalidad/{id}", "/editarLocalidad/{id}", "/listarVehiculo", "/listarTripulante").hasAuthority("Bd")
				.antMatchers("/deleteTripulante/{id}", "/deleteVehiculo/{id}").denyAll()
				//Acceso para consultores
				.antMatchers("/indexConsultor", "/buscarListadoPatente", "/consultas1").hasAuthority("Consultor")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.successHandler(autenticacion)
				.failureUrl("/login?error=true")
				.usernameParameter("username")
				.passwordParameter("password")				
				.and()
			.logout()
				.permitAll();
				//.logoutSuccessUrl("/login?logout");
		http.csrf().disable();
	}	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }
    @Autowired
    LoginUsuarioServiceImp userDetailsService;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());	
    }
    
}
