public class SistemaDeEstoque {
    public static void main(String[] args) {
        // Criando objetos (instâncias da classe Produto)
        Produto playstation = new Produto("PlayStation 5", 4999.90, 4);
        Produto tv = new Produto("Smart TV 55'", 2299.00, 6);
        Produto note = new Produto("Notebook Gamer", 4499.00, 2);

        // Usando os métodos
        playstation.exibirInfo();
        tv.exibirInfo();
        note.exibirInfo();

    // Testando ‘setter’ com validação
        tv.setPreco(1999.00);     // ok
        tv.setPreco(-500);        // vai dar mensagem de erro
        tv.exibirInfo();

    // Usando toString
        System.out.println("toString do note: " + note);
    }
}
