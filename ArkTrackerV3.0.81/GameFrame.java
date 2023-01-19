
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GameFrame extends JFrame implements ActionListener {

    CardLayout cardLayout;
    UserInterfacePanel userInterfacePanel;
    MainMenuPanel mainMenuPanel = new MainMenuPanel();
    WorldPanel theIslandPanel = new WorldPanel("The Island", "THE_ISLAND_DATA.ser");
    WorldPanel theCenterPanel = new WorldPanel("The Center", "THE_CENTER_DATA.ser");
    //Timer gameFrameTimer = new Timer(1000, this);
    

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameFrame gameFrame = new GameFrame("Ark Tracker V3");
                
                
            }
        });
        //Unclear if the snippet above is necessary?
        //Got the idea from advice I read online but 
        // Appears to run no differently than the snippet below?
        // Leave commented out just in case it is needed to revert to 
        // at any point.
        //GameFrame gameFrame = new GameFrame("Ark Tracker V3");



    }

    // Creates the JFrame that is the display Window
    GameFrame(String frameTitle) {
        super(frameTitle);

        //Instantiating All Panels (including Worlds)
        cardLayout = new CardLayout();
        userInterfacePanel = new UserInterfacePanel(cardLayout);
        


        //adds all sub-panels to UIPanel, which can be switched between

        userInterfacePanel.add(mainMenuPanel, "Main Menu");
        userInterfacePanel.add(theIslandPanel, theIslandPanel.getWorldName());
        userInterfacePanel.add(theCenterPanel, theCenterPanel.getWorldName());
    
        //Call in Buttons and add their actionListeners to the GameFrame
        theIslandPanel.getReturnButton().addActionListener(this);
        theIslandPanel.getAddCreatureButton().addActionListener(this);
        theIslandPanel.getViewCreatureButton().addActionListener(this);
        theIslandPanel.getSubmitTextFieldButton().addActionListener(this);
        theIslandPanel.getNextPageButton().addActionListener(this);
        theIslandPanel.getPrevPageButton().addActionListener(this);
        
        theCenterPanel.getReturnButton().addActionListener(this);
        theCenterPanel.getAddCreatureButton().addActionListener(this);
        theCenterPanel.getViewCreatureButton().addActionListener(this);
        theCenterPanel.getSubmitTextFieldButton().addActionListener(this);
        theCenterPanel.getNextPageButton().addActionListener(this);
        theCenterPanel.getPrevPageButton().addActionListener(this);
        
        MainMenuPanel.getTheIslandMenuButton().addActionListener(this);
        MainMenuPanel.getTheCenterMenuButton().addActionListener(this);
        
        
        //Adds UI Panel to the GameFrame
        add(userInterfacePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationByPlatform(true);
        setVisible(true);
        //Fixed Flickering and CPU issue (for initial open)
        this.requestFocus();

    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Variables to detect Source Button and it's parent container
        JButton source = (JButton) e.getSource();
        JPanel parent = (JPanel) source.getParent();
        
        //Declaring the results of each button being pressed

        //Return Button uses isReturnButton Method to make all return buttons 
        //take it to the main menu panel
        if (e.getActionCommand().equals("Return")) {
            
            //Used to make extra fields disappear upon return but maintain
            //Buttons/Labels for returning to that panel later
            ((WorldPanel) parent).removeAll();
            ((WorldPanel) parent).drawButtons(getGraphics());
            ((WorldPanel) parent).drawLabel(getGraphics());
            ((WorldPanel) parent).setCurrentPage(1);
            ((WorldPanel) parent).getPageIndicator().setText("Page #1");

            goToPanel("Main Menu");
        }
        
        
        //Main Menu Buttons to move to each worldPanel
        if (parent == mainMenuPanel) {
            goToPanel(source.getText());
            
        }
        
        
        //Sets action for Add Creature Button for the Worlds
        if (e.getActionCommand().equals("Add")) {
            //Need to make a way to remove View info when switching to add option.
            ((WorldPanel) parent).removeAll();
            ((WorldPanel) parent).drawCreateCreatureTextFields();
            ((WorldPanel) parent).repaint();

            
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
            
        }
        
        if (e.getActionCommand().startsWith("RIP")) {
            ((WorldPanel) parent).setBackground(Color.MAGENTA);
            ((WorldPanel) parent).killCreature(source); 
            ((WorldPanel) parent).removeAll();
            ((WorldPanel) parent).viewCreatures();
            saveData();
        }
        
        if (e.getActionCommand().equals("Next Page")) {
            ((WorldPanel) parent).removeAll();
            ((WorldPanel) parent).incrementCurrentPage();
            int cp = ((WorldPanel) parent).getCurrentPage();
            ((WorldPanel) parent).getPageIndicator().setText("Page #"+cp);
            ((WorldPanel) parent).viewCreatures();
        }
        
        if (e.getActionCommand().equals("Prev Page")) {
            ((WorldPanel) parent).removeAll();
            ((WorldPanel) parent).setCurrentPage(((WorldPanel) parent).getCurrentPage()-1);
            int cp = ((WorldPanel) parent).getCurrentPage();
            ((WorldPanel) parent).getPageIndicator().setText("Page #"+cp);
            ((WorldPanel) parent).viewCreatures();

        }
    }

    public void goToPanel(String selectedPanel){
        cardLayout.show(userInterfacePanel, selectedPanel);
        //Fixed Flickering and CPU Issue
        userInterfacePanel.grabFocus();
    }

    public void saveData(){
        SaveFileManager.writeSaveDate(theIslandPanel);
        SaveFileManager.writeSaveDate(theCenterPanel);
    }
}
