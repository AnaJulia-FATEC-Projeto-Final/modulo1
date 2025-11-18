package com.anajulia.modulo1.controller.dto.requisicao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@Validated
public record PessoaRequisicao(
        @NotBlank(message = "Preencha o nome")
        String nome,

        @NotNull(message = "Preencha a data de nascimento")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate dt_nascimento
) {
}
