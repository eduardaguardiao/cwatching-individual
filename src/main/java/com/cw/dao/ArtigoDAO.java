package com.cw.dao;

import com.cw.conexao.Conexao;
import com.cw.models.Artigo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ArtigoDAO {

    private final Conexao conexao = new Conexao();

    private final JdbcTemplate con = conexao.getConexaoDoBanco();


    public void inserirArtigo (Artigo a){
        String sql = "INSERT INTO artigo (titulo, descricao, categoria, palavra_chave) VALUES (?, ?, ?, ?)";
        con.update(sql, a.getTitulo(), a.getDescricao(), a.getCategoria(), a.getPalavraChave());
    }

    public void atualizarArtigo (Artigo a){
        String sql = "UPDATE artigo SET titulo = ?, descricao = ?, categoria = ?, palavra_chave = ? WHERE id_artigo = ?";
        con.update(sql, a.getTitulo(), a.getDescricao(), a.getCategoria(), a.getPalavraChave(), a.getIdArtigo());
    }

        public boolean verificarIdExistente(Artigo id) {
        String sql = "SELECT * FROM artigo WHERE id_artigo = ?";
        List<Artigo> resultados = con.query(sql, new BeanPropertyRowMapper<>(Artigo.class), id.getIdArtigo());
        return !resultados.isEmpty();
    }

}
