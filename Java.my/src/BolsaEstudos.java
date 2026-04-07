import java.util.Scanner;

public class BolsaEstudos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite sua primeira nota: ");
        double nota1 = sc.nextDouble();
        System.out.println("Digite sua segunda nota: ");
        double nota2 = sc.nextDouble();
        System.out.println("Digite sua terceira nota: ");
        double nota3 = sc.nextDouble();

        System.out.println("Digite sua presença: ");
        int presenca = sc.nextInt();

        int presenca2 = presenca / 100;
        double media = (nota1 + nota2 + nota3) / 3;
        if( (media >= 7.5 && presenca >= 75) || (nota1 == 10 || nota2 == 10 || nota3 == 10) ) {
            System.out.println("Ganhou a bolsa!");

        }else if ( (media >= 6.0 && presenca >= 60) || (nota1 == 6.0 || nota2 == 9.9 || nota3 == 8.9)){
            System.out.println("tem que fazer uma prova para ganhar a bolsa ");
        } else {

        System.out.println("Status: Reprovado / Sem Bolsa");
    }

        System.out.printf("sua media %.2f%n: " , media);
        System.out.println("sua presenca: " + presenca +"%");

        sc.close();
    }
}
