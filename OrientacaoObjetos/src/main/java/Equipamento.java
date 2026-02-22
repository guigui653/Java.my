public class Equipamento {
    private String nome;
    private double peso;
    private boolean emUso;

    // CONSTRUTOR CORRIGIDO: Agora ele grava os dados!
    public Equipamento(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
        this.emUso = false;
    }

    public void ocupar() {
        this.emUso = true;
    }

    public void desocupar() {
        this.emUso = false;
    }

    public String exibirStatus() {
        if (this.emUso) {
            return "Ocupado";
        } else {
            return "Livre";
        }
    }

    public String getNome() {
        return this.nome;
    }

    public double getPeso() {
        return this.peso;
    }

    public String status() {
        return exibirStatus();
    }
}