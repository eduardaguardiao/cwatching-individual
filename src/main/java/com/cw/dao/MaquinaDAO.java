package com.cw.dao;

import com.cw.conexao.Conexao;
import com.cw.models.Empresa;
import com.cw.models.Maquina;
import com.cw.services.LogsService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MaquinaDAO extends Conexao {
    //TODO: remover formatted

    public MaquinaDAO() {
    }

    public Integer inserirMaquina(Maquina m, Empresa empresa) {
        try {
            if (!verificarMaquinaExistePorHostnameEEmpresa(m.getHostname(), empresa)) {
                String sql = "INSERT INTO maquina (so, cpu_modelo, ram_total, hostname, ip, fk_empresa) VALUES (?, ?, ?, ?, ?, ?)";
                return keyInsert(sql, m.getSo(), m.getCpu(), m.getRam(), m.getHostname(), m.getIp(), m.getFkEmpresa());
            }

        }catch (Exception e){
            LogsService.gerarLog("Falha ao inserir maquina: " + e.getMessage());
        }

        return null;
    }

    public Boolean componentesAlterou(Maquina m) {
        Boolean alterado = false;
        String sql = ("SELECT * FROM maquina WHERE " +
                "hostname = '%s' AND " +
                "ip = '%s' AND " +
                "cpu_modelo = '%s' AND " +
                "ram_total = %d AND" +
                " so = '%s'").formatted(m.getHostname(), m.getIp(), m.getCpu(), m.getRam(), m.getSo());
        try{

            alterado = conNuvem.query(sql, new BeanPropertyRowMapper<>(Maquina.class)).isEmpty();
        }catch (Exception e){
            LogsService.gerarLog("Falha ao verificar mudanças de componentes: "+ e.getMessage());
        }
        return alterado;

    }

    public void atualizarMaquina(Maquina m, Empresa empresa) {
        String sql = ("UPDATE maquina SET so = ?, cpu_modelo = ?, ram_total = ?, modificado_em = now() WHERE hostname = ? AND fk_empresa = ?");
        try {
            insert(sql, m.getSo(), m.getCpu(), m.getRam(), m.getHostname(), empresa.getIdEmpresa());

        }catch (Exception e){
            LogsService.gerarLog("Falha ao atualizar máquina: " + e.getMessage());
        }

    }

    public Boolean verificarMaquinaExistePorHostnameEEmpresa(String hostname, Empresa empresa) {
        String sql = "SELECT hostname FROM maquina WHERE hostname = ? AND fk_empresa = ?";
        Boolean existe = false;

        try {
            existe = !conNuvem.query(sql, new BeanPropertyRowMapper<>(Maquina.class), hostname, empresa.getIdEmpresa()).isEmpty();
        }catch (Exception e){
            LogsService.gerarLog("Falha ao verificar se máquina existe: " + e.getMessage());
        }

        return existe;
    }

    public Maquina buscarMaquinaPorHostnameEEmpresa(String hostname, Empresa empresa) {
        Maquina maquina = new Maquina();
        try {
            String sql = "SELECT * FROM maquina WHERE hostname = '%s' AND fk_empresa = %d".formatted(hostname, empresa.getIdEmpresa());

            maquina = conNuvem.queryForObject(sql, new BeanPropertyRowMapper<>(Maquina.class));
        }catch (Exception e){
            LogsService.gerarLog("Falha ao buscar máquina: " + e.getMessage());
        }
        return maquina;
    }
}
