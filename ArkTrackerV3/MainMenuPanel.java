import java.awt.*;

import javax.swing.*;

public class MainMenuPanel extends JPanel{
    
    private JLabel label;
    private static JButton returnButton;

    public MainMenuPanel() {
        super();
        setBackground(Color.BLUE);
        JLabel label = new JLabel("Main Menu");
        add(label);
        //setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    }

}