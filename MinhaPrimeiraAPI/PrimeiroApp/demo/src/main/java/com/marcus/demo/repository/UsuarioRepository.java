package com.marcus.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcus.demo.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
