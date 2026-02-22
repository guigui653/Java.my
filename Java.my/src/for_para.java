import java.util.Scanner;

public class for_para {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       System.out.println("Digite apenas 5 numeros inteiros:");

       for (int i = 5; i >= 0; i--) {
           int numEscolhido = sc.nextInt();
           System.out.println("Numero escolhido: " + numEscolhido);

       }


       sc.close();
    }

}
