package com.cw.dao;

import com.cw.conexao.Conexao;
import com.cw.models.Artigo;
import com.cw.models.Maquina;
import org.springframework.jdbc.core.JdbcTemplate;

public class ArtigoDAO {

    private final Conexao conexao = new Conexao();

    private final JdbcTemplate con = conexao.getConexaoDoBanco();


    public void inserirArtigo (Artigo a){
        String sql = "INSERT INTO artigo (titulo, descricao, categoria, palavra_chave) VALUES (?, ?, ?, ?)";
        con.update(sql, a.getTitulo(), a.getDescricao(), a.getCategoria(), a.getPalavraChave());
    }

}
