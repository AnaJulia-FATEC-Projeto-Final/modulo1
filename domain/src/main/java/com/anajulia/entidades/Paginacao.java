package com.anajulia.entidades;

public record Paginacao<T> (
        Iterable<T> itens,
        long totalItens,
        int totalPaginas,
        int paginaAtual,
        int itensPorPagina
) {}
