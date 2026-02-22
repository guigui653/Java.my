public class Main {
    public static void main(String[] args) {
        Carro meuCarro = new Carro("Toyota", "Preto", 2023, 150000.0, 12345);

        System.out.println("--- Informações do Veículo ---");
        System.out.println("Marca: " + meuCarro.marca);
        System.out.println("Cor: " + meuCarro.cor);
        System.out.println("Ano: " + meuCarro.ano);

        System.out.print("Som da buzina: ");
        meuCarro.buzinar();
    }

}
