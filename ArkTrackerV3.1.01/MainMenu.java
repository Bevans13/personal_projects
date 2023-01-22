import javax.swing.JPanel;
import java.awt.*;

/**
 * MainMenu
 */
public class MainMenu extends JPanel{

    public MainMenu() {
        super();
    }

    //Runs automatically with constructor to set Panel Size
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    }

}