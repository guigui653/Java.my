public class Carro2 {
    private String modelo;
    private int gasolina = 0;

    public Carro2 (String modelo, int gasolina){
        this.modelo = modelo;
        this.gasolina = gasolina;
    }

    public void abastecer (int gasolina){
        this.gasolina += 0;
        System.out.println("voce abasteceu");
    }
    public String distancia (int distancia){
        if(this.gasolina >= distancia){
            return"viajou tantos km";
        }else{
            return"falta gasolina para os km";
        }

    }

}
