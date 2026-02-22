public class Cliente extends ContaBancaria {
    private String cpf;

    public Cliente(int numeroConta, String titular, String cpf) {
        super(numeroConta, titular); // Chama o construtor da classe pai
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void exibirDadosCliente() {
        System.out.println("Cliente: " + getTitular());
        System.out.println("CPF: " + cpf);
        System.out.println("Conta: " + getNumeroConta());
        System.out.println("Saldo: R$ " + getSaldo());
    }
}