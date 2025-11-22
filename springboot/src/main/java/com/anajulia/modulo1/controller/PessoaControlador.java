package com.anajulia.modulo1.controller;

import com.anajulia.entidades.Paginacao;
import com.anajulia.entidades.Pessoa;
import com.anajulia.modulo1.controller.adaptador.PessoaControladorAdaptador;
import com.anajulia.modulo1.controller.dto.requisicao.PessoaRequisicao;
import com.anajulia.modulo1.controller.dto.resposta.PessoaResposta;
import com.anajulia.repositorios.PessoaRepositorio;
import com.anajulia.servicos.PessoaServico;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anajulia/modulo1/v1")
public class PessoaControlador {

    private static final Logger LOG = LoggerFactory.getLogger(PessoaControlador.class);

    private final PessoaRepositorio repositorio;
    private final PessoaServico servico;

    public PessoaControlador(PessoaRepositorio repositorio, PessoaServico servico) {
        this.repositorio = repositorio;
        this.servico = servico;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/pessoa")
    public Paginacao<Pessoa> listar(
            @RequestParam(value = "page", defaultValue = "0") int page
    ) {
        LOG.info("Listando pessoas - pagina: {}", page);
        return servico.listar(page);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/pessoa")
    public PessoaResposta salvar(@Valid @RequestBody PessoaRequisicao request) {
        LOG.info("Cadastrando nova pessoa: {}", request);
        Pessoa pessoa = PessoaControladorAdaptador.cast(request);
        return PessoaControladorAdaptador.cast(servico.cadastrarOuAtualizar(pessoa));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/pessoa/{id}")
    public PessoaResposta lerPorId(@PathVariable("id") String id) {
        LOG.info("Lendo pessoa por ID: {}", id);
        return PessoaControladorAdaptador.cast(servico.lerPorId(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/pessoa/{id}")
    public void inativar(@PathVariable("id") String id) {
        LOG.info("Inativando pessoa por ID: {}", id);
        servico.inativar(id);
    }
}