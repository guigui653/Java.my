import java.util.Scanner;
public class array {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] pizza = {"Calabresa", "Frango com Catupiry", "Portuguesa", "Chocolate"};
        double[] precos = {20.0, 25.0, 22.5, 19.0};

        double valorFinal = 0;
        String escolha = "";
        boolean ganhouGratis = false;  // controla se já ganhou pizza grátis

        System.out.println("===== BEM-VINDO À PIZZARIA! =====\n");

        while(!escolha.equals("5")){  // ← CORRIGIDO

            System.out.println("\n--- CARDÁPIO ---");
            for(int i = 0; i < pizza.length; i++){
                System.out.println((i + 1) + " - " + pizza[i] + " - R$ " + precos[i]);
            }
            System.out.println("5 - Finalizar pedido");

            System.out.print("\nEscolha uma opção: ");
            escolha = sc.nextLine();

            switch (escolha) {
                case "1":
                    valorFinal += precos[0];
                    System.out.println("✓ " + pizza[0] + " adicionada! (R$ " + precos[0] + ")");
                    break;
                case "2":
                    valorFinal += precos[1];
                    System.out.println("✓ " + pizza[1] + " adicionada! (R$ " + precos[1] + ")");
                    break;
                case "3":
                    valorFinal += precos[2];
                    System.out.println("✓ " + pizza[2] + " adicionada! (R$ " + precos[2] + ")");
                    break;
                case "4":
                    valorFinal += precos[3];
                    System.out.println("✓ " + pizza[3] + " adicionada! (R$ " + precos[3] + ")");
                    break;
                case "5":
                    System.out.println("\n--- FINALIZANDO PEDIDO ---");
                    break;
                default:
                    System.out.println("❌ Opção inválida! Tente novamente.");
            }

          
            if(!escolha.equals("5")){
                System.out.println("Total até agora: R$ " + valorFinal);

                // VERIFICA SE GANHOU PIZZA GRÁTIS (só uma vez!)
                if(valorFinal >= 50.0 && !ganhouGratis){
                    System.out.println("\n🎉 PARABÉNS! Você ganhou uma pizza grátis!");
                    System.out.println("Escolha sua pizza grátis:");

                    for(int i = 0; i < pizza.length; i++){
                        System.out.println((i + 1) + " - " + pizza[i]);
                    }

                    System.out.print("Escolha: ");
                    String pizzaGratis = sc.nextLine();

                    switch (pizzaGratis){
                        case "1":
                            System.out.println("✓ " + pizza[0] + " grátis adicionada!");
                            break;
                        case "2":
                            System.out.println("✓ " + pizza[1] + " grátis adicionada!");
                            break;
                        case "3":
                            System.out.println("✓ " + pizza[2] + " grátis adicionada!");
                            break;
                        case "4":
                            System.out.println("✓ " + pizza[3] + " grátis adicionada!");
                            break;
                        default:
                            System.out.println("Opção inválida. Nenhuma pizza grátis foi adicionada.");
                    }

                    ganhouGratis = true;  // marca que já ganhou
                }
            }
        }

        // RESUMO APARECE SÓ NO FINAL (fora do while)
        System.out.println("\n===== RESUMO DO PEDIDO =====");
        System.out.println("Total a pagar: R$ " + valorFinal);

        if(ganhouGratis){
            System.out.println("🎁 Você ganhou 1 pizza grátis!");
        }

        System.out.println("Obrigado por comprar conosco! 🍕");

        sc.close();
    }
}