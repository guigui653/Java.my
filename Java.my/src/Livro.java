public class Livro {
    // Atributos privados (Encapsulamento)
    private String titulo;
    private String autor;
    private int anoPublicacao;

    // Construtor
    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    // Método com retorno: Formata os dados para exibição
    public String obterFichaCatalografica() {
        return "Título: " + titulo + " | Autor: " + autor + " | Ano: " + anoPublicacao;
    }
}