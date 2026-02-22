package application2;

import entities2.empregado;

import java.util.Locale;
import java.util.Scanner;

public class Dados {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        empregado empregado = new empregado();
        System.out.println("nome");
        empregado.nome = sc.nextLine();
        System.out.println("entre com o salario bruto do empregado");
        empregado.salarioBruto = sc.nextDouble();
        System.out.println("entre com a porcentagem do imposto:");
        empregado.imposto = sc.nextDouble();

        System.out.println();
        System.out.println("nome do empregado: " + empregado.nome);
        System.out.println("salario bruto do empregado: " + empregado.salarioBruto);
        System.out.println("imposto do empregado: " + empregado.imposto);
        System.out.println("salario liquido do empregado: " + empregado.netSalary());

        System.out.println();
        System.out.println("updated data: " + empregado);


        sc.close();
    }
}
