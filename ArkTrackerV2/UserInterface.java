import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserInterface extends JPanel implements ActionListener {

private static final int UI_WIDTH = 1200;
private static final int UI_HEIGHT = 700;
private static Color BACKGROUND_COLOR = Color.cyan;

private static MainMenuSelectionButtons theIslandSelectionJButton = new MainMenuSelectionButtons("The Island");
private static MainMenuSelectionButtons theCenterSelectionJButton = new MainMenuSelectionButtons("The Center");
private static MainMenuSelectionButtons scorchedEarthSelectionJButton = new MainMenuSelectionButtons("Scorched Earth");
private static MainMenuSelectionButtons ragnarokSelectionJButton = new MainMenuSelectionButtons("Ragnarok");
private static MainMenuSelectionButtons aberrationSelectionJButton = new MainMenuSelectionButtons("Abberation");
private static MainMenuSelectionButtons extinctionSelectionJButton = new MainMenuSelectionButtons("Extinction");
private static MainMenuSelectionButtons valgueroSelectionJButton = new MainMenuSelectionButtons("Valguero");
private static MainMenuSelectionButtons genesisPartOneSelectionJButton = new MainMenuSelectionButtons("Genesis: Part 1");
private static MainMenuSelectionButtons genesisPartTwoSelectionJButton = new MainMenuSelectionButtons("Genesis: Part 2");
private static MainMenuSelectionButtons crystalIslesSelectionJButton = new MainMenuSelectionButtons("Crystal Isles");
private static MainMenuSelectionButtons lostIslandSelectionJButton = new MainMenuSelectionButtons("Lost Island");
private static MainMenuSelectionButtons fjordurSelectionJButton = new MainMenuSelectionButtons("Fjordur");

static {
    theIslandSelectionJButton.setBounds(30, 30, 100, 100);
    //theCenterSelectionJButton.set
    
}

public UserInterface(){
    setPreferredSize(new Dimension(UI_WIDTH,UI_HEIGHT));
    setBackground(BACKGROUND_COLOR);

}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawButtons(g);
}

private void drawButtons(Graphics g) {
    this.add(theIslandSelectionJButton);
    theIslandSelectionJButton.addActionListener(this);
}

@Override
public void actionPerformed(ActionEvent e) {
    //Just some test actions to ensure the Action is occurring
    theIslandSelectionJButton.setBackground(Color.ORANGE);
    setBackground(Color.ORANGE);
    repaint();
}

public static int getUI_HEIGHT() {
    return UI_HEIGHT;
}

public static int getUI_WIDTH() {
    return UI_WIDTH;
}

}