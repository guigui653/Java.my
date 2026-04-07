import java.util.Scanner;

public class MatriculaInteligente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do aluno: ");
        String nome = sc.nextLine();
        System.out.println("Digite do curso: ");
        String curso = sc.nextLine();
        System.out.println("Digite sua idade: ");
        int idade = sc.nextInt();
        if(curso.equalsIgnoreCase("ads") && idade >= 18) {
            System.out.println("Aluno adicionado com sucesso!");
        }else if(curso.equalsIgnoreCase("ads") && idade >= 17) {
            System.out.println("Necessário assinatura do responsável");
        }else{
            System.out.println("Procure a secretaria geral");
        }
        System.out.println("seu nome do aluno: " + nome);
        System.out.println("seu curso: " + curso);
        System.out.printf("seu idade %d %n: " , idade);


        sc.close();
    }
}
