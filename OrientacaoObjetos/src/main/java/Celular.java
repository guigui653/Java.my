public class Celular {
    private String marca;
    private String modelo;
    private double preco;
    private int armazenamento;
    private int bateria;

    public Celular(String marca, String modelo, double preco, int armazenamento, int bateria) {
        this.marca = marca;
        this.modelo = modelo;
        setPreco(preco);
        setArmazenamento(armazenamento);
        setBateria(bateria);
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        if (preco > 0) {
            this.preco = preco;
        } else {
            System.out.println("Erro: O preço deve ser maior que 0.");
        }
    }

    public int getArmazenamento() {
        return armazenamento;
    }
    public void setArmazenamento(int armazenamento) {
        if (armazenamento > 0) {
            this.armazenamento = armazenamento;
        } else {
            System.out.println("Erro: O armazenamento deve ser maior que 0.");
        }
    }

    public int getBateria() {
        return bateria;
    }
    public void setBateria(int bateria) {
        if (bateria >= 0 && bateria <= 100) {
            this.bateria = bateria;
        } else {
            System.out.println("Erro: A bateria deve estar entre 0 e 100.");
        }
    }

    public void exibirInformacoes(){
        System.out.println("=== INFORMAÇÕES DO CELULAR ===");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Armazenamento: " + armazenamento + " GB");
        System.out.println("Bateria: " + bateria + "%");
        System.out.println("================================\n");
    }

    public void usarCelular(int i) {
    }

    public void carregar(int i) {
    }

    public void aplicarDesconto(int i) {
    }

    public void Menu() {
    }
}
