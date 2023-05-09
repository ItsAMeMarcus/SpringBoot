package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Estudante {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "estudante_sequence"
    )
    @SequenceGenerator(
            name = "estudante_sequence",
            sequenceName = "estudante_sequence",
            allocationSize = 1
    )
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    private Date dataNascimento;
    private boolean matriculado;

    public Estudante(String nome, String email, Date dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public Estudante(Long id, String nome, String email, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public Estudante(EstudanteDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.dataNascimento = dados.dataNascimento();
    }

    public void updateInfo(Estudante dados){
        if(dados.getEmail() != null){
            this.email = dados.getEmail();
        }
        if(dados.getDataNascimento() != null){
            this.dataNascimento = dados.getDataNascimento();
        }
        if(dados.getNome() != null){
            this.nome = dados.getNome();
        }
    }

    public void excluir() {
        this.matriculado = false;
    }
}
