package dao;

import br.com.dobackaoBanco.Livro;
import br.com.dobackaoBanco.Usuario;
import service.EmprestimoService;
import service.LivroService;

public class Main3 {

    public static void main(String[] args) {

        LivroService livroService = new LivroService();
        EmprestimoService emprestimoService = new EmprestimoService();

        // Busca os dados
        Livro livro = livroService.buscarPorId(1);
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        Usuario usuario = usuarioDAO.buscarPorId(1);

        System.out.println("Estoque antes: " + livro.getQuantidade());

        // Realiza empréstimo (com validação de estoque!)
        emprestimoService.realizarEmprestimo(usuario, livro);

        System.out.println("Estoque depois: " + livro.getQuantidade());

        // Lista ativos
        System.out.println("\n📋 Empréstimos ativos:");
        emprestimoService.listarAtivos().forEach(System.out::println);
    }
}