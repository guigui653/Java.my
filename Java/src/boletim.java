import java.util.Scanner;

public class boletim {
    public static void main (String []args ){
            Scanner sc = new Scanner (System.in);

            System.out.println("digite o nome do aluno : ");
            String nome = sc.nextLine();

            System.out.println("digite a sua primeira nota :");
            double nota1 = Double.parseDouble(sc.nextLine());
            System.out.println("digite a sua segunda nota :");
            double nota2 = Double.parseDouble(sc.nextLine());
            System.out.println("digite a sua terceira nota :");
            double nota3 = Double.parseDouble(sc.nextLine());

            double media = (nota1 + nota2 + nota3) / 3;

            if (media >= 7){
                    System.out.println("aprovado");

            }else{
                    System.out.println("reprovado");
            }

            System.out.println("--------esse e a sua nota !--------");
            System.out.println("resultado " + media);

            sc.close();
    }

}
