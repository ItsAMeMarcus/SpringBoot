package com.example.demo.controller;

import com.example.demo.model.Estudante;
import com.example.demo.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/estudante")
public class EstudanteController {
    @Autowired
    private final EstudanteService estudanteService;

    public EstudanteController(EstudanteService estudanteService) {
        this.estudanteService = estudanteService;
    }

    @GetMapping
    public List<Estudante> getEstudante(){
        return estudanteService.getEstudante();
    }


}
