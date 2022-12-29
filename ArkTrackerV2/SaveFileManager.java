import java.io.*;

import Creatures.*;

public class SaveFileManager {

    private static Creature LoadedCreature = null;

    public SaveFileManager(){

    }        
    
    public static void readSaveData(World loadingWorld){
        try {
            
            FileInputStream fileIn = new FileInputStream(loadingWorld.getFILENAME());
            ObjectInputStream in = new ObjectInputStream(fileIn);
            LoadedCreature = (Creature) in.readObject();
            in.close();
            fileIn.close();
         } catch (IOException i) {
            i.printStackTrace();
            return;
         } catch (ClassNotFoundException cnf) {
            System.out.println("Employee class not found");
            cnf.printStackTrace();
            return;
         }
    }
    
    public static void writeSaveDate(Object o){
        try {
            FileOutputStream fileOut = new FileOutputStream("TestSave.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(o);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/Creatures.ser");
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
}