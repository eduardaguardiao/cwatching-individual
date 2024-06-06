package com.cw.models;

public class PermProcesso {
    private Integer idPermProcesso;
    private String nome;
    private Boolean permitido;
    private Integer fkConfig;

    public PermProcesso(String nome, Boolean permitido, Integer fkConfig) {
        this.nome = nome;
        this.permitido = permitido;
        this.fkConfig = fkConfig;
    }

    public PermProcesso() {
    }

    public Integer getIdPermProcesso() {
        return idPermProcesso;
    }

    public void setIdPermProcesso(Integer idPermProcesso) {
        this.idPermProcesso = idPermProcesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getPermitido() {
        return permitido;
    }

    public void setPermitido(Boolean permitido) {
        this.permitido = permitido;
    }

    public Integer getFkConfig() {
        return fkConfig;
    }

    public void setFkConfig(Integer fkConfig) {
        this.fkConfig = fkConfig;
    }

    @Override
    public String toString() {
        return "PermProcesso{" +
                "idPermProcesso=" + idPermProcesso +
                ", nome='" + nome + '\'' +
                ", permitido=" + permitido +
                ", fkConfig=" + fkConfig +
                '}';
    }
}
