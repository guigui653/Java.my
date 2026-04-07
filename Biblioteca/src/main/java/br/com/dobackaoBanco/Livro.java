package br.com.dobackaoBanco;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String editora; // NOVO
    private String isbn;
    private int anoPublicacao; // NOVO
    private int quantidade;
    private String statusLivro; // NOVO
    private String categoria;

    public Livro() {
    }

    public Livro(String titulo, String autor, String editora, String isbn, int anoPublicacao, int quantidade,
            String statusLivro, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.quantidade = quantidade;
        this.statusLivro = statusLivro;
        this.categoria = categoria;
    }

    public Livro(int id, String titulo, String autor, String editora, String isbn, int anoPublicacao, int quantidade,
            String statusLivro, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.quantidade = quantidade;
        this.statusLivro = statusLivro;
        this.categoria = categoria;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatusLivro() {
        return statusLivro;
    }

    public void setStatusLivro(String statusLivro) {
        this.statusLivro = statusLivro;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", status='" + statusLivro + '\'' +
                '}';
    }
}