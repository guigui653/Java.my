public class MainCarro {
    public static void main(String[] args) {
        // 1. Criar a máquina (Nasce com 0 litros)
        Ferrari minhaNave = new Ferrari("Spider");

        System.out.println("--- Teste 1: Tentar andar vazio ---");
        minhaNave.andar(10);

        System.out.println("\n--- Teste 2: Abastecer ---");
        minhaNave.abastecer(50);

        System.out.println("\n--- Teste 3: Andar ---");
        minhaNave.andar(20);

        System.out.println("\n--- Teste 4: Andar demais ---");
        minhaNave.andar(40);
    }
}