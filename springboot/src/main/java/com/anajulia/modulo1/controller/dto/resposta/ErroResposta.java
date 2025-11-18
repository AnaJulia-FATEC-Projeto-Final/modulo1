package com.anajulia.modulo1.controller.dto.resposta;

import java.time.LocalDateTime;

public record ErroResposta(
        LocalDateTime date,
        String path,
        Integer status,
        String error,
        String message
) {
}
