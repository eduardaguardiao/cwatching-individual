package com.cw.dao;

import com.cw.conexao.Conexao;
import com.cw.models.Config;
import com.cw.models.Empresa;
import com.cw.models.PermProcesso;
import com.cw.services.LogsService;
import com.mysql.cj.log.Log;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class ConfigDAO extends Conexao {
    //TODO: remover formatted

    public Config buscarConfigPorEmpresa(Empresa empresa) {
        Config c = new Config();

        try {
            String sql = "SELECT * FROM config WHERE id_config = %d".formatted(empresa.getIdEmpresa());
            c = conNuvem.queryForObject(sql, new BeanPropertyRowMapper<>(Config.class));
        } catch (Exception e){
            LogsService.gerarLog("Falha ao buscar configuração: " + e.getMessage());
        }

        return c;
    }

    public List<PermProcesso> buscarPermProcessosPorConfig(Config c) {
        String sql = "SELECT * FROM perm_processo WHERE fk_config = %d".formatted(c.getIdConfig());
        List<PermProcesso> p = new ArrayList<>();

        try {
            p = conNuvem.query(sql, new BeanPropertyRowMapper<>(PermProcesso.class));
        } catch (Exception e){
            LogsService.gerarLog("Falha ao buscar configuração de processo: " + e.getMessage());
        }

        return p;
    }
}
