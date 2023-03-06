package com.marcus.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcus.demo.domain.Usuario;
import com.marcus.demo.repository.UsuarioRepository;

@SpringBootApplication
public class MyAppApplication implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MyAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Marcus", "teste", "123");
		
		Usuario u2 = new Usuario(null, "Vinicius", "teste2", "456");
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
	}

}
