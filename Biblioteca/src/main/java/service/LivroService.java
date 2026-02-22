package service;

import br.com.dobackaoBanco.Livro;
import dao.LivroDAO;
import dao.LivroDAOImpl;
import java.util.List;

public class LivroService {

    private LivroDAO livroDAO;

    public LivroService() {
        this.livroDAO = new LivroDAOImpl();
    }

    public void cadastrarLivro(String titulo, String autor, String isbn, int quantidade, String categoria) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título não pode ser vazio!");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa!");
        }

        Livro livro = new Livro(titulo, autor, isbn, quantidade, categoria);
        livroDAO.salvar(livro);
    }

    public List<Livro> listarTodos() {
        return livroDAO.listarTodos();
    }

    public List<Livro> buscarPorTermo(String termo) {
        return livroDAO.buscarPorTermo(termo);
    }

    public Livro buscarPorId(int id) {
        Livro livro = livroDAO.buscarPorId(id);
        if (livro == null) {
            throw new RuntimeException("Livro com ID " + id + " não encontrado!");
        }
        return livro;
    }

    public void atualizarLivro(Livro livro) {
        if (livro.getId() <= 0) {
            throw new IllegalArgumentException("ID inválido para atualização!");
        }
        livroDAO.atualizar(livro);
    }

    public void deletarLivro(int id) {
        livroDAO.deletar(id);
    }
}