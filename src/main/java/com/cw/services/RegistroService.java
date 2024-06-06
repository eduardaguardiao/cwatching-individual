package com.cw.services;

import com.cw.dao.ProcessoDAO;
import com.cw.dao.RegistroDAO;
import com.cw.models.Processo;
import com.cw.models.Registro;
import com.cw.models.Sessao;
import com.github.britooo.looca.api.core.Looca;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;

import java.util.Timer;
import java.util.TimerTask;

public class RegistroService extends TimerTask {
    private Sessao sessao;
    private AlertaService alertaService;

    private Looca looca = new Looca();
    private SystemInfo oshi = new SystemInfo();

    private RegistroDAO registroDAO = new RegistroDAO();
    private ProcessoDAO processoDAO = new ProcessoDAO();

    private Boolean registrarProcessos = true;

    public RegistroService(Sessao sessao, AlertaService alertaService) {
        this.sessao = sessao;
        this.alertaService = alertaService;
    }

    public void run() {

        try {
            Registro registro = new Registro(
                    looca.getProcessador().getUso()*10 > 100 ? 100.0 : looca.getProcessador().getUso()*10,
                    looca.getMemoria().getEmUso(),
                    looca.getMemoria().getDisponivel(),
                    looca.getSistema().getTempoDeAtividade(),
                    sessao.getIdSessao());

            registroDAO.inserirRegistro(registro);

            Registro r = registroDAO.buscarUltimoRegistroPorSessao(sessao);

            if (alertaService.verificarAlerta(r)) registrarProcessos(r);
        } catch (Exception e) {
            System.out.println("Não foi possivel inserir o registro: " + e.getMessage());
            LogsService.gerarLog("Falhou ao inserir um registro de componentes: " + e.getMessage());
        }
    }

    public void registrarProcessos(Registro r) {
        if (!alertaService.getRegistrarProcessos()) return;

        for (OSProcess processo : oshi.getOperatingSystem().getProcesses()) {
            if ((!processo.getPath().contains("C:\\Windows\\System32\\") && !processo.getPath().isEmpty())) {
                Processo p = new Processo(
                        processo.getName(),
                        processo.getPath(),
                        processo.getResidentSetSize(),
                        r.getIdRegistro());

                processoDAO.inserirProcesso(p);
            }
        }

        alertaService.setRegistrarProcessos(false);

        // Reinicializando timeout para inserir novamente os processos
        // TODO: parametrizar o timer
        new Timer().schedule(new TimerProcessosService(alertaService), 15000);

        System.out.println("Registrando processos...\n");
    }
}

