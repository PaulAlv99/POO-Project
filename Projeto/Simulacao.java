package Projeto;
import java.util.*;

public class Simulacao {
    Random rand = new Random();

    public Simulacao() { }

    public Liga criarLigaEPopular() {
        Liga liga1 = new Liga();
        for (int i = 0; i < 18; i++) {
            Equipa equipa1 = new Equipa();
            equipa1.setTreinador(new Treinador());
            equipa1.adicionarJogador(new Avancado());
            equipa1.adicionarJogador(new Avancado());
            equipa1.adicionarJogador(new Medio());
            equipa1.adicionarJogador(new Medio());
            equipa1.adicionarJogador(new Medio());
            equipa1.adicionarJogador(new Medio());
            equipa1.adicionarJogador(new Defesa());
            equipa1.adicionarJogador(new Defesa());
            equipa1.adicionarJogador(new Defesa());
            equipa1.adicionarJogador(new Defesa());
            equipa1.adicionarJogador(new GR());
            liga1.adicionarEquipa(equipa1);
        }
        return liga1;
    }

    public void simularJornadas(Liga liga) {
        List<Equipa> equipas = liga.getEquipas();
        int numEquipas = equipas.size();
        
        // Simulate home and away matches for each pair of teams
        for (int i = 0; i < numEquipas; i++) {
            for (int j = i + 1; j < numEquipas; j++) {
                // Simulate first match where equipas.get(i) is the home team
                simularJogo(equipas.get(i), equipas.get(j));
                // Simulate second match where equipas.get(j) is the home team
                simularJogo(equipas.get(j), equipas.get(i));
            }
        }
        System.out.println(liga);
        Menus menus = new Menus();
        menus.mostrarMenu();
    }

    private void simularJogo(Equipa equipa1, Equipa equipa2) {
        int[] golosEquipas = calcularResultadoPartida(equipa1, equipa2);
        int golosEquipa1 = golosEquipas[0];
        int golosEquipa2 = golosEquipas[1];

        printResultadoPartida(equipa1, equipa2, golosEquipa1, golosEquipa2);
        atualizarEstatisticas(equipa1, equipa2, golosEquipa1, golosEquipa2);
    }

    private int[] calcularResultadoPartida(Equipa equipa1, Equipa equipa2) {
        int overallEquipa1 = calcularOverall(equipa1);
        int overallEquipa2 = calcularOverall(equipa2);

        int golosEquipa1 = calcularGolos(overallEquipa1);
        int golosEquipa2 = calcularGolos(overallEquipa2);

        return new int[]{golosEquipa1, golosEquipa2};
    }

    private void printResultadoPartida(Equipa equipa1, Equipa equipa2, int golosEquipa1, int golosEquipa2) {
        System.out.println(equipa1.getID() + "-" + equipa1.getNome() + " | " + golosEquipa1 + " - " + golosEquipa2 + " | " + equipa2.getID() + "-" + equipa2.getNome());
    }

    private void atualizarEstatisticas(Equipa equipa1, Equipa equipa2, int golosEquipa1, int golosEquipa2) {
        equipa1.setGolosmarcados(equipa1.getGolosmarcados() + golosEquipa1);
        equipa1.setGolosofridos(equipa1.getGolosofridos() + golosEquipa2);

        equipa2.setGolosmarcados(equipa2.getGolosmarcados() + golosEquipa2);
        equipa2.setGolosofridos(equipa2.getGolosofridos() + golosEquipa1);

        if (golosEquipa1 > golosEquipa2) {
            equipa1.setVitorias(equipa1.getVitorias() + 1);
            equipa1.setPontos(equipa1.getPontos() + 3);
            equipa2.setDerrotas(equipa2.getDerrotas() + 1);
        } else if (golosEquipa1 < golosEquipa2) {
            equipa2.setVitorias(equipa2.getVitorias() + 1);
            equipa2.setPontos(equipa2.getPontos() + 3);
            equipa1.setDerrotas(equipa1.getDerrotas() + 1);
        } else {
            equipa1.setEmpates(equipa1.getEmpates() + 1);
            equipa1.setPontos(equipa1.getPontos() + 1);
            equipa2.setEmpates(equipa2.getEmpates() + 1);
            equipa2.setPontos(equipa2.getPontos() + 1);
        }
    }

    private int calcularOverall(Equipa equipa) {
        return equipa.getJogadores().stream().mapToInt(Jogador::getOverall).sum() / equipa.getJogadores().size();
    }

    private int calcularGolos(int overall) {
        return rand.nextInt(overall / 16 + 1);
    }
}
