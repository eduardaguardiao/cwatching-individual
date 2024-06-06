package com.cw.models;

import org.h2.util.DateTimeUtils;

public class RegistroOciosidadeMouse {
    private int idTempoOciosidade;
    private String dtHoraRegistro;
    private int tempoRegistroMs;
    private int fkUsuario;

    public RegistroOciosidadeMouse(int tempoRegistroMs, int fkUsuario) {
        this.tempoRegistroMs = tempoRegistroMs;
        this.fkUsuario = fkUsuario;
    }

    public RegistroOciosidadeMouse() {
    }

    public int getTempoRegistroMs() {
        return tempoRegistroMs;
    }

    public int getIdTempoOciosidade() {
        return idTempoOciosidade;
    }

    public void setIdTempoOciosidade(int idTempoOciosidade) {
        this.idTempoOciosidade = idTempoOciosidade;
    }

    public String getDtHoraRegistro() {
        return dtHoraRegistro;
    }

    public void setDtHoraRegistro(String dtHoraRegistro) {
        this.dtHoraRegistro = dtHoraRegistro;
    }

    public void setTempoRegistroMs(int tempoRegistroMs) {
        this.tempoRegistroMs = tempoRegistroMs;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    @Override
    public String toString() {
        return """
                -----------------------
                Registro de Ociosidade
                -----------------------
                Tempo ocioso: %.1f seg
                Data e hora: %s
                -----------------------
                """.formatted(((double)tempoRegistroMs)/1000, dtHoraRegistro);
    }
}
