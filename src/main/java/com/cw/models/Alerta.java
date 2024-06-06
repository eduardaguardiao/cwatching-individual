package com.cw.models;

public class Alerta {
    private Integer idAlerta;
    private String tipo;
    private String descricao;
    private Integer fkRegistro;
    private Integer fkRegVolume;

    public Alerta(String tipo, String descricao, Integer fkRegistro, Integer fkRegVolume) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.fkRegistro = fkRegistro;
        this.fkRegVolume = fkRegVolume;
    }

    public Integer getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Integer idAlerta) {
        this.idAlerta = idAlerta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getFkRegistro() {
        return fkRegistro;
    }

    public void setFkRegistro(Integer fkRegistro) {
        this.fkRegistro = fkRegistro;
    }

    public Integer getFkRegVolume() {
        return fkRegVolume;
    }

    public void setFkRegVolume(Integer fkRegVolume) {
        this.fkRegVolume = fkRegVolume;
    }

    @Override
    public String toString() {
        return "Alerta{" +
                "idAlerta=" + idAlerta +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", fkRegistro=" + fkRegistro +
                ", fkRegVolume=" + fkRegVolume +
                '}';
    }
}
