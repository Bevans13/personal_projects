import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import Creatures.*;

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
        
        // Determining parent/source of action for use in methods below
        JButton source = (JButton) e.getSource();
        JPanel parent = (JPanel) source.getParent();


        //Function to navigate to Worlds from the Main Menu
        if (((JButton) e.getSource()).getParent() == mainMenu) {
            mainMenu.setBackground(Color.ORANGE); //Testing
            String toWorld = ((JButton)e.getSource()).getText();
            goToPanel(toWorld);
            grabFocus();
        }

        //Function used from World Menus to return to Main Menu
        if (e.getActionCommand().equals("Return")) {
            //Removes fields on World Panel and resets when returning to Main Menu
            ((World) parent).removeAll();
            ((World) parent).drawButtons(getGraphics());
            ((World) parent).drawLabel(getGraphics());
            //Navigates to Main Menu
            goToPanel("Main Menu");
            ((JButton) e.getSource()).getParent().setBackground(Color.BLACK); //Testing
        }

        //function used by the add Button on the World Menus
        //Used to call the fields needed to create a new creature
        if ((e.getActionCommand().equals("Add"))) {
            ((JButton) e.getSource()).getParent().setBackground(Color.PINK); //Testing
            Creature.drawCreateCreatureTextFields(parent);

        }

        //Used to to view tames for the world one is currently in
        if (e.getActionCommand().equals("View")) {
            ((JButton) e.getSource()).getParent().setBackground(Color.yellow); //Testing

        }
    }


    public void goToPanel(String selectedPanel){
        AppWindow.getCardLayout().show(this, selectedPanel);
        //Fixed Flickering and CPU Issue
        grabFocus();
    }


    //Getters & Setters
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
