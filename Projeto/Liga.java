package Projeto;

import java.util.*;

public class Liga {
    private int id;
    private static final int jornadasmax = 34;
    private static final int numeroequipasmax = 18;
    private int numerojornada;
    private String nomeliga;
    private static int count=0;
    private static int countEquipasID=0;
    List<Equipa> equipas = new ArrayList<>();

    public void adicionarEquipa(Equipa equipa) {
        if(equipas.size() < numeroequipasmax) {
            equipa.setID(++countEquipasID);
            equipas.add(equipa);
            equipas.sort(Comparator.comparingInt(Equipa::getPontos)
                    .thenComparingInt(Equipa::getGolosofridos)
                    .thenComparingInt(Equipa::getGolosmarcados).reversed());
            updatePositions();
        } else {
            System.out.println("Maximo de equipas na liga");
        }
    }

    private void updatePositions() {
        for (int i = 0; i < equipas.size(); i++) {
            equipas.get(i).setPosicao(i + 1);
        }
    }

    public void removerEquipa(Equipa equipa) {
        equipas.remove(equipa);
        updatePositions();
    }

    Random rand = new Random();

    public String gerarLigaALeatoria() {
        int n = rand.nextInt(5);
        String[] nomes = {"Portuguesa", "Espanhola", "Italiana", "Francesa", "Alema"};
        return nomes[n];
    }

    public Liga() {
        this.nomeliga = gerarLigaALeatoria();
        setId(++count);
    }

    public int getNumerojornada() {
        return numerojornada;
    }

    public void setNumerojornada(int numerojornada) {
        if(numerojornada < jornadasmax) {
            this.numerojornada = numerojornada;
        } else {
            System.out.println("FIM DAS JORNADAS");
            System.out.println(this);
            System.out.println("A recomeçar liga");
            reniciarLiga();
        }
    }

    public void reniciarLiga() {
        for (Equipa equipa : equipas) {
            equipa.resetar(); // Reset each team
        }
        this.numerojornada = 0; // Reset the number of rounds
        equipas.sort(Comparator.comparingInt(Equipa::getPontos)
                .thenComparingInt(Equipa::getGolosofridos)
                .thenComparingInt(Equipa::getGolosmarcados).reversed());
        updatePositions(); // Update positions after reset
    }

    public String getNomeliga() {
        return nomeliga;
    }

    public void setNomeliga(String nomeliga) {
        this.nomeliga = nomeliga;
    }

    @Override
    public String toString() {
        equipas.sort(Comparator.comparingInt(Equipa::getPontos)
                .thenComparingInt(Equipa::getGolosofridos)
                .thenComparingInt(Equipa::getGolosmarcados).reversed());
        updatePositions();
        return "ID: " + this.getId()+" | " + "Liga: " + this.getNomeliga() + " | Numero equipas: " + getEquipas().size() + " | Numero jornada: " + getNumerojornada()
                + "\nEquipas: \n" + equipas;
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
        Liga liga = (Liga) o;
        return getId() == liga.getId() && getNumerojornada() == liga.getNumerojornada() && Objects.equals(getNomeliga(), liga.getNomeliga()) && Objects.equals(getEquipas(), liga.getEquipas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumerojornada(), getNomeliga(), getEquipas());
    }

    public List<Equipa> getEquipas() {
        return equipas;
    }

    public void setEquipas(List<Equipa> equipas) {
        this.equipas = equipas;
    }
}