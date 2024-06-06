package com.cw.dao;

import com.cw.conexao.Conexao;
import com.cw.models.Registro;
import com.cw.models.Sessao;
import com.cw.models.Usuario;
import com.cw.services.LogsService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class RegistroDAO extends Conexao {

    public RegistroDAO() {
    }

    public Registro buscarUltimoRegistroPorSessao(Sessao s) {
        Registro r = new Registro();
        String sql = "SELECT TOP 1 * FROM registro WHERE fk_sessao = ? ORDER BY dt_hora DESC";

        try {
            r = conNuvem.queryForObject(sql, new BeanPropertyRowMapper<>(Registro.class), s.getIdSessao());
        } catch (Exception e) {
            LogsService.gerarLog("Falha ao buscar último registro da sessão: " + e.getMessage());
        }

        return r;
    }

    public void inserirRegistro(Registro r) {
        String sql = "INSERT INTO registro (uso_cpu, uso_ram, disponivel_ram, uptime, fk_sessao) VALUES (?, ?, ?, ?, ?)";

        try {
            insert(sql, r.getUsoCpu(), r.getUsoRam(), r.getDisponivelRam(), r.getUptime(), r.getFkSessao());
        } catch (Exception e) {
            LogsService.gerarLog("Falha ao inserir registro: " + e.getMessage());
        }
    }
}
