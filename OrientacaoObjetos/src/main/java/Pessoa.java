public class Pessoa {
    //aqui sao os atributos
    String nome;
    int idade;
    double altura;

    //aqui começa o metodo do construtor (e usado para criar objetos)
    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }
    //metodo (comportamento)
    public void apresentar() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Altura: " + altura);
    }
    public void fazerAniversario() {
        System.out.println("Aniversario" + idade + "anos");
    }

}
