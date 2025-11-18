package com.anajulia.entity;

import java.time.LocalDate;

public record Pessoa(
        String id,
        String nome,
        LocalDate dt_nascimento,
        boolean ativo
) {
}
