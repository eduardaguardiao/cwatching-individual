package com.cw;

import com.cw.conexao.Conexao;
import com.cw.models.Relatorio;
import com.cw.models.Usuario;
import com.cw.services.*;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainCW {

    public static void main(String[] args) throws IOException {

        Usuario jean = new Usuario("jean.santos", "jea123123");
        Usuario lucas = new Usuario("lucas.faes", "luc123123");
        Usuario maria = new Usuario("maria.guardiao", "mar123123");
        Usuario pedro = new Usuario("pedro.scortuzzi", "sco123123");
        Usuario samuel = new Usuario("samuel.batista", "sam123123");
        Usuario vinicius = new Usuario("vinicius.zirondi", "vin123123");
        Usuario benedito = new Usuario("ryan.costa", "rya123123");

        List<Usuario> usuarios = Arrays.asList(jean, lucas, maria, pedro, samuel, vinicius, benedito);

        Usuario user = usuarios.get(2);

       // Boolean loginJava = Boolean.parseBoolean(args[0]); // Caso for construir o arquivo .jar
        Boolean loginJava = true; // Caso estiver executando na IDE

        if (!loginJava) {
            System.out.println(usuarios.get(Integer.parseInt(args[1])));
            user = usuarios.get(Integer.parseInt(args[1]));
        }

        Conexao.testarConexoes();

        System.out.println("""
                   ______           __           _       __      __       __ \s
                  / ____/__  ____  / /____  ____| |     / /___ _/ /______/ /_\s
                 / /   / _ \\/ __ \\/ __/ _ \\/ ___/ | /| / / __ `/ __/ ___/ __ \\
                / /___/  __/ / / / /_/  __/ /   | |/ |/ / /_/ / /_/ /__/ / / /
                \\____/\\___/_/ /_/\\__/\\___/_/    |__/|__/\\__,_/\\__/\\___/_/ /_/\s
                                                                             \s
                """);

        LoginService.logar(false, user);

//        Relatorio relatorio = new Relatorio();
//        dentro do limite
//        relatorio.setMemoriaMaxima(4000000000L); // Exemplo de valor em bytes
//        System.out.println(relatorio.verificarMemoria());
//        ultrapassa o limite
//        relatorio.setMemoriaMaxima(2000000000L); // Exemplo de novo valor em bytes
//        System.out.println(relatorio.verificarMemoria());

    }





}
