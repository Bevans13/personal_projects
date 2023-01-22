import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

/**
 * MainMenu
 */
public class MainMenu extends JPanel{

    private JLabel mainMenuLabel = new JLabel("Main Menu");

    public MainMenu() {
        super();
        
    }
    
    //Runs automatically with constructor to set Panel Size
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLabel(g);
        drawButtons(g);
    }
    
    public void drawLabel(Graphics g) {
        mainMenuLabel.setBounds(AppWindow.getFrameWidth()/2-(80/2), 15, 80, 25);
        add(mainMenuLabel);

    }

    public void drawButtons(Graphics g) {
        
        World[] allWorlds = AppWindow.getUserInterface().getAllWorlds();
        for (int i = 0; i < allWorlds.length; i++) {
            // allWorlds[i].setBounds(((i*4)+1)*AppWindow.getFrameWidth()/16, AppWindow.getFrameWidth()/9, World.getWorldButtonWidth(), World.getWorldButtonHeight());
            allWorlds[i].setBounds(200, 200, 100, 100);
            add(allWorlds[i].getWorldButton());
        }
    }

}