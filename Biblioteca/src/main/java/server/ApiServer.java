package server;

import br.com.dobackaoBanco.Livro;
import br.com.dobackaoBanco.Usuario;
import com.google.gson.Gson;
import dao.LivroDAOImpl;
import dao.UsuarioDAOImpl;
import service.EmprestimoService;
import service.LivroService;
import service.UsuarioService;
import util.ConexaoBanco;

import static spark.Spark.*;

public class ApiServer {

    public static void main(String[] args) {
        // Configura porta
        port(8090);

        // Habilita CORS
        before((req, res) -> {
            res.header("Access-Control-Allow-Origin", "*");
            res.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            res.header("Access-Control-Allow-Headers", "Content-Type");
            res.type("application/json");
        });
        options("/*", (req, res) -> "OK");

        // Teste de conexão com banco (não fatal)
        try {
            ConexaoBanco.testarConexao();
        } catch (Exception e) {
            System.err.println("⚠️ Banco de dados indisponível na inicialização.");
        }

        Gson gson = new Gson();
        LivroService livroService = new LivroService();
        UsuarioService usuarioService = new UsuarioService();
        EmprestimoService emprestimoService = new EmprestimoService();

        // Rota de saúde
        get("/health", (req, res) -> {
            try {
                ConexaoBanco.testarConexao();
                return gson.toJson(new SucessoResponse("Servidor OK - Banco conectado"));
            } catch (Exception e) {
                res.status(503);
                return gson.toJson(new ErroResponse("Banco de dados indisponível: " + e.getMessage()));
            }
        });

        // Rota simples para testar se o servidor está no ar (independente do banco)
        get("/ping", (req, res) -> "pong");

        // -------------------- LIVROS --------------------
        get("/livros", (req, res) -> gson.toJson(livroService.listarTodos()));
        get("/livros/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            return gson.toJson(livroService.buscarPorId(id));
        });
        post("/livros", (req, res) -> {
            Livro livro = gson.fromJson(req.body(), Livro.class);
            livroService.cadastrarLivro(livro.getTitulo(), livro.getAutor(), livro.getIsbn(), livro.getQuantidade(), livro.getCategoria());
            res.status(201);
            return gson.toJson(new SucessoResponse("Livro cadastrado!"));
        });
        put("/livros/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Livro livro = gson.fromJson(req.body(), Livro.class);
            livro.setId(id);
            livroService.atualizarLivro(livro);
            return gson.toJson(new SucessoResponse("Livro atualizado!"));
        });
        delete("/livros/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            livroService.deletarLivro(id);
            return gson.toJson(new SucessoResponse("Livro deletado!"));
        });

        // -------------------- USUÁRIOS --------------------
        get("/usuarios", (req, res) -> gson.toJson(usuarioService.listarTodos()));
        post("/usuarios", (req, res) -> {
            Usuario usuario = gson.fromJson(req.body(), Usuario.class);
            usuarioService.cadastrarUsuario(usuario);
            res.status(201);
            return gson.toJson(new SucessoResponse("Usuário cadastrado!"));
        });
        put("/usuarios/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Usuario usuario = gson.fromJson(req.body(), Usuario.class);
            usuario.setId(id);
            usuarioService.atualizarUsuario(usuario);
            return gson.toJson(new SucessoResponse("Usuário atualizado!"));
        });
        delete("/usuarios/:id", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            usuarioService.deletarUsuario(id);
            return gson.toJson(new SucessoResponse("Usuário deletado!"));
        });

        // -------------------- EMPRÉSTIMOS --------------------
        get("/emprestimos", (req, res) -> gson.toJson(emprestimoService.listarTodos()));
        get("/emprestimos/ativos", (req, res) -> gson.toJson(emprestimoService.listarAtivos()));
        post("/emprestimos", (req, res) -> {
            EmprestimoRequest er = gson.fromJson(req.body(), EmprestimoRequest.class);
            Livro livro = new LivroDAOImpl().buscarPorId(er.livroId);
            Usuario usuario = new UsuarioDAOImpl().buscarPorId(er.usuarioId);
            if (livro == null || usuario == null) {
                res.status(404);
                return gson.toJson(new ErroResponse("Livro ou usuário não encontrado"));
            }
            emprestimoService.realizarEmprestimo(usuario, livro);
            res.status(201);
            return gson.toJson(new SucessoResponse("Empréstimo realizado!"));
        });
        put("/emprestimos/:id/devolver", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            emprestimoService.devolverEmprestimo(id);
            return gson.toJson(new SucessoResponse("Livro devolvido!"));
        });

        System.out.println("\n🚀 Servidor rodando em http://localhost:8090");
        System.out.println("📌 Teste: http://localhost:8090/ping");
        System.out.println("📌 Teste com banco: http://localhost:8090/health");

        // Mantém a thread principal viva (opcional, mas seguro)
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ErroResponse { String erro; ErroResponse(String erro) { this.erro = erro; } }
    static class SucessoResponse { String mensagem; SucessoResponse(String mensagem) { this.mensagem = mensagem; } }
    static class EmprestimoRequest { int usuarioId; int livroId; }
}