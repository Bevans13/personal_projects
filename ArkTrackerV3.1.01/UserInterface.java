import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class UserInterface extends JPanel implements ActionListener {
    
    private static CardLayout cardLayout = new CardLayout();
    private MainMenu mainMenu = new MainMenu();
    private World theIsland = new World("The Island", "THE_ISLAND_DATA.ser");
    private World theCenter = new World("The Center", "THE_CENTER_DATA.ser");
    
   
   
    public UserInterface() {
        super(cardLayout);

        //Adding each World to the UserInterface
        this.add(mainMenu, "Main Menu");
        this.add(theIsland, theIsland.getWorldName());
        this.add(theCenter, theCenter.getWorldName());
        
    }


    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
