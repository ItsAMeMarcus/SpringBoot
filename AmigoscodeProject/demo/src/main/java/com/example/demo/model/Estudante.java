package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    private String nome;
    private String email;
    private int idade;
    private String dataNascimento;

    public Estudante(String nome, String email, int idade, String dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
    }
}
