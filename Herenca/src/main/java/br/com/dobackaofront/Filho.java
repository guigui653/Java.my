package br.com.dobackaofront;

public class Filho  extends Pai{
    private boolean reclamar;

    public Filho(){
        super(); // ja receber como parametro o construtor
        reclamar = false;
    }
    public Filho(String nome , int idade, boolean reclamar){
        super(nome, idade);
        this.reclamar = reclamar;
    }

    public Filho(boolean reclamar){
        this.reclamar = reclamar;
    }

    public boolean getReclamar() {
        return reclamar;
    }
    public void setReclamar(boolean reclamar) {
        this.reclamar = reclamar;
    }
    @Override
    public void incomodar() {
       super.incomodar();
        System.out.println("heheh");
    }
}

