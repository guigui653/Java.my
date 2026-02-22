public class Requesitos {
    public static void main(String[] args) {
        Celular celular = new Celular("samsung ", "s25", 3000.0, 512, 100);

        // Usando o Getter para ler o valor
        System.out.println("Bateria atual: " + celular.getBateria() + "%");

        // Usando o Setter para alterar o valor
        celular.setBateria(90);
        System.out.println("Nova bateria: " + celular.getBateria() + "%");

        System.out.println("preco" + celular.getPreco()+ "3000");
        System.out.println("armazenamento" + celular.getArmazenamento()+ "512GB");
    }
}
