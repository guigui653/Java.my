public class ContaBancaria {
    // 1. Atributos (Privados = Segurança)
    private int numeroConta;
    private String titular;
    private double saldo;

    // 2. Construtor (Prepara o terreno)
    public ContaBancaria(int numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0; // Toda conta começa zerada por segurança
    }

    // 3. Métodos (Ações)
    // GETTERS (Apenas leitura)
    public int getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // AÇÃO DEPOSITAR (Void: É uma ordem, não devolve nada)
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado!");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    // AÇÃO SACAR (Boolean: É uma pergunta - "Consegui sacar?")
    public boolean sacar(double valor) {
        if (this.saldo >= valor && valor > 0) {
            this.saldo -= valor; // Diminui o saldo
            return true; // Deu certo!
        } else {
            return false; // Deu errado!
        }
    }
}