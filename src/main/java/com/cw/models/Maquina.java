package com.cw.models;

public class Maquina {
    private Integer idMaquina;
    private String so;
    private String cpu;
    private Long ram;
    private String hostname;
    private String ip;
    private Integer fkEmpresa;

    public Maquina(String so, String cpu, Long ram, String hostname) {
        this.so = so;
        this.cpu = cpu;
        this.ram = ram;
        this.hostname = hostname;
    }

    public Maquina() {
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Long getRam() {
        return ram;
    }

    public void setRam(Long ram) {
        this.ram = ram;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    @Override
    public String toString() {
        return "Maquina{" +
                "idMaquina=" + idMaquina +
                ", so='" + so + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ram=" + ram +
                ", hostname='" + hostname + '\'' +
                ", ip='" + ip + '\'' +
                ", fkEmpresa=" + fkEmpresa +
                '}';
    }
}
