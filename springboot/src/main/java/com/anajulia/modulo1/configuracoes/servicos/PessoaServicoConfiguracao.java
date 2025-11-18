package com.anajulia.modulo1.configuracoes.servicos;

import com.anajulia.repositorios.PessoaRepositorio;
import com.anajulia.servicos.PessoaServico;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PessoaServicoConfiguracao {

    @Bean
    public PessoaServico pessoaServico(
            PessoaRepositorio repository
    ) {
        return new PessoaServico(repository);
    }
}