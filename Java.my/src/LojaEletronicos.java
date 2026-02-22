import java.util.Scanner;

// Classe Modelo - representa um produto eletrônico
class Produto {
    private String nome;
    private String categoria;
    private double valor;
    private String caracteristicas;

    public Produto(String nome, String categoria, double valor, String caracteristicas) {
        this.nome = nome;
        this.categoria = categoria;
        this.valor = valor;
        this.caracteristicas = caracteristicas;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getValor() {
        return valor;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String exibirInformacoes() {
        return "Nome: " + nome + " | Categoria: " + categoria +
                " | Valor: R$ " + String.format("%.2f", valor) +
                " | Características: " + caracteristicas;
    }
}

// Classe Principal
public class LojaEletronicos {
    private static Produto[] produtos = new Produto[6];
    private static int totalProdutos = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        do {
            exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    pesquisarProduto();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("\nEncerrando o sistema. Até logo!");
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }
        } while (continuar);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n========================================");
        System.out.println("    LOJA DE ELETRÔNICOS - MENU");
        System.out.println("========================================");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Listar todos os produtos");
        System.out.println("3 - Pesquisar produto");
        System.out.println("4 - Sair");
        System.out.println("========================================");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    private static void cadastrarProduto() {
        if (totalProdutos >= 6) {
            System.out.println("\nLimite de cadastros atingido! (máximo 6 produtos)");
            return;
        }

        System.out.println("\n--- CADASTRAR NOVO PRODUTO ---");

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        System.out.print("Valor (R$): ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Características: ");
        String caracteristicas = scanner.nextLine();

        produtos[totalProdutos] = new Produto(nome, categoria, valor, caracteristicas);
        totalProdutos++;

        System.out.println("\nProduto cadastrado com sucesso!");
    }

    private static void listarProdutos() {
        if (totalProdutos == 0) {
            System.out.println("\nNenhum produto cadastrado.");
            return;
        }

        System.out.println("\n--- LISTA DE PRODUTOS CADASTRADOS ---");
        for (int i = 0; i < totalProdutos; i++) {
            System.out.println((i + 1) + ". " + produtos[i].exibirInformacoes());
        }
    }

    private static void pesquisarProduto() {
        if (totalProdutos == 0) {
            System.out.println("\nNenhum produto cadastrado para pesquisar.");
            return;
        }

        System.out.print("\nDigite o nome (completo ou parte) do produto: ");
        String busca = scanner.nextLine().toLowerCase();

        boolean encontrado = false;
        System.out.println("\n--- RESULTADO DA PESQUISA ---");

        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i].getNome().toLowerCase().contains(busca)) {
                System.out.println(produtos[i].exibirInformacoes());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum produto encontrado com esse nome.");
        }
    }

    private static double calcularMediaPrecos() {
        if (totalProdutos == 0) {
            return 0;
        }

        double soma = 0;
        for (int i = 0; i < totalProdutos; i++) {
            soma += produtos[i].getValor();
        }
        return soma / totalProdutos;
    }
}