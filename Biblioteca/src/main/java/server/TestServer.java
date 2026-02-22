package server;

import static spark.Spark.*;

public class TestServer {
    public static void main(String[] args) {
        port(8090);
        get("/hello", (req, res) -> "Hello World");
        System.out.println("✅ TestServer rodando na porta 8090");
        System.out.println("👉 Acesse: http://localhost:8090/hello");

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}