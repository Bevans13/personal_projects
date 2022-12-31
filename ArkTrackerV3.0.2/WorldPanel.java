import java.awt.*;

import javax.swing.*;

public class WorldPanel extends JPanel {

    private JLabel label;
    private static JButton returnButton = new JButton("Return");
    private String worldName;
    
    //Default Constructor (mainly to test functionality of initial program)
    public WorldPanel() {
        super();
        setBackground(Color.RED);
        label = new JLabel("World Panel");
        worldName = "The Island";
        paint(getGraphics());

    }
    
    //Contstructor to build each individual world
    public WorldPanel(String worldName) {
        super();
        this.worldName = worldName;
        setBackground(Color.ORANGE);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawLabel(g);
        drawButtons(g);
    }
    
    public void drawLabel(Graphics g) {
        label.setBounds(100, 100, 300, 600);
        add(label);
        
    }
    
    public void drawButtons(Graphics g) {
        returnButton.setBounds(500, 500, 250, 250);
        add(returnButton);
        
    }
    
    public JLabel getLabel() {
        return label;
    }
    
    public static JButton getReturnButton() {
        return returnButton;
    }

    public String getWorldName() {
        return worldName;
    }



}
