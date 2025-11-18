package com.anajulia.modulo1.controller;

import com.anajulia.entidades.Paginacao;
import com.anajulia.entidades.Pessoa;
import com.anajulia.modulo1.controller.adaptador.PessoaControladorAdaptador;
import com.anajulia.modulo1.controller.dto.requisicao.PessoaRequisicao;
import com.anajulia.modulo1.controller.dto.resposta.PessoaResposta;
import com.anajulia.repositorios.PessoaRepositorio;
import com.anajulia.servicos.PessoaServico;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anajulia")
public class PessoaControlador {
    private final PessoaRepositorio repositorio;
    private final PessoaServico servico;

    public PessoaControlador(PessoaRepositorio repositorio, PessoaServico servico) {
        this.repositorio = repositorio;
        this.servico = servico;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/modulo1/pessoa")
    public Paginacao<Pessoa> listar(
            @RequestParam(value = "page", defaultValue = "0") int page
    ) {
        return servico.listar(page);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/modulo1/pessoa")
    public PessoaResposta salvar(@Valid @RequestBody PessoaRequisicao request) {
        Pessoa pessoa = PessoaControladorAdaptador.cast(request);
        return PessoaControladorAdaptador.cast(servico.cadastrarOuAtualizar(pessoa));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/modulo1/pessoa/{id}")
    public PessoaResposta lerPorId(@PathVariable("id") String id) {
        return PessoaControladorAdaptador.cast(servico.lerPorId(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/modulo1/pessoa/{id}")
    public void inativar(@PathVariable("id") String id) {
        servico.inativar(id);
    }
}