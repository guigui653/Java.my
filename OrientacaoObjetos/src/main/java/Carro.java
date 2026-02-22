public class Carro extends Veiculo {
    int numPortas;


    public Carro(String marca, String cor, int ano, double preco, int placa) {
        super(marca, cor, ano, preco, placa);
    }

    @Override
    void buzinar(){
        System.out.println("beep-beep");
    }
}
