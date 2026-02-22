import java.util.ArrayList;
import java.util.Scanner;

public class CadastroClientes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> clientes = new ArrayList<>(); // <String>
        // 1. Crie a lista de clientes aqui (chame de 'clientes')
        // Dica: ArrayList<String> ...
        clientes.add("email");
        clientes.add("nome");

        System.out.println("=== SISTEMA DE CADASTRO 1.0 ===");

        while (true) {
            // O MENU JÁ ESTÁ PRONTO
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
                    // TODO: Junte o nome e email numa String só (ex: "Nome - Email")
                    // TODO: Adicione essa String na lista 'clientes'
                    // TODO: Imprima "Cliente cadastrado!"
                    break;

                case "2":
                    System.out.println("--- LISTA DE CLIENTES ---");
                    for(int i = 0; i < clientes.size(); i++){
                        System.out.println(i + ". " + clientes.get(i));
                    }
                    // TODO: Use um FOR (ou for-each) para mostrar todos os itens da lista
                    // Dica: Se a lista estiver vazia (clientes.isEmpty()), avise o usuário.
                    break;

                case "3":
                    System.out.println("--- REMOVER CLIENTE ---");
                    // Vou te ajudar listando primeiro para saber qual número apagar
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println(i + ". " + clientes.get(i));
                    }

                    System.out.print("Digite o número para apagar: ");
                    int indice = Integer.parseInt(sc.nextLine());
                    // TODO: Leia o número (Use Integer.parseInt(sc.nextLine()) para não bugar)
                    // TODO: Verifique se o número existe (if indice >= 0 && indice < tamanho)
                    // TODO: Se existir, remova (remove). Se não, avise que deu erro.
                    break;

                case "4":
                    System.out.println("Fechando o sistema...");
                    sc.close();
                    return; // Encerra tudo

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}