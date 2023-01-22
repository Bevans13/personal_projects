import javax.swing.*;
import java.awt.*;

/**
 * AppWindow
 */
public class AppWindow extends JFrame{

private static CardLayout cardLayout = new CardLayout();
private static UserInterface userInterface = new UserInterface(cardLayout);
private static int frameWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
private static int frameHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public AppWindow(String title){
        super(title);
        
        // userInterface = new UserInterface(cardLayout);

        // Add UI to Frame and set Frame Functions
        add(userInterface);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationByPlatform(true);
        setVisible(true);
        requestFocus();

    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppWindow appWindow = new AppWindow("Ark Tracker V3.1");
            }
        });

    }

    //Allows for getting the UI from other classes (typically 
    //for setting the action listeners to UI)
    public static UserInterface getUserInterface() {
        return userInterface;
    } public static int getFrameWidth() {
        return frameWidth;
    } public static int getFrameHeight() {
        return frameHeight;
    } public static CardLayout getCardLayout() {
        return cardLayout;
    }
    
}