package entities2;

public class empregado {
    public String nome;
    public double salarioBruto;
    public double imposto;

    public double netSalary(){
        return salarioBruto - imposto;
    }
    public void increaseSalary(double percentage){
        salarioBruto += salarioBruto * percentage / 100.0;
    }
    public String toString(){
        return nome
                + " - $ "
                + String.format("%.2f", netSalary());
    }
}
