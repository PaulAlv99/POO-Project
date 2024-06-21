package Projeto;

import java.util.*;

public class Menus {
    Scanner scanner = new Scanner(System.in);
    public Menus(){

    }
    public void mostrarMenu(){
        System.out.println("1-Criar Liga aleatoria,equipas aleatorias e jogadores e treinador aleatorio\n2-Sair");
        String opcao =scanner.next();
        scanner.nextLine();
        switch (opcao){
            case "1":
                Simulacao simulacao =new Simulacao();
                Liga liga = simulacao.criarLigaEPopular();
                System.out.println(liga);
                System.out.println("\n1-Simular jogo\n2-Sair");
                String opcao2 =scanner.next();
                scanner.nextLine();
                switch(opcao2){
                    case "1":
                        //TODO SIMULAR JOGAR
                        simulacao.simularJornadas(liga);
                        break;
                    case "2":
                        break;
                }
            case "2":
                break;
        }

    }
    public void menuSimular(){

    }



}
