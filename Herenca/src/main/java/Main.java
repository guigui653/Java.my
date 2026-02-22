public class Main {
    public static void main(String[] args) {

        Estoque estoque = new Estoque();

        Produto ps5 = new Produto("PlayStation 5", 4999.90, 4);
        Produto tv = new Produto("Smart TV 55'", 2299.00, 6);

        estoque.adicionarProduto(ps5);
        estoque.adicionarProduto(tv);

        estoque.listarTodos();

        System.out.println("Valor total do estoque: R$ " + String.format("%.2f", estoque.calcularValorTotal()));
    }
}
