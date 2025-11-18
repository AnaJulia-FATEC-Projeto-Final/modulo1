package com.anajulia.entidades;

public class Paginacao<T> {
    private final Iterable<T> itens;
    private final int totalItens;
    private final int totalPaginas;
    private final int paginaAtual;
    private final int itensPorPagina = 10;

    public Paginacao(Iterable<T> itens, int totalItens, int totalPaginas, int paginaAtual) {
        this.itens = itens;
        this.totalItens = totalItens;
        this.totalPaginas = totalPaginas;
        this.paginaAtual = paginaAtual;
    }

    public Iterable<T> getItens() {
        return itens;
    }

    public int getTotalItens() {
        return totalItens;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public int getPaginaAtual() {
        return paginaAtual;
    }

    public int getItensPorPagina() {
        return itensPorPagina;
    }
}
