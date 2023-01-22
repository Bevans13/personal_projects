import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class UserInterface extends JPanel implements ActionListener {
    
    

    //Declare all Panels that will be accessible/used by the UI
    private static MainMenu mainMenu = new MainMenu();
    private World theIsland = new World("The Island", "THE_ISLAND_DATA.ser");
    private World theCenter = new World("The Center", "THE_CENTER_DATA.ser");
    private World[] allWorlds = new World[] {
        theIsland, theCenter
    };
    
   
   
    public UserInterface(LayoutManager layout) {
        super(layout);
        
        //Adding each World to the UserInterface
        add(mainMenu, "Main Menu");
        add(theIsland, theIsland.getWorldName());
        add(theCenter, theCenter.getWorldName());
        
        // mainMenu = new MainMenu();
    }


    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public World[] getAllWorlds() {
        return allWorlds;
    }public World getTheIsland() {
        return theIsland;
    }public World getTheCenter() {
        return theCenter;
    }public MainMenu getMainMenu() {
        return mainMenu;
    }
    

}
