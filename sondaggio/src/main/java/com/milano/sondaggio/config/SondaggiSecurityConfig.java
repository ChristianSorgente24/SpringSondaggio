package com.milano.sondaggio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.milano.sondaggio.repository.UtenteRepository;



@Configuration
public class SondaggiSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private UtenteRepository utenteRepository;
	
	public SondaggiSecurityConfig(UtenteRepository utenteRepository) {
		this.utenteRepository = utenteRepository;
	}
	
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.passwordEncoder(passwordEncoder())
//			.withUser("root")
//			.password(passwordEncoder().encode("root"))
//			.roles("ADMIM","USER");
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .csrf().disable()
        .authorizeRequests().antMatchers("/**").permitAll();
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(new JdbcUtenteDetailsService(utenteRepository));
//	}
	
	@Bean
	@Scope("application")
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	
}