import java.util.ArrayList;
import java.util.Scanner;

public class MochilaMagica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> mochila = new ArrayList<>(); // Usei letra minúscula (padrão Java)

        // Itens iniciais
        mochila.add("Poção de Vida");
        mochila.add("Kunai");
        mochila.add("Hamburguer");

        System.out.println("=== 🎒 BEM-VINDO À MOCHILA MÁGICA 🎒 ===");


        while (true) {

            System.out.println("\nO que deseja fazer?");
            System.out.println("1 - Adicionar Item");
            System.out.println("2 - Remover Item (pelo número)");
            System.out.println("3 - Ver Inventário");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");


            String opcao = sc.nextLine();


            switch (opcao) {
                case "1": // ADICIONAR
                    System.out.print("Digite o nome do item: ");
                    String novoItem = sc.nextLine();
                    mochila.add(novoItem);
                    System.out.println(novoItem + " foi guardado na mochila!");
                    break;

                case "2": // REMOVER
                    System.out.println("Qual item remover? (Digite o número do índice)");
                    // Mostra a lista com índices pra facilitar
                    for (int i = 0; i < mochila.size(); i++) {
                        System.out.println(i + ". " + mochila.get(i));
                    }

                    // Lógica de segurança para remover
                    try {
                        int indice = Integer.parseInt(sc.nextLine()); // Converte String para Int
                        if (indice >= 0 && indice < mochila.size()) {
                            String itemRemovido = mochila.remove(indice);
                            System.out.println(itemRemovido + " foi jogado fora.");
                        } else {
                            System.out.println("Erro: Esse número não existe na mochila!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Erro: Digite apenas números!");
                    }
                    break;

                case "3": // MOSTRAR
                    System.out.println("--- CONTEÚDO DA MOCHILA ---");
                    if (mochila.isEmpty()) {
                        System.out.println("(A mochila está vazia)");
                    } else {
                        // Usando um "for-each" (mais elegante para listar)
                        for (String item : mochila) {
                            System.out.println("- " + item);
                        }
                    }
                    break;

                case "4": // SAIR
                    System.out.println("Fechando a mochila... Até mais!");
                    sc.close();
                    return; // Encerra o programa

                default: // SE DIGITAR ALGO NADA A VER
                    System.out.println("Opção inválida! Tente 1, 2, 3 ou 4.");
            }
        }
    }
}