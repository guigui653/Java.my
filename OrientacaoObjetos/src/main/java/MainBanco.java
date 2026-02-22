public class MainBanco {
    public static void main(String[] args) {
        // Criando a conta do Guilherme
        ContaBancaria minhaConta = new ContaBancaria(1234, "Guilherme");

        // 1. Verificar saldo inicial
        System.out.println("Saldo inicial: R$ " + minhaConta.getSaldo());

        // 2. Depositar dinheiro
        minhaConta.depositar(500.0);

        // 3. Tentar sacar (Teste do boolean)
        boolean sucesso = minhaConta.sacar(200.0); // Tenta sacar 200
        if (sucesso) {
            System.out.println("Saque realizado! Pegue seu dinheiro.");
        } else {
            System.out.println("Saldo insuficiente!");
        }

        // 4. Saldo Final
        System.out.println("Saldo Final: R$ " + minhaConta.getSaldo());

        System.out.println("\n--- TESTANDO CLASSE CLIENTE ---");

        // Criando um cliente
        Cliente cliente1 = new Cliente(5678, "Maria Silva", "123.456.789-00");
        cliente1.depositar(1000.0);
        cliente1.exibirDadosCliente();
    }
}