import java.awt.*;

import javax.swing.*;

public class MainMenuPanel extends JPanel{
    
    public MainMenuPanel() {
        super();
        setBackground(Color.BLUE);
        add(new JLabel("Main Menu"));
        //setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    }

}