import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       double precoTotal = 0.0;

       System.out.println("quantas pessoas vao ao cinema hoje?");
       int quantidadeDePessoas = sc.nextInt();

       for (int i = 1; i <= quantidadeDePessoas; i++) {
           System.out.println("Quantidade de pessoas: " + i);

           System.out.println("digite a idade :");
           int idade = sc.nextInt();

           if(idade <18 || idade > 65) {
               System.out.println("voce pode ter o ingresso a meia entrada");
           }

           System.out.println("escolha o seu tipo de ingresso:");
           System.out.println("1 - Inteiro: R$ 40,00");
           System.out.println("2 - Meia (Estudante/Idoso): R$ 20,00");
           System.out.println("3 - VIP: R$ 80,00");
           System.out.print("Opção: ");
           int opcao = sc.nextInt();


           double preco = 0.0;
           String tipoCategoria = "";

           switch (opcao) {
               case 1:
                   preco = 50.00;
                   tipoCategoria = "Inteiro";
                   break;
               case 2:
                   preco = 20.0;
                   tipoCategoria = "Meia";
                   break;
               case 3:
                   preco = 100.00;
                   tipoCategoria = "Vip";
                   break;
           }

           precoTotal += preco;
           System.out.println("Ingresso " + tipoCategoria + ": R$ " +
                   String.format("%.2f", preco));

       }

        System.out.println("TOTAL A PAGAR: R$ " +
                String.format("%.2f", precoTotal));

       if(precoTotal > 150.00){
           System.out.println("voce ganhou uma pipoca de nutella");
       }

        sc.close();
    }
}
