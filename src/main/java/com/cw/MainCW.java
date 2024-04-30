package com.cw;

import com.cw.dao.*;
import com.cw.database.CriarTabelas;
import com.cw.database.PopularTabelas;
import com.cw.models.*;
import com.cw.services.*;
import com.github.britooo.looca.api.core.Looca;

import java.util.Scanner;
import java.util.Timer;

public class MainCW {

    public static void main(String[] args) throws Exception {
        // Buscar hostname da máquina atual
        String hostname = new Looca().getRede().getParametros().getHostName();

        UsuarioDAO userDao = new UsuarioDAO();
        MaquinaDAO maquinaDAO = new MaquinaDAO();
        SessaoDAO sessaoDAO = new SessaoDAO();
        ParametroAlertaDAO parametroAlertaDAO = new ParametroAlertaDAO();

        System.out.println("""                                                                      
                   ______           __           _       __      __       __ \s
                  / ____/__  ____  / /____  ____| |     / /___ _/ /______/ /_\s
                 / /   / _ \\/ __ \\/ __/ _ \\/ ___/ | /| / / __ `/ __/ ___/ __ \\
                / /___/  __/ / / / /_/  __/ /   | |/ |/ / /_/ / /_/ /__/ / / /
                \\____/\\___/_/ /_/\\__/\\___/_/    |__/|__/\\__,_/\\__/\\___/_/ /_/\s
                                                                             \s                                                                         
                """);

        CriarTabelas.criarTabelas();
        PopularTabelas.popularTabelas();

        // Loop para interação com usuário (login)
        Boolean continuar;
        //Scanner leitor = new Scanner(System.in);
        do {
            Scanner leitor = new Scanner(System.in);

            System.out.print("Usuário: ");
            String username = leitor.next();

            System.out.print("Senha: ");
            String senha = leitor.next();

            System.out.print("Cargo: ");
            String cargo = leitor.next();

                

            // Autentica o login
            if (userDao.autenticarLogin(username, senha)) {
                // Usuário está logado


                String opcoes = """
                        Digite a opção desejada
                        1) Inserir artigo
                        2) Atualizar artigo""";

                Funcionario funcionario = userDao.buscarFuncionarioPorUsername(username, cargo);

                System.out.println("Login com sucesso. Registrando sessão...");
                System.out.println("""
                        \n----------------------------
                        Sessão 
                        ----------------------------
                        Nome: %s %s
                        ----------------------------
                        """.formatted(
                        // sessaoAtual.getDtHoraSessao(),
                        funcionario.getPrimeiroNome(),
                        // funcionario.getSobrenome(),
                        funcionario.getCargo()
                        //maquina.getHostname()
                ));


                ArtigoDAO artigoDao = new ArtigoDAO();
                Artigo artigo = new Artigo();

                Integer escolha, id;
                String titulo, descricao, categoria, palavraChave;

                do {
                    System.out.println(opcoes);
                    escolha = leitor.nextInt();
                    switch (escolha) {
                        case 1:
                            leitor.nextLine();
                            System.out.println("Digite o título do artigo:");
                            titulo = leitor.nextLine();
                            artigo.setTitulo(titulo);

                            System.out.println("Digite a descrição do artigo:");
                            descricao = leitor.nextLine();
                            artigo.setDescricao(descricao);

                            System.out.println("Digite a categoria do artigo:");
                            categoria = leitor.nextLine();
                            artigo.setCategoria(categoria);

                            System.out.println("Digite a palavra-chave do artigo:");
                            palavraChave = leitor.nextLine();
                            artigo.setPalavraChave(palavraChave);

                            artigoDao.inserirArtigo(artigo);
                            break;
                        case 2:
                            leitor.nextLine();

                            System.out.println("Digite o ID do artigo que será atualizado");
                            id = leitor.nextInt();
                            artigo.setIdArtigo(id);

                            if(artigoDao.verificarIdExistente(artigo)){
                                leitor.nextLine();
                            System.out.println("Digite o título do artigo:");
                            titulo = leitor.nextLine();
                            artigo.setTitulo(titulo);

                            System.out.println("Digite a descrição do artigo:");
                            descricao = leitor.nextLine();
                            artigo.setDescricao(descricao);

                            System.out.println("Digite a categoria do artigo:");
                            categoria = leitor.nextLine();
                            artigo.setCategoria(categoria);

                            System.out.println("Digite a palavra-chave do artigo:");
                            palavraChave = leitor.nextLine();
                            artigo.setPalavraChave(palavraChave);

                            artigoDao.atualizarArtigo(artigo);
                            }
                            else {
                                System.out.println("ID não encontrado");
                            }
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                } while (escolha.equals(1) || escolha.equals(2));


                continuar = false;
            } else {
                System.out.println("Login inválido. Tentar novamente? Y/N");

                continuar = leitor.next().equalsIgnoreCase("Y");
            }

        } while (continuar);



    }

}
