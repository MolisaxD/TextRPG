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
public class Story {
    public static void printIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("HISTÓRIA");
        GameLogic.printSeparator(30);
        System.out.println("O mundo é dominado por dragões, que formam o topo da hierarquia e são comandados por 5 Emblemas portadores de poderes imensos: Emblema da Entropia,\n"
                + "Emblema da Inércia, Emblema da Energia, Emblema da Origem e Emblema da Polaridade. Nessa situação, a sociedade e os humanos se encontram marginalizados e\n "
                + "procurando qualquer oportunidade de se rebelar. É aí que entra Nigromante, uma pessoa que dedicou sua vida inteira às artes arcanas com o intuito de um dia se juntar à\n "
                + "alta sociedade dos dragões, seja como serva ou renascida como um deles. Foi rejeitada e humilhada, então resolve acudir à sociedade dos artífices, que monta animais mecânicos\n "
                + "artesanais e por meio de um pacto, pretende transferir sua alma ao corpo de um dragão feito com tecnologia humana e energia nuclear. Contudo, é revelado que as intenções de\n "
                + "Nigromante vão além do que era esperado e é necessário que alguém a pare antes que cause uma guerra nuclear e possível genocídio com seu dragão mecânico.\n "
                + "Você é um agente enviado pelos Emblemas para derrotá-la para impedir que pessoas inocentes morram e para prevenir a usurpação de seus líderes dragões.\n");
        GameLogic.anythingToContinue();
    }
    
    public static void printFirstActIntro() {
        GameLogic.clearConsole();
        GameLogic.printHeading("ACT I Intro");
        System.out.println("");
        GameLogic.anythingToContinue();
    }
    
    public static void printFirstActOutro() {
        GameLogic.clearConsole();
        GameLogic.printHeading("ACT I Outro");
        System.out.println("");
        GameLogic.anythingToContinue();
    }
    
    public static void printSecondActIntro() {
        GameLogic.clearConsole();
        GameLogic.printHeading("ACT II Intro");
        System.out.println("");
        GameLogic.anythingToContinue();
    }
    
    public static void printSecondActOutro() {
        GameLogic.clearConsole();
        GameLogic.printHeading("ACT II Outro");
        System.out.println("");
        GameLogic.anythingToContinue();
    }
    
    public static void printThirdActIntro() {
        GameLogic.clearConsole();
        GameLogic.printHeading("ACT III Intro");
        System.out.println("");
        GameLogic.anythingToContinue();
    }
    
    public static void printThirdActOutro() {
        GameLogic.clearConsole();
        GameLogic.printHeading("ACT III Outro");
        System.out.println("");
        GameLogic.anythingToContinue();
    }
    
    public static void printFourthActIntro() {
        GameLogic.clearConsole();
        GameLogic.printHeading("ACT IV Intro");
        System.out.println("");
        GameLogic.anythingToContinue();
    }
    
    public static void printFourthActOutro() {
        GameLogic.clearConsole();
        GameLogic.printHeading("ACT IV Outro");
        System.out.println("");
        GameLogic.anythingToContinue();
    }
    
    public static void printEnd() {
        GameLogic.clearConsole();
        GameLogic.printHeading("Ending");
        System.out.println("");
        GameLogic.anythingToContinue();
    }
}
