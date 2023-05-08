package com.example.demo.service;

import com.example.demo.model.Estudante;
import com.example.demo.repository.EstudanteRepositpory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstudanteService {

    private final EstudanteRepositpory estudanteRepositpory;

    public EstudanteService(EstudanteRepositpory estudanteRepositpory) {
        this.estudanteRepositpory = estudanteRepositpory;
    }

    public List<Estudante> getEstudante() {
        return estudanteRepositpory.findAll();
    }
}

