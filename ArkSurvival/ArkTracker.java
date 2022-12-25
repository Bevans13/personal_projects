import javax.swing.*;

public class ArkTracker extends JFrame{
    
    private static JFrame window = new JFrame("Ark Tracker");
    private static JFrame selectedWorld = new JFrame();

    // defines method to open window for application
    private static void initWindow() {
        //Creates a Window Frame with Title given 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.setSize(1000, 800);

        //Create a JPanel and add it to the JFrame
        UserInterface ui = new UserInterface();
        window.add(ui);

        //set attributes of JFrame

        window.setResizable(false);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        selectedWorld.setResizable(false);
        selectedWorld.pack();
        selectedWorld.setLocationRelativeTo(null);

    }    

    public static void main(String[] args) {
        initWindow();
    }

    public static JFrame getWindow() {
        return window;
    }
    public static void setWindow(JFrame window) {
        ArkTracker.window = window;
    }
    public static JFrame getSelectedWorld() {
        return selectedWorld;
    }
    public static void setSelectedWorld(JFrame selectedWorld) {
        ArkTracker.selectedWorld = selectedWorld;
    }
}
