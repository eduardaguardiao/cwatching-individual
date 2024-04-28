package com.cw.models;

import com.cw.conexao.Conexao;

public class Artigo {

    private Integer idArtigo;
    private String titulo;
    private String descricao;
    private String categoria;
    private String palavraChave;
    private String dataDeCriacao;


    public Artigo(Integer idArtigo, String titulo, String descricao, String categoria, String palavraChave, String dataDeCriacao) {
        this.idArtigo = idArtigo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.palavraChave = palavraChave;
        this.dataDeCriacao = dataDeCriacao;
    }

    public Artigo() {
    }

    public Integer getIdArtigo() {
        return idArtigo;
    }

    public void setIdArtigo(Integer idArtigo) {
        this.idArtigo = idArtigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPalavraChave() {
        return palavraChave;
    }

    public void setPalavraChave(String palavraChave) {
        this.palavraChave = palavraChave;
    }

    public String getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(String dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

}
