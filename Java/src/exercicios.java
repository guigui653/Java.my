import java.util.Locale;
import java.util.Scanner;

public class exercicios {

public static void main (String[]args) {
    String produto1 = "computador";
    String produto2 = "officer desk";

    int idade = 18;
    int code= 6409;
    char sexo = 'M';

    double preco1 = 100.00;
    double preco2 = 200.00;
    double measure = 35.8987;

    System.out.println("produtos:");
    System.out.printf("%s - preco: %.2f%n", produto1, preco1);
    System.out.printf("%s - preco: %.2f%n", produto2, preco2);

    System.out.println("\ninformacoes pessoais:");
    System.out.printf("idade : %d anos%n", idade);


}
}

