import java.util.Scanner;

public class Boletim_escolar {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        // escreva as suas notas para definir sua media final. (definindo variaveis que irá ser ultilizada)
        double nota1;
        double nota2;
        double media;

        boolean continuar = true;

        String proximo;
        String nomeProfessor;
        String nomeEstudante;

        // digite o nome professor e do aluno logo a baixo. (usuario informa nome do professor)
        System.out.print("digite o nome do professor: ");
        nomeProfessor =sc.nextLine();

        // (Estrutura de Repetição)
        while(continuar) {

            // (usuario informa nome do aluno)
            System.out.print("digite o nome do estudante: ");
            nomeEstudante = sc.nextLine();

            //digite a sua nota para definir media. (Usuario informa nota1)
            System.out.print("digite a primeira nota (entre 0 a 10): ");
            nota1 = Double.parseDouble(sc.nextLine());


            // (Usuario informa nota2)
            System.out.print("digite a sua segunda nota (entre 0 a 10): ");
            nota2 = Double.parseDouble(sc.nextLine());

            // (algoritmo de media).
            media = (nota1 + nota2) /2;

            //Com as informaçoes dos nomes do professor e do aluno,insira suas notas para ver a media final, entre elas.

            // (imprimindo dados informados)
            System.out.println("\n---dados do estudante---");
            System.out.printf("Nome Professor: \n", nomeProfessor);
            System.out.printf("nome do aluno: %s\n", nomeEstudante);
            System.out.printf("nota1: %.2f\n", nota1);
            System.out.printf("nota2: %.2f\n", nota2);
            System.out.printf("media: %.2f\n", media);

            //voce pode escolher s/n, para escolher ver a nota de um segundo aluno.

            //(Inserindo dados de novos alunos)

            System.out.print("deseja continuar (s/n)");

            proximo = sc.nextLine();

            // (Estrutura de Condição)
            if(proximo.equalsIgnoreCase("n")){
                continuar = false;
            }
        }

        sc.close();
    }

}
