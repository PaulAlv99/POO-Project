package Projeto;
import java.util.*;
public class Simulacao {
    Random rand = new Random();
    public Simulacao(){
    }
    public Liga criarLigaEPopular(){
        Liga liga1 = new Liga();
        Treinador treinador = new Treinador();
        for(int i=0; i<40; i++){
            Equipa equipa1 = new Equipa();
            equipa1.setTreinador(new Treinador());
            for(int t=0; t<5; t++){
                Avancado jogador1 = new Avancado();
                Medio jogador2 = new Medio();
                Defesa jogador3 = new Defesa();
                GR jogador4 = new GR();
                equipa1.adicionarJogador(jogador1);
                equipa1.adicionarJogador(jogador2);
                equipa1.adicionarJogador(jogador3);
                equipa1.adicionarJogador(jogador4);
            }
            liga1.adicionarEquipa(equipa1);
        }
        return liga1;
    }
    public void simularJornadas(Liga liga) {
        List<Equipa> equipas = liga.getEquipas();
        int numEquipas = equipas.size();
        int totalJogos = numEquipas * (numEquipas - 1); // Total de jogos a serem simulados

        // Simular para cada jornada
        for (int jornada = 1; jornada <= totalJogos; jornada++) {
            System.out.println("Jornada " + jornada);

            // Iterar sobre cada par de equipas
            for (int casa = 0; casa < numEquipas; casa++) {
                Equipa equipaCasa = equipas.get(casa);

                for (int fora = 0; fora < numEquipas; fora++) {
                    Equipa equipaFora = equipas.get(fora);

                    // Garantir que não estamos simulando o jogo da equipe contra ela mesma
                    if (casa != fora) {
                        // Verificar se é a primeira ou segunda partida entre as equipes
                        if (jornada % 2 == 1) {
                            // Jogo em casa para equipaCasa e fora para equipaFora
                            simularJogo(equipaCasa, equipaFora);
                            System.out.println(equipaCasa.getID() + " | " + calcularGolos(calcularOverall(equipaCasa)) + " - " + calcularGolos(calcularOverall(equipaFora)) + " | " + equipaFora.getID());
                        } else {
                            // Jogo fora para equipaCasa e em casa para equipaFora
                            simularJogo(equipaFora, equipaCasa);
                            System.out.println(equipaFora.getID() + " | " + calcularGolos(calcularOverall(equipaFora)) + " - " + calcularGolos(calcularOverall(equipaCasa)) + " | " + equipaCasa.getID());
                        }
                    }
                }
            }
            System.out.println(); // Adicionar linha em branco entre jornadas
        }
        // Exibir classificação final da liga após todas as jornadas
        System.out.println("Classificação Final:\n");
        System.out.println(liga);
    }


    public void simularJogo(Equipa equipa1, Equipa equipa2) {
        int overallEquipa1 = calcularOverall(equipa1);
        int overallEquipa2 = calcularOverall(equipa2);

        int golosEquipa1 = calcularGolos(overallEquipa1);
        int golosEquipa2 = calcularGolos(overallEquipa2);

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
        return equipa.jogadores.stream().mapToInt(Jogador::getOverall).sum()/11;
    }

    private int calcularGolos(int overall) {
        return rand.nextInt(overall / 16);
    }

}
