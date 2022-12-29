import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

import Creatures.Player;
import Creatures.Creature;

public class FallOutEquestria {

    private static JFrame window = new JFrame("Fallout Equestria: Odyssey");
    
    private static JButton combatCalculatorButton = new JButton("Combat Calc");
    private static JButton characterEditorButton = new JButton("Edit Character");
    private static JButton returnToHomeButton = new JButton("Back");
    private static JButton createCharacterButton = new JButton("Create Character");
    
    private static UserInterface userInterface = new UserInterface();
    private static CombatCalculator combatCalculator = new CombatCalculator();
    private static PlayerEditor playerEditor = new PlayerEditor();

    private static ArrayList<Player> playableCharacters = new ArrayList<>();
    private static ArrayList<Creature> NonPlayableCharacters = new ArrayList<>();

    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;


    
    public static void main(String[] args) {
        initWindow();
        readSaveData();
    }
    
    private static void readSaveData(){
        String record = "none";
        String[] fields;
        try {
            bufferedReader = new BufferedReader(new FileReader("Save Data/PLAYABLE_CHARACTERS.txt"));
            record = bufferedReader.readLine();
            
            while (record != null) {
                fields = splitDelimitedString(record,",");
                readCharacterData(fields);
                record = bufferedReader.readLine();
            }
            if (playableCharacters.size()>0) {
                System.out.println("Successfully loaded Saved Characters");
            };
            for (int i = 0; i < playableCharacters.size(); i++) {
                bufferedReader = new BufferedReader(new FileReader(playableCharacters.get(i).getInventoryFile()));
                record = bufferedReader.readLine();
                while (record != null) {
                    fields = splitDelimitedString(record, ",");
                    readInventoryData(fields);
                    record = bufferedReader.readLine();
                }
            }


            bufferedReader.close();
        } catch (IOException ioe) {
            System.out.println("IO Exception Error Reading Save File");
        }
    }

    public static void readCharacterData(String[] fields){
        Player player;
        String name     = fields[0];
        int strength    = Integer.valueOf(fields[1]);
        int perception  = Integer.valueOf(fields[2]);
        int endurance   = Integer.valueOf(fields[3]);
        int charisma    = Integer.valueOf(fields[4]);
        int intelligence= Integer.valueOf(fields[5]);
        int agility     = Integer.valueOf(fields[6]);
        int luck        = Integer.valueOf(fields[7]);
        int level       = Integer.valueOf(fields[8]);
        int health      = Integer.valueOf(fields[9]);
        int smallGuns   = Integer.valueOf(fields[10]);
        int bigGuns     = Integer.valueOf(fields[11]);
        int magicalEnergyWeapons = Integer.valueOf(fields[12]);
        int meleeWeapons= Integer.valueOf(fields[13]);
        int unarmed     = Integer.valueOf(fields[14]);
        int explosives  = Integer.valueOf(fields[15]);
        int damageResistance = Integer.valueOf(fields[16]);
        int actionPoints= Integer.valueOf(fields[17]);
        int currentHealth    = Integer.valueOf(fields[18]);
        int experiencePoints = Integer.valueOf(fields[19]);
        player = new Player(name, strength, perception, endurance, charisma, intelligence, agility, luck, level, health, smallGuns, bigGuns, magicalEnergyWeapons, meleeWeapons, unarmed, explosives, damageResistance, actionPoints, currentHealth, experiencePoints);
        playableCharacters.add(player);
    } 

    public static void readInventoryData(String[] fields){
        
    }

    public static void writeSaveData(){
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("Save Data/PLAYABLE_CHARACTERS.txt"));
            for (int i = 0; i < playableCharacters.size(); i++) {
                bufferedWriter.write(playableCharacters.get(i).toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ioe) {
            System.out.println("IO Exception Writing Save File");
        }
    }

    private static void initWindow(){
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(userInterface);
        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);


    }

    //V2 Simplified into the initWindow() by adding a remove all in the 
    //entry and making it take a JPanel argument?
    public static void changeToNewPanel(JPanel panel){
        window.remove(userInterface);
        window.add(panel);
        window.pack();
    }

    //V2 Simplified into the initWindow() by adding a remove all in the 
    //entry and making it take a JPanel argument?
    public static void returnToUserInterface(){
        window.remove(combatCalculator);
        window.remove(playerEditor);
        window.add(userInterface);
        window.pack();
        combatCalculatorButton.setEnabled(true);
        characterEditorButton.setEnabled(true);
        getUserInterface().repaint();
        writeSaveData();
    }

    public static String[] splitDelimitedString(String toSplit, String delimiter){
        String[] valuesAsStrings = toSplit.split(delimiter);
        return valuesAsStrings;
    }


    public static JButton getPlayerEditorButton() {
        return characterEditorButton;
    }
    public static JButton getCombatCalculatorButton() {
        return combatCalculatorButton;
    }
    public static JButton getReturnToHomeButton() {
        return returnToHomeButton;
    }
    public static JButton getCreateCharacterButton() {
        return createCharacterButton;
    }

    public static UserInterface getUserInterface() {
        return userInterface;
    }
    public static CombatCalculator getCombatCalculator() {
        return combatCalculator;
    }
    public static PlayerEditor getPlayerEditor(){
        return playerEditor;
    }
    
    public static JFrame getWindow() {
        return window;
    }

    public static ArrayList<Player> getPlayableCharacters() {
        return playableCharacters;
    }
    public static void setPlayableCharacters(ArrayList<Player> playablCharacters) {
        FallOutEquestria.playableCharacters = playablCharacters;
    }
    public static ArrayList<Creature> getNonPlayableCharacters() {
        return NonPlayableCharacters;
    }public static void setNonPlayableCharacters(ArrayList<Creature> nonPlayableCharacters) {
        NonPlayableCharacters = nonPlayableCharacters;
    }
}