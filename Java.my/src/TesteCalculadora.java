public class TesteCalculadora {
    public static void main(String[] args) {
        // Criando uma instância da calculadora
        Calculadora calc = new Calculadora();

        // Testando as operações básicas
        System.out.println("Soma: " + calc.somar(10, 5));        // 15.0
        System.out.println("Subtração: " + calc.subtrair(10, 5)); // 5.0
        System.out.println("Multiplicação: " + calc.multiplicar(10, 5)); // 50.0
        System.out.println("Divisão: " + calc.dividir(10, 5));    // 2.0

        // Testando a nova funcionalidade de potência
        System.out.println("\nTestando Potência:");
        System.out.println("2² = " + calc.potencia(2, 2));     // 4.0
        System.out.println("2³ = " + calc.potencia(2, 3));     // 8.0
        System.out.println("5² = " + calc.potencia(5, 2));     // 25.0

        // Exemplo com expoente negativo
        System.out.println("2⁻² = " + calc.potencia(2, -2));   // 0.25

        // Testando o getter do resultado
        System.out.println("\nResultado atual: " + calc.getResultado());

        // Testando o método limpar
        calc.limpar();
        System.out.println("Resultado após limpar: " + calc.getResultado());

        // Testando divisão por zero
        try {
            calc.dividir(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}