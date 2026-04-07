import java.util.Scanner;

public class SistemaMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1-ver saldo");
        System.out.println("2-ver curso");
        System.out.println("0-  sair");
        int op; // Não precisa começar com 0
        do {
            System.out.println("1- ver saldo | 2- ver curso | 0- sair");
            op = sc.nextInt(); // Aqui você atualiza a condição do loop!

            if (op == 1) {
                System.out.println("Seu saldo é 1500$");
            } else if (op == 2) {
                System.out.println("Seu curso é ADS");
            } else if (op == 0) {
                System.out.println("Adeus!");
            } else {
                System.out.println("Opção inválida!");
            }

        } while (op != 0); // Só checa depois de rodar uma vez
        sc.close();
    }
}
