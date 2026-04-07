import java.util.ArrayList;
import java.util.Scanner;

public class CadastroClientes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> clientes = new ArrayList<>(); // <String>

        clientes.add("email");
        clientes.add("nome");

        System.out.println("=== SISTEMA DE CADASTRO 1.0 ===");

        while (true) {

            System.out.println("\n1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Remover Cliente");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");

            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("--- NOVO CLIENTE ---");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    clientes.add("gui");
                    clientes.add("aksj@.gmail.com");
                    System.out.println("cadastro feito");

                    break;

                case "2":
                    System.out.println("--- LISTA DE CLIENTES ---");
                    for(int i = 0; i < clientes.size(); i++){
                        System.out.println(i + ". " + clientes.get(i));
                    }
                    break;

                case "3":
                    System.out.println("--- REMOVER CLIENTE ---");

                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println(i + ". " + clientes.get(i));
                    }

                    System.out.print("Digite o número para apagar: ");
                    int indice = Integer.parseInt(sc.nextLine());

                    break;

                case "4":
                    System.out.println("Fechando o sistema...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}