package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.sql.Date;

public record EstudanteDTO(
        @NotBlank
        String nome,
        @NotBlank
        Date dataNascimento,
        @NotBlank
        @Email
        String email,
        Long id
) {
}
