package com.cw.dao;

import com.cw.conexao.Conexao;
import com.cw.models.RegistroVolume;
import com.cw.models.Volume;
import com.cw.services.LogsService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class RegistroVolumeDAO extends Conexao {

    public RegistroVolumeDAO() {
    }

    public void inserirRegistroVolume(RegistroVolume r) {
        String sql = "INSERT INTO registro_volume (volume_disponivel, fk_sessao, fk_volume) VALUES (?, ?, ?)";

        try {
            insert(sql, r.getVolumeDisponivel(), r.getFkSessao(), r.getFkVolume());
        } catch(Exception e) {
            LogsService.gerarLog("Falha ao inserir registro de volume: " + e.getMessage());
        }
    }

    public RegistroVolume buscarUltimoRegVolumePorUUID(String uuid) {
        RegistroVolume r = new RegistroVolume();
        String sql = "SELECT TOP 1 * FROM registro_volume WHERE fk_volume = ? ORDER BY dt_hora DESC";

        try {
            r = conNuvem.queryForObject(sql, new BeanPropertyRowMapper<>(RegistroVolume.class), uuid);
        } catch (Exception e) {
            System.out.println("Não foi possível buscar registro volume: " + e.getMessage());
            LogsService.gerarLog("Falha ao buscar volume: " + e.getMessage());
        }

        return r;
    }
}
