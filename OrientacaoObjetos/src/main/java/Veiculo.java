public class Veiculo {
    String marca ;
    String cor ;
    int ano ;
    double preco ;
    int placa;

    public Veiculo (String marca , String cor , int ano , double preco , int placa){
        this.marca = marca;
        this.cor = cor;
        this.ano = ano;
        this.preco = preco;
        this.placa = placa;
    }

    void buzinar(){
        System.out.println("bepe-bepe");
    }


}
