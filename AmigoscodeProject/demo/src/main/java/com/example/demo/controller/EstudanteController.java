package com.example.demo.controller;

import com.example.demo.model.Estudante;
import com.example.demo.model.EstudanteDTO;
import com.example.demo.service.EstudanteService;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/estudante")
public class EstudanteController {
    @Autowired
    private final EstudanteService estudanteService;

    public EstudanteController(EstudanteService estudanteService) {
        this.estudanteService = estudanteService;
    }

    @GetMapping
    public ResponseEntity<List<Estudante>> getEstudante(){
        return ResponseEntity.ok(estudanteService.getEstudante());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Estudante>> getEstudanteById(@PathVariable Long id){
        var estudante = estudanteService.getEstudanteById(id);

        return ResponseEntity.ok(estudante);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Estudante> Post(@RequestBody EstudanteDTO dados, UriComponentsBuilder uriBuilder){

        var estudante = new Estudante(dados);

        var retorno = estudanteService.saveEstudante(estudante);

        var uri = uriBuilder.path("/api/v1/estudante/{id}").buildAndExpand(estudante.getId()).toUri();

        return ResponseEntity.created(uri).body(retorno);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody Estudante dados){
        //No futuro, vai ser bom você impedir que certas informações sejam
        //editaveis dentro do sistema, quando isso acontecer, crie um DTO para
        //update

        var estudante = estudanteService.updateEstudante(dados);

        return ResponseEntity.ok(estudante);
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){

        estudanteService.deleteEstudante(id);

        return ResponseEntity.noContent().build();
    }

}
