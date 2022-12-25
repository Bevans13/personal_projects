import javax.swing.*;

import Creatures.PlayerDisplayTable;

import java.awt.*;
import java.awt.event.*;

public class UserInterface extends JPanel implements ActionListener {
    
    private final int UI_WIDTH = 1200;
    private final int UI_HEIGHT = 690;
    private static final Color BACKGROUND_COLOR = new Color(125,125,125);
    
    public UserInterface() {
        setPreferredSize(new Dimension(UI_WIDTH,UI_HEIGHT));
        setBackground(BACKGROUND_COLOR);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawButtons(g);
    }
 
    private void drawButtons(Graphics g) {
        FallOutEquestria.getCombatCalculatorButton().setBounds((UI_WIDTH/2)-(3*UI_WIDTH/8),
        (UI_HEIGHT/2)-(3*UI_HEIGHT/8),(UI_WIDTH/4),(UI_HEIGHT/4));
        FallOutEquestria.getPlayerEditorButton().setBounds((UI_WIDTH)-(3*UI_WIDTH/8),
        (UI_HEIGHT/2)-(3*UI_HEIGHT/8),(UI_WIDTH/4),(UI_HEIGHT/4));
        this.add(FallOutEquestria.getCombatCalculatorButton());
        this.add(FallOutEquestria.getPlayerEditorButton());
        FallOutEquestria.getCombatCalculatorButton().addActionListener(this);
        FallOutEquestria.getPlayerEditorButton().addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==FallOutEquestria.getCombatCalculatorButton() && FallOutEquestria.getCombatCalculatorButton().isEnabled()){
            FallOutEquestria.getCombatCalculator().createCombatCalculatorMenus();
            FallOutEquestria.changeToNewPanel(FallOutEquestria.getCombatCalculator());
            FallOutEquestria.getCombatCalculatorButton().setEnabled(false);
        }
        if (e.getSource()==FallOutEquestria.getPlayerEditorButton() && FallOutEquestria.getPlayerEditorButton().isEnabled()) {
            FallOutEquestria.changeToNewPanel(FallOutEquestria.getPlayerEditor());
            FallOutEquestria.getPlayerEditorButton().setEnabled(false);
        }
    }

    public int getUI_WIDTH() {
        return UI_WIDTH;
    }
    public int getUI_HEIGHT() {
        return UI_HEIGHT;
    }
}
