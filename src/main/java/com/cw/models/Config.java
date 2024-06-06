package com.cw.models;

import java.util.List;

public class Config {
    private Integer idConfig;
    private Double maxCpu;
    private Double maxRam;
    private Double maxVolume;
    private Integer sensibilidadeMouse;
    private Integer timerMouseMs;
    private Integer intervaloRegistroMs;
    private Integer intervaloVolumeMs;
    private Integer intervaloQuestDias;
    private List<PermProcesso> permProcessos;

    public Config(Double maxCpu, Double maxRam, Double maxVolume, Integer sensibilidadeMouse, Integer timerMouseMs, Integer intervaloRegistroMs, Integer intervaloVolumeMs, Integer intervaloQuestDias) {
        this.maxCpu = maxCpu;
        this.maxRam = maxRam;
        this.maxVolume = maxVolume;
        this.sensibilidadeMouse = sensibilidadeMouse;
        this.timerMouseMs = timerMouseMs;
        this.intervaloRegistroMs = intervaloRegistroMs;
        this.intervaloVolumeMs = intervaloVolumeMs;
        this.intervaloQuestDias = intervaloQuestDias;
    }

    public Config() {
    }

    public Integer getIdConfig() {
        return idConfig;
    }

    public void setIdConfig(Integer idConfig) {
        this.idConfig = idConfig;
    }

    public Double getMaxCpu() {
        return maxCpu;
    }

    public void setMaxCpu(Double maxCpu) {
        this.maxCpu = maxCpu;
    }

    public Double getMaxRam() {
        return maxRam;
    }

    public void setMaxRam(Double maxRam) {
        this.maxRam = maxRam;
    }

    public Double getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(Double maxVolume) {
        this.maxVolume = maxVolume;
    }

    public Integer getSensibilidadeMouse() {
        return sensibilidadeMouse;
    }

    public void setSensibilidadeMouse(Integer sensibilidadeMouse) {
        this.sensibilidadeMouse = sensibilidadeMouse;
    }

    public Integer getTimerMouseMs() {
        return timerMouseMs;
    }

    public void setTimerMouseMs(Integer timerMouseMs) {
        this.timerMouseMs = timerMouseMs;
    }

    public Integer getIntervaloRegistroMs() {
        return intervaloRegistroMs;
    }

    public void setIntervaloRegistroMs(Integer intervaloRegistroMs) {
        this.intervaloRegistroMs = intervaloRegistroMs;
    }

    public Integer getIntervaloVolumeMs() {
        return intervaloVolumeMs;
    }

    public void setIntervaloVolumeMs(Integer intervaloVolumeMs) {
        this.intervaloVolumeMs = intervaloVolumeMs;
    }

    public Integer getIntervaloQuestDias() {
        return intervaloQuestDias;
    }

    public void setIntervaloQuestDias(Integer intervaloQuestDias) {
        this.intervaloQuestDias = intervaloQuestDias;
    }

    public List<PermProcesso> getPermProcessos() {
        return permProcessos;
    }

    public void setPermProcessos(List<PermProcesso> permProcessos) {
        this.permProcessos = permProcessos;
    }

    @Override
    public String toString() {
        return "Config{" +
                "idConfig=" + idConfig +
                ", maxCpu=" + maxCpu +
                ", maxRam=" + maxRam +
                ", maxVolume=" + maxVolume +
                ", sensibilidadeMouse=" + sensibilidadeMouse +
                ", timerMouseMs=" + timerMouseMs +
                ", intervaloRegistroMs=" + intervaloRegistroMs +
                ", intervaloVolumeMs=" + intervaloVolumeMs +
                ", intervaloQuestDias=" + intervaloQuestDias +
                ", permProcessos=" + permProcessos +
                '}';
    }
}
