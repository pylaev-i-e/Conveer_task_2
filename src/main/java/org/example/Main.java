// Main.java
package org.example;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/hello", exchange -> {
            String query = Optional.ofNullable(exchange.getRequestURI().getQuery()).orElse("");
            String name = "незнакомец";
            if (query.startsWith("name=")) {
                name = query.substring(5);
            }
            String response = "Привет, " + name + "! Сегодня: " + LocalDate.now();
            exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=utf-8");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
        server.setExecutor(null);
        server.start();
        System.out.println("Сервер запущен на порту " + port);
    }
}