package ArkTrackerV2;

import javax.swing.*;

public class ArkTrackerV2Driver {
    
    private static JFrame arkTrackerFrame = new JFrame("Ark Tracker V2");
    //private static UserInterface userInterface = new UserInterface();

    
    public static void main(String[] args) {
       initWindow(userInterface);
        System.out.println("Testing Main Method");
        
    } 
    
    public static void initWindow(JPanel panel) {
        arkTrackerFrame.removeAll();
        arkTrackerFrame.add(panel);
        arkTrackerFrame.pack();

    }
    
}
