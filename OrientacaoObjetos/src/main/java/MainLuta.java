public class MainLuta {
    public static void main(String[] args) {
        Atleta guerreiro = new Atleta("Guilherme", 100.0);

        // Como o método treinar mudou para aceitar Equipamento, precisamos adaptar ou criar um equipamento fictício
        // Ou se a intenção era apenas gastar energia, podemos criar um método sobrecarregado em Atleta.
        // Mas para corrigir rapidamente com base na mudança recente:
        
        Equipamento pesoLeve = new Equipamento("Pesinho", 10.0);
        
        guerreiro.treinar(pesoLeve);
        guerreiro.treinar(pesoLeve);
        
        System.out.println("Energia atual: " + guerreiro.getEnergia());
    }
}
