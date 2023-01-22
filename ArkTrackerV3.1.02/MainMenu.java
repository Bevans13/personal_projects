import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

/**
 * MainMenu
 */
public class MainMenu extends JPanel{

    private JLabel mainMenuLabel = new JLabel("Main Menu");
    private static World[] allWorlds;

    public MainMenu() {
        super();
        paint(getGraphics());
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
        int worldButtonWidth = AppWindow.getFrameWidth()/8;
        int worldButtonHeight = AppWindow.getFrameHeight()/12;
        allWorlds = AppWindow.getUserInterface().getAllWorlds();

        //Loop to iterate each world and give it a button and bounds for that button
        for (int i = 0; i < allWorlds.length; i++) {
            World thisWorld = allWorlds[i];
            thisWorld.getWorldButton().setBounds(((i*4)+1)*AppWindow.getFrameWidth()/16, AppWindow.getFrameHeight()/9, worldButtonWidth, worldButtonHeight);
            add(allWorlds[i].getWorldButton());
            thisWorld.getWorldButton().addActionListener(AppWindow.getUserInterface());
        }

    }

}