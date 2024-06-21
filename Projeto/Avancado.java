package Projeto;

public class Avancado extends Jogador{
    private static int count = 0;
    public Avancado(){
        this.setId(++count);
    }
}
