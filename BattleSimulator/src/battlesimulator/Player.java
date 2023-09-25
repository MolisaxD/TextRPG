/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlesimulator;

/**
 *
 * @author mborges
 */
public class Player extends Character {
    
    //Atributos extra
    public int gold, pots;
    //Itens
    public int numAtkUpgrades, numDefUpgrades;
    
    
    public String[] atkUpgrades = {"Boomerang", "Trompa de Caça", "Vela Santa", "Dente de Dragão"};
    public String[] defUpgrades = {"Armadura de Ossos", "Cota de Malha", "Pergaminho Sagrado", "União"};

    public Player(String name) {
        super(name, 100, 0);
        
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        
        this.gold = 5;
        this.pots = 1;
        
        chooseItem();
    }

    @Override
    public int attack() {
        return (int) (Math.random() * (xp/4 + numAtkUpgrades * 3 + 3) + xp/10 + numAtkUpgrades * 2 + numDefUpgrades + 1);
    }

    @Override
    public int defend() {
        return (int) (Math.random() * (xp/4 + numDefUpgrades * 3 + 3) + xp/10 + numDefUpgrades * 2 + numDefUpgrades + 1);
    }

    public void chooseItem() {
        GameLogic.clearConsole();
        GameLogic.printHeading("Escolha um item:");
        System.out.println("1)" + atkUpgrades[numAtkUpgrades]);
        System.out.println("2)" + defUpgrades[numDefUpgrades]);
        
        int input = GameLogic.readInt("->", 2);
        GameLogic.clearConsole();
        
        if(input == 1) { 
            GameLogic.printHeading("Você escolheu " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        } else {
            GameLogic.printHeading("Você escolheu " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();
    }
    
}
