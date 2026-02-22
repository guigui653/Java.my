package service;

import br.com.dobackaoBanco.Emprestimo;
import br.com.dobackaoBanco.Livro;
import br.com.dobackaoBanco.Usuario;
import dao.EmprestimoDAO;
import dao.EmprestimoDAOImpl;
import dao.LivroDAO;
import dao.LivroDAOImpl;

import java.time.LocalDate;
import java.util.List;

public class EmprestimoService {

    private EmprestimoDAO emprestimoDAO;
    private LivroDAO livroDAO;

    public EmprestimoService() {
        this.emprestimoDAO = new EmprestimoDAOImpl();
        this.livroDAO = new LivroDAOImpl();
    }

    public void realizarEmprestimo(Usuario usuario, Livro livro) {
        if (livro.getQuantidade() <= 0)
            throw new RuntimeException("❌ Livro '" + livro.getTitulo() + "' sem estoque!");

        long ativos = emprestimoDAO.listarAtivos()
                .stream()
                .filter(e -> e.getUsuario().getId() == usuario.getId())
                .count();

        if (ativos >= 3)
            throw new RuntimeException("❌ Usuário já possui 3 empréstimos ativos!");

        String hoje = LocalDate.now().toString();
        String prazo = LocalDate.now().plusDays(14).toString();

        Emprestimo emprestimo = new Emprestimo(usuario, livro, hoje, prazo);
        emprestimoDAO.salvar(emprestimo);

        livro.setQuantidade(livro.getQuantidade() - 1);
        livroDAO.atualizar(livro);

        System.out.println("✅ Empréstimo realizado! Prazo: " + prazo);
    }

    public void devolverEmprestimo(int emprestimoId) {
        Emprestimo emprestimo = emprestimoDAO.buscarPorId(emprestimoId);
        if (emprestimo == null) {
            throw new RuntimeException("Empréstimo não encontrado!");
        }

        emprestimoDAO.devolver(emprestimoId);

        Livro livro = emprestimo.getLivro();
        livro.setQuantidade(livro.getQuantidade() + 1);
        livroDAO.atualizar(livro);

        System.out.println("✅ Devolução realizada e estoque atualizado!");
    }

    public List<Emprestimo> listarAtivos() {
        return emprestimoDAO.listarAtivos();
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoDAO.listarTodos();
    }
}