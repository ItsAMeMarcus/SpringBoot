package com.example.demo.repository;

import com.example.demo.model.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Repository
public interface EstudanteRepositpory extends JpaRepository<Estudante,Long> {
    Optional<Estudante> findEstudanteByEmail(String email);
}
