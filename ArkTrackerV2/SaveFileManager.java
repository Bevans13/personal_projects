import java.io.*;

public class SaveFileManager {

    private static BufferedReader saveFileBufferedReader;
    private static BufferedWriter saveFileBufferedWriter;



    public SaveFileManager(){

    }
    
    private static void readSaveData(){
        String record = "none";
        String[] fields;
        try {
            saveFileBufferedReader = new BufferedReader(new FileReader("record"));
        } catch (IOException ioe) {
            System.out.println("IO Exception in readSaveData() method");
        }
    }



}