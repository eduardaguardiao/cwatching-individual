package com.cw.services;

import java.util.TimerTask;

public class TimerProcessosService extends TimerTask {
    private AlertaService alertaService;

    public TimerProcessosService(AlertaService alertaService) {
        this.alertaService = alertaService;
    }

    public TimerProcessosService() {
    }

    @Override
    public void run() {
        alertaService.setRegistrarProcessos(true);
    }
}
