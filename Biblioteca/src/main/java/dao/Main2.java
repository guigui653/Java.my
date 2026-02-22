package dao;

import br.com.dobackaoBanco.Emprestimo;
import br.com.dobackaoBanco.Livro;
import br.com.dobackaoBanco.Usuario;

import java.time.LocalDate;

public class Main2 {

    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        LivroDAO livroDAO = new LivroDAOImpl();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAOImpl();

        // Busca usuário e livro que já existem no banco
        Usuario usuario = usuarioDAO.buscarPorId(1);
        Livro livro = livroDAO.buscarPorId(1);

        // Verificação de segurança antes de prosseguir
        if (usuario == null || livro == null) {
            System.out.println("❌ Usuário ou Livro não encontrado no banco!");
            return;
        }

        System.out.println("Usuário encontrado: " + usuario);
        System.out.println("Livro encontrado: " + livro);

        // Cria e salva o empréstimo
        String hoje = LocalDate.now().toString();
        String prazo = LocalDate.now().plusDays(14).toString(); // 14 dias de prazo
        Emprestimo emprestimo = new Emprestimo(usuario, livro, hoje, prazo);
        emprestimoDAO.salvar(emprestimo);

        // Lista todos os empréstimos ativos
        System.out.println("\n📋 Empréstimos ativos:");
        emprestimoDAO.listarAtivos().forEach(System.out::println);

        // Devolve o livro
        emprestimoDAO.devolver(emprestimo.getId());

        // Confirma que saiu da lista de ativos
        System.out.println("\n📋 Empréstimos ativos após devolução:");
        emprestimoDAO.listarAtivos().forEach(System.out::println);
    }
}