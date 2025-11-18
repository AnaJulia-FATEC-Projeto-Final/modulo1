package com.anajulia.servicos;

import com.anajulia.entidades.Paginacao;
import com.anajulia.entidades.Pessoa;
import com.anajulia.excecoes.NotFoundExcecao;
import com.anajulia.repositorios.PessoaRepositorio;

public class PessoaServico {

    private final PessoaRepositorio repository;

    public PessoaServico(PessoaRepositorio repository) {
        this.repository = repository;
    }

    public Paginacao<Pessoa> listar(final int page) {
        return repository.listar(page);
    }

    public Pessoa lerPorId(final String id) {
        return repository.lerPorId(id);
    }

    public Pessoa cadastrarOuAtualizar(Pessoa pessoa) {
        try {
            Pessoa updatePessoa = repository.lerPorId(pessoa.id());
            return salvar(updatePessoa.id(), pessoa);
        } catch (NotFoundExcecao ex) {
            return salvar(pessoa);
        }
    }

    private Pessoa salvar(Pessoa pessoa) {
        return salvar(pessoa.id(), pessoa);
    }

    private Pessoa salvar(final String id, Pessoa pessoa) {
        return repository.salvar(new Pessoa(
                id,
                pessoa.nome(),
                pessoa.dt_nascimento(),
                pessoa.ativo()
        ));
    }

    public void inativar(final String id) {
        repository.inativar(id);
    }
}