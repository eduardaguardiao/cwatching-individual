package com.cw.dao;

import com.cw.conexao.Conexao;
import com.cw.models.*;
import com.cw.services.LogsService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SessaoDAO extends Conexao {

    public SessaoDAO() {
    }

    public Integer registrarSessao(Integer fkMaquina, Integer fkUsuario) {
        String sql = "INSERT INTO sessao (fk_maquina, fk_usuario) VALUES (?, ?)";
        Integer id = null;

        try {
            id = keyInsert(sql, fkMaquina, fkUsuario);
        } catch(Exception e) {
            LogsService.gerarLog("Falha ao registrar sessão: " + e.getMessage());
        }

        return id;
    }

    public void updateFimSessao(Integer idSessao) {
        String sql = "UPDATE sessao SET fim_sessao = now() WHERE id_sessao = ?";
        try {
            insert(sql, idSessao);
        } catch (Exception e) {
            LogsService.gerarLog("Falha ao registrar ociosidade: " + e.getMessage());
        }
    }

    public Sessao buscarSessao(Integer idSessao) {
        String sql = "SELECT * FROM sessao WHERE id_sessao = ?";
        Sessao s;

        try {
            s = conNuvem.queryForObject(sql, new BeanPropertyRowMapper<>(Sessao.class), idSessao);
        } catch (Exception e) {
            LogsService.gerarLog("Falha ao buscar última sessão por máquina: " + e.getMessage());
            return null;
        }

        return s;
    }
}
