package br.com.dobackaofront;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Pai p = new Pai();
        p.setNome("diogo");
        p.setIdade(20);

        Pai p2 = new Pai ("pauli", 50);

        Filho f = new Filho();
        f.setNome("thai");
        f.setIdade(20);
        f.setReclamar(true);
        f.incomodar();



        Filho f2 = new Filho("Pedro", 50, true);

        System.out.println(f2.getReclamar());
        System.out.println(f2.getNome());
        System.out.println(f2.getIdade());



    }
}