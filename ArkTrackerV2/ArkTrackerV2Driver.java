import javax.swing.*;
import Creatures.*;

public class ArkTrackerV2Driver {
    
    private static JFrame arkTrackerFrame = new JFrame("Ark Tracker V2");
   
    private static UserInterface mainMenu = new UserInterface();

    //instantiates all applicable worlds, 
    //World() Constructor has built in methods to read prior save data
    private static World theIslandWorld = new World("The Island","THE_ISLAND_SAVE.ser");
    private static World theCenteWorld = new World("The Center", "THE_CENTER_SAVE.ser");
    private static World scorchedEarthWorld = new World("Scorched Earth", "SCORCHED_EARTH_SAVE.ser");
    private static World ragnarokWorld = new World("Ragnarok", "RAGNAROK_SAVE.ser");
    private static World aberrationWorld = new World("Aberration", "ABERRATION_SAVE.ser");
    private static World extinctionWorld = new World("Extinction", "EXTINCTION_SAVE.ser");
    private static World valguerWorld = new World("Valguero", "VALGUERO.ser");
    private static World genesisPartOneWorld = new World("Genesis Pt. 1", "GENESIS_PART_ONE_SAVE.ser");
    private static World genesisPartTwoWorld = new World("Genesis Pt. 2", "GENESIS_PART_TWO_SAVE.ser");
    private static World crystalIslesWorld = new World("Crystal Isles", "CRYSTAL_ISLES_SAVE.ser");
    private static World lostIslandWorld = new World("Lost Island", "LOST_ISLAND_SAVE.ser");
    private static World fjordurWorld = new World("Fjordur", "FJORDUR_SAVE.ser");
    
    public static void main(String[] args) {
        initWindow(mainMenu);
        System.out.println("Testing Main Method");
        
        // SaveFileManager.writeSaveDate();
         
    } 

    public static void initWindow(JPanel panel) {
        arkTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        arkTrackerFrame.add(panel);
        arkTrackerFrame.paintComponents(null);
        arkTrackerFrame.setResizable(true);
        arkTrackerFrame.pack();
        arkTrackerFrame.setLocationRelativeTo(null);
        arkTrackerFrame.setVisible(true);
        
    }
    
    public static void clearWindow(){
        arkTrackerFrame.removeAll();
    }

    public static JFrame getArkTrackerFrame() {
        return arkTrackerFrame;
    }

    public static World getTheIslandWorld() {
        return theIslandWorld;
    }

    public static World getTheCenteWorld() {
        return theCenteWorld;
    }

    public static World getScorchedEarthWorld() {
        return scorchedEarthWorld;
    }

    public static World getRagnarokWorld() {
        return ragnarokWorld;
    }

    public static World getAberrationWorld() {
        return aberrationWorld;
    }

    public static World getExtinctionWorld() {
        return extinctionWorld;
    }

    public static World getValguerWorld() {
        return valguerWorld;
    }

    public static World getGenesisPartOneWorld() {
        return genesisPartOneWorld;
    }
    
    public static World getGenesisPartTwoWorld() {
        return genesisPartTwoWorld;
    }

    public static World getCrystalIslesWorld() {
        return crystalIslesWorld;
    }

    public static World getLostIslandWorld() {
        return lostIslandWorld;
    }

    public static World getFjordurWorld() {
        return fjordurWorld;
    }


}
