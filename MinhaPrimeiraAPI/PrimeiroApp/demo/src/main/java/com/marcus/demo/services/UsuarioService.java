package com.marcus.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcus.demo.domain.Usuario;
import com.marcus.demo.repository.UsuarioRepository;
import com.marcus.demo.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario update(Integer id, Usuario obj) {
		Usuario newObj = findById(id);
		
		newObj.setNome(obj.getNome());
		newObj.setLogin(obj.getLogin());
		newObj.setSenha(obj.getSenha());
		repository.save(newObj);
		
		return newObj;
	}
	
	public Usuario create (Usuario obj) {
		obj.setId(null);
		
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id); 
		repository.deleteById(id);
	}
}
