import java.awt.*;

import javax.swing.JPanel;

public class MainMenuPanel extends JPanel{
    
    public MainMenuPanel() {

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    }

}
