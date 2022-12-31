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
        theIslandPanel = new WorldPanel("The Island");
        theCenterPanel = new WorldPanel("The Center");

        //adds all sub-panels to UIPanel, which can be switched between
        userInterfacePanel.add(mainMenuPanel, "Main Menu");
        userInterfacePanel.add(worldPanel, "World Panel");
        userInterfacePanel.add(theIslandPanel, "The Island");
        userInterfacePanel.add(theCenterPanel, theCenterPanel.getWorldName());
    
        //Call in Buttons and add their actionListeners to the GameFrame
        theIslandPanel.getReturnButton().addActionListener(this);
        theCenterPanel.getReturnButton().addActionListener(this);
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
        if ((e.getSource() == theIslandPanel.getReturnButton())||(e.getSource()==theCenterPanel.getReturnButton())) {
            cardLayout.show(userInterfacePanel, "Main Menu");
        }
        if (e.getSource() == MainMenuPanel.getTheIslandMenuButton()) {
            goToPanel(theIslandPanel);
            //gameOn();
        }
        if (e.getSource() == MainMenuPanel.getTheCenterMenuButton()) {
            goToPanel(theCenterPanel);
        } 
    }
    
    //testing Method can remove later
    public void gameOn(){
        cardLayout.show(userInterfacePanel, "World Panel");
    }

    public void goToPanel(JPanel panel){
        cardLayout.show(userInterfacePanel, ((WorldPanel) panel).getWorldName());

    }

}
