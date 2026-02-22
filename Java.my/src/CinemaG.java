import java.util.Scanner;

public class CinemaG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double precoTotal = 0.0;
        double devolucao = 0.0;
        double precoDoIngresso = 20.0;
        int quantidadeDeCadeiras = 5;

        System.out.println("Quantas pessoas vão ao cinema hoje?");
        int quantidadeDePessoas = sc.nextInt();
        
        if(quantidadeDePessoas <= 5){
            System.out.println("pode entrar, tem vaga");
        }else{
            System.out.println("voce nao pode entrar, CHEIO ");
        }

        boolean continuar = true;

        while (continuar){
            System.out.println("1 - compra do ingresso - 20$");
            System.out.println("2 - cancelar o ingresso (devolver o dinheiro)");
            System.out.println("3- para sair (adeus)");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    // O Porteiro pergunta: Tem vaga?
                    if (quantidadeDeCadeiras > 0) {
                        System.out.println("Compra do ingresso feita!");
                        precoTotal += 20.0;     // Só soma se tiver vaga
                        quantidadeDeCadeiras--; // Só diminui se tiver vaga
                        System.out.println("Restam " + quantidadeDeCadeiras + " cadeiras.");
                    } else {
                        System.out.println("ERRO: O cinema está LOTADO! Não vendi.");
                    }
                    break;
                case 2:
                    // O Porteiro pergunta: Tem alguém pra sair? (Lugares é menor que o total?)
                    if (quantidadeDeCadeiras < 5) {
                        System.out.println("Ingresso cancelado. Dinheiro devolvido.");
                        precoTotal -= 20.0;     // Só devolve se tiver vendido
                        quantidadeDeCadeiras++; // Libera o lugar
                    } else {
                        System.out.println("ERRO: A sala já está vazia! Não tem o que cancelar.");
                    }
                    break;
                case 3:
                    System.out.println("adeus");
                    continuar = false;
                    break;
                default:
                    System.out.println("opcao invalida");
            }

        }

        System.out.println("o caixa tem de dinheiro: R$ " + precoTotal);


        sc.close();
    }
}
