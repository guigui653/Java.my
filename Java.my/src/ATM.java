import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // O dinheiro que já está na conta (O Estado Inicial)
        double saldoDaConta = 1000.00;

        while (true) {
           
            System.out.println("\n--- CAIXA ELETRÔNICO ---");
            System.out.println("Seu Saldo: R$ " + saldoDaConta);
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar (Somar)");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            // 2. LER A OPÇÃO (1, 2 ou 3)
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // SACAR
                    System.out.print("Quanto você quer sacar? R$ ");
                    double valorSaque = scanner.nextDouble();

                    // Lógica de Proteção (O Porteiro)
                    if (valorSaque <= saldoDaConta && valorSaque > 0) {
                        saldoDaConta -= valorSaque; // Tira do saldo
                        System.out.println("Sucesso! Retire seu dinheiro.");
                    } else {
                        System.out.println("ERRO: Saldo insuficiente ou valor inválido!");
                    }
                    break;

                case 2: // DEPOSITAR
                    System.out.print("Quanto você quer depositar? R$ ");
                    double valorDeposito = scanner.nextDouble();

                    if (valorDeposito > 0) {
                        saldoDaConta += valorDeposito; // Soma no saldo
                        System.out.println("Depósito realizado!");
                    } else {
                        System.out.println("Valor inválido.");
                    }
                    break;

                case 3: // SAIR
                    System.out.println("Obrigado, volte sempre!");
                    scanner.close();
                    return; // Encerra o programa

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}