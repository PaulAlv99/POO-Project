package Projeto;

import java.util.*;

class Pessoa{
    private int idade;
    private String nome;
    private int id;

    Random rand = new Random();
    public int gerarIdadeAleatoria(){
        return 18 + rand.nextInt(40);
    }
    public String gerarNomeALeatorio(){
        int n = rand.nextInt(5);
        String[] nomes = {"Paulo","Tiago","David","Lucas","Mateus"};
        return nomes[n];
    }
    public Pessoa(){
        this.idade = gerarIdadeAleatoria();
        this.nome = gerarNomeALeatorio();
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return getIdade() == pessoa.getIdade() && getNome() == pessoa.getNome() && getId() == pessoa.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdade(), getNome(), getId());
    }

    @Override
    public String toString() {
        return "| Nome: " + getNome() + " | Idade: " + this.getIdade();
    }
}
