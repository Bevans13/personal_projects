import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class UserInterface extends JPanel implements ActionListener {

// need to set to or find a method to get Sreen Size Height/Width to an Int type
private static Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
private static final int UI_WIDTH = (int) screensize.getWidth();
private int buttonWidth = UI_WIDTH/8;
private static final int UI_HEIGHT = (int) screensize.getHeight();
private int buttonHeight = UI_HEIGHT/12;
private static Color BACKGROUND_COLOR = Color.cyan;

private static JButton theIslandSelectionJButton= new JButton("The Island");
private static JButton theCenterSelectionJButton = new JButton("The Center");
private static JButton scorchedEarthSelectionJButton = new JButton("Scorched Earth");
private static JButton ragnarokSelectionJButton = new JButton("Ragnarok");
private static JButton aberrationSelectionJButton = new JButton("Abberation");
private static JButton extinctionSelectionJButton = new JButton("Extinction");
private static JButton valgueroSelectionJButton = new JButton("Valguero");
private static JButton genesisPartOneSelectionJButton = new JButton("Genesis: Part 1");
private static JButton genesisPartTwoSelectionJButton = new JButton("Genesis: Part 2");
private static JButton crystalIslesSelectionJButton = new JButton("Crystal Isles");
private static JButton lostIslandSelectionJButton = new JButton("Lost Island");
private static JButton fjordurSelectionJButton = new JButton("Fjordur");

public UserInterface(){
    setPreferredSize(screensize);
    setBackground(BACKGROUND_COLOR);

    //Start timer that calls actionPerformed(0) - Unneeded but maybe useful later
    // new Timer(45,this).start();
    
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawButtons(g);
}

private void drawButtons(Graphics g) {
    // Section defining bounds and adding Buttons/ActionListeners
    theIslandSelectionJButton.setBounds(UI_WIDTH/16, UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(theIslandSelectionJButton);
    theIslandSelectionJButton.addActionListener(this);
    theCenterSelectionJButton.setBounds(5*UI_WIDTH/16, UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(theCenterSelectionJButton);
    theCenterSelectionJButton.addActionListener(this);
    scorchedEarthSelectionJButton.setBounds(9*UI_WIDTH/16, UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(scorchedEarthSelectionJButton);
    scorchedEarthSelectionJButton.addActionListener(this);
    ragnarokSelectionJButton.setBounds(13*UI_WIDTH/16, UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(ragnarokSelectionJButton);
    ragnarokSelectionJButton.addActionListener(this);
    aberrationSelectionJButton.setBounds(UI_WIDTH/16, 4*UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(aberrationSelectionJButton);
    aberrationSelectionJButton.addActionListener(this);
    extinctionSelectionJButton.setBounds(5*UI_WIDTH/16, 4*UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(extinctionSelectionJButton);
    extinctionSelectionJButton.addActionListener(this);
    valgueroSelectionJButton.setBounds(9*UI_WIDTH/16, 4*UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(valgueroSelectionJButton);
    valgueroSelectionJButton.addActionListener(this);
    genesisPartOneSelectionJButton.setBounds(13*UI_WIDTH/16, 4*UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(genesisPartOneSelectionJButton);
    genesisPartOneSelectionJButton.addActionListener(this);
    genesisPartTwoSelectionJButton.setBounds(UI_WIDTH/16, 7*UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(genesisPartTwoSelectionJButton);
    genesisPartTwoSelectionJButton.addActionListener(this);
    crystalIslesSelectionJButton.setBounds(5*UI_WIDTH/16, 7*UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(crystalIslesSelectionJButton);
    crystalIslesSelectionJButton.addActionListener(this);
    lostIslandSelectionJButton.setBounds(9*UI_WIDTH/16, 7*UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(lostIslandSelectionJButton);
    lostIslandSelectionJButton.addActionListener(this);
    fjordurSelectionJButton.setBounds(13*UI_WIDTH/16, 7*UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(fjordurSelectionJButton);
    fjordurSelectionJButton.addActionListener(this);
    
}

@Override
public void actionPerformed(ActionEvent e) {
    //Just some test actions to ensure the Action is occurring
    if (e.getSource()==theIslandSelectionJButton) {
        setBackground(Color.ORANGE);
        
    }
    repaint();
}

public static int getUI_HEIGHT() {
    return UI_HEIGHT;
}

public static int getUI_WIDTH() {
    return UI_WIDTH;
}

}