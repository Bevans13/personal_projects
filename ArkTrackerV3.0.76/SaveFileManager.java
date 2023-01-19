import java.io.*;
import java.util.ArrayList;

import Creatures.*;

public class SaveFileManager {

    private static Creature loadedCreature = null;
    private static ArrayList<Creature> loadTames;

    public SaveFileManager(){
      // Default constructor, no need to 
      // define as just functions as a save file reader
    }        
    
    public static void readSaveData(WorldPanel loadingWorld){
        try {
            
            FileInputStream fileIn = new FileInputStream(loadingWorld.getSaveFilePath());
            ObjectInputStream in = new ObjectInputStream(fileIn);
            loadTames = (ArrayList<Creature>) in.readObject();
            loadingWorld.setTames(loadTames);
            in.close();
            fileIn.close();
            System.out.println(loadingWorld.getWorldName()+" read");  
         } catch (IOException i) {
            i.printStackTrace();
            return;
         } catch (ClassNotFoundException cnf) {
            System.out.println("Creature class not found");
            cnf.printStackTrace();
            return;
         }
    }
    
    public static void writeSaveDate(WorldPanel savingWorld){
        try {
            FileOutputStream fileOut = new FileOutputStream(savingWorld.getSaveFilePath());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(savingWorld.getTames());
            out.close();
            fileOut.close();
            System.out.println("Serialized data for "+savingWorld.getWorldName()+" was saved");
         } catch (IOException i) {
            i.printStackTrace();
         } 
    }

    public static void showData(Creature c){
        c.display();
    }

    public static Creature getLoadedCreature() {
        return loadedCreature;
    }

    public static ArrayList<Creature> getLoadTames() {
        return loadTames;
    }
}