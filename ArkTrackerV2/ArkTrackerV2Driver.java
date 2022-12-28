import javax.swing.*;

public class ArkTrackerV2Driver {
    
    private static JFrame arkTrackerFrame = new JFrame("Ark Tracker V2");
   
    private static UserInterface mainMenu = new UserInterface();
    
    public static void main(String[] args) {
        SaveFileManager saveFileManager = new SaveFileManager();
        initWindow(mainMenu);
        System.out.println("Testing Main Method");
        
    } 
    
    public static void initWindow(JPanel panel) {
        arkTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        arkTrackerFrame.add(panel);
        arkTrackerFrame.paintComponents(null);
        arkTrackerFrame.setResizable(true);
        arkTrackerFrame.pack();
        arkTrackerFrame.setLocationRelativeTo(null);
        arkTrackerFrame.setVisible(true);
        
    }
    
    public static void clearWindow(){
        arkTrackerFrame.removeAll();
    }

    public static JFrame getArkTrackerFrame() {
        return arkTrackerFrame;
    }
}
