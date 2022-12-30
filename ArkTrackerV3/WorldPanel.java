import java.awt.*;

import javax.swing.*;

public class WorldPanel extends JPanel {

    private JLabel label;
    private static JButton returnButton;

    
    public WorldPanel() {
        super();
        setBackground(Color.RED);
        label = new JLabel("World Panel");
        returnButton = new JButton("Return");
        paint(getGraphics());
        // setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
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



}
