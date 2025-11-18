package com.anajulia.modulo1.repositorio;

import com.anajulia.entidades.Paginacao;
import com.anajulia.entidades.Pessoa;
import com.anajulia.excecoes.NotFoundExcecao;
import com.anajulia.modulo1.repositorio.adaptador.PessoaRepositorioAdaptador;
import com.anajulia.modulo1.repositorio.client.PessoaRepositorioMongo;
import com.anajulia.modulo1.repositorio.orm.PessoaOrm;
import com.anajulia.repositorios.PessoaRepositorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class PessoaRepositorioImpl implements PessoaRepositorio {
    private final PessoaRepositorioMongo repository;

    public PessoaRepositorioImpl(PessoaRepositorioMongo repository) {
        this.repository = repository;
    }

    @Override
    public Paginacao<Pessoa> listar(int page) {
        Page<PessoaOrm> paginacaoPessoasOrm =  repository.listarTodosAtivos(Pageable.ofSize(10).withPage(page));

        return new Paginacao<Pessoa>(
                PessoaRepositorioAdaptador.cast(paginacaoPessoasOrm),
                paginacaoPessoasOrm.getTotalElements(),
                paginacaoPessoasOrm.getTotalPages(),
                paginacaoPessoasOrm.getPageable().getPageNumber(),
                paginacaoPessoasOrm.getSize()
        );
    }

    @Override
    public Pessoa lerPorId(final String id) {
        PessoaOrm pessoaOrm = repository.findById(id)
                .orElseThrow(() -> new NotFoundExcecao("Pessoa nao existe na API!"));

        return PessoaRepositorioAdaptador.cast(pessoaOrm);
    }

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        PessoaOrm orm = PessoaRepositorioAdaptador.cast(pessoa);
        return PessoaRepositorioAdaptador.cast(repository.save(orm));
    }

    @Override
    public void inativar(final String id) {
        PessoaOrm pessoaOrm = repository.findById(id)
                .orElseThrow(() -> new NotFoundExcecao("Pessoa nao existe na API!"));

        this.salvar(new Pessoa(
                pessoaOrm.id(),
                pessoaOrm.nome(),
                pessoaOrm.dt_nascimento(),
                false
        ));
    }
}