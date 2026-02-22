import java.util.ArrayList;

public class PraticaArrayList {
    public static void main(String[] args) {
        ArrayList<String> compras = new ArrayList<>();

        compras.add("maça");
        compras.add("banana");
        compras.add("morango");

        System.out.println("O primeiro item é: " + compras.get(1)); // serve para contar, quantos elementos existe neste texto.
        System.out.println("Total de itens: " + compras.size());// Serve para buscar um ‘item’ especifico na lista. 0,1,2,3...
    }

}
