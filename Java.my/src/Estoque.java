import java.util.ArrayList;

public class Estoque {
    public static void main (String [] args){


        System.out.println("bem vindo ao estoque!!!!");

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("USUÁRIO: ").append("Guilherme\n"); // \n pula linha
        relatorio.append("PRODUTO EM DESTAQUE: ").append("Playstation");

        String fraseFinal = relatorio.toString();
        System.out.println(fraseFinal);

        ArrayList<String> estoque = new ArrayList<>();
        estoque.add("playstation");
        estoque.add("note");
        estoque.add("tv");
        estoque.add(0,"xbox"); // Faz criar uma [] de array para guardar os itens. Com isso o xbox fica em primeiro.
        System.out.println(estoque);

        System.out.println("o primeiro item e  :" + estoque.get(0));
        System.out.println("numero total de itens:  " + estoque.size());
        System.out.println(estoque.remove(2));

        double playstation = 5000.00;
        double tv = 233.00;
        double xbox = 4000.00;
        double note = 150.00;

        double maiscaro = Math.max(playstation , note);
        double maisBarato = Math.min(xbox, tv);
        System.out.println("o mais caro custa"+ maiscaro);
        double mediaPrecos = (playstation + tv + xbox + note) / 4.0; // sempre que voce quiser, achar um valor meio termo divida gui!!
        System.out.println("A média dos preços é: " + mediaPrecos);



    }
}
