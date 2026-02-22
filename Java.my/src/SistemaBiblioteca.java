import java.util.Scanner;

public class SistemaBiblioteca {
    static Livro[] estante = new Livro[6];
    static int quantidadeLivros = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    pesquisarLivro();
                    break;
                case 4:
                    System.out.println("Fechando a biblioteca... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println("---------------------------------");
        } while (opcao != 4);

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
        System.out.println("1. Cadastrar Novo Livro");
        System.out.println("2. Listar Acervo");
        System.out.println("3. Pesquisar por Título");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void cadastrarLivro() {
        if (quantidadeLivros >= estante.length) {
            System.out.println("ERRO: A estante está cheia! (Máx: 6 livros).");
            return;
        }

        System.out.println("--- Novo Livro ---");
        System.out.print("Título da obra: ");
        String titulo = scanner.nextLine();

        System.out.print("Nome do Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Ano de publicação: ");
        int ano = 0;
        try {
            ano = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Ano inválido. Tente novamente.");
            return;
        }

        Livro novoLivro = new Livro(titulo, autor, ano);
        estante[quantidadeLivros] = novoLivro;
        quantidadeLivros++;

        System.out.println("Sucesso! Livro adicionado ao acervo.");
    }

    public static void listarLivros() {
        System.out.println("--- Acervo da Biblioteca ---");
        if (quantidadeLivros == 0) {
            System.out.println("Nenhum livro cadastrado ainda.");
            return;
        }

        for (int i = 0; i < quantidadeLivros; i++) {
            System.out.println(estante[i].obterFichaCatalografica());
        }
    }

    public static void pesquisarLivro() {
        System.out.print("Digite o título (ou parte dele) para buscar: ");
        String termo = scanner.nextLine().toLowerCase();

        boolean encontrou = false;

        for (int i = 0; i < quantidadeLivros; i++) {
            if (estante[i].getTitulo().toLowerCase().contains(termo)) {
                System.out.println("ENCONTRADO: " + estante[i].obterFichaCatalografica());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum livro encontrado com esse título.");
        }
    }
}
