import java.io.*;
import java.util.ArrayList;

import Creatures.*;

public class SaveFileManager {

    private static Creature LoadedCreature = null;
    private static ArrayList<Creature> loadTames;

    public SaveFileManager(){

    }        
    
    public static void readSaveData(World loadingWorld){
        try {
            
            FileInputStream fileIn = new FileInputStream(loadingWorld.getFILENAME());
            ObjectInputStream in = new ObjectInputStream(fileIn);
            //unneeded?  LoadedCreature = (Creature) in.readObject();
            loadTames = (ArrayList<Creature>) in.readObject();
            loadingWorld.setTames(loadTames);
            in.close();
            fileIn.close();
         } catch (IOException i) {
            i.printStackTrace();
            return;
         } catch (ClassNotFoundException cnf) {
            System.out.println("Creature class not found");
            cnf.printStackTrace();
            return;
         }
    }
    
    public static void writeSaveDate(World savingWorld){
        try {
            FileOutputStream fileOut = new FileOutputStream(savingWorld.getFILENAME());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(savingWorld.getTames());
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved");
         } catch (IOException i) {
            i.printStackTrace();
         } 
    }

    public static void showData(Creature c){
        c.display();
    }

    public static Creature getLoadedCreature() {
        return LoadedCreature;
    }

    public static ArrayList<Creature> getLoadTames() {
        return loadTames;
    }
}