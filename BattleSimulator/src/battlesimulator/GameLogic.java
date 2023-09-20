/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesimulator;

import java.util.Scanner;

/**
 *
 * @author mborges
 */
public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    
    static Player player;
    
    //Variável para determinar se o jogo já começou
    public static boolean isRunning;
    
    //Encontros aleatórios
    public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest"};
    
    //Inimigos
    public static String[] enemies = {"Javali", "Bandido", "Arthropleura", "Verme da Terra", "Golem de Pedra", "Soldado da Resistência", "Agente da Irmandade", "Sparky",
        "Carnotauro Esqueletal", "Hecatônquiro", ""};
    
    //Progressão da história
    public static int place = 0, act = 1;
    public static String[] places = {"Forest", "Enchanted Mountains", "City", "Underground"};
    
    //Método para ler input do usuário
    public static int readInt(String prompt, int userChoices) {
        int input;
        
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Por favor insira um valor válido.");
            }
        } while(input < 1 || input > userChoices);
        return input;
    }
    
    //Limpar console
    public static void clearConsole() {
        for(int i = 0; i < 100; i++ ) {
                System.out.println();
        }  
    }
    
    //Separador
    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++) {
                System.out.print("-");
        }
            System.out.println();
        
    }
    
    //Cabeçalho
    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }
    
    //Pausa para o jogador continuar
    public static void anythingToContinue() {
        System.out.println("\nInsira qualquer valor para continuar...");
        scanner.next();
    }
    
    //Começar o jogo
    public static void startGame() {
        boolean nameSet = false;
        String name;
        
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("league of legends");
        printSeparator(30);
        printSeparator(40);
        anythingToContinue();
        
        do {
            clearConsole();
            printHeading("Digite seu nome: ");
            name = scanner.next();
            nameSet = true;
        } while (!nameSet);
        
        Story.printIntro();
        
        player = new Player(name);
        
        Story.printFirstActIntro();
        
        isRunning = true;
        
        gameLoop();
    }
    
    //Método para checar ato
    public static void checkAct() {
        if(player.xp >= 10 && act == 1) {
            //Incrementar ato e lugar
            act = 2;
            place = 1;
            
            //História
            Story.printFirstActOutro();
            
            //Escolher equipamento novo
            player.chooseItem();
            
            //História
            Story.printSecondActIntro();
        } else if(player.xp >= 50 && act == 2) {
            act = 3;
            place = 2;
            
            Story.printSecondActOutro();
            
            player.chooseItem();
            
            Story.printThirdActIntro();
        } else if(player.xp >= 100 && act == 3) {
            act = 4;
            place = 3;
            
            Story.printThirdActOutro();
            
            player.chooseItem();
            
            Story.printFourthActIntro();
        }
    }
    
    //Método para continuar a jornada
    public static void continueJourney() {
        //Checar o ato atual
        checkAct();
        //Checar se é o último ato
        if(act != 4) {
            randomEncounter();
        }
        
    }
    
    public static void characterInfo() {
        clearConsole();
        printHeading("INFORMAÇÕES DO PERSONAGEM");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeparator(20);
        System.out.println("XP: " + player.xp);
        printSeparator(20);
        
        if(player.numAtkUpgrades > 0) {
            System.out.println("Armas: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeparator(20);
        } 
        if(player.numDefUpgrades > 0) {
            System.out.println("Defesa: " + player.defUpgrades[player.numDefUpgrades - 1]);
        }
        
        anythingToContinue();
    }
    
    //Método para definir o menu
    public static void printMenu() {
        clearConsole();
        printHeading(places[place]);
        System.out.println("Escolha uma ação:");
        printSeparator(20);
        System.out.println("1) Continue sua jornada");
        System.out.println("2) Dados do personagem");
        System.out.println("3) Sair do jogo");
    }
    
    //Loop principal
    public static void gameLoop() {
        while(isRunning) {
            printMenu();
            int input = readInt("->", 3);
            if(input == 1) {
                continueJourney();
            } else if (input == 2){
                characterInfo();
            } else {
                isRunning = false;
            }
        }
    }
}
