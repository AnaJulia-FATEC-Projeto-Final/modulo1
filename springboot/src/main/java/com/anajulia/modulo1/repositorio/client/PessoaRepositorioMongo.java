package com.anajulia.modulo1.repositorio.client;

import com.anajulia.modulo1.repositorio.orm.PessoaOrm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepositorioMongo extends MongoRepository<PessoaOrm, String> {
    @Query("{ 'ativo': true }")
    Page<PessoaOrm> listarTodosAtivos(Pageable pageable);
}
