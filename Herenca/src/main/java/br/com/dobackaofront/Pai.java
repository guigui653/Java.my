package br.com.dobackaofront;

public class Pai {
    private String nome;
    private int idade;

    public Pai(){
        nome = "";
        idade = 0;
    }

    public Pai(String nome, int idade){
       this.nome = nome;
       this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void incomodar(){
        System.out.println("pai pai pai pai pai pai pai pai pai pai pai pai pai");
    }

}
