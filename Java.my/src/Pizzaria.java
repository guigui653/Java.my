import java.util.Scanner;
import java.util.ArrayList;

public class Pizzaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem-vindo à Pizzaria Java!");

        // ArrayList para armazenar os pedidos e preços
        ArrayList<String> pedidos = new ArrayList<>();
        ArrayList<Double> precos = new ArrayList<>();

        double total = 0.0;
        String continuar = "sim";
        int numeroPedido = 1;

        while (continuar.equalsIgnoreCase("sim")) {
            System.out.println("\n--- PEDIDO #" + numeroPedido + " ---");
            System.out.println("Escolha o tamanho da pizza (P, M, G):");
            char tamanho = sc.next().toUpperCase().charAt(0);
            System.out.println("Escolha o sabor da pizza (Mussarela, Calabresa, Portuguesa):");
            String sabor = sc.next();
            System.out.println("Deseja refrigerante? (Sim/Não):");
            String refri = sc.next();

            double preco = 0.0;
            String descricaoPizza = "";

            switch (tamanho) {
                case 'P':
                    preco = 20.0;
                    descricaoPizza += "Pizza P";
                    break;
                case 'M':
                    preco = 30.0;
                    descricaoPizza += "Pizza M";
                    break;
                case 'G':
                    preco = 40.0;
                    descricaoPizza += "Pizza G";
                    break;
                default:
                    System.out.println("Tamanho inválido!");
                    continue;
            }

            switch (sabor.toLowerCase()) {
                case "mussarela":
                    preco += 5.0;
                    descricaoPizza += " - Mussarela";
                    break;
                case "calabresa":
                    preco += 7.0;
                    descricaoPizza += " - Calabresa";
                    break;
                case "portuguesa":
                    preco += 10.0;
                    descricaoPizza += " - Portuguesa";
                    break;
                default:
                    System.out.println("Sabor inválido!");
                    continue;
            }

            if (refri.equalsIgnoreCase("sim")) {
                System.out.println("Qual refrigerante? (Coca-Cola, Guarana, Fanta):");
                String escolhaRefri = sc.next();
                switch (escolhaRefri.toLowerCase()) {
                    case "coca-cola":
                        preco += 5.0;
                        descricaoPizza += " + Coca-Cola";
                        break;
                    case "guarana":
                        preco += 7.0;
                        descricaoPizza += " + Guarana";
                        break;
                    case "fanta":
                        preco += 10.0;
                        descricaoPizza += " + Fanta";
                        break;
                    default:
                        System.out.println("Refrigerante inválido!");
                }
            }

            // Adicionar ao ArrayList
            pedidos.add(descricaoPizza);
            precos.add(preco);
            total += preco;

            System.out.printf("Preço desta pizza: R$ %.2f%n", preco);
            System.out.println("Deseja pedir outra pizza? (Sim/Não):");
            continuar = sc.next();
            numeroPedido++;
        }

        // Exibir resumo dos pedidos
        System.out.println("\n========== RESUMO DO PEDIDO ==========");
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.printf("Pedido %d: %s - R$ %.2f%n", i + 1, pedidos.get(i), precos.get(i));
        }
        System.out.println("=====================================");

        if (total >= 100) {
            total = total * 0.9;
            System.out.println("Você recebeu 10% de desconto por gastar mais de R$100,00!");
        } else {
            System.out.println("Não houve desconto.");
        }

        System.out.printf("Total a pagar: R$ %.2f%n", total);
        System.out.println("Obrigado por pedir na Pizzaria Java!");

        sc.close();
    }
}


