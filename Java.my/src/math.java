import java.util.ArrayList;
import java.util.Scanner;

public class math {
    public static void main (String [] args){

        StringBuilder cadastro = new StringBuilder();
        cadastro.append("Guilherme  ");
        cadastro.append("playstation ");
        cadastro.append(0);

        String fraseFinal = cadastro.toString();
        System.out.println(fraseFinal);

        ArrayList<String> Produtos = new ArrayList<>();
        Produtos.add("playstation");
        Produtos.add("tv");
        Produtos.add("xbox");
        Produtos.add("computador");
        System.out.println(Produtos);

        System.out.println("o primeiro item e" + Produtos.get(0));
        System.out.println("numero total de itens" + Produtos.size());

        double playstation = 5000.00;
        double tv = 233.00;
        double xbox = 4000.00;
        double computador = 150.00;

        double maiscaro = Math.max(playstation , computador);
        double maisBarato = Math.min(xbox, tv);
        System.out.println("o mais caro custa"+ maiscaro);

    }
}
