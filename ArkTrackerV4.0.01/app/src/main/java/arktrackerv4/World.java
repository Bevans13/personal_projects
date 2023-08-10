package arktrackerv4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
//This class is designed to be the World in Ark and have a panel for each individual world. 
public class World extends JPanel {
    //Final class attributes
    private static final int WORLD_PANEL_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int WORLD_PANEL_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static final Color BACKGROUND_COLOR = Color.BLUE;

    //Default Constructor
    public World(){
        super();

        setBackground(BACKGROUND_COLOR);
    }

    //Sets the default size of the Panel
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(WORLD_PANEL_WIDTH, WORLD_PANEL_HEIGHT);
    }

}
