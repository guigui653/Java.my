import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        double [] notas1 = {10, 5.8, 7.9, 1.3, 8.9};
        double [] notas2 = {9, 6.8, 7.9, 3.3, 9.9};
        double [] notas3 = {10, 4.8, 9.9, 4.3, 6.9};


        System.out.println("digite seu nome:");
        Scanner sc = new Scanner(System.in);
        String nome = sc.nextLine();
        double media = (notas1[0] + notas2[0] + notas3[0]) /3;
        System.out.printf("Olá %s, sua média foi: %.2f\n", nome, media);

        if (media >= 7.0) {
            System.out.println("Status: VOCÊ PASSOU! ");
        } else if (media >= 5.0) {
            System.out.println("Status: RECUPERAÇÃO!");
        } else {
            System.out.println("Status: REPROVADO! ");
        }

        System.out.println("Notas: " + Arrays.toString(notas1));
        System.out.println("Notas: " + Arrays.toString(notas2));
        System.out.println("Notas: " + Arrays.toString(notas3));

    }
}
