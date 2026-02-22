public class Atleta2 {
    private String nome;
    private double forca; // Quanto ele aguenta levantar

    public Atleta2(String nome, double forca) {
        this.nome = nome;
        this.forca = forca;
    }


    public void treinar(Equipamento aparelho) {


        double pesoDoAparelho = aparelho.getPeso();


        if (this.forca >= pesoDoAparelho) {

            aparelho.ocupar();
            System.out.println("BIRL! " + this.nome + " está levantando o " + aparelho.getNome());
        } else {

            System.out.println("Eita... " + aparelho.getNome() + " é muito pesado pra você, " + this.nome);
        }
    }
}