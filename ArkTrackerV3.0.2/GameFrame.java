import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GameFrame extends JFrame implements ActionListener {

    CardLayout cardLayout;
    UserInterfacePanel userInterfacePanel;
    MainMenuPanel mainMenuPanel;
    WorldPanel worldPanel;
    WorldPanel theIslandPanel;


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
        theIslandPanel = new WorldPanel();

        //adds all sub-panels to UIPanel, which can be switched between
        userInterfacePanel.add(mainMenuPanel, "Main Menu");
        userInterfacePanel.add(worldPanel, "World Panel");
        userInterfacePanel.add(theIslandPanel, "The Island");
    
        //Call in Buttons and add their actionListeners to the GameFrame
        MainMenuPanel.getTheIslandMenuButton().addActionListener(this);
        WorldPanel.getReturnButton().addActionListener(this);
        
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
        if (e.getSource()==WorldPanel.getReturnButton()) {
            cardLayout.show(userInterfacePanel, "Main Menu");
        }
        if (e.getSource()==MainMenuPanel.getTheIslandMenuButton()) {
            goToPanel(theIslandPanel);
            //gameOn();
        }
    }
    
    public void gameOn(){
        cardLayout.show(userInterfacePanel, "World Panel");
    }

    public void goToPanel(JPanel panel){
        cardLayout.show(userInterfacePanel, ((WorldPanel) panel).getWorldName());

    }

}
