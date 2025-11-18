package com.anajulia.repositorios;

import com.anajulia.entidades.Paginacao;
import com.anajulia.entidades.Pessoa;

public interface PessoaRepositorio {
    Paginacao<Pessoa> listar(int page);

    Pessoa lerPorId(String id);

    Pessoa salvar(Pessoa pessoa);

    void inativar(String id);
}
