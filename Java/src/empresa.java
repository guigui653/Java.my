package barprograma;

import java.util.Scanner;

public class empresa{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0;

        StringBuilder detalhes = new StringBuilder();
        // Solicitar o número da mesa
        System.out.println("Digite o número da mesa: ");
        int numeroMesa = scanner.nextInt();
        scanner.nextLine(); // Limpa o caractere de quebra de linha após nextInt

        for (int i = 1; i <= 2; i++) {
            System.out.println("Pedido " + i + ":");

            System.out.println("Digite o nome do produto (Bebida ou Comida): ");
            String produto = scanner.nextLine();

            System.out.println("Digite o valor do produto: ");
            double valor = scanner.nextDouble();

            System.out.println("Digite a quantidade do produto: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Limpa o caractere de quebra de linha após nextInt

            double subtotal = valor * quantidade;
            total += subtotal;

            detalhes.append("Produto: ").append(produto)
                    .append(" | Valor: ").append(valor)
                    .append(" | Quantidade: ").append(quantidade)
                    .append(" | Subtotal: ").append(subtotal)
                    .append("\n");
        }

        System.out.println("\nDetalhes dos pedidos:\n" + detalhes);
        System.out.println("Valor total: R$ " + total);

        scanner.close();
    }
}

