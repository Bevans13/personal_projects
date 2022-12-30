import java.awt.*;

import javax.swing.*;

public class MainMenuPanel extends JPanel{
    
    private static JLabel label;
    private static JButton theIslandMenuButton;

    private static int MainMenuPanelWidth;
    private static int MainMenuPanelHeight;

    public MainMenuPanel() {
        super();
        setBackground(Color.BLUE);
        label = new JLabel("Main Menu");
        theIslandMenuButton = new JButton("The Island");
        paint(getGraphics());

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
        add(label);
    }

    public void drawButtons(Graphics g) {
        theIslandMenuButton.setBounds(500,500,200,200);
        add(theIslandMenuButton);
    }

    public static JButton getTheIslandMenuButton() {
        return theIslandMenuButton;
    }

}