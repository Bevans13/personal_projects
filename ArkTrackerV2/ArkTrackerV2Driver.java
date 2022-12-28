import java.nio.file.*;
import javax.swing.*;
import Creatures.*;

public class ArkTrackerV2Driver {
    
    private static JFrame arkTrackerFrame = new JFrame("Ark Tracker V2");
   
    private static UserInterface mainMenu = new UserInterface();
    
    public static void main(String[] args) {
        //temp  initWindow(mainMenu);
        System.out.println("Testing Main Method");
        
        Creature testCreature1 = new Creature();
        SaveFileManager.writeSaveDate(testCreature1);
        
         
        SaveFileManager.readSaveData();
        SaveFileManager.showData(SaveFileManager.getLoadedCreature());
        Path path = Paths.get("TestSave.ser");
        System.out.println(path.toAbsolutePath().toString());
        path.getParent();
        
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
