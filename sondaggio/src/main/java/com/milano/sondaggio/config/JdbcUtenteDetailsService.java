package com.milano.sondaggio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.milano.sondaggio.model.Utente;
import com.milano.sondaggio.repository.UtenteRepository;

@Configuration
public class JdbcUtenteDetailsService implements UserDetailsService {
	
	private UtenteRepository repo;
	
	public JdbcUtenteDetailsService(UtenteRepository utenteRepository) {
		this.repo = utenteRepository;
	}
	
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Utente utente = this.repo.findByUsername(username);
			if (utente != null) {
				String password = passwordEncoder.encode(utente.getPassword());

				return User.withUsername(
						utente.getUsername())
						.password(password)
						.roles(utente.getRuolo())
						.build();
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		throw new UsernameNotFoundException(username);
	}
	
}
