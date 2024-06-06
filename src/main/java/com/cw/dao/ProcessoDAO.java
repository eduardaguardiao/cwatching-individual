package com.cw.dao;

import com.cw.conexao.Conexao;
import com.cw.models.Processo;
import com.cw.models.Registro;
import com.cw.services.LogsService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyEditor;
import java.util.ArrayList;
import java.util.List;

public class ProcessoDAO extends Conexao {
    //TODO: remover formatted

    public void inserirProcesso(Processo p) {
        String sql = "INSERT INTO processo (nome, caminho, uso_ram, fk_registro) VALUES (?, ?, ?, ?)";

        try{
            insert(sql, p.getNome(), p.getCaminho(), p.getUsoRam(), p.getFkRegistro());
        } catch (Exception e) {
            LogsService.gerarLog("Falha ao registrar processo: " + e.getMessage());
        }
    }

    public List<Processo> buscarDezProcessosComMaisMemoria(Registro r) {
        String sql = "SELECT TOP 10 * FROM processo WHERE fk_registro = %d ORDER BY uso_ram DESC".formatted(r.getIdRegistro());

        List<Processo> p = new ArrayList<>();

        try{
            p = conNuvem.query(sql, new BeanPropertyRowMapper<>(Processo.class));
        } catch (Exception e) {
            LogsService.gerarLog("Falha ao buscar 10 processos com mais memória: " + e.getMessage());
        }
        return p;
    }
}
