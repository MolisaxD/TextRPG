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
    
    
    //Inimigos
    public static String[] enemies = {"Javali", "Bandido", "Arthropleura",
        "Verme da Terra", "Águia Gigante", "Golem de Pedra",
        "Soldado da Resistência", "Agente da Irmandade", "Sparky",
        "Carnotauro Esqueletal", "Hecatônquiro", "Avatar da Escuridão"};
    
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
        System.out.println("NOME DO JOGO");
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
            
            //Novos inimigos para cada ato
            enemies[0] = "Verme da Terra";
            enemies[1] = "Água Gigante";
            enemies[2] = "Golem de Pedra";
            
            //Curar o jogador
            player.hp = player.maxHp;
            
            //História
            Story.printSecondActIntro();
        } else if(player.xp >= 50 && act == 2) {
            act = 3;
            place = 2;
            
            Story.printSecondActOutro();
            
            player.chooseItem();
            
            enemies[0] = "Soldado da Resistência";
            enemies[1] = "Agente da Irmandade";
            enemies[2] = "Sparky";
            
            player.hp = player.maxHp;
            
            Story.printThirdActIntro();
        } else if(player.xp >= 100 && act == 3) {
            act = 4;
            place = 3;
            
            Story.printThirdActOutro();
            
            player.chooseItem();
            
            enemies[0] = "Carnotauro Esqueletal";
            enemies[1] = "Hecatônquiro";
            enemies[2] = "Avatar da Escuridão";
            
            player.hp = player.maxHp;
            
            Story.printFourthActIntro();
        } else if(player .xp >= 200 && act == 4) {
            act = 5;
            place = 3;
            
            //Batalha final
            //finalBattle();
        }
    }
    
    //Método para calcular um encontro aleatório
    public static void randomEncounter() {
        //Número aleatório entre 0 e o tamanho do Array de encontros 
        int enemy = (int) (Math.random() * enemies.length);
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
    
    //Método para criar uma batalha aleatória
    public static void randomBattle() {
        clearConsole();
        printHeading("Você foi emboscado por um ser perturbado. Você deve lutar!!");
        anythingToContinue();
        
        //Criando inimigo novo
        battle(new Enemy(enemies[(int) (Math.random() * enemies.length)], player.xp));
    }
    
    //O método principal de batalha
    public static void battle(Enemy enemy) {
        while(true) {
            clearConsole();
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
            System.out.println("Escolha uma ação:");
            printSeparator(20);
            System.out.println("1) Lutar");
            System.out.println("2) Usar poção de cura");
            System.out.println("3) Correr");
            int input = readInt("->", 3);
        }
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
