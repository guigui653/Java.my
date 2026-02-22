public class Livro {

    // Campos (atributos)
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

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }


    public String obterFichaCatalografica() {
        return String.format("\"%s\" - %s (%d)", titulo, autor, anoPublicacao);
    }

    // toString() utilizando a ficha catalográfica (muito comum em exercícios)
    @Override
    public String toString() {
        return obterFichaCatalografica();
    }
}