
import javax.swing.*;

import Creatures.*;

import java.awt.event.*;
import java.awt.*;

public class GameFrame extends JFrame implements ActionListener {

    CardLayout cardLayout;
    UserInterfacePanel userInterfacePanel;
    MainMenuPanel mainMenuPanel;
    WorldPanel worldPanel;
    WorldPanel theIslandPanel = new WorldPanel("The Island", "THE_ISLAND_DATA.ser");
    WorldPanel theCenterPanel = new WorldPanel("The Center", "THE_CENTER_DATA.ser");
    // delete private static GameFrame gameFrame;


    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameFrame gameFrame = new GameFrame("Ark Tracker V3");
            }
        });



    }

    // Creates the JFrame that is the display Window
    GameFrame(String frameTitle) {
        super(frameTitle);

        //Instantiating All Panels (including Worlds)
        cardLayout = new CardLayout();
        userInterfacePanel = new UserInterfacePanel(cardLayout);
        mainMenuPanel = new MainMenuPanel();
        worldPanel = new WorldPanel();
        
        

        //adds all sub-panels to UIPanel, which can be switched between
        userInterfacePanel.add(mainMenuPanel, "Main Menu");
        userInterfacePanel.add(worldPanel, "World Panel");
        userInterfacePanel.add(theIslandPanel, theIslandPanel.getWorldName());
        userInterfacePanel.add(theCenterPanel, theCenterPanel.getWorldName());
    
        //Call in Buttons and add their actionListeners to the GameFrame
        theIslandPanel.getReturnButton().addActionListener(this);
        theIslandPanel.getAddCreatureButton().addActionListener(this);
        theIslandPanel.getViewCreatureButton().addActionListener(this);
        theIslandPanel.getSubmitTextFieldButton().addActionListener(this);
        theIslandPanel.getNextPageButton().addActionListener(this);

        theCenterPanel.getReturnButton().addActionListener(this);
        theCenterPanel.getAddCreatureButton().addActionListener(this);
        theCenterPanel.getViewCreatureButton().addActionListener(this);
        theCenterPanel.getSubmitTextFieldButton().addActionListener(this);

        MainMenuPanel.getTheIslandMenuButton().addActionListener(this);
        MainMenuPanel.getTheCenterMenuButton().addActionListener(this);
        
        
        //Adds UI Panel to the GameFrame
        add(userInterfacePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationByPlatform(true);
        setVisible(true);
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Variables to detect Source Button and it's parent container
        JButton source = (JButton) e.getSource();
        JPanel parent = (JPanel) source.getParent();
        System.out.println(parent.toString());
        
        //Declaring the results of each button being pressed

        //Return Button uses isReturnButton Method to make all return buttons 
        //take it to the main menu panel
        if (e.getActionCommand().equals("Return")) {
            cardLayout.show(userInterfacePanel, "Main Menu");
            ((WorldPanel) parent).removeCreateCreatureTextFields();
            ((WorldPanel) parent).removeAll();
        }
        
        
        //Main Menu Buttons to move to each worldPanel
        if (parent == mainMenuPanel) {
            goToPanel(source.getText());
        }
        
        
        //Sets action for Add Creature Button for the Worlds
        if (e.getActionCommand().equals("Add")) {
            //Need to make a way to remove View info when switching to add option.
            ((WorldPanel) parent).removeAll();
            ((WorldPanel) parent).repaint();
            ((WorldPanel) parent).drawCreateCreatureTextFields();
            
        }
        
        if (e.getActionCommand().equals("Submit")) {
            String creatureName = ((WorldPanel) parent).getNewCreatureNameTextField().getText();
            String creatureSpecies = ((WorldPanel) parent).getNewCreatureSpeciesTextField().getText();
            char creatureGender = ((WorldPanel) parent).getNewCreatureGenderTextField().getText().charAt(0);
            Double creatureHP = Double.valueOf(((WorldPanel) parent).getNewCreatureHPTextField().getText());
            Double creatureStamina = Double.valueOf(((WorldPanel) parent).getNewCreatureStaminaTextField().getText());
            Double creatureOxygen = Double.valueOf(((WorldPanel) parent).getNewCreatureOxygenTextField().getText());
            Double creatureFood = Double.valueOf(((WorldPanel) parent).getNewCreatureFoodTextField().getText());
            Double creatureWeight = Double.valueOf(((WorldPanel) parent).getNewCreatureWeighTextField().getText());
            Double creatureMelee = Double.valueOf(((WorldPanel) parent).getNewCreatureMeleeTextField().getText());
            Double creatureMovement = Double.valueOf(((WorldPanel) parent).getNewCreatureMovementTextField().getText());
            Double creatureTorpor = Double.valueOf(((WorldPanel) parent).getNewCreatureTorporTextField().getText());
            
            WorldPanel currentWorld = ((WorldPanel) parent);
            currentWorld.createCreature(creatureName, creatureSpecies, 
            creatureGender, creatureHP, creatureStamina, creatureOxygen, 
            creatureFood, creatureWeight, creatureMelee, creatureMovement, 
            creatureTorpor);

            System.out.println(creatureName);   

            ((WorldPanel) parent).removeCreateCreatureTextFields();
            saveData();
        }

        //currently working on adding the ability to add an array of kill buttons and listeners
        if (e.getActionCommand().equals("View")) {
            ((WorldPanel) parent).removeCreateCreatureTextFields();
            ((WorldPanel) parent).viewCreatures();
            //Calls RIP Buttons and adds actionListeners for each one.
            JButton[] RIPButtons = ((WorldPanel) parent).getRIPButtons();
            for (int i = 0; i < ((WorldPanel) parent).getTames().size(); i++) {
                RIPButtons[i].addActionListener(this);
            }

            parent.setBackground(Color.CYAN);
        }
        
        if (e.getActionCommand().startsWith("RIP")) {
            ((WorldPanel) parent).setBackground(Color.MAGENTA);
            ((WorldPanel) parent).killCreature(source); 
            ((WorldPanel) parent).removeAll();
            ((WorldPanel) parent).viewCreatures();
            saveData();
        }

        if (e.getActionCommand().equalsIgnoreCase("Next Page")) {
            ((WorldPanel) parent).setBackground(Color.blue);
            ((WorldPanel) parent).removeAll();
            ((WorldPanel) parent).incrementCurrentPage();
            ((WorldPanel) parent).viewCreatures();
        }

    }
    public void goToPanel(String selectedPanel){
        cardLayout.show(userInterfacePanel, selectedPanel);

    }

    public void saveData(){
        SaveFileManager.writeSaveDate(theIslandPanel);
        SaveFileManager.writeSaveDate(theCenterPanel);
    }
}
