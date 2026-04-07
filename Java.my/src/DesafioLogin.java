import java.util.Scanner;

public class DesafioLogin {
    public static void main(String[] args) {
        String senhaSecreta = "7667";
        Scanner sc = new Scanner(System.in);
        String senhaDigitada = "";

        for (int i = 0; i < 5; i++) {
            System.out.print("digite a senha (tentativa " + (i + 1) + "): ");
            senhaDigitada = sc.next();

            if (senhaDigitada.equals(senhaSecreta)) {
                System.out.println("acesso concedido!");
                break;
            } else {
                System.out.println("acesso negado!");
            }
        }

        sc.close();
    }
}