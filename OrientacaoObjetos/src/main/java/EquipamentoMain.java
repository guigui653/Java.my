public class EquipamentoMain {
    public static void main (String [] args){


        Equipamento supino = new Equipamento("Supino Monstro", 900.0);
        Atleta guilherme = new Atleta("Guilherme", 10.0); // Força inicial: 80kg


        System.out.println("--- Tentativa 1 ---");
        guilherme.treinar(supino);
        System.out.println("Status do Supino: " + supino.status());


        System.out.println("\n--- Tentativa 2 (Mais forte) ---");
        

        guilherme.setForca(12.0);
        System.out.println("Guilherme treinou pesado e agora sua força é: " + guilherme.getForca());

        guilherme.treinar(supino);
        System.out.println("Status do Supino: " + supino.status());
    }
}
