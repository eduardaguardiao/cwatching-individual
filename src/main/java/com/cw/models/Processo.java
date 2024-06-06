package com.cw.models;

import com.cw.services.ConversorService;

public class Processo {
    private Integer idProcesso;
    private String nome;
    private String caminho;
    private Long usoRam;
    private Integer fkRegistro;

    public Processo(String nome, String caminho, Long usoRam, Integer fkRegistro) {
        this.nome = nome;
        this.caminho = caminho;
        this.usoRam = usoRam;
        this.fkRegistro = fkRegistro;
    }

    public Processo() {
    }

    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Long getUsoRam() {
        return usoRam;
    }

    public void setUsoRam(Long usoRam) {
        this.usoRam = usoRam;
    }

    public Integer getFkRegistro() {
        return fkRegistro;
    }

    public void setFkRegistro(Integer fkRegistro) {
        this.fkRegistro = fkRegistro;
    }

    @Override
    public String toString() {
        return """
                Nome: %s
                Uso de RAM: %.1f GB
                Caminho: %s
                """.formatted(nome, ConversorService.converterBytesParaGb(usoRam), caminho);
    }
}
