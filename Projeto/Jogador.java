package Projeto;

import java.util.Random;

public class Jogador extends Pessoa{
    private Equipa equipa;
    private int overall;
    Random rand = new Random();
    public Jogador() {
        this.overall= 45 + rand.nextInt(50);
    }

    public Equipa getEquipa() {
        return equipa;
    }

    public void setEquipa(Equipa equipa) {
        this.equipa = equipa;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }
    public String toString() {
        return "ID: " + this.getId()+" | " + "Posição: " + this.getClass().getSimpleName()+
                " | Nome: " + getNome() + " | Idade: " + this.getIdade() + " | Overall: " + this.getOverall() + "\n";
    }
}
