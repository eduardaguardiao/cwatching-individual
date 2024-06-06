package com.cw.conexao;

import com.cw.services.LogsService;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Conexao {
    public static final JdbcTemplate conLocal = setConexaoLocal();
    public static final JdbcTemplate conNuvem = setConexaoNuvem();
    public JdbcTemplate conexao;

    public Conexao() {

    }

    private static JdbcTemplate setConexaoLocal() {

            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/cwdb");
            dataSource.setUsername("root");
            dataSource.setPassword("root");

            return new JdbcTemplate(dataSource);
    }

    private static JdbcTemplate setConexaoNuvem() {

         BasicDataSource dataSource = new BasicDataSource();
         dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         dataSource.setUrl("jdbc:sqlserver://54.198.160.133:1433;database=cwdb;trustServerCertificate=true");
         dataSource.setUsername("sa");
         dataSource.setPassword("cwc@2024");

         return new JdbcTemplate(dataSource);
    }

    private static void testarConexao(JdbcTemplate con) {
        try {
            con.queryForObject("SELECT 1", Integer.class);
        } catch (Exception e) {
            LogsService.gerarLog("Falha ao estabelecer conexão com o MySQL: " + e.getMessage() + " " + Arrays.toString(e.getStackTrace()));
        }
    }

    public static void testarConexoes() {
        testarConexao(conLocal);
        testarConexao(conNuvem);
    }

    public void insert(String sql, Object ... args) {
        insertFuture(sql, conLocal, args);
        insertFuture(sql, conNuvem, args);
    }

    public Integer keyInsert(String sql, Object ... args) {
        insertFuture(sql, conLocal, args);
        return keyInsertFuture(sql, conNuvem, args);
    }

    public void insertFuture(String sql, JdbcTemplate con, Object ... args) {
        CompletableFuture.runAsync(() -> {
            con.update(sql, args);
        });
    }

    public Integer keyInsertFuture(String sql, JdbcTemplate con, Object ... args) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        Integer key = null;

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                con.update(connection -> {
                    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    for (int i = 0; i < args.length; i++) {
                        ps.setObject(i + 1, args[i]);
                    }
                    return ps;
                }, keyHolder);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return keyHolder.getKey().intValue();
        });

        try {
            key = future.get();
        } catch (Exception e) {
            LogsService.gerarLog("Erro ao inserir: " + e.getMessage());
        }

        return key;
    }
}

