package com.anajulia.service;

import com.anajulia.entity.Pessoa;
import com.anajulia.exception.NotFoundException;
import com.anajulia.repository.PessoaRepository;

public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public Pessoa cadastrarOuAtualizar(Pessoa pessoa) {
        try {
            Pessoa updatePessoa = repository.lerPorId(pessoa.id());
            return salvar(updatePessoa.id(), pessoa);
        } catch (NotFoundException ex) {
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
}