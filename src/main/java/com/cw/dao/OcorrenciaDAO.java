package com.cw.dao;

import com.cw.conexao.Conexao;
import com.cw.models.Ocorrencia;
import com.cw.services.LogsService;
import org.springframework.jdbc.core.JdbcTemplate;

public class OcorrenciaDAO extends Conexao {

    public OcorrenciaDAO() {
    }

    public void inserirOcorrencia(Ocorrencia o) {
        String sql = "INSERT INTO ocorrencia (titulo, descricao, tipo, fk_sessao) VALUES (?, ?, ?, ?)";

        try {
            insert(sql, o.getTitulo(), o.getDescricao(), o.getTipo(), o.getFkSessao());
        } catch(Exception e) {
            LogsService.gerarLog("Falha ao inserir ocorrencia: " + e.getMessage());
        }
    }
}
