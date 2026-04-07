public class MainBanco {
    public static void main(String[] args) {

        ContaBancaria minhaConta = new ContaBancaria(1234, "Guilherme");

        System.out.println("Saldo inicial: R$ " + minhaConta.getSaldo());

        minhaConta.depositar(500.0);

        boolean sucesso = minhaConta.sacar(200.0); // Tenta sacar 200
        if (sucesso) {
            System.out.println("Saque realizado! Pegue seu dinheiro.");
        } else {
            System.out.println("Saldo insuficiente!");
        }

        System.out.println("Saldo Final: R$ " + minhaConta.getSaldo());

        System.out.println("\n--- TESTANDO CLASSE CLIENTE ---");

        Cliente cliente1 = new Cliente(5678, "Maria Silva", "123.456.789-00");
        cliente1.depositar(1000.0);
        cliente1.exibirDadosCliente();
    }
}