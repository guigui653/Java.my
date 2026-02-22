package br.com.dobackaoBanco;

public enum Status {
    ATIVO("Ativo"),
    DEVOLVIDO("Devolvido"),
    ATRASADO("Atrasado");

    private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

