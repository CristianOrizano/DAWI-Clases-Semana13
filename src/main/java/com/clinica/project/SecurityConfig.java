package com.clinica.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//anotación para habilitar la seguridad
@EnableWebSecurity
@Configuration
public class SecurityConfig {

	//lo que hace la anota es q en el contenedor del sprint se esta registrando un metodo 
	//y ese metodo va estar en el contenedor, y cuando estemos en otra clase
	//y quiera utilizar ese metodo, ya lo vamos a usar de manera directa
	//este metodo es para encriptar
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	//este metodo es la configuracion para 
	//trabajar con nuestro propio login
    //si no ponemos este metodo(por defecto nos sale el login de spring)
	@Bean
	public  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//no vamos a autenticar en funcion a un formulario(login personalizado)
		/*http.authorizeHttpRequests((auth)-> auth.anyRequest().authenticated())
		.formLogin(form-> form.loginPage("/login")
		si todo es correcto que vaya a esta ruta
		.permitAll().defaultSuccessUrl("/medicamento/lista"));*/
	
		http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests((auth) -> {
			auth.anyRequest().authenticated();})
		  .formLogin(form -> {
			try {
				form.loginPage("/login")
  //si todo es correcto ingresamos a esta ruta
						  .permitAll().defaultSuccessUrl("/intranet")
				          //.failureUrl("/loginerrord")
						 .and()
						 .logout()
						     //.logoutSuccessUrl("/intranet");
						 //.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
						 .logoutSuccessUrl("/login?logout")
						 .permitAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		);
		
	    return http.build();	
	}
	
	/*
	@Bean
	public UserDetailsService userDetailsService(BCryptPasswordEncoder encoder) {
		//crear objeto de la InMemoryUserDetailsManager
		//aqui hay herencia multiple de InMemoryUserDetailsManager que su interfaz devuelve userdetailSer
		InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
		//aqui creamos los usuarios en memoria
	//necesitamos encriptar el password para ello implemento el metodo BCryptPasswordEncoder
	 //necesitamos encriptar ya que si no le ponemos el sprint lo reconoce como no encrip
		manager.createUser(User.withUsername("luis").password(encoder.encode("123")).roles("USER").build());
		manager.createUser(User.withUsername("carlos").password(encoder.encode("456")).roles("ADMIN").build());
		
		return manager;
	} */
	

	
}
