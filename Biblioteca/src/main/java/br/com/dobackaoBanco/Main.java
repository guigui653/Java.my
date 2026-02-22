package br.com.dobackaoBanco;

import util.ConexaoBanco;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conexao = ConexaoBanco.getConexao();
        ConexaoBanco.fecharConexao(conexao);
    }
}