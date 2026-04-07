public class Requesitos {
    public static void main(String[] args) {
        Celular celular = new Celular("samsung ", "s25", 3000.0, 512, 100);

        System.out.println("Bateria atual: " + celular.getBateria() + "%");

        celular.setBateria(90);
        System.out.println("Nova bateria: " + celular.getBateria() + "%");

        System.out.println("preco" + celular.getPreco()+ "3000");
        System.out.println("armazenamento" + celular.getArmazenamento()+ "512GB");
    }
}
