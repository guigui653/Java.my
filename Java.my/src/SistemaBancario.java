import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 1500;
        double SaqueSaldo = 500;

        System.out.println("Digite quanto voce quer sacar: ");
        double valor = sc.nextDouble();

        if (valor <= saldo) {

            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
            System.out.println("Novo saldo: R$ " + saldo);

        } else if (valor <= (saldo + 500)) {

            System.out.println("Saque realizado usando o Cheque Especial!");
            System.out.println("Saldo devedor: R$ " + saldo);

        } else {

            System.out.println("Saldo insuficiente, mesmo com o limite extra.");
        }


        sc.close();
    }
}
