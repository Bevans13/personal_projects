import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

import Creatures.Creature;

public class UserInterface extends JPanel implements ActionListener {
    
    private static final Color BACKGROUND_COLOR = new Color(250,250,250); 
    private final int UIWidth = 1200;
    private final int UIHeight = 690;
    //Create a JButton and each corresponding World Object
    private static JButton[] UIButtons = new JButton[12];
    private static World[] UIWorlds = new World[12];
    private static JButton theIslandButton = new JButton("The Island");
    private World THE_ISLAND = new World("The Island", "THE ISLAND.txt");
    private JButton scorchedEarthButton= new JButton("Scorched Earth");
    private World SCORCHED_EARTH = new World("Scorched Earth", "SCORCHED EARTH.txt");
    private JButton aberrationButton = new JButton("Aberration");
    private World ABERRATION= new World("Aberration", "ABERRATION.txt");
    private JButton extinctionButton = new JButton("Extinction");
    private World EXTINCTION = new World("Extinction", "EXTINCTION.txt");
    private JButton genesisP1Button = new JButton("Genesis Part 1");
    private World GENESISP1 = new World("Genesis Part 1", "GENESISP1.txt");
    private JButton genesisP2Button = new JButton("Genesis Part 2");
    private World GENESISP2 = new World("Genesis Part 2", "GENESISP2.txt");
    private JButton theCenterButton = new JButton("The Center");
    private World THE_CENTER = new World("The Center", "THE CENTER.txt");
    private JButton ragnarokButton = new JButton("Ragnarok");
    private World RAGNAROK = new World("Ragnarok", "RAGNAROK.txt");
    private JButton valgueroButton = new JButton("Valguero");
    private World VALGUERO = new World("Valguero", "VALGUERO.txt");
    private JButton crystalIslesButton = new JButton("Crystal Isles");
    private World CRYSTAL_ISLES = new World("Crystal Isles", "CRYSTAL ISLES.txt");
    private JButton lostIslandButton = new JButton("Lost Island");
    private World LOST_ISLAND = new World("Lost Island", "LOST ISLAND.txt");
    private JButton fjordurButton = new JButton("Fjordur");
    private World FJORDUR = new World("Fjordur", "FJORDUR.txt");

    static {
        
    }
    
    
    public UserInterface() {
        //set size of UI
        setPreferredSize(new Dimension(UIWidth,UIHeight));
        setBackground(BACKGROUND_COLOR);
        UIButtons[0] = theIslandButton;
        UIWorlds[0] = THE_ISLAND;
        UIButtons[1] = scorchedEarthButton;
        UIWorlds[1] = SCORCHED_EARTH;
        UIButtons[2] = aberrationButton;
        UIWorlds[2] = ABERRATION;
        UIButtons[3] = extinctionButton;
        UIWorlds[3] = EXTINCTION;
        UIButtons[4] = genesisP1Button;
        UIWorlds[4] = GENESISP1;
        UIButtons[5] = genesisP2Button;
        UIWorlds[5] = GENESISP2;
        UIButtons[6] = theCenterButton;
        UIWorlds[6] = THE_CENTER;
        UIButtons[7] = ragnarokButton;
        UIWorlds[7] = RAGNAROK;
        UIButtons[8] = valgueroButton;
        UIWorlds[8] = VALGUERO;
        UIButtons[9] = crystalIslesButton;
        UIWorlds[9] = CRYSTAL_ISLES;
        UIButtons[10] = lostIslandButton;
        UIWorlds[10] = LOST_ISLAND;
        UIButtons[11] = fjordurButton;
        UIWorlds[11] = FJORDUR;
        

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        drawButtons(g);

    }

    private void drawButtons(Graphics g){
        //draw a button
        for (int i = 0; i< UIButtons.length; i++) {
            if(i<4){
                UIButtons[i].setBounds((((i+1)*UIWidth)/4)-(((UIWidth/4)/4)*3), (UIHeight/3)-((((UIHeight)/3)/3)*2), (UIWidth/8), (UIHeight/3/3));
            }
            if(i>=4 && i<8){
                UIButtons[i].setBounds((((i+1-4)*UIWidth)/4)-(((UIWidth/4)/4)*3), (2*UIHeight/3)-((((UIHeight)/3)/3)*2), (UIWidth/8), (UIHeight/3/3));
            }
            if(i>=8){
                UIButtons[i].setBounds((((i+1-8)*UIWidth)/4)-(((UIWidth/4)/4)*3), (UIHeight)-((((UIHeight)/3)/3)*2), (UIWidth/8), (UIHeight/3/3));
            }
            this.add(UIButtons[i]);
            UIButtons[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < UIButtons.length; i++) {
            if(UIButtons[i]== e.getSource()){
                openMapSelected(UIWorlds[i]);
                ArrayList<Creature> readList;
                readList = readFile(UIWorlds[i]);
                UIWorlds[i].setTames(readList);
            }
        }
    }

    private void openMapSelected(World selectedMap){
        
        ArkTracker.getSelectedWorld().add(selectedMap);
        ArkTracker.getSelectedWorld().setTitle(selectedMap.getWorldName());
        ArkTracker.getSelectedWorld().pack();
        ArkTracker.getSelectedWorld().setVisible(true);
        ArkTracker.getSelectedWorld().setContentPane(selectedMap);

    }

    public static ArrayList<Creature> readFile(World world){
        BufferedReader br;
        String record;
        String[] fields;
        try {
            
            //instantiating br here to point to the input file
            br = new BufferedReader(new FileReader(world.getFILENAME()));
            System.out.println(world.getFILENAME());
            //reading the first record and storing it in the 'record' variable
            record = br.readLine();
            
            
            //Begins section where program reads existing file and loads creatures into program
            while (record != null) {
                
                // Instantiates the fields array and splits into separate strings for each 
                // value
                fields = Driver.splitDelimitedString(record, ",");
                
                // assign each position of the fields array to it's corresponding data
                String n    = fields[0];
                String sp   = fields[1];
                char gen    = fields[2].charAt(0);

                // the following fields are no longer actually strings so use Double method
                // to convert the fields values to double values
                double hp   = Double.valueOf(fields[3]);
                double stam = Double.valueOf(fields[4]);
                double oxy  = Double.valueOf(fields[5]);
                double f    = Double.valueOf(fields[6]);
                double w    = Double.valueOf(fields[7]);
                double mel  = Double.valueOf(fields[8]);
                double mov  = Double.valueOf(fields[9]);
                double torp = Double.valueOf(fields[10]);

                // Runs Static Driver method to create creatures (allows for same create creature code to 
                // be used both in the initial reading of the file as well as when adding creatures later on)
                Driver.createCreature(n, sp, gen, hp, stam, oxy, f, w, mel, mov, torp);
                // Read the next record in the file
                record = br.readLine();
                
            }// End of Try Block which will read existing file
            br.close();
        }catch (IOException ioe){
            System.out.println("IO Exception Error - Reading");
        }
        if (world.getTames().size()>1) {
            System.out.println(world.getWorldName()+"Tames Loaded");
        }
        return Driver.getTames();
    }

    public int getUIWidth() {
        return UIWidth;
    }
    public int getUIHeight() {
        return UIHeight;
    }


}
