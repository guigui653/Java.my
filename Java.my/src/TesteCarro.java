public class TesteCarro {

    public static void main (String [] args){
        Carro uno = new Carro();
        Carro BWO = new Carro();

        uno.marca = "fiat";
        uno.cor = "branco";
        uno.modelo = "miller";
        uno.tanqueCombustivel = 100;
        uno.consumo = 0.10;

        BWO.marca = "fiat";
        BWO.cor = "preto";
        BWO.modelo = "bwo";
        BWO.tanqueCombustivel = 10000;
        BWO.consumo = 120;

        System.out.println("dados do veiculo: " + uno.modelo + " \n" + uno.cor + " \n" + uno.marca + "\n" + uno.calcularAutonomia());

       System.out.println("dados do veiculo: "
               + BWO.modelo +
               " \n" + BWO.cor +
               " \n" + BWO.marca +
               "\n " + BWO.consumo +
               "\n" + BWO.calcularAutonomia() +
               "\n"+ uno.calcularAutonomia());

    }

}
