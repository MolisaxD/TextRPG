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
    
    public int numAtkUpgrades, numDefUpgrades;
    
    public String[] atkUpgrades = {"Boomerang", "Hunting Horn", "Sacred Candle", "Dragon Tooth"};
    public String[] defUpgrades = {"Bone Armor", "Chainmail", "Holy Bible", "Plot Armor"};

    public Player(String name) {
        super(name, 100, 0);
        
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        
        chooseItem();
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }

    private void chooseItem() {
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
