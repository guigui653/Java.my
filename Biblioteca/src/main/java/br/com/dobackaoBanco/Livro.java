package br.com.dobackaoBanco;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private int quantidade;
    private String categoria; // NOVO

    public Livro(String titulo, String autor, String isbn, int quantidade, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public Livro(int id, String titulo, String autor, String isbn, int quantidade, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return "Livro{id=" + id + ", titulo='" + titulo + "', autor='" + autor + "', categoria='" + categoria + "'}";
    }
}