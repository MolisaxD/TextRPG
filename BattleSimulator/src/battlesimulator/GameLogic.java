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
    
    //Progressão da história
    public static int place = 0, act;
    public static String[] places = {"ç", "", "chinelo", "putz"};
    
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
    
    //Método para continuar a jornada
    private static void continueJourney() {
        
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
        printHeading("MENU");
        System.out.println("Escolha uma ação:");
        printSeparator(20);
        System.out.println("1) Continue sua jornada");
        System.out.println("2) Dados do personagem");
        System.out.println("3) Sair do jogo");
    }
    
    //Loop principal
    private static void gameLoop() {
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
