package Projeto;

import java.util.*;

public class Equipa {
    private int id;
    private String nome;
    private Treinador treinador;
    private Liga liga;
    private int pontos;
    private int golosmarcados;
    private int golosofridos;
    private int vitorias;
    private int derrotas;
    private int empates;
    private int posicao = 1;
    private static int count = 0;
    private static int countJogadoresID = 1;
    private static final int numerojogadoresmax = 11;
    List<Jogador> jogadores = new ArrayList<>();
    Random rand = new Random();

    public void resetar() {
        this.pontos = 0;
        this.golosmarcados = 0;
        this.golosofridos = 0;
        this.vitorias = 0;
        this.derrotas = 0;
        this.empates = 0;
        this.posicao = 1;
    }

    public String gerarNomeAleatorio() {
        int n = rand.nextInt(5);
        String[] nomes = {"Benfica", "Porto", "Sporting", "Braga", "Estoril"};
        return nomes[n];
    }

    public Equipa() {
        this.nome = gerarNomeAleatorio();
    }

    public void adicionarJogador(Jogador jogador) {
        if (jogadores.size() < numerojogadoresmax) {
            jogador.setId(++countJogadoresID);
            jogadores.add(jogador);
        } else {
            System.out.println("Maximo de jogadores na equipa");
        }
    }

    public void removerJogador(Jogador jogador) {
        jogadores.remove(jogador);
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ID: " + this.getID() + " | " + this.getPosicao() + " - " + "Equipa: " + this.getNome() + " | Pontos: " + getPontos() + " | Vitorias: " + getVitorias() + " | Empates: " + getEmpates() + " | Derrotas: " + getDerrotas() + " | Golos marcados: " + getGolosmarcados() + " | Golos sofridos: " + getGolosofridos() + " | Treinador: " + getTreinador() + "\n";
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipa equipa = (Equipa) o;
        return getID() == equipa.getID() && getPontos() == equipa.getPontos() && getVitorias() == equipa.getVitorias() && getDerrotas() == equipa.getDerrotas() && Objects.equals(getNome(), equipa.getNome()) && Objects.equals(getLiga(), equipa.getLiga()) && Objects.equals(jogadores, equipa.jogadores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getNome(), getLiga(), getPontos(), getVitorias(), getDerrotas(), jogadores);
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getGolosmarcados() {
        return golosmarcados;
    }

    public void setGolosmarcados(int golosmarcados) {
        this.golosmarcados = golosmarcados;
    }

    public int getGolosofridos() {
        return golosofridos;
    }

    public void setGolosofridos(int golosofridos) {
        this.golosofridos = golosofridos;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public void setTreinador(Treinador treinador) {
        if (this.getTreinador() != null) {
            System.out.print("Ja existe treinador");
        } else {
            treinador.setId(++count);
            this.treinador = treinador;
        }
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
}
