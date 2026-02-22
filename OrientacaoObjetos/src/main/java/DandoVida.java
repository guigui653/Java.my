public class DandoVida {
    public static void main(String[] args) {
        //criando objetos(instancias da classe pessoa)
        Pessoa pessoa1 =new Pessoa("gui", 25, 1.65);
        Pessoa pessoa2 =new Pessoa("maria", 60, 1.45);

        //aqui está a ser usado os metodos dos objetos
        pessoa1.apresentar();
        pessoa2.apresentar();

        // acessando os atributos
        System.out.println("altura: " + pessoa1.altura);
        System.out.println("idade: " + pessoa1.idade);

        System.out.println("altura: " + pessoa2.altura);
        System.out.println("idade: " + pessoa2.idade);


    }
}
