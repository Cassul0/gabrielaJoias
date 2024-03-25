package com.cassul.gabrielaJoias.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cassul.gabrielaJoias.model.Usuario;
import com.cassul.gabrielaJoias.repository.UsuarioRepository;
import com.cassul.gabrielaJoias.service.UsuarioService;


@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;
	
    @Transactional(readOnly = false)
	public void save(Usuario usuario) {
    	final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
    	repository.save(usuario);
	}
    
    public List<Usuario> findAll(){
    	return repository.findAll();
    }

    @Transactional(readOnly = false)
    public void deleteById(Long id) {
    	repository.deleteById(id);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByUsername(username);
		if (usuario.isPresent()) {
			return User.builder()
		            .username(usuario.get().getNome())
		            .password(usuario.get().getSenha())
		            .roles("ADMIN") 
		            .build();
		} else {
			return User.withUsername(" ")
		            .password(" ")
		            .roles(" ")
		            .disabled(true)
		            .build();
		}
		
	}
}
