public class Ferrari {

    private String modelo;
    private int gasolina;


    public Ferrari(String modelo) {
        this.modelo = modelo;
        this.gasolina = 0; // Todo carro novo vem com tanque vazio
    }


    public void abastecer(int litros) {

        this.gasolina += litros;
        System.out.println("Glug glug! Abasteceu " + litros + " litros. Tanque: " + this.gasolina);
    }


    public void andar(int distanciaKm) {



        if (this.gasolina >= distanciaKm) {
            this.gasolina -= distanciaKm;
            System.out.println("Vrummmm! A " + this.modelo + " correu " + distanciaKm + "Km.");
            System.out.println("Sobrou no tanque: " + this.gasolina + " litros.");
        } else {
            System.out.println("Pane Seca! Você quer andar " + distanciaKm + "Km, mas só tem " + this.gasolina + " litros.");
        }
    }
}