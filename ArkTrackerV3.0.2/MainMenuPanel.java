import java.awt.*;

import javax.swing.*;

public class MainMenuPanel extends JPanel{
    
    private static JLabel label;
    private static JButton theIslandMenuButton;

    private static int MainMenuPanelWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static int MainMenuPanelHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private static int buttonWidth = MainMenuPanelWidth/8;
    private static int buttonHeight = MainMenuPanelHeight/12;

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
        //theIslandMenuButton.setBounds(500,500,200,200);
        theIslandMenuButton.setBounds(MainMenuPanelWidth/16, MainMenuPanelHeight/9, buttonWidth, buttonHeight);
        add(theIslandMenuButton);
    }

    public static JButton getTheIslandMenuButton() {
        return theIslandMenuButton;
    }

}