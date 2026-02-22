public class Carro {
    String modelo;
    String cor;
    String marca;
    double tanqueCombustivel;
    double consumo;

    public double calcularAutonomia(){
        return tanqueCombustivel / consumo;

    }

    public double obterAutonomia(double qtdPecorrido){

        double automonia = qtdPecorrido/consumo;
        return automonia;
    }

}
