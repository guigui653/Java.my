import java.util.Scanner;

public class QualCurso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do aluno: ");
        String nome = sc.nextLine();
        System.out.println("qual e o seu curso: ");
        String curso = sc.nextLine();
        if (curso.equalsIgnoreCase("ADS")) {
            System.out.println("voce ganha uma bolsa!");
        }else {
            System.out.println("curso chato!");
        }
        System.out.println("seu nome do aluno: " + nome);
        System.out.println("seu curso: " + curso);


        sc.close();
    }
}
