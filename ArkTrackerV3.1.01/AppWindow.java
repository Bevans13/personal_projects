import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * AppWindow
 */
public class AppWindow extends JFrame{

private static UserInterface userInterface = new UserInterface();

    public AppWindow(String title){
        super(title);

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
    }
    
}