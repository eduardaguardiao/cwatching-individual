package com.cw.services;

public class ConversorService {
    public static Double converterPorcentagem(Long total, Long parcial) {
        return (double)parcial/(double)(total)*100;
    }

    public static Double converterBytesParaGb(Long bytes) {
        return (double)bytes / (Math.pow(10.0, 9.0));
    }
}
