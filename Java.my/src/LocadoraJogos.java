import java.util.Scanner;

public class LocadoraJogos {
    public static void main(String[] args) {
        // Inicializa o Scanner para ler a entrada do usuário
        Scanner sc = new Scanner(System.in);

        System.out.println("🎮 Bem-vindo à Locadora de Jogos!");
        System.out.println("Qual é o seu nome?");
        String nome = sc.nextLine();

        System.out.println("\nQuantos jogos você quer alugar? (máximo 4)");
        int quantidadeJogos = sc.nextInt();

        // Validação da quantidade máxima de jogos permitida
        if (quantidadeJogos > 4) {
            System.out.println("Máximo 4 jogos! Vamos considerar 4.");
            quantidadeJogos = 4;
        }

        // Variáveis acumuladoras para o total a pagar e total de dias
        double totalPagar = 0.0;
        int totalDias = 0;

        // Loop para processar cada jogo escolhido individualmente
        for (int i = 1; i <= quantidadeJogos; i++) {
            System.out.println("\n--- Jogo " + i + "/" + quantidadeJogos + " ---");
            System.out.println("Escolha a plataforma:");
            System.out.println("1 - PlayStation: R$ 8,00/dia");
            System.out.println("2 - Xbox: R$ 8,00/dia");
            System.out.println("3 - Nintendo: R$ 6,00/dia");
            System.out.println("4 - PC: R$ 5,00/dia");
            System.out.print("Opção: ");
            int escolha = sc.nextInt();


            double precoPorDia = 0.0;
            String plataforma = "";

            // Define o preço diário e o nome da plataforma com base na escolha do usuário
            switch (escolha) {
                case 1:
                    precoPorDia = 8.0;
                    plataforma = "PlayStation";
                    break;
                case 2:
                    precoPorDia = 8.0;
                    plataforma = "Xbox";
                    break;
                case 3:
                    precoPorDia = 6.0;
                    plataforma = "Nintendo";
                    break;
                case 4:
                    precoPorDia = 5.0;
                    plataforma = "PC";
                    break;
                default:
                    System.out.println("Opção inválida! Considerando PC.");
                    precoPorDia = 5.0;
                    plataforma = "PC";
                    break;
            }

            System.out.print("Por quantos dias? (1-7): ");
            int dias = sc.nextInt();

            // Garante que o número de dias esteja entre 1 e 7
            if (dias < 1) dias = 1;
            if (dias > 7) dias = 7;

            // Calcula o custo total para este jogo específico
            double precoJogo = precoPorDia * dias;

            // Atualiza os acumuladores globais
            totalPagar += precoJogo;
            totalDias += dias;

            System.out.printf("%s por %d dias: R$ %.2f%n", plataforma, dias, precoJogo);
        }

        // Exibe o resumo final da transação
        System.out.println("\n==============================");
        System.out.println("Cliente: " + nome);
        System.out.println("Jogos alugados: " + quantidadeJogos);
        System.out.println("Total de dias: " + totalDias);
        System.out.printf("Total a pagar: R$ %.2f%n", totalPagar);
        System.out.println("==============================");
        System.out.println("Obrigado pela preferência!");

        // Fecha o scanner para liberar recursos do sistema
        sc.close();
    }
}