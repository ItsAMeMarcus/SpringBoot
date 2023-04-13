package med.voll.apiHospital.controller;

import jakarta.validation.Valid;
import med.voll.apiHospital.medico.*;
import med.voll.apiHospital.medico.DadosListagemMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;
    @PostMapping
    @Transactional
    public void cadastroMedico(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listagemMedico(@PageableDefault(size = 10,sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @GetMapping(value = "/{id}")
    public Optional<DadosListagemMedico> listagemMedicoId(@PathVariable Long id){
        return repository.findById(id).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void alterarDadosMedico(@RequestBody @Valid DadosAtualizarMedico dados){
        var medico = repository.getReferenceById(dados.id());

        medico.atualizarInfomacoes(dados);
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public void deletarMedico(@PathVariable Long id){
        var medico = repository.getReferenceById(id);

        medico.excluir();
    }
}
