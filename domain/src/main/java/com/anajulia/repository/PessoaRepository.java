package com.anajulia.repository;

import com.anajulia.entity.Pessoa;
import java.util.List;

public interface PessoaRepository {
    List<Pessoa> listar(int page);

    Pessoa salvar(Pessoa pessoa);

    Pessoa lerPorId(String id);

    void deletar(String id);
}
