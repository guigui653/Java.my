public class TesteCelular {
    public static void main(String[] args) {
        // Criando 3 celulares diferentes
        Celular cel1 = new Celular("Samsung", "Galaxy S23", 3500.0, 128, 100);
        Celular cel2 = new Celular("Apple", "iPhone 15", 5000.0, 256, 100);
        Celular cel3 = new Celular("Xiaomi", "Redmi Note 13", 1500.0, 64, 100);

        // Exibindo informações iniciais
        System.out.println(">>> CELULAR 1 <<<");
        cel1.exibirInformacoes();

        System.out.println(">>> CELULAR 2 <<<");
        cel2.exibirInformacoes();

        System.out.println(">>> CELULAR 3 <<<");
        cel3.exibirInformacoes();

        // Testando o celular 1
        System.out.println("\n--- TESTANDO CELULAR 1 ---");
        cel1.usarCelular(30);  // usar por 30 minutos
        cel1.carregar(20);     // carregar 20%
        cel1.aplicarDesconto(10);  // 10% de desconto
        cel1.exibirInformacoes();

        // Testando o celular 2
        System.out.println("\n--- TESTANDO CELULAR 2 ---");
        cel2.usarCelular(50);  // usar por 50 minutos
        cel2.exibirInformacoes();

        // Testando o celular 3
        System.out.println("\n--- TESTANDO CELULAR 3 ---");
        cel3.aplicarDesconto(15);  // 15% de desconto
        cel3.usarCelular(25);
        cel3.carregar(30);
        cel3.exibirInformacoes();

        // Testando validações
        System.out.println("\n--- TESTANDO VALIDAÇÕES ---");
        cel1.setPreco(-100);  // deve dar erro
        cel1.setBateria(150); // deve dar erro
        cel1.setArmazenamento(-50); // deve dar erro



    }
}
