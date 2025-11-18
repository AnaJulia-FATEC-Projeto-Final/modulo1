package com.anajulia.modulo1.repositorio.adaptador;

import com.anajulia.entidades.Pessoa;
import com.anajulia.modulo1.repositorio.orm.PessoaOrm;
import org.springframework.data.domain.Page;
import java.util.List;

public class PessoaRepositorioAdaptador {
    private PessoaRepositorioAdaptador() {
    }

    public static PessoaOrm cast(Pessoa pessoa) {
        return new PessoaOrm(
                pessoa.id(),
                pessoa.nome(),
                pessoa.dt_nascimento(),
                pessoa.ativo()
        );
    }

    public static Pessoa cast(PessoaOrm pessoaOrm) {
        return new Pessoa(
                pessoaOrm.id(),
                pessoaOrm.nome(),
                pessoaOrm.dt_nascimento(),
                pessoaOrm.ativo()
        );
    }

    public static List<Pessoa> cast(Page<PessoaOrm> paginacaoPessoasOrm) {
        return paginacaoPessoasOrm.map(PessoaRepositorioAdaptador::cast).toList();
    }
}