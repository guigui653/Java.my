import java.util.Scanner;

public class PatternInvertido {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o numero de linhas:");
        int rows = sc.nextInt();

        for (int i = rows; i >= 1; i--) {

            for (int j = rows; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}
