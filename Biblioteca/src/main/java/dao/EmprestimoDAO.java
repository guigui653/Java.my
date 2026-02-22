package dao;

import br.com.dobackaoBanco.Emprestimo;

import java.util.List;

public interface EmprestimoDAO {
    void salvar(Emprestimo emprestimo);
    Emprestimo buscarPorId(int id);
    List<Emprestimo> listarTodos();
    List<Emprestimo> listarAtivos();
    void devolver(int id); // regra especial: marcar como devolvido
    void deletar(int id);
}
