package com.cw.dao;

import com.cw.conexao.Conexao;
import com.cw.models.Empresa;
import com.cw.models.Funcionario;
import com.cw.models.Usuario;
import com.cw.services.LogsService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends Conexao {
    //TODO: remover formatted

    public UsuarioDAO() {

    }

    public Usuario buscarUsuarioPorUsername(String username) {

        Usuario usuario;

        try {
            usuario = conNuvem.queryForObject("SELECT * FROM usuario WHERE username = '%s'".formatted(username), new BeanPropertyRowMapper<>(Usuario.class));
        } catch (Exception e) {
            LogsService.gerarLog("Falha ao buscar usuário por username: " + e.getMessage());
            return null;
        }

        return usuario;
    }

    public Boolean autenticarLogin(String username, String senha) {

        List<Usuario> usuario = new ArrayList<>();

        try {
            usuario = conNuvem.query("SELECT * FROM usuario WHERE username = '%s' AND senha = '%s'".formatted(username, senha), new BeanPropertyRowMapper<>(Usuario.class));
        } catch(Exception e) {
            LogsService.gerarLog("Falha ao autenticar login: " + e.getMessage());
        }

        return usuario.size() == 1;
    }

    public Empresa buscarEmpresaPorUsername(String username) {
        String sql = "SELECT * FROM empresa JOIN funcionario ON fk_empresa = id_empresa JOIN usuario ON id_usuario = id_funcionario WHERE username = '%s'".formatted(username);

        Empresa empresa;

        try {
            empresa = conNuvem.queryForObject(sql, new BeanPropertyRowMapper<>(Empresa.class));
        } catch(Exception e) {
            LogsService.gerarLog("Falha ao buscar empresa por username: " + e.getMessage());
            return null;
        }

        return empresa;
    }

    public Funcionario buscarFuncionarioPorUsername(String username) {
        String sql = "SELECT * FROM funcionario JOIN usuario ON id_usuario = id_funcionario WHERE username = '%s'".formatted(username);

        Funcionario f;

        try {
            f = conNuvem.queryForObject(sql, new BeanPropertyRowMapper<>(Funcionario.class));
        } catch(Exception e) {
            LogsService.gerarLog("Falha ao buscar funcionario por username: " + e.getMessage());
            return null;
        }

        return f;

    }
}
