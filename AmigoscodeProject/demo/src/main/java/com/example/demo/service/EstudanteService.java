package com.example.demo.service;

import com.example.demo.model.Estudante;
import com.example.demo.repository.EstudanteRepositpory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    private final EstudanteRepositpory estudanteRepositpory;

    public EstudanteService(EstudanteRepositpory estudanteRepositpory) {
        this.estudanteRepositpory = estudanteRepositpory;
    }

    public List<Estudante> getEstudante() {
        return estudanteRepositpory.findAll();
    }

    public Estudante saveEstudante(Estudante estudante) {
        Optional<Estudante> verificaEmail = estudanteRepositpory.findEstudanteByEmail(estudante.getEmail());

        estudante.setMatriculado(true);

        if(verificaEmail.isPresent()){
            throw new IllegalStateException("Email já cadastrado");
        }
        return estudanteRepositpory.save(estudante);
    }

    public Estudante updateEstudante(Estudante dados) {
        var estudante = estudanteRepositpory.findById(dados.getId()).get();

        estudante.updateInfo(dados);

        return estudante;
    }

    public Optional<Estudante> getEstudanteById(Long id) {
        return estudanteRepositpory.findById(id);
    }

    public void deleteEstudante(Long id) {
        var estudante = estudanteRepositpory.findById(id).get();

        estudante.excluir();
    }
}

