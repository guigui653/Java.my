public class Informações {
    public static void main(String[] args) {
        Celular meuCelular = new Celular("Apple", "iPhone 15", 5000.0, 128, 100);

        System.out.println("--- Informações do Celular ---");
        meuCelular.Menu();

        System.out.println("Alterando configurações...");
        meuCelular.setPreco(4500.0);
        meuCelular.setArmazenamento(256);
        meuCelular.setBateria(85);

        meuCelular.Menu();
    }

}
