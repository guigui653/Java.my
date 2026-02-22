public class Atleta {
    private String nome;
    private int energia;
    private double forca;

    public Atleta(String nome, double forca) {
        this.nome = nome;
        this.forca = forca;
        this.energia = 100;
    }

    public double getForca() {
        return forca;
    }

    public void setForca(double forca) {
        this.forca = forca;
    }

    public boolean temEnergiaParaLutar() {
        return this.energia > 0;
    }

    public void treinar(Equipamento equipamento) {
        if (this.forca >= equipamento.getPeso()) {
            System.out.println(this.nome + " conseguiu levantar o " + equipamento.getNome() + "!");
            equipamento.ocupar();
            this.energia -= 10;
        } else {
            System.out.println(this.nome + " é muito fraco para o " + equipamento.getNome() + ". Precisa de mais força!");
        }
    }

    public int getEnergia() {
        return this.energia;
    }
}
