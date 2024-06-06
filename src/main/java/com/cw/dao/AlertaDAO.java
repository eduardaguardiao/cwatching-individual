package com.cw.dao;

import com.cw.conexao.Conexao;
import com.cw.models.Alerta;
import com.cw.services.LogsService;
import org.springframework.jdbc.core.JdbcTemplate;

public class AlertaDAO extends Conexao {

    public AlertaDAO() {
    }

    public void inserirAlerta(Alerta l) {
        System.out.println("Inserindo alerta...\n");
        String sql = "INSERT INTO alerta(tipo, descricao, fk_registro, fk_reg_volume) values (?, ?, ?, ?)";
        try{
            insert(sql, l.getTipo(), l.getDescricao(), l.getFkRegistro(), l.getFkRegVolume());
        }catch (Exception e){
            LogsService.gerarLog("Falha ao inserir alerta: "+ e.getMessage());
        }

    }
}
