package br.com.dobackaoBanco;

public class Emprestimo {
    private int id;
    private Usuario usuario;
    private Livro livro;
    private String dataEmprestimo;
    private String dataPrevistaDevolucao; // NOVO
    private String dataDevolucao;
    private Status status;

    public Emprestimo(Usuario usuario, Livro livro, String dataEmprestimo, String dataPrevistaDevolucao) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.status = Status.ATIVO;
    }

    public Emprestimo(int id, Usuario usuario, Livro livro, String dataEmprestimo, String dataPrevistaDevolucao, String dataDevolucao, Status status) {
        this.id = id;
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Livro getLivro() { return livro; }
    public void setLivro(Livro livro) { this.livro = livro; }
    public String getDataEmprestimo() { return dataEmprestimo; }
    public void setDataEmprestimo(String dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }
    public String getDataPrevistaDevolucao() { return dataPrevistaDevolucao; }
    public void setDataPrevistaDevolucao(String d) { this.dataPrevistaDevolucao = d; }
    public String getDataDevolucao() { return dataDevolucao; }
    public void setDataDevolucao(String dataDevolucao) { this.dataDevolucao = dataDevolucao; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    @Override
    public String toString() {
        return "Emprestimo{id=" + id + ", usuario=" + usuario.getNome() +
                ", livro=" + livro.getTitulo() + ", status=" + status +
                ", previsto=" + dataPrevistaDevolucao + "}";
    }
}