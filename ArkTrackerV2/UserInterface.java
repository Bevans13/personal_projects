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

public UserInterface(){
    super();
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
    ArkTrackerV2Driver.theIslandSelectionJButton.setBounds(UI_WIDTH/16, UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(ArkTrackerV2Driver.theIslandSelectionJButton);
    ArkTrackerV2Driver.theIslandSelectionJButton.addActionListener(this);
    ArkTrackerV2Driver.theCenterSelectionJButton.setBounds(5*UI_WIDTH/16, UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(ArkTrackerV2Driver.theCenterSelectionJButton);
    ArkTrackerV2Driver.theCenterSelectionJButton.addActionListener(this);
    ArkTrackerV2Driver.scorchedEarthSelectionJButton.setBounds(9*UI_WIDTH/16, UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(ArkTrackerV2Driver.scorchedEarthSelectionJButton);
    ArkTrackerV2Driver.scorchedEarthSelectionJButton.addActionListener(this);
    ArkTrackerV2Driver.ragnarokSelectionJButton.setBounds(13*UI_WIDTH/16, UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(ArkTrackerV2Driver.ragnarokSelectionJButton);
    ArkTrackerV2Driver.ragnarokSelectionJButton.addActionListener(this);
    ArkTrackerV2Driver.aberrationSelectionJButton.setBounds(UI_WIDTH/16, 4*UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(ArkTrackerV2Driver.aberrationSelectionJButton);
    ArkTrackerV2Driver.aberrationSelectionJButton.addActionListener(this);
    ArkTrackerV2Driver.extinctionSelectionJButton.setBounds(5*UI_WIDTH/16, 4*UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(ArkTrackerV2Driver.extinctionSelectionJButton);
    ArkTrackerV2Driver.extinctionSelectionJButton.addActionListener(this);
    ArkTrackerV2Driver.valgueroSelectionJButton.setBounds(9*UI_WIDTH/16, 4*UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(ArkTrackerV2Driver.valgueroSelectionJButton);
    ArkTrackerV2Driver.valgueroSelectionJButton.addActionListener(this);
    ArkTrackerV2Driver.genesisPartOneSelectionJButton.setBounds(13*UI_WIDTH/16, 4*UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(ArkTrackerV2Driver.genesisPartOneSelectionJButton);
    ArkTrackerV2Driver.genesisPartOneSelectionJButton.addActionListener(this);
    ArkTrackerV2Driver.genesisPartTwoSelectionJButton.setBounds(UI_WIDTH/16, 7*UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(ArkTrackerV2Driver.genesisPartTwoSelectionJButton);
    ArkTrackerV2Driver.genesisPartTwoSelectionJButton.addActionListener(this);
    ArkTrackerV2Driver.crystalIslesSelectionJButton.setBounds(5*UI_WIDTH/16, 7*UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(ArkTrackerV2Driver.crystalIslesSelectionJButton);
    ArkTrackerV2Driver.crystalIslesSelectionJButton.addActionListener(this);
    ArkTrackerV2Driver.lostIslandSelectionJButton.setBounds(9*UI_WIDTH/16, 7*UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(ArkTrackerV2Driver.lostIslandSelectionJButton);
    ArkTrackerV2Driver.lostIslandSelectionJButton.addActionListener(this);
    ArkTrackerV2Driver.fjordurSelectionJButton.setBounds(13*UI_WIDTH/16, 7*UI_HEIGHT/9, buttonWidth, buttonHeight);
    this.add(ArkTrackerV2Driver.fjordurSelectionJButton);
    ArkTrackerV2Driver.fjordurSelectionJButton.addActionListener(this);
    
}

@Override
public void actionPerformed(ActionEvent e) {
    //Just some test actions to ensure the Action is occurring
    if (e.getSource()==ArkTrackerV2Driver.theIslandSelectionJButton) {
        setBackground(Color.ORANGE);   
    }
    if (e.getSource()==ArkTrackerV2Driver.theCenterSelectionJButton) {
        setBackground(Color.darkGray);
        ArkTrackerV2Driver.changeToNewPanel(ArkTrackerV2Driver.getTheCenterWorld());
        //ArkTrackerV2Driver.getScreenPages().show(ArkTrackerV2Driver.getTheCenterWorld(), "The Center");
        //ArkTrackerV2Driver.changeToNewPanel(ArkTrackerV2Driver.getTheCenterWorld());
        //ArkTrackerV2Driver.theCenterSelectionJButton.setEnabled(false);
    }
    if (e.getSource()==ArkTrackerV2Driver.scorchedEarthSelectionJButton) {
        
    }
    if (e.getSource()==ArkTrackerV2Driver.ragnarokSelectionJButton) {
        
    }
    if (e.getSource()==ArkTrackerV2Driver.aberrationSelectionJButton) {
        
    }
    if (e.getSource()==ArkTrackerV2Driver.extinctionSelectionJButton) {
        
    }
    if (e.getSource()==ArkTrackerV2Driver.valgueroSelectionJButton) {
        
    }
    if (e.getSource()==ArkTrackerV2Driver.genesisPartOneSelectionJButton) {
        
    }
    if (e.getSource()==ArkTrackerV2Driver.genesisPartTwoSelectionJButton) {
        
    }
    if (e.getSource()==ArkTrackerV2Driver.crystalIslesSelectionJButton) {
        
    }
    if (e.getSource()==ArkTrackerV2Driver.lostIslandSelectionJButton) {
        
    }
    if (e.getSource()==ArkTrackerV2Driver.fjordurSelectionJButton) {
        
    }
       
}

public static int getUI_HEIGHT() {
    return UI_HEIGHT;
}

public static int getUI_WIDTH() {
    return UI_WIDTH;
}

public static Dimension getScreensize() {
    return screensize;
}

}