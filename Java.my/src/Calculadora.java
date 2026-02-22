public class Calculadora {
    // Atributos existentes
    private double resultado;

    // Construtor existente
    public Calculadora() {
        this.resultado = 0;
    }

    // Métodos existentes
    public double somar(double numero1, double numero2) {
        this.resultado = numero1 + numero2;
        return this.resultado;
    }

    public double subtrair(double numero1, double numero2) {
        this.resultado = numero1 - numero2;
        return this.resultado;
    }

    public double multiplicar(double numero1, double numero2) {
        this.resultado = numero1 * numero2;
        return this.resultado;
    }

    public double dividir(double numero1, double numero2) {
        if (numero2 == 0) {
            throw new ArithmeticException("Não é possível dividir por zero!");
        }
        this.resultado = numero1 / numero2;
        return this.resultado;
    }

    // Novo método para calcular potência
    public double potencia(double base, double expoente) {
        this.resultado = Math.pow(base, expoente);
        return this.resultado;
    }

    // Getter existente
    public double getResultado() {
        return this.resultado;
    }

    // Método existente para limpar
    public void limpar() {
        this.resultado = 0;
    }
}