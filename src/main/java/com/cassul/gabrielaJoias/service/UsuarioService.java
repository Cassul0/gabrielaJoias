package com.cassul.gabrielaJoias.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cassul.gabrielaJoias.model.Usuario;
import com.cassul.gabrielaJoias.repository.UsuarioRepository;
import com.cassul.gabrielaJoias.service.UsuarioService;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
    @Transactional(readOnly = false)
	public void save(Usuario usuario) {
    	repository.save(usuario);
	}
    
    public List<Usuario> findAll(){
    	return repository.findAll();
    }

    @Transactional(readOnly = false)
    public void deleteById(Long id) {
    	repository.deleteById(id);
    }
}
