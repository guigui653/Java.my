import java.util.ArrayList;

public class Estoque {

    private ArrayList<Produto> Produtos;

    public Estoque() {
        Produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto p) {
        Produtos.add(p);
        System.out.println("Produto adicionado: " + p.getNome());
    }

    public void listarTodos() {
        if ( Produtos.isEmpty()) {
            System.out.println("Estoque vazio!");
            return;
        }

        System.out.println("\n=== ESTOQUE ATUAL ===");
        for (Produto p : Produtos) {
            p.exibirInfo();
        }
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Produto p : Produtos) {
            total += p.getPreco() * p.getQuantidade();
        }
        return total;
    }

}
