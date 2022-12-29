import javax.swing.*;

import Creatures.*;
import java.awt.*;
import java.awt.event.*;

public class ArkTrackerV2Driver extends JFrame implements ActionListener {
    
    private static CardLayout screenPages = new CardLayout();
    
    private static UserInterface userInterface = new UserInterface();
    private static JPanel mainPanel = new JPanel(screenPages);
    
    private static ArkTrackerV2Driver arkTrackerFrame = new ArkTrackerV2Driver();
    
    //instantiates all applicable worlds, 
    //World() Constructor has built in methods to read prior save data
    private static World theIslandWorld = new World("The Island","THE_ISLAND_SAVE.ser");
    private static World theCenterWorld = new World("The Center", "THE_CENTER_SAVE.ser");
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
    
    static JButton theIslandSelectionJButton= new JButton("The Island");
    static JButton theCenterSelectionJButton = new JButton("The Center");
    static JButton scorchedEarthSelectionJButton = new JButton("Scorched Earth");
    static JButton ragnarokSelectionJButton = new JButton("Ragnarok");
    static JButton aberrationSelectionJButton = new JButton("Abberation");
    static JButton extinctionSelectionJButton = new JButton("Extinction");
    static JButton valgueroSelectionJButton = new JButton("Valguero");
    static JButton genesisPartOneSelectionJButton = new JButton("Genesis: Part 1");
    static JButton genesisPartTwoSelectionJButton = new JButton("Genesis: Part 2");
    static JButton crystalIslesSelectionJButton = new JButton("Crystal Isles");
    static JButton lostIslandSelectionJButton = new JButton("Lost Island");
    static JButton fjordurSelectionJButton = new JButton("Fjordur");
    
    public static void main(String[] args) {
        initWindow();
        System.out.println("Testing Main Method");
        
        // SaveFileManager.writeSaveDate();
         
    } 

    public ArkTrackerV2Driver() {
        super();
    }

    public static void initWindow() {
        arkTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        arkTrackerFrame.add(mainPanel);
        arkTrackerFrame.paintComponents(null);
        arkTrackerFrame.setResizable(true);
        arkTrackerFrame.pack();
        arkTrackerFrame.setLocationRelativeTo(null);
        arkTrackerFrame.setVisible(true);
        mainPanel.add(userInterface, "User Interface");
        mainPanel.add(theCenterWorld, theCenterWorld.getWorldName());
        //userInterface.add(theCenterWorld, "The Center");
        //userInterface.add(theIslandWorld, "The Island");
    }
    
    public static void changeToNewPanel(JPanel panel){
        /*arkTrackerFrame.remove(userInterface);
        arkTrackerFrame.repaint();
        arkTrackerFrame.revalidate();

        arkTrackerFrame.add(panel);
        arkTrackerFrame.repaint();
        arkTrackerFrame.revalidate();*/

        //screenPages.show(mainPanel, ((World) panel).getWorldName());
        screenPages.show(mainPanel, null);
    }

    public static CardLayout getScreenPages() {
        return screenPages;
    }

    public static JFrame getArkTrackerFrame() {
        return arkTrackerFrame;
    }

    public static UserInterface getUserInterface() {
        return userInterface;
}

    public static World getTheIslandWorld() {
        return theIslandWorld;
    }

    public static World getTheCenterWorld() {
        return theCenterWorld;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        changeToNewPanel(theCenterWorld);
        
    }














}
