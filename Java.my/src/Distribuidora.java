import java.util.Scanner;

public class Distribuidora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1- doce");
        System.out.println("2- refrigerante");
        System.out.println("3- pastel");
        System.out.println("4- sair");

        int op;
        do {
            System.out.println("1- doce | 2- refrigerante | 3- pastel | 4- sair");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Você ganha 10 balas!");
                    break;
                case 2:
                    System.out.println("Você ganha 10 refrigerantes!");
                    break;
                case 3:
                    System.out.println("Você ganha 10 pastéis!");
                    break;
                case 4:
                    System.out.println("Saindo do sistema... Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (op != 4);
        sc.close();

    }
}
