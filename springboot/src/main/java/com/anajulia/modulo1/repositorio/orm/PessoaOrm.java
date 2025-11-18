package com.anajulia.modulo1.repositorio.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(value = "pessoas")
public record PessoaOrm(
        @Id
        String id,
        String nome,
        LocalDate dt_nascimento,
        boolean ativo
) {
}
