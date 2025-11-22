package com.anajulia.modulo1.controller.adaptador;

import com.anajulia.entidades.Pessoa;
import com.anajulia.modulo1.controller.dto.requisicao.PessoaRequisicao;
import com.anajulia.modulo1.controller.dto.resposta.PessoaResposta;
import java.util.UUID;

public class PessoaControladorAdaptador {
    private PessoaControladorAdaptador() {
    }

    public static PessoaResposta cast(Pessoa pessoa) {
        return new PessoaResposta(
                pessoa.id(),
                pessoa.nome(),
                pessoa.dt_nascimento().toString()
        );
    }

    public static Pessoa cast(PessoaRequisicao request) {
        return new Pessoa(
                UUID.randomUUID().toString(),
                request.nome(),
                request.dt_nascimento(),
                true
        );
    }
}
