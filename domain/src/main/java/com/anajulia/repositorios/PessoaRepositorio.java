package com.anajulia.repositorios;

import com.anajulia.entidades.Pessoa;
import java.util.List;

public interface PessoaRepositorio {
    List<Pessoa> listar(int page);

    Pessoa salvar(Pessoa pessoa);

    Pessoa lerPorId(String id);

    void deletar(String id);
}
