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
                GameFrame gameFrame = new GameFrame();
            }
        });



    }

    // Creates the JFrame that is the display Window
    GameFrame() {
        super();

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
        userInterfacePanel.add(theIslandPanel, "The Island");
        userInterfacePanel.add(theCenterPanel, theCenterPanel.getWorldName());
    
        //Call in Buttons and add their actionListeners to the GameFrame
        theIslandPanel.getReturnButton().addActionListener(this);
        theCenterPanel.getReturnButton().addActionListener(this);
        theIslandPanel.getAddCreatureButton().addActionListener(this);
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
        //Declaring the results of each button being pressed

        //Return Button uses isReturnButton Method to make all return buttons 
        //take it to the main menu panel
        if (isReturnButton(e)) {
            cardLayout.show(userInterfacePanel, "Main Menu");
            saveData();
        }

        //Main Menu Buttons to move to each worldPanel
        if (e.getSource() == MainMenuPanel.getTheIslandMenuButton()) {
            goToPanel(theIslandPanel);
            //gameOn();
        }
        if (e.getSource() == MainMenuPanel.getTheCenterMenuButton()) {
            goToPanel(theCenterPanel);
        } 

        //Sets action for Add Creature Button for the Worlds
        if (e.getSource() == theIslandPanel.getAddCreatureButton()) {
            theIslandPanel.setBackground(Color.BLACK);
        }

    }
    
    //testing Method can remove later
    public void gameOn(){
        cardLayout.show(userInterfacePanel, "World Panel");
    }

    public void goToPanel(WorldPanel panel){
        SaveFileManager.readSaveData(panel);
        panel.repaint();
        cardLayout.show(userInterfacePanel, panel.getWorldName());

    }

    public boolean isReturnButton(ActionEvent e){

        return e.getSource() == theIslandPanel.getReturnButton()
        || e.getSource()==theCenterPanel.getReturnButton();
    }

    public void saveData(){
        SaveFileManager.writeSaveDate(theIslandPanel);
        SaveFileManager.writeSaveDate(theCenterPanel);
    }

}
