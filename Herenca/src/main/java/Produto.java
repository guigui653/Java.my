public class Produto {
    private String nome;
    private double preco;
    private int quantidade;


    public Produto(String nome, double preco, int quantidade){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;

    }
    public void exibirProduto(){
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Quantidade: " + quantidade + " unidades");
        System.out.println("-----------------------------");
    }
    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }
    public int getQuantidade() {
        return quantidade;
    }

    public void setPreco(double novoPreco) {
        if (novoPreco > 0) {
            this.preco = novoPreco;
            System.out.println("Preço atualizado para R$ " + novoPreco);
        } else {
            System.out.println("Preço inválido! Deve ser maior que 0.");
        }
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }


    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Quantidade: " + quantidade + " unidades");
        System.out.println("-----------------------------");
    }
}
