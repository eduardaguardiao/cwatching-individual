package com.cw.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.cw.models.Ocorrencia;
import org.json.JSONObject;

public class SlackService {
    private static HttpClient client = HttpClient.newHttpClient();
    private static final String URL = "https://hooks.slack.com/services/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";

    private static void postar(JSONObject content) {
        HttpRequest request = HttpRequest.newBuilder(
                        URI.create(URL)
                ).header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(String.format("Status: %s", response.statusCode()));
            System.out.println(String.format("Response: %s", response.body()));
            throw new InterruptedException();


        } catch (InterruptedException | IOException e) {
            // Sout;
            LogsService.gerarLog("Erro ao enviar mensagem para o Slack: " + e.getMessage());
        }
    }

    public static void postarOcorrencia(Ocorrencia o) {
        String content = """
                %s
                %s
                %s
                """.formatted(o.getTitulo(), o.getDescricao(), o.getTipo());

        postar(new JSONObject().put("text", content));
    }
}
