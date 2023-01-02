import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GameFrame extends JFrame implements ActionListener {

    CardLayout cardLayout;
    UserInterfacePanel userInterfacePanel;
    MainMenuPanel mainMenuPanel;
    WorldPanel worldPanel;
    WorldPanel theIslandPanel;
    WorldPanel theCenterPanel;


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
        theIslandPanel = new WorldPanel("The Island", "THE_ISLAND_DATA.ser");
        theCenterPanel = new WorldPanel("The Center", "THE_CENTER_DATA.ser");

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
            saveData();
            ((WorldPanel) parent).removeCreateCreatureTextFields();
        }
        
        
        //Main Menu Buttons to move to each worldPanel
        if (parent == mainMenuPanel) {
            goToPanel(source.getText());
        }
        
        
        //Sets action for Add Creature Button for the Worlds
        if (e.getActionCommand().equals("Add")) {
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
            
            ((WorldPanel) parent).getTames().add(new Creature(creatureName, creatureSpecies, 
            creatureGender, creatureHP, creatureStamina, 
            creatureOxygen, creatureFood, creatureWeight, 
            creatureMelee, creatureMovement, creatureTorpor));

            System.out.println(creatureName);   
            ((WorldPanel) parent).removeCreateCreatureTextFields();

        }

        
    }
    
    //testing Method can remove later
    public void gameOn(){
        cardLayout.show(userInterfacePanel, "World Panel");
    }

    //No longer Used, need to implement loading somewhere else now
    public void goToPanel(WorldPanel panel){
        SaveFileManager.readSaveData(panel);
        cardLayout.show(userInterfacePanel, panel.getWorldName());

    }

    public void goToPanel(String selectedPanel){
        cardLayout.show(userInterfacePanel, selectedPanel);

    }

    public void saveData(){
        SaveFileManager.writeSaveDate(theIslandPanel);
        SaveFileManager.writeSaveDate(theCenterPanel);
    }

}
