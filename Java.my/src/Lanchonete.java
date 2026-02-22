import java.util.Scanner;

public class Lanchonete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double valorTotal = 0.0;
        System.out.println("qual e o seu nome?");
        String nome = sc.nextLine();



        int quantidade = 0;
        for (int i = 0; i < 5 ; i++) {
            System.out.println("item " + (i + 1) + "/" + 5);
            System.out.println("quantos voce quer comprar?(pode no maximo 5!)");
            System.out.println("1-hamburguer");
            System.out.println("2-hot-dog");
            System.out.println("3-batata-frita");
            quantidade = sc.nextInt();

            switch (quantidade){
                case 1:
                    System.out.println("voce escolheu o hamburguer");
                    valorTotal += 10.0;
                    break;

                    case 2:
                        System.out.println("voce escolheu o hot-dog");
                        valorTotal += 5.0;
                        break;

                        case 3:
                            System.out.println("voce escolheu a batata-frita");
                            valorTotal += 7.0;
                            break;
                            default:
                                System.out.println("item invalido");
                                break;
            }

        }

        System.out.println("Cliente: " + nome);
        System.out.printf("Valor total da compra: R$ %.2f %n", valorTotal);

        sc.close();
    }
}
